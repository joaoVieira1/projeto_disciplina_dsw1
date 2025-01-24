package br.edu.ifsp.dsw1.controller.command.loggin;

import java.io.IOException;

import br.edu.ifsp.dsw1.controller.command.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetCadastroCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return "cadastro.jsp";
	}

}
