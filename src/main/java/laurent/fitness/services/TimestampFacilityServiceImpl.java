package laurent.fitness.services;

import java.util.List;

import org.springframework.stereotype.Service;

import laurent.fitness.model.Facility;
import laurent.fitness.model.FacilityCategory;
import laurent.fitness.model.TimestampFacility;
import laurent.fitness.repository.FacilityCategoryRepository;
import laurent.fitness.repository.FacilityRepository;
import laurent.fitness.repository.TimestampFacilityRepository;

@Service
public class TimestampFacilityServiceImpl implements TimestampFacilityService {
	
	private TimestampFacilityRepository timestampFacilityRepo;
	private FacilityRepository facilityRepo;
	private FacilityCategoryRepository facilityCategoryRepo;
	
	public TimestampFacilityServiceImpl(
			TimestampFacilityRepository timestampFacilityRepo, 
			FacilityRepository facilityRepo, 
			FacilityCategoryRepository facilityCategoryRepo) {
		this.timestampFacilityRepo = timestampFacilityRepo;
		this.facilityRepo = facilityRepo;
		this.facilityCategoryRepo = facilityCategoryRepo;
	}

	@Override
	public List<TimestampFacility> getAllTimestampFacilities() {
		// TODO Auto-generated method stub
		return this.timestampFacilityRepo.findAll();
	}

	@Override
	public TimestampFacility saveNewTimestampFacility(String refTimestamp, String facilityName, String facilityCategoryName) {
		// TODO Auto-generated method stub
		Facility facility = this.facilityRepo.findByFacilityName(facilityName);
		FacilityCategory facilityCategory = this.facilityCategoryRepo.findByFacilityCategoryName(facilityCategoryName);
		TimestampFacility timestampFacility = new TimestampFacility(refTimestamp, facility, facilityCategory);
		return this.timestampFacilityRepo.save(timestampFacility);
	}

	@Override
	public void deleteTimestampFacility(TimestampFacility timestampFacility) {
		// TODO Auto-generated method stub
		this.timestampFacilityRepo.delete(timestampFacility);
	}

	@Override
	public TimestampFacility saveTimestampFacility(TimestampFacility timestampFacility) {
		// TODO Auto-generated method stub
		return this.timestampFacilityRepo.save(timestampFacility);
	}

	@Override
	public int findByFacilityCategoryCount(String facilityCategoryName, String timestamp) {
		// TODO Auto-generated method stub
		return this.timestampFacilityRepo.findByFacilityCategoryCount(facilityCategoryName, timestamp);
	}

}
