package br.edu.ifsp.dsw1.controller.command.logged;

import java.io.IOException;

import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.model.dao.LinkDaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RedirecionamentoCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String view = null;
		
		var urlCurta = request.getParameter("urlCurta");
		
		var dao = new LinkDaoFactory().factory();
		
		var link = dao.findByUrlCurta(urlCurta);
		
		var update = dao.updateClicks(link);
		
		response.sendRedirect(link.getUrlLonga());
		
		return null;
		
	}

}
