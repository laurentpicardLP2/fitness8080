package laurent.fitness.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TimestampMaterial database table.
 * 
 */
@Entity
@NamedQuery(name="TimestampMaterial.findAll", query="SELECT t FROM TimestampMaterial t")
public class TimestampMaterial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idTimestampMaterial;

	private String nameCategory;

	private String refTimestamp;

	//bi-directional many-to-one association to Material
	@OneToMany(mappedBy="timestampMaterial")
	private List<Material> materials;

	public TimestampMaterial() {
	}

	public int getIdTimestampMaterial() {
		return this.idTimestampMaterial;
	}

	public void setIdTimestampMaterial(int idTimestampMaterial) {
		this.idTimestampMaterial = idTimestampMaterial;
	}

	public String getNameCategory() {
		return this.nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public String getRefTimestamp() {
		return this.refTimestamp;
	}

	public void setRefTimestamp(String refTimestamp) {
		this.refTimestamp = refTimestamp;
	}

	public List<Material> getMaterials() {
		return this.materials;
	}

	public void setMaterials(List<Material> materials) {
		this.materials = materials;
	}

	public Material addMaterial(Material material) {
		getMaterials().add(material);
		material.setTimestampMaterial(this);

		return material;
	}

	public Material removeMaterial(Material material) {
		getMaterials().remove(material);
		material.setTimestampMaterial(null);

		return material;
	}

}