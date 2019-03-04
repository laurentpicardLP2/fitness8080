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

	//bi-directional many-to-many association to Seance
	@ManyToMany
	@JoinTable(
		name="Seance_has_TimestampFacility"
		, joinColumns={
			@JoinColumn(name="TimestampFacility_idTimestampFacillity")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Seance_idSeance")
			}
		)
	private List<Seance> seances;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name="Facility_idFacility")
	private Facility facility;

	public TimestampFacility() {
	}
	
	public TimestampFacility(String refTimestamp, Facility facility) {
		this.refTimestamp = refTimestamp;
		this.facility = facility;
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

	public List<Seance> getSeances() {
		return this.seances;
	}

	public void setSeances(List<Seance> seances) {
		this.seances = seances;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

}