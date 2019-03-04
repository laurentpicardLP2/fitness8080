package laurent.fitness.services;

import java.util.List;

import laurent.fitness.model.TimestampFacility;

public interface TimestampFacilityService {
	public List<TimestampFacility> getAllTimestampFacilities();
	
	public TimestampFacility saveTimestampFacility(TimestampFacility timestampFacility);
	
	public TimestampFacility saveNewTimestampFacility(String refTimestamp, String facilityName);
	
	public void deleteTimestampFacility(TimestampFacility timestampFacility);
	
	public int findByFacilityCategoryCount(String facilityName, String refTimestamp);
}