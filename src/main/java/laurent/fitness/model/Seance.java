package laurent.fitness.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Seance database table.
 * 
 */
@Entity
@NamedQuery(name="Seance.findAll", query="SELECT s FROM Seance s")
public class Seance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idSeance;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="Customer_Users_username")
	private Customer customer;

	//bi-directional many-to-one association to Purchase
	@ManyToOne
	@JoinColumn(name="Purchase_idPrestation")
	private Purchase purchase;

	public Seance() {
	}

	public int getIdSeance() {
		return this.idSeance;
	}

	public void setIdSeance(int idSeance) {
		this.idSeance = idSeance;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Purchase getPurchase() {
		return this.purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

}