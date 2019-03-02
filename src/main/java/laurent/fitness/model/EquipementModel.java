package laurent.fitness.model;

import java.io.Serializable;
import javax.persistence.*;


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
	@ManyToOne
	@JoinColumn(name="Equipement_idEquipement")
	private Equipement equipement;

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

	public Equipement getEquipement() {
		return this.equipement;
	}

	public void setEquipement(Equipement equipement) {
		this.equipement = equipement;
	}

}