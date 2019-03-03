package laurent.fitness.services;

import java.util.List;

import org.springframework.stereotype.Service;

import laurent.fitness.model.MaterialCategory;
import laurent.fitness.repository.MaterialCategoryRepository;

@Service
public class MaterialCategoryServiceImpl implements MaterialCategoryService {
	
	private MaterialCategoryRepository materialCategoryRepo;

    public MaterialCategoryServiceImpl(MaterialCategoryRepository materialCategoryRepo) {
        this.materialCategoryRepo = materialCategoryRepo;
    }


	@Override
	public List<MaterialCategory> getAllMaterialCategories() {
		// TODO Auto-generated method stub
		return this.materialCategoryRepo.findAll();
	}

	@Override
	public MaterialCategory saveMaterialCategory(MaterialCategory materialCategory) {
		// TODO Auto-generated method stub
		return this.materialCategoryRepo.save(materialCategory);
	}

	@Override
	public void deleteMaterialCategory(MaterialCategory materialCategory) {
		// TODO Auto-generated method stub
		this.materialCategoryRepo.delete(materialCategory);
	}

	@Override
	public MaterialCategory findByMaterialCategoryName(String materialCategoryName) {
		// TODO Auto-generated method stub
		return this.materialCategoryRepo.findByMaterialCategoryName(materialCategoryName);
	}

}
