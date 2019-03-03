package laurent.fitness.services;

import java.util.List;

import laurent.fitness.model.MaterialCategory;

public interface MaterialCategoryService {
	public List<MaterialCategory> getAllMaterialCategories();
	
	public MaterialCategory saveMaterialCategory(MaterialCategory materialCategory);
	
	public void deleteMaterialCategory(MaterialCategory materialCategory);
	
	public MaterialCategory findByMaterialCategoryName(String materialCategoryName);

}
