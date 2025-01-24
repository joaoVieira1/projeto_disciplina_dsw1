package br.edu.ifsp.dsw1.model.entity;

public class Link {
	
	private static int ultimoId = 0;
	
	private int id;
	private String urlLonga;
	private String urlCurta;
	
	public Link() {
		ultimoId += 1;
		setId(ultimoId);
	}

	public Link(String urlLonga, String urlCurta) {
		super();
		this.urlLonga = urlLonga;
		this.urlCurta = urlCurta;
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
	
	
	
}
