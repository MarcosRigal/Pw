package es.uco.pw.servlet;

import es.uco.pw.business.managers.ReviewManager;
import es.uco.pw.display.javabean.CustomerBean;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Clase deleteReviewServlet para borrar una review del sistema
 * @author Antonio Moruno Gracia
 * @author David Pérez Dueñas
 * @author Marcos Rivera Gavilán
 * @version 1.0
 */

@WebServlet(name = "deleteReview", urlPatterns = "/deleteReview")
public class deleteReviewServlet extends HttpServlet {

  /** Serial ID */
  private static final long serialVersionUID = -5782796844904182648L;

  /**
   * Borra una review del sistema
   * @param HttpServletRequest request
   * @param HttpServletResponse response
   * @return none
   */

  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  )
    throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");
    HttpSession session = request.getSession(true);
    CustomerBean customerBean = (CustomerBean) session.getAttribute(
      "customerBean"
    );

    if (customerBean == null || customerBean.getEmailUser().equals("")) {
      RequestDispatcher dispatcher = request.getRequestDispatcher(
        "/mvc/view/userNotFound.html"
      );
      dispatcher.include(request, response);
    } else {
      ReviewManager reviewManager = ReviewManager.getInstance();

      int reviewId = Integer.parseInt(request.getParameter("reviewId"));

      reviewManager.deleteReview(
        reviewId,
        customerBean.getEmailUser(),
        customerBean.getTypeUser()
      );

      RequestDispatcher dispatcher = request.getRequestDispatcher(
        "/mvc/view/listUserReviews.jsp"
      );
      dispatcher.include(request, response);
    }
  }
}
