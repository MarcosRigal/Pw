<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="es.uco.pw.business.factories.UserFactory,es.uco.pw.business.users.User,es.uco.pw.data.dto.UserDTO,es.uco.pw.data.dao.UserDAO,java.util.ArrayList,es.uco.pw.business.managers.UserManager" %>
<jsp:useBean  id="customerBean" scope="session" class="es.uco.pw.display.javabean.CustomerBean"></jsp:useBean>
<%

String nextPage = "../../index.jsp";
String mensajeNextPage = "";
String paramEncoding = application.getInitParameter("PARAMETER_ENCODING");
request.setCharacterEncoding(paramEncoding);

UserManager userManager = UserManager.getInstance();
if (customerBean == null || customerBean.getEmailUser().equals("")) {
	String name = request.getParameter("name");
	String surname = request.getParameter("surname");
	String nick = request.getParameter("nick");
	String email = request.getParameter("email");
	String password = request.getParameter("password");

	if (name != null && surname != null && nick != null && email != null && password != null) {

		User user = UserFactory.getUser("Spectator");
		user.setName(name);
		user.setSurname(surname);
		user.setNick(nick);
		user.setEmail(email);
		user.setPassword(password);


		if (userManager.registerUser(user)) {
%>
<jsp:setProperty property="emailUser" value="<%=email%>" name="customerBean"/>
<jsp:setProperty property="typeUser" value='<%="Spectator"%>' name="customerBean"/>
<%
		} else {

			nextPage = "../view/registerView.jsp";
			mensajeNextPage = "Error al registrar usuario, el correo introducido ya esta registrado";
		}
	} else {
		nextPage = "../view/registerView.jsp";		
	}
}
%>
<jsp:forward page="<%=nextPage%>">
	<jsp:param value="<%=mensajeNextPage%>" name="message"/>
</jsp:forward>