package br.edu.ifsp.dsw1.model.entity;

import java.util.LinkedList;
import java.util.List;

public class Usuario {
	
	private String login;
	private String senhaHash;
	private List<Link> links;
	
	public Usuario() {
		links = new LinkedList<Link>();
	}
	
	public Usuario(String login, String senhaHash) {
		super();
		setLogin(login);
		setSenhaHash(senhaHash);
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenhaHash() {
		return senhaHash;
	}
	public void setSenhaHash(String senhaHash) {
		this.senhaHash = senhaHash;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
	

}
