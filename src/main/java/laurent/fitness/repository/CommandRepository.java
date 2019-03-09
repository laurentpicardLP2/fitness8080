package laurent.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import laurent.fitness.model.Command;

public interface CommandRepository extends JpaRepository<Command, Integer> {
	@Query("SELECT c FROM Command c WHERE c.idCommand = ?1")
	Command findByCommand(int idCommand);
}
