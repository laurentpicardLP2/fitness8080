package laurent.fitness.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;


/**
 * The persistent class for the ConnectedWatch database table.
 * 
 */
@Entity
@NamedQuery(name="ConnectedWatch.findAll", query="SELECT c FROM ConnectedWatch c")
public class ConnectedWatch extends Item implements Serializable {
	private static final long serialVersionUID = 1L;

	private String modelWatch;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="Customer_Users_username")
	@JsonBackReference
	private Customer customer;

	public ConnectedWatch() {
	}
	
	public ConnectedWatch(List<Command> commands) {
		super(commands);
	}

	public String getModelWatch() {
		return this.modelWatch;
	}

	public void setModelWatch(String modelWatch) {
		this.modelWatch = modelWatch;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}