<%@page import="br.edu.ifsp.dsw1.model.entity.Link"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<jsp:include page="/includes/head.html"/>

<body>

	<jsp:include page="/includes/navBar.html"/>
	
	<h2 style="text-align: center; margin-top: 20px;">CADASTRE-SE E GERE LINKS PERSONALIZADOS!</h2>
	
	<form class="bg-white p-4 rounded-3 shadow" method="post" action="login.do?action=encurtarLink">
		<label for="linkLongo" class="form-label" style="text-align: center;
				margin-top: 20px; 
				font-weight: 400; 
				font-size: 25px">LINK:</label>
				
		<input type="text" id="linkLongo" class="form-control" 
				aria-describedby="passwordHelpBlock" 
				placeholder="Informe o link a ser encurtado"
				name="textLinkLongo">
		
		<button type="submit" class="btn btn-warning" style="text-align: center; margin-top: 20px;">Encurtar link</button>
	</form>
	
	<%
		String urlCurta = (String) request.getAttribute("urlCurta");
		String urlLonga = (String) request.getAttribute("urlLonga");
		
		if(urlCurta != null && urlLonga != null){
			out.println("<div class=\"alert alert-success alert-dismissible fade show\" role=\"alert\">");
			out.println("Link encurtado com sucesso!");
	%>
	
	<br/><br/>
	
	<a href="<%=urlLonga%>"><%=urlCurta%></a>
	
	<%}%>	
	
	<%
    String mensagemErro = (String) session.getAttribute("mensagemErro");
    if (mensagemErro != null) {
	%>
    <div class="alert alert-danger alert-dismissible fade show" role="alert">
        <%= mensagemErro %>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
	<%
    session.removeAttribute("mensagemErro");
    }
	%>
		
	<jsp:include page="/includes/scripts.html"/>
	
<body/>

</html>