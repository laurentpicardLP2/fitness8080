package laurent.fitness.controller;


import static laurent.fitness.security.SecurityConstants.SECRET_KEY;
import static laurent.fitness.security.SecurityConstants.TOKEN_EXPIRATION_TIME;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import laurent.fitness.model.AuthToken;
import laurent.fitness.model.User;
import laurent.fitness.repository.UserRepository;
import laurent.fitness.services.MapValidationErrorService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;

import laurent.fitness.services.AuthorityService;
import laurent.fitness.services.CustomerService;
import laurent.fitness.services.StaffService;
import laurent.fitness.services.UserService;
import laurent.fitness.model.Authority;
import laurent.fitness.model.Customer;
import laurent.fitness.model.Staff;
import laurent.fitness.model.User;
import laurent.fitness.repository.UserRepository;

@RestController
@RequestMapping("/userctrl")
@CrossOrigin("http://localhost:4200")
public class UserController {
	
	@Autowired
	UserRepository usersRepo;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
    private MapValidationErrorService mapValidationErrorService;
	
	public static final String TOKEN_PREFIX = "Bearer ";
	
	
	private AuthorityService authorityService;
	private CustomerService customerService;
	private StaffService staffService;
	private UserService userService;
	
	public UserController(
				AuthorityService authorityService, 
				CustomerService customerService,
				StaffService staffService,
				UserService userService) {
		this.authorityService = authorityService;
		this.customerService = customerService;
		this.staffService = staffService;
		this.userService = userService;
	}
	
	@PostMapping("/newcustomer")
	public ResponseEntity<?> createCustomer(@RequestBody Customer newCustomer) {

		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		
		try {
			this.authorityService.saveAuthority(new Authority(newCustomer.getUsername(), "ROLE_CUSTOMER"));
			this.customerService.saveCustomer(new Customer(this.userService.findByUsernameIdMax(),
				newCustomer.getUsername(), newCustomer.getFullname(), "{bcrypt}" + bcrypt.encode(newCustomer.getPassword()), 
				newCustomer.getEmail(), newCustomer.getTel(), new Date(), (byte)1, newCustomer.getDateOfBirthday(),
				newCustomer.getDomesticAddress(), newCustomer.getDomesticCp(), newCustomer.getDeliveryCity(), newCustomer.getDomesticCountry(),
				newCustomer.getDeliveryAddress(), newCustomer.getDeliveryCp(), newCustomer.getDeliveryCity(), newCustomer.getDeliveryCountry()));
		return ResponseEntity.status(HttpStatus.OK).body(null);
		
	} catch(Exception e) {
		
		System.out.println(e);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);	
		}			
	}
		
	
	
	@PostMapping("/newstaff/{role}")
	public ResponseEntity<?> addStaff(@PathVariable String role) {			
		return ResponseEntity.status(HttpStatus.OK).body(null);		
	}
	
	@DeleteMapping("/deluser")
	public ResponseEntity<?> delCustomer(@Valid String username){
		try {
			this.userService.deleteUser(this.userService.findByUsername(username));
			return ResponseEntity.status(HttpStatus.OK).body(null);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);	
		}
	}
	
	@GetMapping("/authorities")
	public List<Authority> getAllAuthorities() {
		return this.authorityService.getAllAuthorities();
	}
	
	
	//temporary login process 
	//@PostMapping("/login")
	public ResponseEntity<?> userLogin(@RequestBody User pUser) {			
		System.out.println("/login");
		try {
			User user = this.userService.findByUsername(pUser.getUsername());
			System.out.println("username : " + user.getUsername());
		return ResponseEntity.status(HttpStatus.OK).body(user);
			
		} catch(Exception e) {
			
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);	
		}			
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody User user, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationService(result);
        
        if(errorMap != null)
            return  errorMap;
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                		user.getUsername(),
                		user.getPassword()
                )
        );
        
        user = usersRepo.findByUsername(user.getUsername()); // pour récupérer l'id
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        Date now = new Date(System.currentTimeMillis());
        Date expireDate = new Date(now.getTime() + TOKEN_EXPIRATION_TIME);
        Map<String, Object>claims = new HashMap<>();
        claims.put("id", (Long.toString(user.getIdUser())));
        claims.put("username", user.getUsername());
        claims.put("role",  authentication.getAuthorities());
        String jwt =  TOKEN_PREFIX + Jwts.builder()
                .setSubject(user.getUsername())
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();

        return ResponseEntity.ok(new AuthToken(jwt));
	}

}
