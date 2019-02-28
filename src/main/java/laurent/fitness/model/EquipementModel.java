package laurent.fitness.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the EquipementModel database table.
 * 
 */
@Entity
@NamedQuery(name="EquipementModel.findAll", query="SELECT e FROM EquipementModel e")
public class EquipementModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idEquipementModel;

	private String categoryEquipement;

	private String nameEquipement;

	private String quantity;

	//bi-directional many-to-one association to Equipement
	@OneToMany(mappedBy="equipementModel")
	private List<Equipement> equipements;

	public EquipementModel() {
	}

	public int getIdEquipementModel() {
		return this.idEquipementModel;
	}

	public void setIdEquipementModel(int idEquipementModel) {
		this.idEquipementModel = idEquipementModel;
	}

	public String getCategoryEquipement() {
		return this.categoryEquipement;
	}

	public void setCategoryEquipement(String categoryEquipement) {
		this.categoryEquipement = categoryEquipement;
	}

	public String getNameEquipement() {
		return this.nameEquipement;
	}

	public void setNameEquipement(String nameEquipement) {
		this.nameEquipement = nameEquipement;
	}

	public String getQuantity() {
		return this.quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public List<Equipement> getEquipements() {
		return this.equipements;
	}

	public void setEquipements(List<Equipement> equipements) {
		this.equipements = equipements;
	}

	public Equipement addEquipement(Equipement equipement) {
		getEquipements().add(equipement);
		equipement.setEquipementModel(this);

		return equipement;
	}

	public Equipement removeEquipement(Equipement equipement) {
		getEquipements().remove(equipement);
		equipement.setEquipementModel(null);

		return equipement;
	}

}