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

	//bi-directional many-to-one association to Room
	@ManyToOne
	@JoinColumn(name="Room_idRoom")
	private Room room;

	//bi-directional many-to-one association to EquipementModel
	@OneToMany(mappedBy="equipement")
	private List<EquipementModel> equipementModels;

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

	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public List<EquipementModel> getEquipementModels() {
		return this.equipementModels;
	}

	public void setEquipementModels(List<EquipementModel> equipementModels) {
		this.equipementModels = equipementModels;
	}

	public EquipementModel addEquipementModel(EquipementModel equipementModel) {
		getEquipementModels().add(equipementModel);
		equipementModel.setEquipement(this);

		return equipementModel;
	}

	public EquipementModel removeEquipementModel(EquipementModel equipementModel) {
		getEquipementModels().remove(equipementModel);
		equipementModel.setEquipement(null);

		return equipementModel;
	}

}