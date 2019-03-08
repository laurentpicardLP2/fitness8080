package laurent.fitness.services;

import java.util.List;

import org.springframework.stereotype.Service;

import laurent.fitness.model.FacilityCategory;
import laurent.fitness.repository.FacilityCategoryRepository;
import laurent.fitness.repository.TimestampFacilityRepository;

@Service
public class FacilityCategoryServiceImpl implements FacilityCategoryService {
	
	private FacilityCategoryRepository facilityCategoryRepo;
	private TimestampFacilityRepository timestampFacilityRepo;

    public FacilityCategoryServiceImpl(FacilityCategoryRepository facilityCategoryRepo, TimestampFacilityRepository timestampFacilityRepo) {
        this.facilityCategoryRepo = facilityCategoryRepo;
        this.timestampFacilityRepo = timestampFacilityRepo;
    }

	@Override
	public List<FacilityCategory> getAllFacilityCategories() {
		// TODO Auto-generated method stub
		return  this.facilityCategoryRepo.findAll();
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

	@Override
	public FacilityCategory updateFacilityCategory(String facilityCategoryName, String quantity, String price,
			String description, String image) {
		// TODO Auto-generated method stub
		FacilityCategory facilityCategoryToUpdate = this.facilityCategoryRepo.findByFacilityCategoryName(facilityCategoryName);
		facilityCategoryToUpdate.setQuantity(Integer.parseInt(quantity));
		facilityCategoryToUpdate.setPrice(Float.parseFloat(price));
		facilityCategoryToUpdate.setDescription(description);
		facilityCategoryToUpdate.setImage(image);
		return this.facilityCategoryRepo.save(facilityCategoryToUpdate);
	}




}
