package laurent.fitness.services;

import java.util.Date;
import java.util.List;

import laurent.fitness.model.TimestampFacility;
import laurent.fitness.model.adaptater.TimestampFacilityAdaptater;

public interface TimestampFacilityService {
	public List<TimestampFacility> getAllTimestampFacilities();
	
	public TimestampFacility saveTimestampFacility(TimestampFacility timestampFacility);
	
	public TimestampFacility saveNewTimestampFacility(int idItem, String refTimestamp, String facilityName, String facilityCategoryName);
	
	public void deleteTimestampFacility(int idTimestampFacillity);
	
	public int findByFacilityCategoryCount(String facilityCategoryName, String timestamp);
}
