package br.edu.ifsp.dsw1.controller.command.loggin;

import java.io.IOException;
import java.util.List;

import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.model.dao.LinkDaoFactory;
import br.edu.ifsp.dsw1.model.entity.Link;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LinksPersonalizadosCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		var dao = new LinkDaoFactory().factory();
		
		
		List<Link> links = dao.getAll();
		session.setAttribute("allLinks", links);
		
		
		return "personalizados.jsp";
	}
	
	

}
