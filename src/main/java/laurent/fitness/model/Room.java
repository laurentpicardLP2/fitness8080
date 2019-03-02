package laurent.fitness.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Room database table.
 * 
 */
@Entity
@NamedQuery(name="Room.findAll", query="SELECT r FROM Room r")
public class Room implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idRoom;

	private int capacity;

	//bi-directional many-to-one association to Equipement
	@OneToMany(mappedBy="room")
	private List<Equipement> equipements;

	//bi-directional many-to-one association to SessionTraining
	@OneToMany(mappedBy="room")
	private List<SessionTraining> sessionTrainings;

	public Room() {
	}

	public int getIdRoom() {
		return this.idRoom;
	}

	public void setIdRoom(int idRoom) {
		this.idRoom = idRoom;
	}

	public int getCapacity() {
		return this.capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<Equipement> getEquipements() {
		return this.equipements;
	}

	public void setEquipements(List<Equipement> equipements) {
		this.equipements = equipements;
	}

	public Equipement addEquipement(Equipement equipement) {
		getEquipements().add(equipement);
		equipement.setRoom(this);

		return equipement;
	}

	public Equipement removeEquipement(Equipement equipement) {
		getEquipements().remove(equipement);
		equipement.setRoom(null);

		return equipement;
	}

	public List<SessionTraining> getSessionTrainings() {
		return this.sessionTrainings;
	}

	public void setSessionTrainings(List<SessionTraining> sessionTrainings) {
		this.sessionTrainings = sessionTrainings;
	}

	public SessionTraining addSessionTraining(SessionTraining sessionTraining) {
		getSessionTrainings().add(sessionTraining);
		sessionTraining.setRoom(this);

		return sessionTraining;
	}

	public SessionTraining removeSessionTraining(SessionTraining sessionTraining) {
		getSessionTrainings().remove(sessionTraining);
		sessionTraining.setRoom(null);

		return sessionTraining;
	}

}