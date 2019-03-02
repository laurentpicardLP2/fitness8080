package laurent.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import laurent.fitness.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
