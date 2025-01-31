package br.edu.ifsp.dsw1.model.dao;

import java.util.List;

import br.edu.ifsp.dsw1.model.entity.Link;
import br.edu.ifsp.dsw1.model.entity.Usuario;

public interface LinkDao {

	boolean insert(Link link);
	List<Link> getAllByUsuario(Usuario usuario);
	List<Link>getAll();
	int getUltimoId();
	public boolean delete(Link link);
	public Link findByUrlCurta(String urlCurta);
	public boolean updateClicks(Link link);
	boolean updateLink(Link link);
	boolean updateLinkLongo(Link link);
}
