<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<jsp:include page="/includes/head.html"/>

<body>

	<jsp:include page="/loggedin/includes/navBar.html"/>
	
	<form class="bg-white p-4 rounded-3 shadow" method="post" action="">
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
	
	<jsp:include page="/includes/scripts.html"/>
	
</body>
</html>