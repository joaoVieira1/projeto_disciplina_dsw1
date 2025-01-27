package br.edu.ifsp.dsw1.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.controller.command.loggin.CadastroUsuarioCommand;
import br.edu.ifsp.dsw1.controller.command.loggin.EncurtarLinkCommand;
import br.edu.ifsp.dsw1.controller.command.loggin.GetCadastroCommand;
import br.edu.ifsp.dsw1.controller.command.loggin.GetIndexCommand;
import br.edu.ifsp.dsw1.controller.command.loggin.GetLoginCommand;
import br.edu.ifsp.dsw1.controller.command.loggin.LoginUsuarioCommand;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
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
		
		if(action.equals("getIndex")) {
			command = new GetIndexCommand();
		}else if(action.equals("getLoginForm")) {
			command = new GetLoginCommand();
		}else if(action.equals("getCadastroForm")) {
			command = new GetCadastroCommand();
		}else if(action.equals("cadastroUsuario")) {
			command = new CadastroUsuarioCommand();
		}else if(action.equals("loginUsuario")) {
			command = new LoginUsuarioCommand();
		}else if(action.equals("encurtarLink")) {
			command = new EncurtarLinkCommand();
		}
		
		String view = command.execute(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
		
	}
	
}
