package br.edu.ifsp.dsw1.controller.command.logged;

import java.io.IOException;

import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.model.service.EncurtadorUrl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EncurtarLinkLoggedCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String urlLongaParameter = request.getParameter("textLinkLongo");
		
		String urlCurta = EncurtadorUrl.getUrlCurta(urlLongaParameter);
		String urlLonga = EncurtadorUrl.getUrlLonga(urlCurta);
		
		request.setAttribute("urlLonga", urlLonga);
		request.setAttribute("urlCurta", urlCurta);
		
		return "/loggedin/logged.jsp";
	}

}
