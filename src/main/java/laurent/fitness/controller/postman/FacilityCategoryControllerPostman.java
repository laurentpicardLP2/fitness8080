package laurent.fitness.controller.postman;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import laurent.fitness.model.FacilityCategory;
import laurent.fitness.model.Room;
import laurent.fitness.services.FacilityCategoryService;

@RestController
@RequestMapping("/postman/facilitycategoryctrl")
public class FacilityCategoryControllerPostman {
private FacilityCategoryService facilityCategoryService;
	
	public FacilityCategoryControllerPostman(FacilityCategoryService facilityCategoryService) {
		this.facilityCategoryService = facilityCategoryService;
	}
	
	//Add a new category of facility
	@PostMapping("/addfacilitycategory")
	public ResponseEntity<?> addFacilityCategory(@Valid String facilityCategoryName, @Valid String quantity, @Valid String description) {
		try {
			this.facilityCategoryService.saveFacilityCategory(
					new FacilityCategory(facilityCategoryName, Integer.parseInt(quantity), description));
		return ResponseEntity.status(HttpStatus.OK).body(null);
		
		} catch(Exception e) {
			
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);	
		}			
	}
	
	// Update a category of facility
		@PutMapping("/updatefacilitycategory")
		public ResponseEntity<?> updateFacilityCategory(
				@Valid String facilityCategoryName, 
				@Valid String quantity,
				@Valid String price,
				@Valid String description,
				@Valid String image){
			try {
				this.facilityCategoryService.updateFacilityCategory(facilityCategoryName, quantity, price, description, image);
				return ResponseEntity.status(HttpStatus.OK).body(null);
			} catch(Exception e) {
				System.out.println(e);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);	
			}
		}
	
	// Delete a category of facility
		@DeleteMapping("/delfacilitycategory")
		public ResponseEntity<?> delFacilityCategory(@Valid String facilityCategoryName){
			try {
				this.facilityCategoryService.deleteFacilityCategory(this.facilityCategoryService.findByFacilityCategoryName(facilityCategoryName));
				return ResponseEntity.status(HttpStatus.OK).body(null);
			} catch(Exception e) {
				System.out.println(e);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);	
			}
		}
}
