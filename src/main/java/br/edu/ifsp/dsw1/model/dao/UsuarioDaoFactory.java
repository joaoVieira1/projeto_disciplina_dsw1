package br.edu.ifsp.dsw1.model.dao;

public class UsuarioDaoFactory {
	
	public UsuarioDao factory() {
		return new UsuarioDaoImpl();
	}
	
}
