package laurent.fitness.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import laurent.fitness.model.Facility;
import laurent.fitness.model.FacilityCategory;
import laurent.fitness.model.adaptater.FacilityAvailableAdaptater;
import laurent.fitness.repository.FacilityCategoryRepository;
import laurent.fitness.repository.FacilityRepository;
import laurent.fitness.repository.TimestampFacilityRepository;

@Service
public class FacilityAvailableAdaptaterServiceImpl implements FacilityAvailableAdaptaterService {
	private FacilityRepository facilityRepo;
	private FacilityCategoryRepository facilityCategoryRepo;
	private TimestampFacilityRepository timestampFacilityRepo;
	
	public FacilityAvailableAdaptaterServiceImpl(
			FacilityCategoryRepository facilityCategoryRepo,
			TimestampFacilityRepository timestampFacilityRepo,
			FacilityRepository facilityRepo) {
        this.facilityCategoryRepo = facilityCategoryRepo;
        this.timestampFacilityRepo = timestampFacilityRepo;
        this.facilityRepo = facilityRepo;
    }

	
	@Override
	public List<FacilityAvailableAdaptater> getFacilitiesAvailable(String timestamp) {
		// TODO Auto-generated method stub
		int availableFacilities = 0;
		String facilityCategoryName = "";
		ArrayList<FacilityAvailableAdaptater> facilitiesAvailableAdaptater = new ArrayList<FacilityAvailableAdaptater>() ;
		List<Facility> facilities = null;
		List<FacilityCategory> facilityCategories = this.facilityCategoryRepo.findAll();
		
		for (int i=0; i<facilityCategories.size(); i++) {
			facilityCategoryName = facilityCategories.get(i).getFacilityCategoryName();
			availableFacilities = this.timestampFacilityRepo.findByFacilityCategoryCount(facilityCategoryName, timestamp);
			facilities = this.facilityRepo.findByFacilityAvailable(facilityCategoryName, timestamp);
			facilitiesAvailableAdaptater.add(new FacilityAvailableAdaptater(facilityCategoryName, availableFacilities, facilities));
		}
		return facilitiesAvailableAdaptater;
	}
	
	
	

}
