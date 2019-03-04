package laurent.fitness.controller.postman;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import laurent.fitness.services.FacilityService;

@RestController
@RequestMapping("/postman/facilityctrl")
public class FacilityControllerPostman {
	
	private FacilityService facilityService;

	public FacilityControllerPostman(FacilityService facilityService) {
		this.facilityService = facilityService;
	}
	
	//Add a new facility
	@PostMapping("/addfacility")
	public ResponseEntity<?> addFacility(
			@Valid String facilityName, 
			@Valid String roomName, 
			@Valid String facilityCategoryName) {
		try {
			this.facilityService.saveNewFacility(facilityName, roomName, facilityCategoryName);
		return ResponseEntity.status(HttpStatus.OK).body(null);
		
		} catch(Exception e) {
			
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);	
		}			
	}
	
}
