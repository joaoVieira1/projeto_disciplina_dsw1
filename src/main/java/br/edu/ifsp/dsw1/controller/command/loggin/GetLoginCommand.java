package br.edu.ifsp.dsw1.controller.command.loggin;

import java.io.IOException;

import br.edu.ifsp.dsw1.controller.command.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetLoginCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return "login.jsp";
	}

}
