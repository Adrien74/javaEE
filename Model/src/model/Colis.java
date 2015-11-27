package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the colis database table.
 * 
 */
@Entity
@Table(name="colis")
@NamedQuery(name="Colis.findAll", query="SELECT c FROM Colis c")
public class Colis implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true)
	private int idcolis;

	@Column(length=30)
	private String destination;

	@Column(length=30)
	private String origine;

	@Column(precision=10)
	private BigDecimal poids;

	@Column(length=150)
	private String valeur;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="idClient", nullable=false)
	private Client client;

	//bi-directional many-to-one association to Position
	@OneToMany(mappedBy="colis")
	private List<Position> positions;

	public Colis() {
	}

	public int getIdcolis() {
		return this.idcolis;
	}

	public Colis(String destination, String origine, BigDecimal poids, String valeur, Client client) {
		super();
		this.destination = destination;
		this.origine = origine;
		this.poids = poids;
		this.valeur = valeur;
		this.client = client;
	}



	public void setIdcolis(int idcolis) {
		this.idcolis = idcolis;
	}

	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getOrigine() {
		return this.origine;
	}

	public void setOrigine(String origine) {
		this.origine = origine;
	}

	public BigDecimal getPoids() {
		return this.poids;
	}

	public void setPoids(BigDecimal poids) {
		this.poids = poids;
	}

	public String getValeur() {
		return this.valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Position> getPositions() {
		return this.positions;
	}

	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}

	public Position addPosition(Position position) {
		getPositions().add(position);
		position.setColi(this);

		return position;
	}

	public Position removePosition(Position position) {
		getPositions().remove(position);
		position.setColi(null);

		return position;
	}

}