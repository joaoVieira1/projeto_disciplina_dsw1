<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<jsp:include page="/includes/head.html"/>

<body>
	
	<jsp:include page="/includes/navBar.html"/>
	
	<h1 style="text-align: center;">CADASTRO</h1>
	
	<%
		String msg = (String) request.getAttribute("message");
		if (msg != null ) {
			boolean success = (Boolean) request.getAttribute("saved");
			
			if (success) {
				out.println("<div class=\"alert alert-success alert-dismissible fade show\" role=\"alert\">");
			} else {
				out.println("<div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\">");
			}
			out.println(msg);
			out.println("<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
		}
	%>
	
	<jsp:include page="/includes/formCadastro.html"/>
	
	<jsp:include page="/includes/scripts.html"/>

</body>

</html>