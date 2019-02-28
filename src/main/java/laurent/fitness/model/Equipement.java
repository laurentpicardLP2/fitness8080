package laurent.fitness.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Equipement database table.
 * 
 */
@Entity
@NamedQuery(name="Equipement.findAll", query="SELECT e FROM Equipement e")
public class Equipement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idEquipement;

	private String nameEquipement;

	private String seance;

	private String timestamp;

	//bi-directional many-to-one association to EquipementModel
	@ManyToOne
	@JoinColumn(name="EquipementModel_idEquipementModel")
	private EquipementModel equipementModel;

	//bi-directional many-to-one association to Room
	@OneToMany(mappedBy="equipement")
	private List<Room> rooms;

	public Equipement() {
	}

	public int getIdEquipement() {
		return this.idEquipement;
	}

	public void setIdEquipement(int idEquipement) {
		this.idEquipement = idEquipement;
	}

	public String getNameEquipement() {
		return this.nameEquipement;
	}

	public void setNameEquipement(String nameEquipement) {
		this.nameEquipement = nameEquipement;
	}

	public String getSeance() {
		return this.seance;
	}

	public void setSeance(String seance) {
		this.seance = seance;
	}

	public String getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public EquipementModel getEquipementModel() {
		return this.equipementModel;
	}

	public void setEquipementModel(EquipementModel equipementModel) {
		this.equipementModel = equipementModel;
	}

	public List<Room> getRooms() {
		return this.rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public Room addRoom(Room room) {
		getRooms().add(room);
		room.setEquipement(this);

		return room;
	}

	public Room removeRoom(Room room) {
		getRooms().remove(room);
		room.setEquipement(null);

		return room;
	}

}