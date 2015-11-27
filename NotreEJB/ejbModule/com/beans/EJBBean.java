package com.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.interfaces.EJBInterface;

import model.Client;
import model.Colis;
import model.Position;

/**
 * Session Bean implementation class EJBBean
 */
@Stateless(mappedName = "EJB")
public class EJBBean implements EJBInterface {

	@PersistenceContext
	EntityManager em;

	@Override
	public boolean login(String login, String password) {
		Query query = em.createQuery("Select c from Client c WHERE c.login = :login AND c.password = :password");
		query.setParameter("login", login);
		query.setParameter("password", password);
		try
		{
			query.getSingleResult();
		}
		catch(NoResultException|NonUniqueResultException e)
		{
			return false;
		}
		return true;
	}
	
	@Override
	public List<Client> getAllClients() {
		Query query = em.createQuery("Select c from Client c");
		return query.getResultList();

	}
	
	@Override
	public List<Colis> getAllColis() {
		return em.createQuery("Select c from Colis c ORDER BY c.idcolis").getResultList();
	}

	@Override
	public void createColis(BigDecimal poids, String valeur, String origine, String destination, int idClient) {
		Client client = em.find(Client.class, idClient);
		Colis colis = new Colis (destination,origine,poids,valeur, null);
		colis.setClient(client);
		em.persist(colis);
		/*Position position = new Position();
		position.setColi(colis);
		em.persist(position);*/
	}
	
	@Override
	public boolean isAdmin(String login) {
		Query query = em.createQuery("Select c.isAdmin from Client c WHERE c.login = :login");
		query.setParameter("login", login);
		try
		{
			return (boolean) query.getSingleResult();
		}
		catch(NoResultException|NonUniqueResultException e)
		{
			return false;
		}
	}

	@Override
	public List<Colis> getClientColis(String login) {
		Query query = em.createQuery("Select c from Client c WHERE c.login = :login");
		query.setParameter("login", login);
		Client client = (Client) query.getSingleResult();
		client.getColis().size();
		return client.getColis();
	}

	@Override
	public Colis getColisEtPositions(int idColis) {
		Colis colis = em.find(Colis.class, idColis);
		colis.getPositions().size();
		List<Position> positions = colis.getPositions();
		return colis;
	}
	



}
