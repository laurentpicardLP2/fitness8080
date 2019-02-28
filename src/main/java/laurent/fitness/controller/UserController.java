package laurent.fitness.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import laurent.fitness.repository.AuthorityRepository;
import laurent.fitness.repository.UserRepository;
import laurent.fitness.model.Authority;
import laurent.fitness.model.User;

@RestController
@RequestMapping("/userctrl")
public class UserController {
	
	@Autowired
	AuthorityRepository authorityRepo;
	
	//private AuthoritiesService authoritiesService;
	
	@Autowired
	UserRepository userRepo;
	
	//private UsersService usersService;
	
	//via Postman
		@PostMapping("/adduser")
		public ResponseEntity<?> addUser(@Valid String username, @Valid String fullname, @Valid String password, 
				@Valid String email, @Valid String tel, @Valid String role) {
			User user;
			Authority authority;
			
			Long userId;

			//BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
			
			//userId =  (LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli())/1000;
			
			
			user = new User(username, fullname, password, 
					email, tel, new Date(), (byte) 1);
			
			authority = new Authority(username, role);
			//authority.setUser(user);
			authorityRepo.save(authority);
			System.out.println("ggggggggg authorityRepo.save(authority); " + authorityRepo.save(authority));
			userRepo.save(user);
			
			try {
				//authoritiesRepo.save(authorities);
				return ResponseEntity.status(HttpStatus.OK).body(null);
				
			} catch(Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);	
			}	
					
		}
}
