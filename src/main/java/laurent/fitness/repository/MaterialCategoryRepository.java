package laurent.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import laurent.fitness.model.MaterialCategory;

public interface MaterialCategoryRepository extends JpaRepository<MaterialCategory, Integer> {
	@Query("SELECT mc FROM MaterialCategory mc WHERE mc.materialCategoryName LIKE %?1%")
	MaterialCategory findByMaterialCategoryName(String materialCategoryName);
}
