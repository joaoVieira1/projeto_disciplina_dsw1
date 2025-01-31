<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="br.edu.ifsp.dsw1.model.entity.Link" %>
<%@ page import="br.edu.ifsp.dsw1.model.entity.Usuario" %>

<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>

<jsp:include page="/includes/head.html"/>

<body>

	<jsp:include page="/loggedin/includes/navBar.html"/>
	
	<%
    
    Usuario usuario = (Usuario) session.getAttribute("usuario");
	List<Link> links = (List<Link>) session.getAttribute("linksUsuario");

    if (usuario == null) {
        response.sendRedirect("login.jsp");
        return;
    }


	%>
	
	<div class="container">
    <h2>Links de <%= usuario.getLogin() %></h2>

    <table class="table">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">URL LONGA</th>
					<th scope="col">IDENTIFICADOR</th>
					<th scope="col">CLICKS</th>
					<th scope="col">DELETAR</th>
					<th scope="col">ATUALIZAR</th>
				</tr>
			</thead>
			<tbody class="table-group-divider">
			<%
			int i = 1;
			for (var link : links) {
			%>
				<tr>
					<th scope="row"><%= i %></th>
					<td><%= link.getUrlLonga() %></td>
					<td><a href="logged.do?action=redirecionamento&urlCurta=<%=link.getUrlCurta()%>">
						<%=link.getUrlCurta()%></a></td>
					<td><%= link.getClicks() %></td>
					<td>
						<a class="btn btn-outline-danger" 
						href="logged.do?action=deletar&urlCurta=<%=link.getUrlCurta()%>" >
						Deletar Link</a>
					</td>
					<td>
						<a class="btn btn-outline-danger" 
						href="logged.do?action=getAtualizar&linkAtualizar=<%=link.getUrlCurta()%>" >
						Atualizar Link</a>
					</td>
				</tr>
			<%	i += 1;
			} 
			%>
			</tbody>
		</table>

</div>
	
	
	<jsp:include page="/includes/scripts.html"/>
	
</body>
</html>