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
import es.uco.pw.data.dtos.ReviewDTO;
import es.uco.pw.display.javabean.CustomerBean;

@WebServlet(name="voteReview", urlPatterns="/voteReview")
public class voteReviewServlet extends HttpServlet{

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
		    
			ReviewManager reviewManager = ReviewManager.getInstance();
			
			
			int choice = Integer.parseInt(request.getParameter("choice"));
			int reviewId = Integer.parseInt(request.getParameter("reviewId"));
				
			ReviewDTO review = reviewManager.findReview(reviewId);

			reviewManager.voteReview(choice, reviewId, customerBean.getEmailUser());
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("listSpectacleReviews?spectacleId="+review.getSpectacleId());
			dispatcher.include(request, response);
		}		
	}
}
