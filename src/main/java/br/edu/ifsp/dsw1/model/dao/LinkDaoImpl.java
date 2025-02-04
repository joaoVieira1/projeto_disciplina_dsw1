package br.edu.ifsp.dsw1.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	private static final String GET_ALL_BY_USUARIO = "SELECT * FROM link WHERE usuario = ? ORDER BY clicks DESC";
	private static final String GET_ALL = "SELECT * FROM link";
	private static final String DELETE = "DELETE FROM Link WHERE urlCurta = ?";
	private static final String UPDATE_CLICK = "UPDATE Link SET clicks = ? WHERE urlCurta = ?";
	private static final String UPDATE_LINK = "UPDATE Link SET urlLonga = ?, urlCurta = ? WHERE id = ?";
	private static final String UPDATE_LINK_LONGO = "UPDATE Link SET urlLonga = ? WHERE id = ?";


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
	public List<Link> getAllByUsuario(Usuario usuario) {
		usuario.clearLinks();

		try (var connection = DatabaseConnection.getConnection();
			 var preparedStatement = connection.prepareStatement(GET_ALL_BY_USUARIO)){
			
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
	
	
	public boolean delete(Link link) {
		
		int rows = 0;
		
		if(link != null) {
			try(var conn = DatabaseConnection.getConnection();
					var statement = conn.prepareStatement(DELETE)){
				
				statement.setString(1, link.getUrlCurta());
				
				rows = statement.executeUpdate();
				
			}catch(SQLException e ) {
				e.printStackTrace();
			}
			
			return rows > 0;
		}
		
		return false;
	}

	public Link findByUrlCurta(String urlCurta){
		Link newLink = null;
		
		if(urlCurta != null && !urlCurta.isEmpty()) {
			
			try(var conn = DatabaseConnection.getConnection();
					var statement = conn.prepareStatement(FIND_BY_URL_CURTA)){
				
				statement.setString(1, urlCurta);
				
				ResultSet result = statement.executeQuery();
				
				if(result.next()) {
					newLink = new Link();
					newLink.setUrlCurta(result.getString("urlCurta"));
					newLink.setUrlLonga(result.getString("urlLonga"));
					newLink.setId(result.getInt("id"));;
					newLink.setClicks(result.getInt("clicks"));
					newLink.setUsuario(result.getString("usuario"));
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		return newLink;
	}
	
	public boolean updateClicks(Link link) {
		
		int rows = 0;
		int newClick = link.getClicks() + 1;

		if(link != null) {
			
			try(var conn = DatabaseConnection.getConnection();
					var statement = conn.prepareStatement(UPDATE_CLICK)){
				
				statement.setInt(1, newClick);
				statement.setString(2, link.getUrlCurta());
				
				rows = statement.executeUpdate();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			return rows > 0;
		}
		
		return false;
	}
	
	public boolean updateLinkLongo(Link link) {
		int rows = 0;
		
		if(link != null) {
			
			try(var conn = DatabaseConnection.getConnection();
					var statement = conn.prepareStatement(UPDATE_LINK_LONGO)){
				
				statement.setString(1, link.getUrlLonga());
				statement.setInt(2, link.getId());
				
				rows = statement.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return rows > 0;
		}
		
		return false;
	}
	
	public boolean updateLink(Link link) {
		int rows = 0;
		
		if(link != null) {
			
			try(var conn = DatabaseConnection.getConnection();
					var statement = conn.prepareStatement(UPDATE_LINK)){
				
				statement.setString(1, link.getUrlLonga());
				statement.setString(2, link.getUrlCurta());
				statement.setInt(3, link.getId());
				
				rows = statement.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return rows > 0;
		}
		
		return false;
	}

	@Override
	public List<Link> getAll() {
		List<Link> links = new ArrayList<>();

	    try (var connection = DatabaseConnection.getConnection();
	         var preparedStatement = connection.prepareStatement(GET_ALL);) {

	    	 var resultSet = preparedStatement.executeQuery();
	    	
	        while (resultSet.next()) {
	            var link = new Link();
	            link.setId(resultSet.getInt("id"));
	            link.setUrlCurta(resultSet.getString("urlCurta"));
	            link.setUrlLonga(resultSet.getString("urlLonga"));
	            link.setClicks(resultSet.getInt("clicks"));
	            link.setUsuario(resultSet.getString("usuario"));
	            links.add(link);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return links;
	}

}
