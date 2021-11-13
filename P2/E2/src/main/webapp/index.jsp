<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean  id="customerBean" scope="session" class="es.uco.pw.display.javabean.CustomerBean"></jsp:useBean>
<%@ page import ="es.uco.pw.business.managers.DataBaseManager" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejercicio 2</title>
</head>
<body>
<% 
//Este código de reset es únicamente para poder probar múltiples veces el MVC
String properties = application.getInitParameter("properties");
java.io.InputStream myIO = application.getResourceAsStream(properties);
DataBaseManager dataBaseManager = DataBaseManager.getInstance(application.getInitParameter("url"),application.getInitParameter("user"),application.getInitParameter("password"), myIO);
dataBaseManager.getConnected();
if (request.getParameter("reset") != null) {
%>
<jsp:setProperty property="emailUser" value="" name="customerBean"/>
<%
}
if (customerBean == null || customerBean.getEmailUser().equals("")) {
	// Usuario no logado -> Se invoca al controlador de la funcionalidad
%>
<a href="/JSPMVC/mvc/controller/registerController.jsp">Registrarse</a>
<a href="/JSPMVC/mvc/controller/loginController.jsp">Acceder</a>
<% } else { %>
	¡¡Bienvenido <jsp:getProperty property="emailUser" name="customerBean"/>!! 
	<br></br>
	<a href="/JSPMVC/mvc/controller/logoutController.jsp">Desconectar</a>
<% } %>

</body>
</html>