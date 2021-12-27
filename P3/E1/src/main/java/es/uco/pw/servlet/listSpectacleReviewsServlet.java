package es.uco.pw.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.uco.pw.display.javabean.CustomerBean;

@WebServlet(name="listSpectacleReviews", urlPatterns="/listSpectacleReviews")
public class listSpectacleReviewsServlet extends HttpServlet{

	/** Serial ID */
	private static final long serialVersionUID = -5782796844904182648L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession(true);
		CustomerBean customerBean = (CustomerBean)session.getAttribute("customerBean");
		
		if (customerBean == null || customerBean.getEmailUser().equals("")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/mvc/view/userNotFound.html");
			dispatcher.include(request, response);
		} else {
			
			String spectacleId = request.getParameter("spectacleId");
			
			customerBean.setSearch(spectacleId);
			
			session.setAttribute("customerBean", customerBean);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/mvc/view/listSpectacleReviews.jsp");
			dispatcher.include(request, response);
		}		
	}
}
