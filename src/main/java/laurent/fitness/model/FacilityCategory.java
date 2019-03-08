package laurent.fitness.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the FacilityCategory database table.
 * 
 */
@Entity
@NamedQuery(name="FacilityCategory.findAll", query="SELECT f FROM FacilityCategory f")
public class FacilityCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idFacilityCategory;

	@Lob
	private String description;

	private String facilityCategoryName;

	private String image;

	private float price;

	private int quantity;

	//bi-directional many-to-one association to Facility
	@OneToMany(mappedBy="facilityCategory")
	@JsonManagedReference
	private List<Facility> facilities;
	
	//bi-directional many-to-one association to TimestampFacility
	@OneToMany(mappedBy="facilityCategory")
	private List<TimestampFacility> timestampFacilities;


	public FacilityCategory() {
	}
	
	public FacilityCategory(String facilityCategoryName, int quantity) {
		this.facilityCategoryName = facilityCategoryName;
		this.quantity = quantity;
	}
	
	public FacilityCategory(String facilityCategoryName, int quantity, String description) {
		this.facilityCategoryName = facilityCategoryName;
		this.quantity = quantity;
		this.description = description;
	}
	
	public FacilityCategory(String facilityCategoryName, int quantity, String description, String image) {
		this.facilityCategoryName = facilityCategoryName;
		this.quantity = quantity;
		this.description = description;
		this.image = image;
	}

	public int getIdFacilityCategory() {
		return this.idFacilityCategory;
	}

	public void setIdFacilityCategory(int idFacilityCategory) {
		this.idFacilityCategory = idFacilityCategory;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFacilityCategoryName() {
		return this.facilityCategoryName;
	}

	public void setFacilityCategoryName(String facilityCategoryName) {
		this.facilityCategoryName = facilityCategoryName;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@JsonIgnore
	public List<Facility> getFacilities() {
		return this.facilities;
	}

	public void setFacilities(List<Facility> facilities) {
		this.facilities = facilities;
	}

	public Facility addFacility(Facility facility) {
		getFacilities().add(facility);
		facility.setFacilityCategory(this);

		return facility;
	}

	public Facility removeFacility(Facility facility) {
		getFacilities().remove(facility);
		facility.setFacilityCategory(null);

		return facility;
	}
	
	@JsonIgnore
	public List<TimestampFacility> getTimestampFacilities() {
		return this.timestampFacilities;
	}

	public void setTimestampFacilities(List<TimestampFacility> timestampFacilities) {
		this.timestampFacilities = timestampFacilities;
	}

	public TimestampFacility addTimestampFacility(TimestampFacility timestampFacility) {
		getTimestampFacilities().add(timestampFacility);
		timestampFacility.setFacilityCategory(this);

		return timestampFacility;
	}

	public TimestampFacility removeTimestampFacility(TimestampFacility timestampFacility) {
		getTimestampFacilities().remove(timestampFacility);
		timestampFacility.setFacilityCategory(null);

		return timestampFacility;
	}


}