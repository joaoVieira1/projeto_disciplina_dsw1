package br.edu.ifsp.dsw1.controller.command.loggin;

import java.io.IOException;

import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.model.dao.UsuarioDaoFactory;
import br.edu.ifsp.dsw1.model.entity.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginUsuarioCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		var login = request.getParameter("textLogin");
		var senha = request.getParameter("textSenha");
		
		String view;
		
		var dao = new UsuarioDaoFactory().factory();
		var usuario = dao.findByLogin(login);
		
		var autenticar = Usuario.autenticar(usuario, login, senha);
		
		if(autenticar) {
			var session = request.getSession(true);
			session.setAttribute("usuario", usuario);
			session.setMaxInactiveInterval(24 * 60 * 60);
			session.setAttribute("cadastrado", "cadastrado");
			view = "logged.do?action=getLogged";
		}else {
			request.setAttribute("message", "Login ou senha inválidos");
			view = "login.do?action=getLoginForm";
		}
		
		return view;
	}

}
