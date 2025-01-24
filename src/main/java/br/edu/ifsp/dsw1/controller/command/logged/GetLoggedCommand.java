package br.edu.ifsp.dsw1.controller.command.logged;

import java.io.IOException;

import br.edu.ifsp.dsw1.controller.command.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetLoggedCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return "/loggedin/logged.jsp";
	}

}
