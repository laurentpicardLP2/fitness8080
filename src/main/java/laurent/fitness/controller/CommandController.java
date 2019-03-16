package laurent.fitness.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import laurent.fitness.model.Command;
import laurent.fitness.model.Customer;
import laurent.fitness.model.Item;
import laurent.fitness.model.User;
import laurent.fitness.services.CommandService;
import laurent.fitness.services.CustomerService;
import laurent.fitness.services.UserService;

@RestController
@RequestMapping("/commandctrl")
@CrossOrigin("http://localhost:4200")
public class CommandController {
	private CommandService commandService;
	private CustomerService customerService;
	
	public CommandController(CommandService commandService, CustomerService customerService) {
		this.commandService = commandService;
		this.customerService = customerService;
	}
	
	//Initialise une commande lorsqu'un utilisateur se connecte
	@PostMapping("/addcommand/{username}")
	public ResponseEntity<?> addCommand(@PathVariable String username) {
		try {
			Customer customer = this.customerService.findByUsername(username);
			return ResponseEntity.status(HttpStatus.OK).body(this.commandService.saveCommand(new Command(customer, new Date())));
		
		} catch(Exception e) {
			
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);	
		}			
	}
	
	// Delete a command
	@DeleteMapping("/delcommand")
	public ResponseEntity<?> delCommand(@Valid int idCommand){
		try {
			this.commandService.deleteCommand(this.commandService.findByIdCommand(idCommand));
			return ResponseEntity.status(HttpStatus.OK).body(null);
		} catch(Exception e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);	
		}
	}
	
	// Reset a command resetcommand
	@PutMapping("/resetcommand/{idCommand}/{username}")
	public ResponseEntity<?> resetCommand(@PathVariable int idCommand, @PathVariable String username){
	
		try {
			this.commandService.deleteCommand(this.commandService.findByIdCommand(idCommand));
			Customer customer = this.customerService.findByUsername(username);
			return ResponseEntity.status(HttpStatus.OK).body(this.commandService.saveCommand(new Command(customer, new Date())));
		} catch(Exception e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);	
		}
	}
	
	// Validation du panier : maj en base des prix des différents items du panier
	@PutMapping("/validatecommand")
	public ResponseEntity<?> validateCommand(@RequestBody Command command){
	
		try {
			
			Command tmpCommand = this.commandService.findByIdCommand(command.getIdCommand());
			
			System.out.println("command item : " + command.getIdCommand());
			
			for(Item item : tmpCommand.getItems()) {
				System.out.println("item : " + item.getIdItem());
				System.out.println("item : " + item.getPrice());
			}
			
			this.commandService.saveCommand(command);
			
			return ResponseEntity.status(HttpStatus.OK).body(command);
//			this.commandService.deleteCommand(this.commandService.findByIdCommand(idCommand));
//			Customer customer = this.customerService.findByUsername(username);
//			return ResponseEntity.status(HttpStatus.OK).body(this.commandService.saveCommand(new Command(customer, new Date())));
		} catch(Exception e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);	
		}
	}
	
	// Validation du panier : maj en base des prix des différents items du panier
	@GetMapping("/validatecommand/{idCommand}")
	public Command GetCommand(@PathVariable int idCommand){
	
		try {
			return this.commandService.findByIdCommand(idCommand);
		} catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	

}
