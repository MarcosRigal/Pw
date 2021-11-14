<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="es.uco.pw.business.users.User,es.uco.pw.data.dto.UserDTO,es.uco.pw.data.dao.UserDAO,java.util.ArrayList,es.uco.pw.business.managers.UserManager" %>
<jsp:useBean  id="customerBean" scope="session" class="es.uco.pw.display.javabean.CustomerBean"></jsp:useBean>
<%
/* Posibles flujos:
	1) customerBean está logado (!= null && != "") -> Se redirige al index.jsp
	2) customerBean no está logado:
		a) Hay parámetros en el request  -> procede de la vista 
		b) No hay parámetros en el request -> procede de otra funcionalidad o index.jsp
	*/
//Caso 1: Por defecto, vuelve al index
String nextPage = "../../index.jsp";
String mensajeNextPage = "";
String paramEncoding = application.getInitParameter("PARAMETER_ENCODING");
request.setCharacterEncoding(paramEncoding);
//Caso 2
UserManager userManager = UserManager.getInstance();
if (customerBean == null || customerBean.getEmailUser().equals("")) {
	String emailUser = request.getParameter("email");
	String passwordUser = request.getParameter("password");

	//Caso 2.a: Hay parámetros -> procede de la VISTA
	if (emailUser != null && passwordUser != null) {
		//Se accede a bases de datos para obtener el usuario
		//Se realizan todas las comprobaciones necesarias del dominio
		//Aquí sólo comprobamos que exista el usuario
		if (userManager.loginUser(emailUser, passwordUser)) {
			// Usuario válido		
			UserDTO user = userManager.findUser(emailUser);
%> 			
			<jsp:setProperty property="emailUser" value="<%=emailUser%>" name="customerBean"/>
			<jsp:setProperty property="typeUser" value="<%=user.getType()%>" name="customerBean"/>
<%
		} else {
			// Usuario válido
			nextPage = "../view/loginView.jsp";
			mensajeNextPage = "El usuario que ha indicado no existe o no es v&aacute;lido";
		}
	//Caso 2.b -> se debe ir a la vista por primera vez
	} else {
		nextPage = "../view/loginView.jsp";		
	}
}
%>
<jsp:forward page="<%=nextPage%>">
	<jsp:param value="<%=mensajeNextPage%>" name="message"/>
</jsp:forward>