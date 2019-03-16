package laurent.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import laurent.fitness.model.TimestampFacility;

public interface TimestampFacilityRepository extends JpaRepository <TimestampFacility, Integer> {


//	@Query(value = "SELECT (facility_category.quantity) - "
//			+ " (SELECT COUNT(*) FROM timestamp_facility INNER JOIN facility ON timestamp_facility.facility_id_facility = ( "
//			+ " SELECT  facility.id_facility FROM facility INNER JOIN facility_category ON "
//			+ " facility.facility_category_id_facility_category = facility_category.id_facility_category "
//			+ "  WHERE facility_category.facility_category_name like %?1%) "
//			+ " WHERE timestamp_facility.ref_timestamp like %?2%) "
//			+ " FROM facility_category WHERE facility_category.facility_category_name like %?1%", nativeQuery = true)

	
	@Query(value = "SELECT (facility_category.quantity_facility_category) - "
			+ " (SELECT COUNT(*) FROM timestamp_facility INNER JOIN facility_category ON "
			+ " timestamp_facility.facility_category_id_facility_category = facility_category.id_facility_category "
			+ "  WHERE facility_category.name_facility_category like %?1% AND timestamp_facility.ref_timestamp like %?2% ) "
			+ " FROM facility_category WHERE facility_category.name_facility_category like %?1%", nativeQuery = true)
	int findByFacilityCategoryCount(String nameFacility, String timestamp);

}
