package laurent.fitness.controller.postman;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import laurent.fitness.model.Command;
import laurent.fitness.model.Item;
import laurent.fitness.services.CommandService;
import laurent.fitness.services.ItemService;

@RestController
@RequestMapping("/postman/itemctrl")
public class ItemControllerPostman {
	private ItemService itemService;
	private CommandService commandService;
	
	public ItemControllerPostman(ItemService itemService, CommandService commandService) {
		this.itemService = itemService;
		this.commandService = commandService;
	}
	
	//Initialise un item pour une commande donnée d'un utilisateur connecté
	@PostMapping("/additem")
	public ResponseEntity<?> addItem(@Valid int idCommand) {
		List<Item> items;
		ArrayList<Command> commands = new ArrayList<Command>();
		try {
			Command currentCommand = this.commandService.findByCommand(idCommand);
			commands.add(currentCommand);
			items = currentCommand.getItems();
			Item newItem = this.itemService.saveItem(new Item(commands));
		
		return ResponseEntity.status(HttpStatus.OK).body(newItem);
		
		} catch(Exception e) {
			
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);	
		}			
	}
		
	
}
