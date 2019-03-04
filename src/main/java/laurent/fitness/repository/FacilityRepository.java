package laurent.fitness.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import laurent.fitness.model.Facility;


public interface FacilityRepository extends JpaRepository<Facility, Integer> {
	@Query("SELECT f FROM Facility f WHERE f.facilityName LIKE %?1%")
	Facility findByFacilityName(String facilityName);

}
