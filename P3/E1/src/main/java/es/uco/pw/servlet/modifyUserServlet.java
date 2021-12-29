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

@WebServlet(name = "modifyUser", urlPatterns = "/modifyUser")
public class modifyUserServlet extends HttpServlet {

  /** Serial ID */
  private static final long serialVersionUID = -5782796844904182648L;

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
      UserManager userManager = UserManager.getInstance();
      String nameUser = request.getParameter("name");
      String surnameUser = request.getParameter("surname");
      String nickUser = request.getParameter("nick");
      String passwordUser = request.getParameter("password");

      UserDTO user = userManager.findUser(customerBean.getEmailUser());

      user.setName(nameUser);
      user.setSurname(surnameUser);
      user.setNick(nickUser);
      user.setPassword(passwordUser);
      userManager.modifyUser(user);

      customerBean.setNickUser(user.getNick());

      session.setAttribute("customerBean", customerBean);
      RequestDispatcher dispatcher = request.getRequestDispatcher(
        "/mvc/view/userProfile.jsp"
      );
      dispatcher.include(request, response);
    }
  }
}
