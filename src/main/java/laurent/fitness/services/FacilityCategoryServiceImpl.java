package laurent.fitness.services;

import java.util.List;

import org.springframework.stereotype.Service;

import laurent.fitness.model.FacilityCategory;
import laurent.fitness.repository.FacilityCategoryRepository;

@Service
public class FacilityCategoryServiceImpl implements FacilityCategoryService {
	
	private FacilityCategoryRepository facilityCategoryRepo;

    public FacilityCategoryServiceImpl(FacilityCategoryRepository facilityCategoryRepo) {
        this.facilityCategoryRepo = facilityCategoryRepo;
    }

	@Override
	public List<FacilityCategory> getAllFacilityCategories() {
		// TODO Auto-generated method stub
		return this.facilityCategoryRepo.findAll();
	}

	@Override
	public FacilityCategory saveFacilityCategory(FacilityCategory facilityCategory) {
		// TODO Auto-generated method stub
		return this.facilityCategoryRepo.save(facilityCategory);
	}

	@Override
	public void deleteFacilityCategory(FacilityCategory facilityCategory) {
		// TODO Auto-generated method stub
		this.facilityCategoryRepo.delete(facilityCategory);
	}

	@Override
	public FacilityCategory findByFacilityCategoryName(String facilityCategoryName) {
		// TODO Auto-generated method stub
		return this.facilityCategoryRepo.findByFacilityCategoryName(facilityCategoryName);
	}




}
