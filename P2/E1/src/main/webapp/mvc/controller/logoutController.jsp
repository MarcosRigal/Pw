<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="customerBean" scope="session" class="es.uco.pw.display.javabean.CustomerBean"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Desconectar usuario</title>
</head>
<body>
<%
//Se comprueba primero que el usuario no está logado
if (customerBean.getEmailUser()=="" || customerBean == null) { %>
El usuario ya estaba desconectado. <br/>
<% } else { %>
Desconectando usuario... <br/>
<%
	// Para desconectar al usuario, se accede al método removeAttribute() de la sesión)
	request.getSession().removeAttribute("customerBean");
} %>
<a href="/JSPMVC/index.jsp">Volver</a>
</body>
</html>