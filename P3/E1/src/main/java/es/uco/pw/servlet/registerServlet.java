package es.uco.pw.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.uco.pw.business.factories.UserFactory;
import es.uco.pw.business.managers.UserManager;
import es.uco.pw.business.users.User;
import es.uco.pw.display.javabean.CustomerBean;

@WebServlet(name="register", urlPatterns="/register")
public class registerServlet extends HttpServlet{

	/** Serial ID */
	private static final long serialVersionUID = -5782796844904182648L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		response.setContentType("text/html;charset=UTF-8");
		UserManager userManager = UserManager.getInstance();
		String typeUser = request.getParameter("type");
		String nameUser = request.getParameter("name");
		String surnameUser = request.getParameter("surname");
		String nickUser = request.getParameter("nick");
		String emailUser = request.getParameter("email");
		String passwordUser = request.getParameter("password");
		
		System.out.println(typeUser); 
		System.out.println(nameUser); 
		System.out.println(surnameUser); 
		System.out.println(nickUser); 
		System.out.println(emailUser);
		System.out.println(passwordUser);
		CustomerBean customerBean = (CustomerBean)session.getAttribute("customerBean");
		if (!userManager.loginUser(emailUser, passwordUser)) {

			User user = UserFactory.getUser(typeUser);
			
			user.setName(nameUser);
			user.setSurname(surnameUser);
			user.setNick(nickUser);
			user.setEmail(emailUser);
			user.setPassword(passwordUser);
			if (userManager.registerUser(user)) {				
				if (customerBean == null || customerBean.getEmailUser().equals("")) {
					customerBean = new CustomerBean();
					customerBean.setEmailUser(emailUser);
					customerBean.setNickUser(user.getNick());
					customerBean.setTypeUser(user.getType());
					
					session.setAttribute("customerBean", customerBean);
				}

				if (user.getType().equals("Spectator")) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
					dispatcher.include(request, response);
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
					dispatcher.include(request, response);
				}
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/mvc/view/userAlreadyRegistered.html");
				dispatcher.include(request, response);				
			}
		} 
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/mvc/view/userAlreadyRegistered.html");
			dispatcher.include(request, response);
		}

	}
}
