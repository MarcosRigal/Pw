package es.uco.pw.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.uco.pw.business.managers.ReviewManager;
import es.uco.pw.business.reviews.Review;
import es.uco.pw.display.javabean.CustomerBean;

@WebServlet(name="registerReview", urlPatterns="/registerReview")
public class registerReviewServlet extends HttpServlet{

	/** Serial ID */
	private static final long serialVersionUID = -5782796844904182648L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			HttpSession session = request.getSession(true);
			CustomerBean customerBean = (CustomerBean)session.getAttribute("customerBean");
			
			if (customerBean == null || customerBean.getEmailUser().equals("")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/mvc/view/userNotFound.html");
				dispatcher.include(request, response);
			} else {
			    Review review = new Review();
			    ReviewManager reviewManager = ReviewManager.getInstance();
			    
			    review.setEmail(customerBean.getEmailUser());
			    review.setSpectacleId(Integer.parseInt(request.getParameter("spectacleId")));
			    review.setTitle(request.getParameter("title"));
			    review.setScore(Integer.parseInt(request.getParameter("score")));
			    review.setReview(request.getParameter("review"));
			    
			    reviewManager.registerReview(review);
			    
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.include(request, response);
			}

	}
}
