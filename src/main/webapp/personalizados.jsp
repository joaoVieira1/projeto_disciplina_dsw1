<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="br.edu.ifsp.dsw1.model.entity.Link" %>
<%@ page import="br.edu.ifsp.dsw1.model.entity.Usuario" %>

<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>

<jsp:include page="/includes/head.html"/>

<body>

	<jsp:include page="/includes/navBar.html"/>
	
	<% List<Link> links = (List<Link>) session.getAttribute("allLinks"); %>
	
	<div class="container">
    <h2>Links Gerados</h2>

    <table class="table">
			<thead>
				<tr>
					<th scope="col">URL LONGA</th>
					<th scope="col">IDENTIFICADOR</th>
					<th scope="col">CRIADOR</th>
				</tr>
			</thead>
			<tbody class="table-group-divider">
			<%
			for (var link : links) {
			%>
				<tr>
					<td><%= link.getUrlLonga() %></td>
					<td><a href="logged.do?action=redirecionamento&urlCurta=<%=link.getUrlCurta()%>">
						<%=link.getUrlCurta()%></a></td>
					<td><%= link.getUsuario() %></td>
				</tr>
			<%	
			} 
			%>
			</tbody>
		</table>

</div>
	
	
	<jsp:include page="/includes/scripts.html"/>
	
</body>
</html>