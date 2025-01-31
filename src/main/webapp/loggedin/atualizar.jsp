<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<jsp:include page="/includes/head.html"/>

<body>

	<jsp:include page="/loggedin/includes/navBar.html"/>
	
	<form class="bg-white p-4 rounded-3 shadow" method="post" action="logged.do?action=atualizar">
		<label for="NovoLinkLongo" class="form-label" style="text-align: center;
				margin-top: 20px; 
				font-weight: 400; 
				font-size: 25px">NOVO LINK LONGO:</label>
				
		<input type="text" id="NovoLinklongo" class="form-control" 
				aria-describedby="passwordHelpBlock" 
				placeholder="Informe o link longo a ser personalizado"
				name="textLinkLongo">
				
				
		<label for="NovoLinkCurto" class="form-label" style="text-align: center;
				margin-top: 20px; 
				font-weight: 400; 
				font-size: 25px">NOVO IDENTIFICADOR:</label>
				
		<input type="text" id="NovoLinkCurto" class="form-control" 
				aria-describedby="passwordHelpBlock" 
				placeholder="Escreva seu novo link curto"
				name="textLinkCurto">
		
		<button type="submit" class="btn btn-warning" style="text-align: center; margin-top: 20px;">Atualizar Link</button>
	</form>

	
	
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