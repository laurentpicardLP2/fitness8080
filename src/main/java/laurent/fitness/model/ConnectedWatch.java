package laurent.fitness.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import laurent.fitness.model.Purchase;


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

	private String modelWatch;

	private float price;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="Customer_Users_username")
	private Customer customer;

	//bi-directional many-to-one association to Purchase
	@OneToMany(mappedBy="connectedWatch")
	private List<Purchase> purchases;

	public ConnectedWatch() {
	}

	public int getIdConnectedWatch() {
		return this.idConnectedWatch;
	}

	public void setIdConnectedWatch(int idConnectedWatch) {
		this.idConnectedWatch = idConnectedWatch;
	}

	public String getModelWatch() {
		return this.modelWatch;
	}

	public void setModelWatch(String modelWatch) {
		this.modelWatch = modelWatch;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Purchase> getPurchases() {
		return this.purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}

	public Purchase addPurchas(Purchase purchas) {
		getPurchases().add(purchas);
		purchas.setConnectedWatch(this);

		return purchas;
	}

	public Purchase removePurchas(Purchase purchas) {
		getPurchases().remove(purchas);
		purchas.setConnectedWatch(null);

		return purchas;
	}

}