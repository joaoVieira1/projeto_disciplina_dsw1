package br.edu.ifsp.dsw1.controller.command.logged;

import java.io.IOException;

import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.model.dao.LinkDaoFactory;
import br.edu.ifsp.dsw1.model.entity.Link;
import br.edu.ifsp.dsw1.model.entity.Usuario;
import br.edu.ifsp.dsw1.model.service.EncurtadorUrl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class EncurtarLinkLoggedCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String urlLongaParameter = request.getParameter("textLinkLongo");
		
		String urlCurta = EncurtadorUrl.getUrlCurta(urlLongaParameter);
		String urlLonga = EncurtadorUrl.getUrlLonga(urlCurta);
		
		
		
		HttpSession session = request.getSession(false);
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		var dao = new LinkDaoFactory().factory();
		
		if (usuario != null) {
			Link link = new Link(urlLonga, urlCurta, usuario.getLogin());
			if (dao.insert(link)) {
				request.setAttribute("urlLonga", urlLonga);
				request.setAttribute("urlCurta", urlCurta);
			}else {
				session.setAttribute("mensagemErro", "Link curto ja cadastrado ao sistema");
                return "/loggedin/logged.jsp";
			}
		}else {
			session.setAttribute("mensagemErro", "!!!Faça login no sistema!!");
            return "login.jsp";
		}
		
		
		return "/loggedin/logged.jsp";
	}

}
