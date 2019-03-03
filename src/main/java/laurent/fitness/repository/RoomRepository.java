package laurent.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import laurent.fitness.model.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {
	@Query("SELECT r FROM Room r WHERE r.roomName LIKE %?1%")
	Room findByRoomName(String roomName);
}
