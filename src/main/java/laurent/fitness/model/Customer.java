package laurent.fitness.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Customer database table.
 * 
 */
@Entity
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idCustomer;

	private String deliveryAddress;

	private String deliveryCity;

	private String deliveryCountry;

	private String deliveryCp;

	private String domesticAddress;

	private String domesticCity;

	private String domesticCountry;

	private String domesticCp;

	private String modelWatch;

	private String typeSubscription;

	//bi-directional many-to-one association to ConnectedWatch
	@OneToMany(mappedBy="customer")
	private List<ConnectedWatch> connectedWatches;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="Users_username")
	private User user;

	public Customer() {
	}

	public int getIdCustomer() {
		return this.idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getDeliveryAddress() {
		return this.deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getDeliveryCity() {
		return this.deliveryCity;
	}

	public void setDeliveryCity(String deliveryCity) {
		this.deliveryCity = deliveryCity;
	}

	public String getDeliveryCountry() {
		return this.deliveryCountry;
	}

	public void setDeliveryCountry(String deliveryCountry) {
		this.deliveryCountry = deliveryCountry;
	}

	public String getDeliveryCp() {
		return this.deliveryCp;
	}

	public void setDeliveryCp(String deliveryCp) {
		this.deliveryCp = deliveryCp;
	}

	public String getDomesticAddress() {
		return this.domesticAddress;
	}

	public void setDomesticAddress(String domesticAddress) {
		this.domesticAddress = domesticAddress;
	}

	public String getDomesticCity() {
		return this.domesticCity;
	}

	public void setDomesticCity(String domesticCity) {
		this.domesticCity = domesticCity;
	}

	public String getDomesticCountry() {
		return this.domesticCountry;
	}

	public void setDomesticCountry(String domesticCountry) {
		this.domesticCountry = domesticCountry;
	}

	public String getDomesticCp() {
		return this.domesticCp;
	}

	public void setDomesticCp(String domesticCp) {
		this.domesticCp = domesticCp;
	}

	public String getModelWatch() {
		return this.modelWatch;
	}

	public void setModelWatch(String modelWatch) {
		this.modelWatch = modelWatch;
	}

	public String getTypeSubscription() {
		return this.typeSubscription;
	}

	public void setTypeSubscription(String typeSubscription) {
		this.typeSubscription = typeSubscription;
	}

	public List<ConnectedWatch> getConnectedWatches() {
		return this.connectedWatches;
	}

	public void setConnectedWatches(List<ConnectedWatch> connectedWatches) {
		this.connectedWatches = connectedWatches;
	}

	public ConnectedWatch addConnectedWatch(ConnectedWatch connectedWatch) {
		getConnectedWatches().add(connectedWatch);
		connectedWatch.setCustomer(this);

		return connectedWatch;
	}

	public ConnectedWatch removeConnectedWatch(ConnectedWatch connectedWatch) {
		getConnectedWatches().remove(connectedWatch);
		connectedWatch.setCustomer(null);

		return connectedWatch;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}