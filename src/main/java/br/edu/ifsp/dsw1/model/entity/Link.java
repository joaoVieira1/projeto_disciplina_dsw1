package br.edu.ifsp.dsw1.model.entity;

import br.edu.ifsp.dsw1.model.dao.LinkDaoFactory;

public class Link {
		
	private int id;
	private String urlLonga;
	private String urlCurta;
	private int clicks;
	private String usuario;
	
	public Link() {
		int ultimoId = pegarUltimoId();
		ultimoId += 1;
		setId(ultimoId);
		setClicks(0);
	}

	public Link(String urlLonga, String urlCurta) {
		this();
		this.urlLonga = urlLonga;
		this.urlCurta = urlCurta;
	}
	
	public Link(String urlLonga, String urlCurta, String usuario) {
		this(urlLonga, urlCurta);
		this.usuario = usuario;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrlLonga() {
		return urlLonga;
	}

	public void setUrlLonga(String urlLonga) {
		this.urlLonga = urlLonga;
	}

	public String getUrlCurta() {
		return urlCurta;
	}

	public void setUrlCurta(String urlCurta) {
		this.urlCurta = urlCurta;
	}

	public int getClicks() {
		return clicks;
	}

	public void setClicks(int clicks) {
		this.clicks = clicks;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	public int pegarUltimoId() {
		var dao = new LinkDaoFactory().factory();
		return dao.getUltimoId();
	}
	
}
