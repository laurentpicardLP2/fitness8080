package laurent.fitness.services;

import java.util.List;
import laurent.fitness.model.Facility;

public interface FacilityService {
	public List<Facility> getAllFacilities();
	
	public Facility saveNewFacility(String facilityName, String roomName, String facilityCategoryName);
	
	public Facility saveCategory(Facility facility);
	
	public void deleteFacility(Facility facility);
	
	public Facility findByFacilityName(String facilityName);
}
