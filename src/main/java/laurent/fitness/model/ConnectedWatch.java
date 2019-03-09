package laurent.fitness.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ConnectedWatch database table.
 * 
 */
@Entity
@NamedQuery(name="ConnectedWatch.findAll", query="SELECT c FROM ConnectedWatch c")
public class ConnectedWatch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idConnectedWatch;

	private String modelWatch;

	private float price;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="Customer_Users_username")
	private Customer customer;

	//bi-directional many-to-one association to Item
	@OneToMany(mappedBy="connectedWatch")
	private List<Item> items;

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

	public List<Item> getItems() {
		return this.items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Item addItem(Item item) {
		getItems().add(item);
		item.setConnectedWatch(this);

		return item;
	}

	public Item removeItem(Item item) {
		getItems().remove(item);
		item.setConnectedWatch(null);

		return item;
	}

}