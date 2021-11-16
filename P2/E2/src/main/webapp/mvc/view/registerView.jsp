<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean  id="customerBean" scope="session" class="es.uco.pw.display.javabean.CustomerBean"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register User</title>
</head>
<body>
<%

String nextPage = "../controller/loginController.jsp";
String messageNextPage = request.getParameter("message");
String paramEncoding = application.getInitParameter("PARAMETER_ENCODING");
request.setCharacterEncoding(paramEncoding);
if (messageNextPage == null) messageNextPage = "";

if (customerBean != null && !customerBean.getEmailUser().equals("")) {
	nextPage = "../../index.jsp";
} else {
%>
<%= messageNextPage %><br/>
<form method="post" action="../controller/registerController.jsp">
	<label for="name">Nombre: </label>
	<input type="text" name="name" value="">
	<br><br/>
	<label for="email">Apellidos: </label>
	<input type="text" name="surname" value="">
	<br><br/>
	<label for="name">Nick: </label>
	<input type="text" name="nick" value="">
	<br><br/>
	<label for="name">Email: </label>
	<input type="text" name="email" value="">
	<br><br/>
	<label for="name">Contraseña: </label>
	<input type="text" name="password" value="">
	<br><br/>
	<input type="submit" value="Submit">
</form>
<%
}
%>

</body>
</html>