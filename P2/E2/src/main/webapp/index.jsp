<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean  id="customerBean" scope="session" class="es.uco.pw.display.javabean.CustomerBean"></jsp:useBean>
<%@ page import ="java.text.SimpleDateFormat,es.uco.pw.data.dto.UserDTO,es.uco.pw.business.managers.DataBaseManager,es.uco.pw.business.managers.UserManager,java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejercicio 2</title>
</head>
<body>
<% 
String messageNextPage = request.getParameter("message");

String properties = application.getInitParameter("properties");
SimpleDateFormat formatter6 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
java.io.InputStream myIO = application.getResourceAsStream(properties);
DataBaseManager dataBaseManager = DataBaseManager.getInstance(application.getInitParameter("url"),application.getInitParameter("user"),application.getInitParameter("password"), myIO);
dataBaseManager.getConnected();
UserManager userManager = UserManager.getInstance();
if (request.getParameter("reset") != null) {
%>
<jsp:setProperty property="emailUser" value="" name="customerBean"/>
<jsp:setProperty property="typeUser" value="" name="customerBean"/>
<%
}
if (customerBean == null || customerBean.getEmailUser().equals("")) {
%>
<a href="/JSPMVC/mvc/controller/registerController.jsp">Registrarse</a>
<a href="/JSPMVC/mvc/controller/loginController.jsp">Acceder</a>
<% } else { 
	if(customerBean.getTypeUser().equals("Spectator")){
	UserDTO user = userManager.findUser(customerBean.getEmailUser());
	if(!messageNextPage.equals("")){
%>
		<%= messageNextPage %><br/><br/>
<% }%>
	¡¡Bienvenido <jsp:getProperty property="emailUser" name="customerBean"/>!! 
	<br></br>
	Fecha y Hora: <%= formatter6.format(new java.util.Date())%>
	<br></br>
	Fecha de registro: <%= formatter6.format(user.getRegisterDate())%>
	<br></br>
	<a href="/JSPMVC/mvc/controller/modifyUserController.jsp">Modificar</a>
	<a href="/JSPMVC/mvc/controller/logoutController.jsp">Desconectar</a>
		
<% 	} else{
	ArrayList<UserDTO> users = userManager.getUsers();
	if(!messageNextPage.equals("")){
%>
		<%= messageNextPage %><br/><br/>
<% }%>

	¡¡Bienvenido <jsp:getProperty property="emailUser" name="customerBean"/>!! 
	<br></br>
	Fecha y Hora: <%= formatter6.format(new java.util.Date())%>
    <% 
    for (int i = 0; i < users.size(); i++) {%>
	<br></br>
    	<%= users.get(i).toString()%>
    <%}
    %>
	<br></br>
	<a href="/JSPMVC/mvc/controller/modifyUserController.jsp">Modificar</a>
	<a href="/JSPMVC/mvc/controller/logoutController.jsp">Desconectar</a>
	
	<%}%>
<% } %>

</body>
</html>