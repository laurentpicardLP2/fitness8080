package laurent.fitness.controller.postman;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import laurent.fitness.model.MaterialCategory;
import laurent.fitness.services.MaterialCategoryService;

@RestController
@RequestMapping("/postman/materialcategoryctrl")
public class MaterialCategoryControllerPostman {
private MaterialCategoryService materialCategoryService;
	
	public MaterialCategoryControllerPostman(MaterialCategoryService materialCategoryService) {
		this.materialCategoryService = materialCategoryService;
	}
	
	//Add a new category of material
	@PostMapping("/addmaterialcategory")
	public ResponseEntity<?> addMaterialCategory(@Valid String materialCategoryName, @Valid String quantity, @Valid String description) {
		try {
			this.materialCategoryService.saveMaterialCategory(
					new MaterialCategory(materialCategoryName, Integer.parseInt(quantity), description));
		return ResponseEntity.status(HttpStatus.OK).body(null);
		
		} catch(Exception e) {
			
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);	
		}			
	}
}
