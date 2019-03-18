package laurent.fitness.services;

import java.util.Date;
import java.util.List;

import laurent.fitness.model.TimestampFacility;

public interface TimestampFacilityService {
	public List<TimestampFacility> getAllTimestampFacilities();
	
	public TimestampFacility saveTimestampFacility(TimestampFacility timestampFacility);
	
	public TimestampFacility saveNewTimestampFacility(int idItem, String refTimestamp, String facilityName, String facilityCategoryName, Date dateOfTimestamp);
	
	public void deleteTimestampFacility(int idTimestampFacillity);
	
	public int findByFacilityCategoryCount(String facilityCategoryName, String timestamp);
	
	public List<TimestampFacility> findTimestampByIdItem(int idItem);
}
