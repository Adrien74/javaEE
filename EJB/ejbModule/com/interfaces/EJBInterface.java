package com.interfaces;

import java.util.List;

import javax.ejb.Remote;

import model.Colis;

@Remote(EJBInterface.class)
public interface EJBInterface {
	public String HelloWord(String to);
	public List<Colis> getAllColis();
}
