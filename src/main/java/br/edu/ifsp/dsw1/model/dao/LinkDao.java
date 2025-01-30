package br.edu.ifsp.dsw1.model.dao;

import java.util.List;

import br.edu.ifsp.dsw1.model.entity.Link;
import br.edu.ifsp.dsw1.model.entity.Usuario;

public interface LinkDao {

	boolean insert(Link link);
	List<Link> getAll(Usuario usuario);
	int getUltimoId();
}
