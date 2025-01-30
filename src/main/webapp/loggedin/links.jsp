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
					<th scope="col">URL CURTA</th>
					<th scope="col">CLICKS</th>
					<th scope="col">DELETAR</th>
				</tr>
			</thead>
			<tbody class="table-group-divider">
			<%
			int i = 1;
			for (var link : links) {
			%>
				<tr>
					<th scope="row"><%= i %></th>
					<td><a href="<%= link.getUrlLonga() %>" target="_blank"><%= link.getUrlLonga() %></a></td>
					<td><%= link.getUrlCurta() %></td>
					<td><%= link.getClicks() %></td>
					<td>
						<a class="btn btn-outline-danger" 
						onclick="return confirm('Confirma a exclusão?');" 
						href="logged.do?action=deletar&id=<%=link.getId()%>" >
						Deleta Link</a>
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