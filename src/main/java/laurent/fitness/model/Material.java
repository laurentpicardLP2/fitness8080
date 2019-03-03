package laurent.fitness.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Material database table.
 * 
 */
@Entity
@NamedQuery(name="Material.findAll", query="SELECT m FROM Material m")
public class Material implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idMaterial;

	private String materialName;

	//bi-directional many-to-one association to Room
	@ManyToOne
	@JoinColumn(name="Room_idRoom")
	private Room room;

	//bi-directional many-to-one association to MaterialCategory
	@ManyToOne
	@JoinColumn(name="MaterialCategory_idMaterial")
	private MaterialCategory materialCategory;

	//bi-directional many-to-one association to TimestampMaterial
	@ManyToOne
	@JoinColumn(name="TimestampMaterial_idTimestampMaterial")
	private TimestampMaterial timestampMaterial;

	//bi-directional many-to-many association to Seance
	@ManyToMany(mappedBy="materials")
	private List<Seance> seances;

	public Material() {
	}

	public int getIdMaterial() {
		return this.idMaterial;
	}

	public void setIdMaterial(int idMaterial) {
		this.idMaterial = idMaterial;
	}

	public String getMaterialName() {
		return this.materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public MaterialCategory getMaterialCategory() {
		return this.materialCategory;
	}

	public void setMaterialCategory(MaterialCategory materialCategory) {
		this.materialCategory = materialCategory;
	}

	public TimestampMaterial getTimestampMaterial() {
		return this.timestampMaterial;
	}

	public void setTimestampMaterial(TimestampMaterial timestampMaterial) {
		this.timestampMaterial = timestampMaterial;
	}

	public List<Seance> getSeances() {
		return this.seances;
	}

	public void setSeances(List<Seance> seances) {
		this.seances = seances;
	}

}