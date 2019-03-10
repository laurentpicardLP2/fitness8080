package laurent.fitness.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Command database table.
 * 
 */
@Entity
@NamedQuery(name="Command.findAll", query="SELECT c FROM Command c")
public class Command implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCommand;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfCommand;

	private float totalPrice;
	
	private int statusCommand;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="Users_username")
	@JsonManagedReference
	private User user;

	//bi-directional many-to-many association to Item
	@ManyToMany(mappedBy="commands", cascade=CascadeType.REMOVE)
	@JsonManagedReference
	private List<Item> items;

	public Command() {
		this.items = new ArrayList<Item>();
	}
	
	public Command(User user) {
		this.user = user;
		this.items = new ArrayList<Item>();
	}
	
	public Command(User user, Date dateOfCommand) {
		this.user = user;
		this.dateOfCommand = dateOfCommand;
		this.items = new ArrayList<Item>();
	}

	public int getIdCommand() {
		return this.idCommand;
	}

	public void setIdCommand(int idCommand) {
		this.idCommand = idCommand;
	}

	public Date getDateOfCommand() {
		return this.dateOfCommand;
	}

	public void setDateOfCommand(Date dateOfCommand) {
		this.dateOfCommand = dateOfCommand;
	}

	public float getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public int getStatusCommand() {
		return this.statusCommand;
	}

	public void setStatusCommand(int statusCommand) {
		this.statusCommand = statusCommand;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Item> getItems() {
		return this.items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}