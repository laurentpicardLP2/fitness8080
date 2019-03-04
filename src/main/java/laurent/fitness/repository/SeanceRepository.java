package laurent.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import laurent.fitness.model.Seance;

public interface SeanceRepository extends JpaRepository<Seance, Integer> {

}
