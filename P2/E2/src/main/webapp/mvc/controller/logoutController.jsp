<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="customerBean" scope="session" class="es.uco.pw.display.javabean.CustomerBean"></jsp:useBean>
<%
String nextPage = "../controller/loginController.jsp";
String messageNextPage = request.getParameter("message");

if (customerBean.getEmailUser()!="" || customerBean != null) {
	request.getSession().removeAttribute("customerBean");
	messageNextPage = "loggedOut";
	nextPage = "../view/logoutView.jsp";	
} 
%>
<jsp:forward page="<%=nextPage%>">
	<jsp:param value="<%=messageNextPage%>" name="message"/>
</jsp:forward>