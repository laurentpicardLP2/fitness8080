package laurent.fitness.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import laurent.fitness.model.Command;
import laurent.fitness.model.Seance;
import laurent.fitness.services.CommandService;
import laurent.fitness.services.SeanceService;

@RestController
@RequestMapping("/seancectrl")
@CrossOrigin("http://localhost:4200")
public class SeanceController {

	private SeanceService seanceService;
	private CommandService commandService;
	
	public SeanceController(SeanceService seanceService, CommandService commandService) {
		this.seanceService = seanceService;
		this.commandService = commandService;
	}
	
	//Initialise une seance pour une commande donnée d'un utilisateur connecté (customer ou staff-seller)
	@PostMapping("/addseance/{idCommand}")
	public ResponseEntity<?> addItem(@PathVariable int idCommand) {
		//List<Item> items;
		ArrayList<Command> commands = new ArrayList<Command>();
		try {
			Command currentCommand = this.commandService.findByCommand(idCommand);
			commands.add(currentCommand);
			Seance newSeance = this.seanceService.saveSeance(new Seance(commands));
		
		return ResponseEntity.status(HttpStatus.OK).body(newSeance);
		
		} catch(Exception e) {
			
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);	
		}			
	}
		
}
