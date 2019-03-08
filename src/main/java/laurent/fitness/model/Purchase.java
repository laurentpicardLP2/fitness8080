package laurent.fitness.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Purchase database table.
 * 
 */
@Entity
@NamedQuery(name="Purchase.findAll", query="SELECT p FROM Purchase p")
public class Purchase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPrestation;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfPurchase;

	private float price;

	//bi-directional many-to-one association to ConnectedWatch
	@ManyToOne
	@JoinColumn(name="ConnectedWatch_idConnectedWatch")
	
	private ConnectedWatch connectedWatch;

	//bi-directional many-to-one association to Subscription
	@ManyToOne
	@JoinColumn(name="Subscription_idSubscriptionType")
	private Subscription subscription;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="Users_username")
	private User user;

	//bi-directional many-to-one association to Seance
	@OneToMany(mappedBy="purchase")
	private List<Seance> seances;

	//bi-directional many-to-many association to Command
	@ManyToMany
	@JoinTable(
		name="Purchase_has_Command"
		, joinColumns={
			@JoinColumn(name="Purchase_idPrestation")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Command_idCommande")
			}
		)
	private List<Command> commands;

	//bi-directional many-to-many association to SessionTraining
	@ManyToMany(mappedBy="purchases")
	private List<SessionTraining> sessionTrainings;

	public Purchase() {
	}

	public int getIdPrestation() {
		return this.idPrestation;
	}

	public void setIdPrestation(int idPrestation) {
		this.idPrestation = idPrestation;
	}

	public Date getDateOfPurchase() {
		return this.dateOfPurchase;
	}

	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
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

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Seance> getSeances() {
		return this.seances;
	}

	public void setSeances(List<Seance> seances) {
		this.seances = seances;
	}

	public Seance addSeance(Seance seance) {
		getSeances().add(seance);
		seance.setPurchase(this);

		return seance;
	}

	public Seance removeSeance(Seance seance) {
		getSeances().remove(seance);
		seance.setPurchase(null);

		return seance;
	}

	public List<Command> getCommands() {
		return this.commands;
	}

	public void setCommands(List<Command> commands) {
		this.commands = commands;
	}

	public List<SessionTraining> getSessionTrainings() {
		return this.sessionTrainings;
	}

	public void setSessionTrainings(List<SessionTraining> sessionTrainings) {
		this.sessionTrainings = sessionTrainings;
	}

}