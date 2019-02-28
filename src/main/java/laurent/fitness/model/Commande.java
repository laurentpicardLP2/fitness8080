package laurent.fitness.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Commande database table.
 * 
 */
@Entity
@NamedQuery(name="Commande.findAll", query="SELECT c FROM Commande c")
public class Commande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idCommande;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime;

	private float totalPrice;

	public Commande() {
	}

	public int getIdCommande() {
		return this.idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public Date getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public float getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

}