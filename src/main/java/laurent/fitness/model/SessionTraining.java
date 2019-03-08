package laurent.fitness.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the SessionTraining database table.
 * 
 */
@Entity
@NamedQuery(name="SessionTraining.findAll", query="SELECT s FROM SessionTraining s")
public class SessionTraining implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idSessionTraining;

	private int capacityAttendant;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime;

	//bi-directional many-to-one association to Room
	@ManyToOne
	@JoinColumn(name="Room_idRoom")
	private Room room;

	//bi-directional many-to-one association to Staff
	@ManyToOne
	@JoinColumn(name="Staff_Users_username")
	private Staff staff;

	//bi-directional many-to-many association to Purchase
	@ManyToMany
	@JoinTable(
		name="Purchase_has_SessionTraining"
		, joinColumns={
			@JoinColumn(name="SessionTraining_idSessionTraining")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Purchase_idPrestation")
			}
		)
	private List<Purchase> purchases;

	//bi-directional many-to-many association to Customer
	@ManyToMany
	@JoinTable(
		name="SessionTraining_has_Customer"
		, joinColumns={
			@JoinColumn(name="SessionTraining_idSessionTraining")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Customer_Users_username")
			}
		)
	private List<Customer> customers;

	public SessionTraining() {
	}

	public int getIdSessionTraining() {
		return this.idSessionTraining;
	}

	public void setIdSessionTraining(int idSessionTraining) {
		this.idSessionTraining = idSessionTraining;
	}

	public int getCapacityAttendant() {
		return this.capacityAttendant;
	}

	public void setCapacityAttendant(int capacityAttendant) {
		this.capacityAttendant = capacityAttendant;
	}

	public Date getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public List<Purchase> getPurchases() {
		return this.purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

}