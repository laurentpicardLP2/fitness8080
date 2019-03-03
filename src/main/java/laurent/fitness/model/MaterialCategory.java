package laurent.fitness.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MaterialCategory database table.
 * 
 */
@Entity
@NamedQuery(name="MaterialCategory.findAll", query="SELECT m FROM MaterialCategory m")
public class MaterialCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idMaterialCategory;

	@Lob
	private String description;

	private String image;

	private String materialCategoryName;

	private int quantity;

	//bi-directional many-to-one association to Material
	@OneToMany(mappedBy="materialCategory")
	private List<Material> materials;

	public MaterialCategory() {
	}
	
	public MaterialCategory(String materialCategoryName, int quantity) {
		this.materialCategoryName = materialCategoryName;
		this.quantity = quantity;
	}
	
	public MaterialCategory(String materialCategoryName, int quantity, String description) {
		this.materialCategoryName = materialCategoryName;
		this.quantity = quantity;
		this.description = description;
	}
	
	public MaterialCategory(String materialCategoryName, int quantity, String description, String image) {
		this.materialCategoryName = materialCategoryName;
		this.quantity = quantity;
		this.description = description;
		this.image = image;
	}

	public int getIdMaterialCategory() {
		return this.idMaterialCategory;
	}

	public void setIdMaterialCategory(int idMaterialCategory) {
		this.idMaterialCategory = idMaterialCategory;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getMaterialCategoryName() {
		return this.materialCategoryName;
	}

	public void setMaterialCategoryName(String materialCategoryName) {
		this.materialCategoryName = materialCategoryName;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<Material> getMaterials() {
		return this.materials;
	}

	public void setMaterials(List<Material> materials) {
		this.materials = materials;
	}

	public Material addMaterial(Material material) {
		getMaterials().add(material);
		material.setMaterialCategory(this);

		return material;
	}

	public Material removeMaterial(Material material) {
		getMaterials().remove(material);
		material.setMaterialCategory(null);

		return material;
	}

}