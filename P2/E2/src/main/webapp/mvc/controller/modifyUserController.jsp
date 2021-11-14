<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="es.uco.pw.business.factories.UserFactory,es.uco.pw.business.users.User,es.uco.pw.data.dto.UserDTO,es.uco.pw.data.dao.UserDAO,java.util.ArrayList,es.uco.pw.business.managers.UserManager" %>
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
if (customerBean != null && !customerBean.getEmailUser().equals("")) {
	String name = request.getParameter("name");
	String surname = request.getParameter("surname");
	String nick = request.getParameter("nick");
	String password = request.getParameter("password");

	//Caso 2.a: Hay parámetros -> procede de la VISTA
	if (name != null && surname != null && nick != null && password != null) {
		//Se accede a bases de datos para obtener el usuario
		UserDTO user = userManager.findUser(customerBean.getEmailUser());
		user.setName(name);
		user.setSurname(surname);
		user.setNick(nick);
		user.setPassword(password);

		//Se realizan todas las comprobaciones necesarias del dominio
		//Aquí sólo comprobamos que exista el usuario
		userManager.modifyUser(user);
		nextPage = "../../index.jsp";
		mensajeNextPage = "Cambios guardados correctamente";
	} else {
		nextPage = "../view/modifyUserView.jsp";		
	}
}
%>
<jsp:forward page="<%=nextPage%>">
	<jsp:param value="<%=mensajeNextPage%>" name="message"/>
</jsp:forward>