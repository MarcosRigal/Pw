package es.uco.pw.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="logout", urlPatterns="/logout")
public class logoutServlet extends HttpServlet{

	/** Serial ID */
	private static final long serialVersionUID = -5782796844904182648L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession(true);
			session.removeAttribute("customerBean");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.include(request, response);
	}
}
