package br.edu.ifsp.dsw1.controller.command.loggin;

import java.io.IOException;

import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.model.dao.UsuarioDaoFactory;
import br.edu.ifsp.dsw1.model.entity.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CadastroUsuarioCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		var login = request.getParameter("textLogin");
		var senha = request.getParameter("textSenha");
		
		String message;
		Boolean saved;
		
		var dao = new UsuarioDaoFactory().factory();
		saved = dao.insert(new Usuario(login, senha));
		
		if(saved) {
			message = "Registro efetuado com sucesso";
		}else {
			message = "Falha ao realizar registro";
		}
		
		request.setAttribute("message", message);
		request.setAttribute("saved", saved);
		
		return "cadastro.jsp";
	}

}
