package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@Table(name="client")
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true)
	private int idClient;
	
	@Column(nullable=false)
	private boolean isAdmin;

	@Column(nullable=false, length=30)
	private String login;

	@Column(nullable=false, length=30)
	private String password;

	//bi-directional many-to-one association to Colis
	@OneToMany(mappedBy="client")
	private List<Colis> colis;

	public Client() {
	}

	public int getIdClient() {
		return this.idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public boolean getIsAdmin() {
		return this.isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Colis> getColis() {
		return this.colis;
	}

	public void setColis(List<Colis> colis) {
		this.colis = colis;
	}

	public Colis addColi(Colis coli) {
		getColis().add(coli);
		coli.setClient(this);

		return coli;
	}

	public Colis removeColi(Colis coli) {
		getColis().remove(coli);
		coli.setClient(null);

		return coli;
	}

}