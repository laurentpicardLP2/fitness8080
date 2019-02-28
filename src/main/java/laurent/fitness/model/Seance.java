package laurent.fitness.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Seance database table.
 * 
 */
@Entity
@NamedQuery(name="Seance.findAll", query="SELECT s FROM Seance s")
public class Seance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idSeance;

	//bi-directional many-to-one association to Prestation
	@ManyToOne
	@JoinColumn(name="Prestation_idPrestation")
	private Prestation prestation;

	public Seance() {
	}

	public int getIdSeance() {
		return this.idSeance;
	}

	public void setIdSeance(int idSeance) {
		this.idSeance = idSeance;
	}

	public Prestation getPrestation() {
		return this.prestation;
	}

	public void setPrestation(Prestation prestation) {
		this.prestation = prestation;
	}

}