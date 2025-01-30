package br.edu.ifsp.dsw1.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.controller.command.logged.DeletarLinkCommand;
import br.edu.ifsp.dsw1.controller.command.logged.EncurtarLinkLoggedCommand;
import br.edu.ifsp.dsw1.controller.command.logged.GetLoggedCommand;
import br.edu.ifsp.dsw1.controller.command.logged.GetPersonalizarCommand;
import br.edu.ifsp.dsw1.controller.command.logged.LinksCommand;
import br.edu.ifsp.dsw1.controller.command.logged.LogoffCommand;
import br.edu.ifsp.dsw1.controller.command.logged.RedirecionamentoCommand;
import br.edu.ifsp.dsw1.controller.command.logged.SalvarPersonalizadoCommand;



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
		}else if(action.equals("encurtarLink")){
			command = new EncurtarLinkLoggedCommand();
		}else if(action.equals("getPersonalizar")) {
			command = new GetPersonalizarCommand();
		}else if(action.equals("salvarPersonalizado")) {
			command = new SalvarPersonalizadoCommand();
		}else if(action.equals("getLinks")) {
			command = new LinksCommand();
		}else if(action.equals("deletar")) {
			command = new DeletarLinkCommand();
		}else if(action.equals("redirecionamento")) {
			command = new RedirecionamentoCommand();
		}
		
		if(command != null) {
			String view = command.execute(request, response);
			
			if(view != null) {
				RequestDispatcher dispatcher = request.getRequestDispatcher(view);
				dispatcher.forward(request, response);
			}
		}else {
	        response.sendError(HttpServletResponse.SC_NOT_FOUND, "Comando não encontrado");
	    }
		
		
		
	}
	
}
