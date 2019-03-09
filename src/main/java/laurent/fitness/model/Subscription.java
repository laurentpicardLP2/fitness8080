package laurent.fitness.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Subscription database table.
 * 
 */
@Entity
@NamedQuery(name="Subscription.findAll", query="SELECT s FROM Subscription s")
public class Subscription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idSubscriptionType;

	private String last;

	private String nameSubscription;

	private float price;

	//bi-directional many-to-one association to Item
	@OneToMany(mappedBy="subscription")
	private List<Item> items;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="Customer_Users_username")
	private Customer customer;

	public Subscription() {
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

	public List<Item> getItems() {
		return this.items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Item addItem(Item item) {
		getItems().add(item);
		item.setSubscription(this);

		return item;
	}

	public Item removeItem(Item item) {
		getItems().remove(item);
		item.setSubscription(null);

		return item;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}