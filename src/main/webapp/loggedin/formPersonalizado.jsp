<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<jsp:include page="/includes/head.html"/>

<body>

	<jsp:include page="/loggedin/includes/navBar.html"/>
	
	<form class="bg-white p-4 rounded-3 shadow" method="post" action="logged.do?action=salvarPersonalizado">
		<label for="linkLongo" class="form-label" style="text-align: center;
				margin-top: 20px; 
				font-weight: 400; 
				font-size: 25px">LINK:</label>
				
		<input type="text" id="linkLongo" class="form-control" 
				aria-describedby="passwordHelpBlock" 
				placeholder="Informe o link a ser personalizado"
				name="textLinkLongo">
				
				
		<label for="linkPersonalizado" class="form-label" style="text-align: center;
				margin-top: 20px; 
				font-weight: 400; 
				font-size: 25px">LINK PERSONALIZADO:</label>
				
		<input type="text" id="linkPersonalizado" class="form-control" 
				aria-describedby="passwordHelpBlock" 
				placeholder="Escreva seu link personalizado"
				name="textLinkPersonalizado">
		
		<button type="submit" class="btn btn-warning" style="text-align: center; margin-top: 20px;">Salvar Link Personalizado</button>
	</form>
	
	<%
		String urlCurta = (String) request.getAttribute("urlCurta");
		String urlLonga = (String) request.getAttribute("urlLonga");
		
		if(urlCurta != null && urlLonga != null){
			out.println("<div class=\"alert alert-success alert-dismissible fade show\" role=\"alert\">");
			out.println("Link personalizado gerado com sucesso!");
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
	
</body>
</html>