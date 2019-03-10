package laurent.fitness.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import laurent.fitness.model.Command;
import laurent.fitness.model.User;
import laurent.fitness.services.CommandService;
import laurent.fitness.services.UserService;

@RestController
@RequestMapping("/commandctrl")
@CrossOrigin("http://localhost:4200")
public class CommandController {
	private CommandService commandService;
	private UserService userService;
	
	public CommandController(CommandService commandService, UserService userService) {
		this.commandService = commandService;
		this.userService = userService;
	}
	
	//Initialise une commande lorsqu'un utilisateur se connecte
	@PostMapping("/addcommand/{username}")
	public ResponseEntity<?> addCommand(@PathVariable String username) {
		try {
			User userLogin = this.userService.findByUsername(username);
			return ResponseEntity.status(HttpStatus.OK).body(this.commandService.saveCommand(new Command(userLogin, new Date())));
		
		} catch(Exception e) {
			
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);	
		}			
	}
	
	// Delete a command
	@DeleteMapping("/delcommand")
	public ResponseEntity<?> delCommand(@Valid int idCommand){
		try {
			this.commandService.deleteCommand(this.commandService.findByCommand(idCommand));
			return ResponseEntity.status(HttpStatus.OK).body(null);
		} catch(Exception e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);	
		}
	}

}
