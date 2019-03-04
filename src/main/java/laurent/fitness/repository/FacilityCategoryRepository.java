package laurent.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import laurent.fitness.model.FacilityCategory;

public interface FacilityCategoryRepository extends JpaRepository<FacilityCategory, Integer> {
	@Query("SELECT fc FROM FacilityCategory fc WHERE fc.facilityCategoryName LIKE %?1%")
	FacilityCategory findByFacilityCategoryName(String facilityCategoryName);
}