package es.uco.pw.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="userReviews", urlPatterns="/userReviews")
public class userReviewsServlet extends HttpServlet{

	/** Serial ID */
	private static final long serialVersionUID = -5782796844904182648L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/mvc/view/listUserReviews.jsp");
			dispatcher.include(request, response);
	}
}
