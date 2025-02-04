package br.edu.ifsp.dsw1.controller.command.logged;

import java.io.IOException;

import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.model.dao.LinkDaoFactory;
import br.edu.ifsp.dsw1.model.dao.LinkDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeletarLinkCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String urlCurta = request.getParameter("urlCurta"); 
		
		var dao = new LinkDaoFactory().factory();
		
		var link = dao.findByUrlCurta(urlCurta);
		
		dao.delete(link);
		
		return "logged.do?action=getLinks";
	}

}
