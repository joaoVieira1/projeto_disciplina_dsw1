package br.edu.ifsp.dsw1.model.dao;

public class LinkDaoFactory{
	
	public LinkDao factory() {
		return new LinkDaoImpl();
	}

}
