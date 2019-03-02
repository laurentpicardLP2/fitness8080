package laurent.fitness.controller;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

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


import laurent.fitness.services.AuthorityService;
import laurent.fitness.services.CustomerService;
import laurent.fitness.services.StaffService;
import laurent.fitness.services.UserService;
import laurent.fitness.model.Authority;
import laurent.fitness.model.Customer;
import laurent.fitness.model.Staff;

@RestController
@RequestMapping("/userctrl")
@CrossOrigin("http://localhost:4200")
public class UserController {
	
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

		//BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		
		try {
			this.authorityService.saveAuthority(new Authority(newCustomer.getUsername(), "ROLE_CUSTOMER"));
			this.customerService.saveCustomer(new Customer(this.userService.findByUsernameIdMax(),
				newCustomer.getUsername(), newCustomer.getFullname(), newCustomer.getPassword(), 
				newCustomer.getEmail(), newCustomer.getTel(), new Date(), (byte)1, newCustomer.getDateOfBirthday(),
				newCustomer.getDomesticAddress(), newCustomer.getDomesticCp(), newCustomer.getDeliveryCity(), newCustomer.getDomesticCountry(),
				newCustomer.getDeliveryAddress(), newCustomer.getDeliveryCp(), newCustomer.getDeliveryCity(), newCustomer.getDeliveryCountry()));
		return ResponseEntity.status(HttpStatus.OK).body(null);
		
	} catch(Exception e) {
		
		System.out.println(e);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);	
	}			
	}
		
	
	
	@PostMapping("/addstaff/{role}")
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

}
