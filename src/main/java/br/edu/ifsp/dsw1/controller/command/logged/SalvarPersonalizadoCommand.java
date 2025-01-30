package br.edu.ifsp.dsw1.controller.command.logged;

import java.io.IOException;

import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.model.dao.LinkDaoFactory;
import br.edu.ifsp.dsw1.model.entity.Link;
import br.edu.ifsp.dsw1.model.entity.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SalvarPersonalizadoCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		var linkPersonalizado = request.getParameter("textLinkPersonalizado");
		var linkLongo = request.getParameter("textLinkLongo");	
		
		HttpSession session = request.getSession(false);
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		var dao = new LinkDaoFactory().factory();
		
		
		if (usuario != null) {
			String regex = "^[a-zA-Z0-9_]{5,12}$";
			if (linkPersonalizado.matches(regex)) {
				Link link = new Link(linkLongo, linkPersonalizado, usuario.getLogin());
				if (dao.insert(link)) {
					request.setAttribute("urlLonga", linkLongo);
					request.setAttribute("urlCurta", linkPersonalizado);
				}else {
					session.setAttribute("mensagemErro", "O link personalizado ja foi cadastrado anteriormente ao sistema!!Tente outro!!!");
	                return "/loggedin/formPersonalizado.jsp";
				}
			    
			} else {
				session.setAttribute("mensagemErro", "O link personalizado deve conter entre 5 e 12 caracteres, podendo incluir letras, números e '_'.");
                return "/loggedin/formPersonalizado.jsp";
			}
			
			
		}
		
		
		return "/loggedin/logged.jsp";
	}

}
