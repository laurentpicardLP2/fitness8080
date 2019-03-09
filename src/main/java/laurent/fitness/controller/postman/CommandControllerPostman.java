package laurent.fitness.controller.postman;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import laurent.fitness.model.Command;
import laurent.fitness.model.User;
import laurent.fitness.services.CommandService;
import laurent.fitness.services.UserService;

@RestController
@RequestMapping("/postman/commandctrl")
public class CommandControllerPostman {
	private CommandService commandService;
	private UserService userService;
	
	public CommandControllerPostman(CommandService commandService, UserService userService) {
		this.commandService = commandService;
		this.userService = userService;
	}
	
	//Initialise une commande lorsqu'un utilisateur se connecte
	@PostMapping("/addcommand")
	public ResponseEntity<?> addCommand(@Valid String username) {
		try {
			User userLogin = this.userService.findByUsername(username);
			this.commandService.saveCommand(new Command(userLogin, new Date()));
		return ResponseEntity.status(HttpStatus.OK).body(null);
		
		} catch(Exception e) {
			
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);	
		}			
	}
	
	// Delete a command by Postman
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
