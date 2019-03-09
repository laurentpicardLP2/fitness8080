package laurent.fitness.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Seance database table.
 * 
 */
@Entity
@NamedQuery(name="Seance.findAll", query="SELECT s FROM Seance s")
public class Seance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idSeance;

	//bi-directional many-to-one association to Item
	@OneToMany(mappedBy="seance")
	private List<Item> items;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="Customer_Users_username")
	private Customer customer;

	//bi-directional many-to-one association to TimestampFacility
	@OneToMany(mappedBy="seance")
	private List<TimestampFacility> timestampFacilities;

	public Seance() {
	}

	public int getIdSeance() {
		return this.idSeance;
	}

	public void setIdSeance(int idSeance) {
		this.idSeance = idSeance;
	}

	public List<Item> getItems() {
		return this.items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Item addItem(Item item) {
		getItems().add(item);
		item.setSeance(this);

		return item;
	}

	public Item removeItem(Item item) {
		getItems().remove(item);
		item.setSeance(null);

		return item;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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