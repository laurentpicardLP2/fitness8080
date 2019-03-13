package laurent.fitness.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the Seance database table.
 * 
 */
@Entity
@NamedQuery(name="Seance.findAll", query="SELECT s FROM Seance s")
public class Seance extends Item implements Serializable {
	private static final long serialVersionUID = 1L;


	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="Customer_Users_username")
	@JsonIgnore
	private Customer customer;

	private int statusSeance;

	//bi-directional many-to-one association to TimestampFacility
	@OneToMany(mappedBy="seance", cascade=CascadeType.REMOVE)
	@JsonManagedReference
	private List<TimestampFacility> timestampFacilities;

	public Seance() {
		this.timestampFacilities = new ArrayList<TimestampFacility>();
	}
	
	public Seance (List<Command> commands) {
		super(commands);
		this.timestampFacilities = new ArrayList<TimestampFacility>();
	}
	
	public Seance (List<Command> commands, Customer customer) {
		super(commands);
		this.customer = customer;
		this.timestampFacilities = new ArrayList<TimestampFacility>();
	}
	
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public int getStatusSeance() {
		return this.statusSeance;
	}

	public void setStatusSeance(int statusSeance) {
		this.statusSeance = statusSeance;
	}
	
	public List<TimestampFacility> getTimestampFacilities() {
		return this.timestampFacilities;
	}

	public void setTimestampFacilities(List<TimestampFacility> timestampFacilities) {
		this.timestampFacilities = timestampFacilities;
	}	

	public TimestampFacility addTimestampFacility(TimestampFacility timestampFacility) {
		getTimestampFacilities().add(timestampFacility);
		timestampFacility.setSeance(this);

		return timestampFacility;
	}

	public TimestampFacility removeTimestampFacility(TimestampFacility timestampFacility) {
		getTimestampFacilities().remove(timestampFacility);
		timestampFacility.setSeance(null);

		return timestampFacility;
	}

}