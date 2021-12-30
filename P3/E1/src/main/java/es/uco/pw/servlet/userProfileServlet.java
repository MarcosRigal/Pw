package es.uco.pw.servlet;

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
 * Clase userProfileServlet para gestionar todo lo relacionado con el perfil de un usuario
 * @author Antonio Moruno Gracia
 * @author David Pérez Dueñas
 * @author Marcos Rivera Gavilán
 * @version 1.0
 */

@WebServlet(name = "userProfile", urlPatterns = "/userProfile")
public class userProfileServlet extends HttpServlet {

  /** Serial ID */
  private static final long serialVersionUID = -5782796844904182648L;

  /**
   * Modifica los datos del usuario
   * @param HttpServletRequest request
   * @param HttpServletResponse response
   * @return none
   */

  protected void doPost(
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
      String filter = request.getParameter("filter");
      String search = request.getParameter("search");

      customerBean.setFilter(filter);
      customerBean.setSearch(search);

      session.setAttribute("customerBean", customerBean);

      RequestDispatcher dispatcher = request.getRequestDispatcher(
        "/mvc/view/listSpectacles.jsp"
      );
      dispatcher.include(request, response);
    }
  }

  /**
   * Redirige al usuario a la vista de su perfil
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
      RequestDispatcher dispatcher = request.getRequestDispatcher(
        "/mvc/view/userProfile.jsp"
      );
      dispatcher.include(request, response);
    }
  }
}
