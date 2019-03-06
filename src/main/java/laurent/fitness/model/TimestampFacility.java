package laurent.fitness.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;



/**
 * The persistent class for the TimestampFacility database table.
 * 
 */
@Entity
@NamedQuery(name="TimestampFacility.findAll", query="SELECT t FROM TimestampFacility t")
public class TimestampFacility implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int idTimestampFacillity;

	private String refTimestamp;

	private int statusBooking;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name="Facility_idFacility")
	private Facility facility;
	
	//bi-directional many-to-one association to FacilityCategory
	@ManyToOne
	@JoinColumn(name="FacilityCategory_idFacilityCategory")
	private FacilityCategory facilityCategory;


	//bi-directional many-to-one association to Seance
	@ManyToOne
	@JoinColumn(name="Seance_idSeance")
	private Seance seance;

	public TimestampFacility() {
	}

    public TimestampFacility(String refTimestamp, Facility facility, FacilityCategory facilityCategory) {
		this.refTimestamp = refTimestamp;
		this.facility = facility;
		this.facilityCategory = facilityCategory;
	}

	public int getIdTimestampFacillity() {
		return this.idTimestampFacillity;
	}

	public void setIdTimestampFacillity(int idTimestampFacillity) {
		this.idTimestampFacillity = idTimestampFacillity;
	}

	public String getRefTimestamp() {
		return this.refTimestamp;
	}

	public void setRefTimestamp(String refTimestamp) {
		this.refTimestamp = refTimestamp;
	}

	public int getStatusBooking() {
		return this.statusBooking;
	}

	public void setStatusBooking(int statusBooking) {
		this.statusBooking = statusBooking;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}
	
	public FacilityCategory getFacilityCategory() {
		return this.facilityCategory;
	}

	public void setFacilityCategory(FacilityCategory facilityCategory) {
		this.facilityCategory = facilityCategory;
	}


	public Seance getSeance() {
		return this.seance;
	}

	public void setSeance(Seance seance) {
		this.seance = seance;
	}

}