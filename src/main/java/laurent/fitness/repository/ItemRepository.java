package laurent.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import laurent.fitness.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
