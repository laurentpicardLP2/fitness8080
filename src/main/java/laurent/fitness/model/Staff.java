package laurent.fitness.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Staff database table.
 * 
 */
@Entity
@NamedQuery(name="Staff.findAll", query="SELECT s FROM Staff s")
public class Staff implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idStaff;

	private String dayWorking;

	private String hourWorking;

	//bi-directional many-to-one association to SessionTraining
	@OneToMany(mappedBy="staff")
	private List<SessionTraining> sessionTrainings;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="Users_username")
	private User user;

	public Staff() {
	}

	public int getIdStaff() {
		return this.idStaff;
	}

	public void setIdStaff(int idStaff) {
		this.idStaff = idStaff;
	}

	public String getDayWorking() {
		return this.dayWorking;
	}

	public void setDayWorking(String dayWorking) {
		this.dayWorking = dayWorking;
	}

	public String getHourWorking() {
		return this.hourWorking;
	}

	public void setHourWorking(String hourWorking) {
		this.hourWorking = hourWorking;
	}

	public List<SessionTraining> getSessionTrainings() {
		return this.sessionTrainings;
	}

	public void setSessionTrainings(List<SessionTraining> sessionTrainings) {
		this.sessionTrainings = sessionTrainings;
	}

	public SessionTraining addSessionTraining(SessionTraining sessionTraining) {
		getSessionTrainings().add(sessionTraining);
		sessionTraining.setStaff(this);

		return sessionTraining;
	}

	public SessionTraining removeSessionTraining(SessionTraining sessionTraining) {
		getSessionTrainings().remove(sessionTraining);
		sessionTraining.setStaff(null);

		return sessionTraining;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}