package laurent.fitness.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Users database table.
 * 
 */
@Entity
@Table(name="Users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@Id
	@Column(unique=true)
	@NotBlank(message = "Login ne doit pas être vide")
	private String username;
	
	private int idUser;

	private String fullname;

	private String password;
	
	private String email;

	private String tel;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	private byte enabled;
	
	//bi-directional many-to-one association to Customer
	@OneToMany(mappedBy="user")
	private List<Customer> customers;

	//bi-directional many-to-one association to Prestation
	@OneToMany(mappedBy="user")
	private List<Prestation> prestations;

	//bi-directional many-to-one association to Staff
	@OneToMany(mappedBy="user")
	private List<Staff> staffs;

	//bi-directional one-to-one association to Authority
	@OneToOne
	@JoinColumn(name="username")
	private Authority authority;

	public User() {
	}
	
	public User(String username, String fullname, String password, String email, String tel, Date creationDate, byte enabled) {
		this.username = username;
		this.fullname = fullname;
		this.password = password;
		this.email = email;
		this.tel = tel;
		this.creationDate = creationDate;
		this.enabled = enabled;
	}
	
	public User(int idUser, String username, String fullname, String password, String email, String tel, Date creationDate, byte enabled) {
		this.idUser = idUser;
		this.username = username;
		this.fullname = fullname;
		this.password = password;
		this.email = email;
		this.tel = tel;
		this.creationDate = creationDate;
		this.enabled = enabled;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getEnabled() {
		return this.enabled;
	}

	public void setEnabled(byte enabled) {
		this.enabled = enabled;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer addCustomer(Customer customer) {
		getCustomers().add(customer);
		customer.setUser(this);

		return customer;
	}

	public Customer removeCustomer(Customer customer) {
		getCustomers().remove(customer);
		customer.setUser(null);

		return customer;
	}

	public List<Prestation> getPrestations() {
		return this.prestations;
	}

	public void setPrestations(List<Prestation> prestations) {
		this.prestations = prestations;
	}

	public Prestation addPrestation(Prestation prestation) {
		getPrestations().add(prestation);
		prestation.setUser(this);

		return prestation;
	}

	public Prestation removePrestation(Prestation prestation) {
		getPrestations().remove(prestation);
		prestation.setUser(null);

		return prestation;
	}

	public List<Staff> getStaffs() {
		return this.staffs;
	}

	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}

	public Staff addStaff(Staff staff) {
		getStaffs().add(staff);
		staff.setUser(this);

		return staff;
	}

	public Staff removeStaff(Staff staff) {
		getStaffs().remove(staff);
		staff.setUser(null);

		return staff;
	}

	public Authority getAuthority() {
		return this.authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

}