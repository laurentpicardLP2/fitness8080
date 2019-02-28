package laurent.fitness.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ConnectedWatch database table.
 * 
 */
@Entity
@NamedQuery(name="ConnectedWatch.findAll", query="SELECT c FROM ConnectedWatch c")
public class ConnectedWatch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idConnectedWatch;

	@Column(name="Users_username")
	private String users_username;

	//bi-directional many-to-one association to ConnectedWatchModel
	@ManyToOne
	@JoinColumn(name="ConnectedWatchModel_idConnectedWatchModel")
	private ConnectedWatchModel connectedWatchModel;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="Customer_idCustomer")
	private Customer customer;

	//bi-directional many-to-one association to Prestation
	@ManyToOne
	@JoinColumn(name="Prestation_idPrestation")
	private Prestation prestation;

	public ConnectedWatch() {
	}

	public int getIdConnectedWatch() {
		return this.idConnectedWatch;
	}

	public void setIdConnectedWatch(int idConnectedWatch) {
		this.idConnectedWatch = idConnectedWatch;
	}

	public String getUsers_username() {
		return this.users_username;
	}

	public void setUsers_username(String users_username) {
		this.users_username = users_username;
	}

	public ConnectedWatchModel getConnectedWatchModel() {
		return this.connectedWatchModel;
	}

	public void setConnectedWatchModel(ConnectedWatchModel connectedWatchModel) {
		this.connectedWatchModel = connectedWatchModel;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Prestation getPrestation() {
		return this.prestation;
	}

	public void setPrestation(Prestation prestation) {
		this.prestation = prestation;
	}

}