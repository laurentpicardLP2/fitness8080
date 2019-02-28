package laurent.fitness.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Prestation database table.
 * 
 */
@Entity
@NamedQuery(name="Prestation.findAll", query="SELECT p FROM Prestation p")
public class Prestation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPrestation;

	private float price;

	//bi-directional many-to-one association to ConnectedWatch
	@OneToMany(mappedBy="prestation")
	private List<ConnectedWatch> connectedWatches;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="Users_username")
	private User user;

	//bi-directional many-to-one association to Seance
	@OneToMany(mappedBy="prestation")
	private List<Seance> seances;

	//bi-directional many-to-one association to SessionTraining
	@OneToMany(mappedBy="prestation")
	private List<SessionTraining> sessionTrainings;

	//bi-directional many-to-one association to Subscription
	@OneToMany(mappedBy="prestation")
	private List<Subscription> subscriptions;

	public Prestation() {
	}

	public int getIdPrestation() {
		return this.idPrestation;
	}

	public void setIdPrestation(int idPrestation) {
		this.idPrestation = idPrestation;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public List<ConnectedWatch> getConnectedWatches() {
		return this.connectedWatches;
	}

	public void setConnectedWatches(List<ConnectedWatch> connectedWatches) {
		this.connectedWatches = connectedWatches;
	}

	public ConnectedWatch addConnectedWatch(ConnectedWatch connectedWatch) {
		getConnectedWatches().add(connectedWatch);
		connectedWatch.setPrestation(this);

		return connectedWatch;
	}

	public ConnectedWatch removeConnectedWatch(ConnectedWatch connectedWatch) {
		getConnectedWatches().remove(connectedWatch);
		connectedWatch.setPrestation(null);

		return connectedWatch;
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
		seance.setPrestation(this);

		return seance;
	}

	public Seance removeSeance(Seance seance) {
		getSeances().remove(seance);
		seance.setPrestation(null);

		return seance;
	}

	public List<SessionTraining> getSessionTrainings() {
		return this.sessionTrainings;
	}

	public void setSessionTrainings(List<SessionTraining> sessionTrainings) {
		this.sessionTrainings = sessionTrainings;
	}

	public SessionTraining addSessionTraining(SessionTraining sessionTraining) {
		getSessionTrainings().add(sessionTraining);
		sessionTraining.setPrestation(this);

		return sessionTraining;
	}

	public SessionTraining removeSessionTraining(SessionTraining sessionTraining) {
		getSessionTrainings().remove(sessionTraining);
		sessionTraining.setPrestation(null);

		return sessionTraining;
	}

	public List<Subscription> getSubscriptions() {
		return this.subscriptions;
	}

	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

	public Subscription addSubscription(Subscription subscription) {
		getSubscriptions().add(subscription);
		subscription.setPrestation(this);

		return subscription;
	}

	public Subscription removeSubscription(Subscription subscription) {
		getSubscriptions().remove(subscription);
		subscription.setPrestation(null);

		return subscription;
	}

}