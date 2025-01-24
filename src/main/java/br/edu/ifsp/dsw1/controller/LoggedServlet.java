package br.edu.ifsp.dsw1.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.controller.command.logged.GetLoggedCommand;
import br.edu.ifsp.dsw1.controller.command.logged.LogoffCommand;
import br.edu.ifsp.dsw1.controller.command.loggin.CadastroUsuarioCommand;
import br.edu.ifsp.dsw1.controller.command.loggin.GetCadastroCommand;
import br.edu.ifsp.dsw1.controller.command.loggin.GetIndexCommand;
import br.edu.ifsp.dsw1.controller.command.loggin.GetLoginCommand;
import br.edu.ifsp.dsw1.controller.command.loggin.LoginUsuarioCommand;


@WebServlet("/logged.do")
public class LoggedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String action = request.getParameter("action");
		Command command = null;
		
		if(action.equals("getLogged")) {
			command = new GetLoggedCommand();
		}else if(action.equals("logoff")) {
			command = new LogoffCommand();
		}
		
		String view = command.execute(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
		
	}
	
}
