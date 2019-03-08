package laurent.fitness.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import laurent.fitness.model.Facility;


public interface FacilityRepository extends JpaRepository<Facility, Integer> {
	@Query("SELECT f FROM Facility f WHERE f.facilityName LIKE %?1%")
	Facility findByFacilityName(String facilityName);
	
	@Query(value = "SELECT facility.* FROM facility INNER JOIN facility_category ON "
			+ " facility_category_id_facility_category = id_facility_category "
			+ " WHERE facility_category_name like %?1% AND id_facility NOT IN "
			+ " (SELECT facility_id_facility FROM timestamp_facility INNER JOIN facility_category ON "
			+ " facility_category_id_facility_category = id_facility_category WHERE ref_timestamp like %?2% ) ", nativeQuery = true)
	List<Facility> findByFacilityAvailable(String facilityName, String timestamp);

}
