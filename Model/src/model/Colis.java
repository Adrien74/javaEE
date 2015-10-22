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
@NamedQuery(name="Coli.findAll", query="SELECT c FROM Colis c")
public class Colis implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idcolis;

	@Column(length=30)
	private String destination;

	@Column(length=30)
	private String origine;

	@Column(precision=10)
	private BigDecimal poids;

	@Column(length=150)
	private String valeur;

	//bi-directional many-to-one association to Position
	@OneToMany(mappedBy="coli")
	private List<Position> positions;

	public Colis() {
	}

	public int getIdcolis() {
		return this.idcolis;
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