package br.edu.ifsp.dsw1.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifsp.dsw1.model.dao.connection.DatabaseConnection;
import br.edu.ifsp.dsw1.model.entity.Usuario;

public class UsuarioDaoImpl implements UsuarioDao{
	
	//CREATE TABLE Usuario(
    //login VARCHAR(128) UNIQUE KEY PRIMARY KEY NOT NULL,
    //senha VARCHAR(128) NOT NULL);
	
	//CREATE TABLE Link(
    //id INTEGER NOT NULL PRIMARY KEY,
    //urlLonga VARCHAR(128) NOT NULL,
    //urlCurta VARCHAR(128) NOT NULL UNIQUE KEY,
	//clicks INTEGER NOT NULL,
    //usuario VARCHAR(128) NOT NULL,
    //FOREIGN KEY (usuario) REFERENCES Usuario(login) ON DELETE CASCADE);
	
	private static final String INSERT = "INSERT INTO Usuario (login, senha) VALUES (?, ?)";
	private static final String FIND_BY_LOGIN ="SELECT * FROM Usuario WHERE login = ?";
	
	
	@Override
	public boolean insert(Usuario usuario) {
		
		int rows = 0;
		
		if(usuario != null) {
			
			try(var connection = DatabaseConnection.getConnection();
					var statement = connection.prepareStatement(INSERT)){
				
				statement.setString(1, usuario.getLogin());
				statement.setString(2, usuario.getSenhaHash());
				
				rows = statement.executeUpdate();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return rows > 0;
	}

	@Override
	public Usuario findByLogin(String login) {
		
		Usuario usuario = null;
		
		try(var connection = DatabaseConnection.getConnection();
				var statement = connection.prepareStatement(FIND_BY_LOGIN)){
			
			statement.setString(1, login);
			
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				usuario = new Usuario(result.getString("login"), result.getString("senha"), true);
			}
			
		}catch(SQLException e ){
			e.printStackTrace();
			usuario = null;
		}
		
		return usuario;
	}

}
