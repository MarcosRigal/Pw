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
if (customerBean != null && !customerBean.getEmailUser().equals("")) {
	String name = request.getParameter("name");
	String surname = request.getParameter("surname");
	String nick = request.getParameter("nick");
	String password = request.getParameter("password");

	if (name != null && surname != null && nick != null && password != null) {

		UserDTO user = userManager.findUser(customerBean.getEmailUser());
		user.setName(name);
		user.setSurname(surname);
		user.setNick(nick);
		user.setPassword(password);

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