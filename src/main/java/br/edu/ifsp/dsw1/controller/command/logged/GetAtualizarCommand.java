package br.edu.ifsp.dsw1.controller.command.logged;

import java.io.IOException;

import br.edu.ifsp.dsw1.controller.command.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class GetAtualizarCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var urlCurta = request.getParameter("linkAtualizar"); 	
		
		HttpSession session = request.getSession();
		session.setAttribute("linkAtualizar2", urlCurta);

		return "/loggedin/atualizar.jsp";
	}

}
