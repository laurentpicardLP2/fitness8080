package laurent.fitness.controller.postman;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import laurent.fitness.services.TimestampFacilityService;

@RestController
@RequestMapping("/postman/timestampfacilityctrl")
public class TimestampFacilityControllerPostman {
	private TimestampFacilityService timestampFacilityService;
	
	public TimestampFacilityControllerPostman(TimestampFacilityService timestampFacilityService) {
		this.timestampFacilityService = timestampFacilityService;
	}
	
	//Add a new timestampFacility
	@PostMapping("/addtimestampfacility")
	public ResponseEntity<?> addTimestampFacility(@Valid String refTimestamp, @Valid String facilityName) {
		try {
			this.timestampFacilityService.saveNewTimestampFacility(refTimestamp, facilityName);
		return ResponseEntity.status(HttpStatus.OK).body(null);
		
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
			System.out.println("refTimestamp : " + refTimestamp);
			System.out.println("nbAvailableFacilities : " + nbAvailableFacilities);
		return ResponseEntity.status(HttpStatus.OK).body(null);
		
		} catch(Exception e) {
			
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);	
		}			
	}
}