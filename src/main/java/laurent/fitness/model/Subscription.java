package laurent.fitness.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Subscription database table.
 * 
 */
@Entity
@NamedQuery(name="Subscription.findAll", query="SELECT s FROM Subscription s")
public class Subscription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idSubscription;

	@Column(name="Users_username")
	private String users_username;

	//bi-directional many-to-one association to Prestation
	@ManyToOne
	@JoinColumn(name="Prestation_idPrestation")
	private Prestation prestation;

	//bi-directional many-to-one association to SubscriptionModel
	@ManyToOne
	@JoinColumn(name="SubscriptionModel_idSubscriptionType")
	private SubscriptionModel subscriptionModel;

	public Subscription() {
	}

	public int getIdSubscription() {
		return this.idSubscription;
	}

	public void setIdSubscription(int idSubscription) {
		this.idSubscription = idSubscription;
	}

	public String getUsers_username() {
		return this.users_username;
	}

	public void setUsers_username(String users_username) {
		this.users_username = users_username;
	}

	public Prestation getPrestation() {
		return this.prestation;
	}

	public void setPrestation(Prestation prestation) {
		this.prestation = prestation;
	}

	public SubscriptionModel getSubscriptionModel() {
		return this.subscriptionModel;
	}

	public void setSubscriptionModel(SubscriptionModel subscriptionModel) {
		this.subscriptionModel = subscriptionModel;
	}

}