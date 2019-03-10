package laurent.fitness.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Users database table.
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="Users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@Id
	@Column(unique=true)
	@NotBlank(message = "Login ne doit pas être vide")
	protected String username;
	
	@Column(unique=true)
	protected int idUser;

	protected String fullname;

	protected String password;
	
	protected String email;

	protected String tel;
	
	@Temporal(TemporalType.DATE)
	protected Date dateOfRegistration;
	
	protected byte enabled;
	

	//bi-directional many-to-one association to Command
	@OneToMany(mappedBy="user")
	@JsonIgnore
	private List<Command> commands;


	//bi-directional one-to-one association to Authority
	@OneToOne(optional=true, cascade=CascadeType.REMOVE)
	@JoinColumn(name="username")
	protected Authority authority;

	public User() {
	}
	
	public User(String username,String password) {
		this.username = username;
		this.password = password;
	}
	
	public User(int idUser, String username, String fullname, String password, String email, String tel, Date dateOfRegistration, byte enabled) {
		this.idUser = idUser;
		this.username = username;
		this.fullname = fullname;
		this.password = password;
		this.email = email;
		this.tel = tel;
		this.dateOfRegistration = dateOfRegistration;
		this.enabled = enabled;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getDateOfRegistration() {
		return this.dateOfRegistration;
	}

	public void setDateOfRegistration(Date dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
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

	public List<Command> getCommands() {
		return this.commands;
	}

	public void setCommands(List<Command> commands) {
		this.commands = commands;
	}

	public Command addCommand(Command command) {
		getCommands().add(command);
		command.setUser(this);

		return command;
	}

	public Command removeCommand(Command command) {
		getCommands().remove(command);
		command.setUser(null);

		return command;
	}
	
	public Authority getAuthority() {
		return this.authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}


}