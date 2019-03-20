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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import laurent.fitness.services.TimestampFacilityService;

@RestController
@RequestMapping("/timestampfacilityctrl")
@CrossOrigin("http://localhost:4200")
public class TimestampFacilityController {
private TimestampFacilityService timestampFacilityService;
	
	public TimestampFacilityController(TimestampFacilityService timestampFacilityService) {
		this.timestampFacilityService = timestampFacilityService;
	}
	
	//Add a new timestampFacility
	@PostMapping("/addtimestampfacility/{idItem}/{refTimestamp}/{nameFacility}/{nameFacilityCategory}")
	public ResponseEntity<?> addTimestampFacility(
			@PathVariable int idItem,
			@PathVariable String refTimestamp, 
			@PathVariable String nameFacility, 
			@PathVariable String nameFacilityCategory) {
		try {
		return ResponseEntity.status(HttpStatus.OK).body(
				this.timestampFacilityService.saveNewTimestampFacility(idItem, refTimestamp, nameFacility, nameFacilityCategory));
		
		} catch(Exception e) {
			
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);	
		}			
	}
	
	//Check the quantity of available facilities for a timestamp and its category
	@GetMapping("/availablefacilities/{facilityName}/{refTimestamp}")
	public ResponseEntity<?> getQuantityAvailableFacilities(@PathVariable String facilityName, @PathVariable String refTimestamp) {
		try {
			int nbAvailableFacilities = this.timestampFacilityService.findByFacilityCategoryCount(facilityName, refTimestamp);
		return ResponseEntity.status(HttpStatus.OK).body(null);
		
		} catch(Exception e) {
			
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);	
		}			
	}
	
	@DeleteMapping("/deletetimestampfacility/{idTimestampFacillity}")
	public ResponseEntity<?> delTimestamp(@PathVariable String idTimestampFacillity){
		try {
			this.timestampFacilityService.deleteTimestampFacility(Integer.parseInt(idTimestampFacillity));
			return ResponseEntity.status(HttpStatus.OK).body(null);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);	
		}
	}
}
