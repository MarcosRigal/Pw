<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="es.uco.pw.business.users.User,es.uco.pw.data.dto.UserDTO,es.uco.pw.data.dao.UserDAO,java.util.ArrayList,es.uco.pw.business.managers.UserManager" %>
<jsp:useBean  id="customerBean" scope="session" class="es.uco.pw.display.javabean.CustomerBean"></jsp:useBean>
<%

String nextPage = "../../index.jsp";
String mensajeNextPage = "";
String paramEncoding = application.getInitParameter("PARAMETER_ENCODING");
request.setCharacterEncoding(paramEncoding);

UserManager userManager = UserManager.getInstance();
if (customerBean == null || customerBean.getEmailUser().equals("")) {
	String emailUser = request.getParameter("email");
	String passwordUser = request.getParameter("password");

	if (emailUser != null && passwordUser != null) {

		if (userManager.loginUser(emailUser, passwordUser)) {

			UserDTO user = userManager.findUser(emailUser);
%> 			
			<jsp:setProperty property="emailUser" value="<%=emailUser%>" name="customerBean"/>
			<jsp:setProperty property="typeUser" value="<%=user.getType()%>" name="customerBean"/>
<%
		} else {

			nextPage = "../view/loginView.jsp";
			mensajeNextPage = "El usuario que ha indicado no existe o no es v&aacute;lido";
		}

	} else {
		nextPage = "../view/loginView.jsp";		
	}
}
%>
<jsp:forward page="<%=nextPage%>">
	<jsp:param value="<%=mensajeNextPage%>" name="message"/>
</jsp:forward>