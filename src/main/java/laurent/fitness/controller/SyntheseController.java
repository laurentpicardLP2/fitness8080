package laurent.fitness.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import laurent.fitness.model.Command;
import laurent.fitness.services.CommandService;
import laurent.fitness.services.CustomerService;
import laurent.fitness.services.SeanceService;

@RestController
@RequestMapping("/synthesectrl")
@CrossOrigin("http://localhost:4200")
public class SyntheseController {

	private CommandService commandService;
	private CustomerService customerService;
	private SeanceService seanceService;
	
	public SyntheseController(CommandService commandService, CustomerService customerService, SeanceService seanceService) {
		this.commandService = commandService;
		this.customerService = customerService;
		this.seanceService = seanceService;
	}

	
	// Récupération des différentes de commandes et de leur état (payé ou non) pour un utilisteur donné
	@GetMapping("/getcommands/{username}")
	public List<Command> GetCommands(@PathVariable String username){
	System.out.println("username : " + username);
		try {
			return this.commandService.findCommandByUsername(username);
		} catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}	

}
