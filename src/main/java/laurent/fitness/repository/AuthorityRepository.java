package laurent.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import laurent.fitness.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, String>{
//	@Query("SELECT a FROM Authorities a WHERE a.username LIKE %?1%")
//	 public Authority findByUsername(String name);
//	
//	void deleteByUsername(String username);
}


