package br.edu.ifsp.dsw1.model.dao;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifsp.dsw1.model.dao.connection.DatabaseConnection;
import br.edu.ifsp.dsw1.model.entity.Link;
import br.edu.ifsp.dsw1.model.entity.Usuario;

public class LinkDaoImpl implements LinkDao{
	
//	CREATE TABLE Link(
//  id INTEGER NOT NULL PRIMARY KEY,
//  urlLonga VARCHAR(128) NOT NULL,
//  urlCurta VARCHAR(128) NOT NULL UNIQUE KEY,
//	clicks INTEGER NOT NULL,
//  usuario VARCHAR(128) NOT NULL,
//  FOREIGN KEY (usuario) REFERENCES Usuario(login) ON DELETE CASCADE);
	
	private static final String INSERT = "INSERT INTO Link (id, urlLonga, urlCurta, clicks, usuario) VALUES (?, ?, ?, ?, ?)";
	private static final String FIND_BY_URL_CURTA ="SELECT * FROM Link WHERE urlCurta = ?";
	private static final String PEGAR_ULTIMO_ID = "SELECT id FROM Link ORDER BY id DESC LIMIT 1";
	private static final String GET_ALL = "SELECT * FROM link WHERE usuario = ? ORDER BY usuario";
	

	@Override
	public boolean insert(Link link) {
		
		int rows = 0;
		
		if(link != null) {
			
			try(var connection = DatabaseConnection.getConnection();
					var statement = connection.prepareStatement(INSERT)){
				
				statement.setInt(1, link.getId());
				statement.setString(2, link.getUrlLonga());
				statement.setString(3, link.getUrlCurta());
				statement.setInt(4, link.getClicks());
				statement.setString(5, link.getUsuario());
				
				rows = statement.executeUpdate();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return rows > 0;
	}
	
	public int getUltimoId() {
		int lastId = 0;
		
		try(var connection = DatabaseConnection.getConnection();
				var statement = connection.prepareStatement(PEGAR_ULTIMO_ID)){
			var resultSet = statement.executeQuery();
			
			 if (resultSet.next()) {
				 lastId = resultSet.getInt("id"); 
		     }
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return lastId;
	}

	@Override
	public List<Link> getAll(Usuario usuario) {
		usuario.clearLinks();

		try (var connection = DatabaseConnection.getConnection();
			 var preparedStatement = connection.prepareStatement(GET_ALL)){
			
			preparedStatement.setString(1, usuario.getLogin());
			var result = preparedStatement.executeQuery();

			while (result.next()) {
				var link = new Link();
				link.setId(result.getInt("id"));
				link.setUrlCurta(result.getString("urlCurta"));
				link.setUrlLonga(result.getString("urlLonga"));
				link.setClicks(result.getInt("clicks"));
				link.setUsuario(result.getString("usuario"));
				usuario.addLink(link);;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuario.getLinks();
		
	}

	

}
