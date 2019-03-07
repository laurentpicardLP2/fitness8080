package laurent.fitness.services;

import java.util.List;

import laurent.fitness.model.FacilityCategory;

public interface FacilityCategoryService {
	public List<FacilityCategory> getFacilitiesAvailable(String timestamp);
	
	public FacilityCategory saveFacilityCategory(FacilityCategory facilityCategory);
	
	public void deleteFacilityCategory(FacilityCategory facilityCategory);
	
	public FacilityCategory findByFacilityCategoryName(String facilityCategoryName);
	
	public FacilityCategory updateFacilityCategory(String facilityCategoryName, String quantity, 
			String price, String description, String image);

}
