package laurent.fitness.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SubscriptionModel database table.
 * 
 */
@Entity
@NamedQuery(name="SubscriptionModel.findAll", query="SELECT s FROM SubscriptionModel s")
public class SubscriptionModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idSubscriptionType;

	private String last;

	private String nameSubscription;

	private float price;

	//bi-directional many-to-one association to Subscription
	@OneToMany(mappedBy="subscriptionModel")
	private List<Subscription> subscriptions;

	public SubscriptionModel() {
	}

	public int getIdSubscriptionType() {
		return this.idSubscriptionType;
	}

	public void setIdSubscriptionType(int idSubscriptionType) {
		this.idSubscriptionType = idSubscriptionType;
	}

	public String getLast() {
		return this.last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getNameSubscription() {
		return this.nameSubscription;
	}

	public void setNameSubscription(String nameSubscription) {
		this.nameSubscription = nameSubscription;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public List<Subscription> getSubscriptions() {
		return this.subscriptions;
	}

	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

	public Subscription addSubscription(Subscription subscription) {
		getSubscriptions().add(subscription);
		subscription.setSubscriptionModel(this);

		return subscription;
	}

	public Subscription removeSubscription(Subscription subscription) {
		getSubscriptions().remove(subscription);
		subscription.setSubscriptionModel(null);

		return subscription;
	}

}