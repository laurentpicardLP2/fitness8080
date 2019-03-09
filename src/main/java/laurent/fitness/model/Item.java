package laurent.fitness.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the Item database table.
 * 
 */
@Entity
@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idItem;

	private float price;

	private int statusPurchase;

	//bi-directional many-to-many association to Command
	@ManyToMany
	@JoinTable(
		name="Command_has_Item"
		, joinColumns={
			@JoinColumn(name="Item_idItem")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Command_idCommand")
			}
		)
	@JsonManagedReference
	private List<Command> commands;

	//bi-directional many-to-one association to SessionTraining
	@ManyToOne
	@JoinColumn(name="SessionTraining_idSessionTraining")
	private SessionTraining sessionTraining;

	//bi-directional many-to-one association to ConnectedWatch
	@ManyToOne
	@JoinColumn(name="ConnectedWatch_idConnectedWatch")
	private ConnectedWatch connectedWatch;

	//bi-directional many-to-one association to Subscription
	@ManyToOne
	@JoinColumn(name="Subscription_idSubscriptionType")
	private Subscription subscription;

	//bi-directional many-to-one association to Seance
	@ManyToOne
	@JoinColumn(name="Seance_idSeance")
	private Seance seance;

	public Item() {
	}
	
	public Item(List<Command> commands) {
		setCommands(commands);
	}


	public int getIdItem() {
		return this.idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getStatusPurchase() {
		return this.statusPurchase;
	}

	public void setStatusPurchase(int statusPurchase) {
		this.statusPurchase = statusPurchase;
	}

	public List<Command> getCommands() {
		return this.commands;
	}

	public void setCommands(List<Command> commands) {
		this.commands = commands;
	}

	public SessionTraining getSessionTraining() {
		return this.sessionTraining;
	}

	public void setSessionTraining(SessionTraining sessionTraining) {
		this.sessionTraining = sessionTraining;
	}

	public ConnectedWatch getConnectedWatch() {
		return this.connectedWatch;
	}

	public void setConnectedWatch(ConnectedWatch connectedWatch) {
		this.connectedWatch = connectedWatch;
	}

	public Subscription getSubscription() {
		return this.subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	public Seance getSeance() {
		return this.seance;
	}

	public void setSeance(Seance seance) {
		this.seance = seance;
	}

}