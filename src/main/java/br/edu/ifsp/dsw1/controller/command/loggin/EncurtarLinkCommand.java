package br.edu.ifsp.dsw1.controller.command.loggin;

import java.io.IOException;

import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.model.dao.LinkDaoFactory;
import br.edu.ifsp.dsw1.model.entity.Link;
import br.edu.ifsp.dsw1.model.entity.Usuario;
import br.edu.ifsp.dsw1.model.service.EncurtadorUrl;
import br.edu.ifsp.dsw1.model.service.URLValidator;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class EncurtarLinkCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String urlLongaParameter = request.getParameter("textLinkLongo");
		
		String urlCurta = EncurtadorUrl.getUrlCurta(urlLongaParameter);
		String urlLonga = EncurtadorUrl.getUrlLonga(urlCurta);
		
		HttpSession session = request.getSession(false);
		
		if (!URLValidator.isValidURL(urlLonga)) {
			session.setAttribute("mensagemErro", "Url invalida, forneça uma URL valida por favor!!");
			return "index.jsp";
		}
		
		request.setAttribute("urlLonga", urlLonga);
		request.setAttribute("urlCurta", urlCurta);
		
		
		return "index.jsp";
	}
	

}
