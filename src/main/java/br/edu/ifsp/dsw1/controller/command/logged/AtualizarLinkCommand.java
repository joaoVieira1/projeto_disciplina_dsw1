package br.edu.ifsp.dsw1.controller.command.logged;

import java.io.IOException;
import java.net.URL;

import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.model.dao.LinkDaoFactory;
import br.edu.ifsp.dsw1.model.entity.Link;
import br.edu.ifsp.dsw1.model.service.URLValidator;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AtualizarLinkCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		var linkLongo = request.getParameter("textLinkLongo");
		var linkCurto = request.getParameter("textLinkCurto");	
		var dao = new LinkDaoFactory().factory();
		HttpSession session = request.getSession(false);
		String urlCurta = (String) session.getAttribute("linkAtualizar2");
		System.out.println(linkLongo);
		System.out.println(linkCurto);
		Link link = dao.findByUrlCurta(urlCurta);
		 
	
		if (URLValidator.isValidURL(linkLongo)) {
			link.setUrlLonga(linkLongo);
		
			if (linkCurto == null || linkCurto.isEmpty() ) {
				System.out.println(link);
				dao.updateLinkLongo(link);
				return "logged.do?action=getLinks";
			}else {
				link.setUrlCurta(linkCurto);
				
				if (dao.updateLink(link)) {
					
					System.out.println(link);
					return "logged.do?action=getLinks";
				}else {
					session.setAttribute("mensagemErro", "O link curto ja foi cadastrado anteriormente ao sistema!!Tente outro!!!");
					return "logged.do?action=getLinks";
				}
			}
		
			
			
		}else {
			session.setAttribute("mensagemErro", "O campo da URL longa precisa ser preenchido ou a URL fornecida nao é um link valido!!!");
			return "/loggedin/atualizar.jsp";
		}
	}

}
