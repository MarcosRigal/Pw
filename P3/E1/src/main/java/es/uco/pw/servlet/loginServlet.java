package es.uco.pw.servlet;

import es.uco.pw.business.managers.UserManager;
import es.uco.pw.data.dtos.UserDTO;
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
 * Clase loginServlet para iniciar sesión
 * @author Antonio Moruno Gracia
 * @author David Pérez Dueñas
 * @author Marcos Rivera Gavilán
 * @version 1.0
 */

@WebServlet(name = "login", urlPatterns = "/login")
public class loginServlet extends HttpServlet {

  /** Serial ID */
  private static final long serialVersionUID = -5782796844904182648L;

  /**
   * Inicia sesión con los datos de un formulario
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
    UserManager userManager = UserManager.getInstance();
    String emailUser = request.getParameter("email");
    String passwordUser = request.getParameter("password");

    HttpSession session = request.getSession(true);
    CustomerBean customerBean = (CustomerBean) session.getAttribute(
      "customerBean"
    );
    if (userManager.loginUser(emailUser, passwordUser)) {
      UserDTO user = userManager.findUser(emailUser);
      if (customerBean == null) {
        customerBean = new CustomerBean();
      }

      customerBean.setEmailUser(emailUser);
      customerBean.setNickUser(user.getNick());
      customerBean.setTypeUser(user.getType());

      session.setAttribute("customerBean", customerBean);
      if (user.getType().equals("Spectator")) {
        RequestDispatcher dispatcher = request.getRequestDispatcher(
          "/mvc/view/userHome.jsp"
        );
        dispatcher.include(request, response);
      } else {
        RequestDispatcher dispatcher = request.getRequestDispatcher(
          "/mvc/view/adminHome.jsp"
        );
        dispatcher.include(request, response);
      }
    } else {
      RequestDispatcher dispatcher = request.getRequestDispatcher(
        "/mvc/view/userNotFound.html"
      );
      dispatcher.include(request, response);
    }
  }
}
