package laurent.fitness.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ConnectedWatchModel database table.
 * 
 */
@Entity
@NamedQuery(name="ConnectedWatchModel.findAll", query="SELECT c FROM ConnectedWatchModel c")
public class ConnectedWatchModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idConnectedWatchModel;

	private String modelWatch;

	private float price;

	private int quantity;

	//bi-directional many-to-one association to ConnectedWatch
	@OneToMany(mappedBy="connectedWatchModel")
	private List<ConnectedWatch> connectedWatches;

	public ConnectedWatchModel() {
	}

	public int getIdConnectedWatchModel() {
		return this.idConnectedWatchModel;
	}

	public void setIdConnectedWatchModel(int idConnectedWatchModel) {
		this.idConnectedWatchModel = idConnectedWatchModel;
	}

	public String getModelWatch() {
		return this.modelWatch;
	}

	public void setModelWatch(String modelWatch) {
		this.modelWatch = modelWatch;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<ConnectedWatch> getConnectedWatches() {
		return this.connectedWatches;
	}

	public void setConnectedWatches(List<ConnectedWatch> connectedWatches) {
		this.connectedWatches = connectedWatches;
	}

	public ConnectedWatch addConnectedWatch(ConnectedWatch connectedWatch) {
		getConnectedWatches().add(connectedWatch);
		connectedWatch.setConnectedWatchModel(this);

		return connectedWatch;
	}

	public ConnectedWatch removeConnectedWatch(ConnectedWatch connectedWatch) {
		getConnectedWatches().remove(connectedWatch);
		connectedWatch.setConnectedWatchModel(null);

		return connectedWatch;
	}

}