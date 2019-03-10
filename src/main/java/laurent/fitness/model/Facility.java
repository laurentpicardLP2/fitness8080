package laurent.fitness.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the Facility database table.
 * 
 */
@Entity
@NamedQuery(name="Facility.findAll", query="SELECT f FROM Facility f")
public class Facility implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idFacility;

	private String facilityName;

	//bi-directional many-to-one association to Room
	@ManyToOne
	@JoinColumn(name="Room_idRoom")
	@JsonBackReference
	private Room room;

	//bi-directional many-to-one association to FacilityCategory
	@ManyToOne
	@JoinColumn(name="FacilityCategory_idFacilityCategory")
	@JsonBackReference
	private FacilityCategory facilityCategory;

	//bi-directional many-to-one association to MaintenanceOperation
	@OneToMany(mappedBy="facility")
	@JsonManagedReference
	private List<MaintenanceOperation> maintenanceOperations;

	//bi-directional many-to-one association to TimestampFacility
	@OneToMany(mappedBy="facility")
	@JsonManagedReference
	private List<TimestampFacility> timestampFacilities;

	public Facility() {
	}
	
	public Facility(String facilityName, Room room, FacilityCategory facilityCategory) {
		this.facilityName = facilityName;
		this.room = room;
		this.facilityCategory = facilityCategory;
	}

	public int getIdFacility() {
		return this.idFacility;
	}

	public void setIdFacility(int idFacility) {
		this.idFacility = idFacility;
	}

	public String getFacilityName() {
		return this.facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public FacilityCategory getFacilityCategory() {
		return this.facilityCategory;
	}

	public void setFacilityCategory(FacilityCategory facilityCategory) {
		this.facilityCategory = facilityCategory;
	}

	public List<MaintenanceOperation> getMaintenanceOperations() {
		return this.maintenanceOperations;
	}

	public void setMaintenanceOperations(List<MaintenanceOperation> maintenanceOperations) {
		this.maintenanceOperations = maintenanceOperations;
	}

	public MaintenanceOperation addMaintenanceOperation(MaintenanceOperation maintenanceOperation) {
		getMaintenanceOperations().add(maintenanceOperation);
		maintenanceOperation.setFacility(this);

		return maintenanceOperation;
	}

	public MaintenanceOperation removeMaintenanceOperation(MaintenanceOperation maintenanceOperation) {
		getMaintenanceOperations().remove(maintenanceOperation);
		maintenanceOperation.setFacility(null);

		return maintenanceOperation;
	}

	public List<TimestampFacility> getTimestampFacilities() {
		return this.timestampFacilities;
	}

	public void setTimestampFacilities(List<TimestampFacility> timestampFacilities) {
		this.timestampFacilities = timestampFacilities;
	}

	public TimestampFacility addTimestampFacility(TimestampFacility timestampFacility) {
		getTimestampFacilities().add(timestampFacility);
		timestampFacility.setFacility(this);

		return timestampFacility;
	}

	public TimestampFacility removeTimestampFacility(TimestampFacility timestampFacility) {
		getTimestampFacilities().remove(timestampFacility);
		timestampFacility.setFacility(null);

		return timestampFacility;
	}

}