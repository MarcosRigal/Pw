<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="customerBean" scope="session" class="es.uco.pw.display.javabean.CustomerBean"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log Out</title>
</head>
<body>
<%
String nextPage = "../controller/loginController.jsp";
String messageNextPage = request.getParameter("message");
if (messageNextPage == null) messageNextPage = "";
if (messageNextPage.equals("loggedOut")){%>	
	Desconectando usuario... <br/>
<%
	nextPage = "/JSPMVC/index.jsp";
%>
<% } else if(customerBean.getEmailUser()=="" || customerBean == null) {%>
	El usuario ya estaba desconectado. <br/>
<%
}%>
<a href="/JSPMVC/index.jsp">Volver</a>
</body>
</html>