package br.edu.ifsp.dsw1.model.dao;

import br.edu.ifsp.dsw1.model.entity.Link;
import br.edu.ifsp.dsw1.model.entity.Usuario;

public interface LinkDao {

	boolean insert(Link link);
	Link findByUrlCurta(String url);
	int getUltimoId();
}
