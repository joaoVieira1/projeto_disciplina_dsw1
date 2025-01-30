package br.edu.ifsp.dsw1.model.entity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;


public class Usuario {
	
	private String login;
	private String senhaHash;
	private List<Link> links;
	
	public Usuario(String login, String senhaHash) {
		init(login, hashSHA256(senhaHash));
	}
	
	public Usuario(String login, String senhaHash, boolean usuarioBanco) {
		if(usuarioBanco) {
			init(login, senhaHash);
		}else {
			init(login, hashSHA256(senhaHash));
		}
	}
	
	private void init(String login, String senha) {
		this.login = login;
		this.senhaHash = senha;
		links = new LinkedList<Link>();
	}
	
	public void addLink(Link link) {
		links.add(
				link
				);
	}
	
	public void clearLinks() {
		links.clear();
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
		this.senhaHash = hashSHA256(senhaHash);
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
	public static boolean autenticar(Usuario usuarioBanco, String login, String senha) {
		if(usuarioBanco != null) {
			return hashSHA256(senha).equals(usuarioBanco.senhaHash) && login.equals(usuarioBanco.login);
		}
		return false;
	}
	
	private static String hashSHA256(String input) {
		try {
			var digest = MessageDigest.getInstance("SHA-256");
			
			byte[] hashBytes = digest.digest(input.getBytes());
			
			var sb = new StringBuilder();
			for (byte b : hashBytes) {
				String hex = Integer.toHexString(0xff & b);
				if (hex.length() == 1) {
					sb.append('0');
				}
				sb.append(hex);
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao criptografar.", e);
		}
	}

}
