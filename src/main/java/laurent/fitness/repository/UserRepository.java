package laurent.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import laurent.fitness.model.User;

public interface UserRepository extends JpaRepository<User, String>{
//	User findByUsername(String username);
//    User getByUsersId(Long id);
//    void deleteByUsername(String username);
	
	@Query("SELECT u FROM User u WHERE u.idUser in (SELECT MAX(idUser) from User)")
	 public User findByUsernameIdMax();
}



