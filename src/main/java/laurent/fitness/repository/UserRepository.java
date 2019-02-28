package laurent.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import laurent.fitness.model.User;

public interface UserRepository extends JpaRepository<User, String>{
//	User findByUsername(String username);
//    User getByUsersId(Long id);
//    void deleteByUsername(String username);
}



