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
 * Clase listSesionsServlet para listar las sesiones del sistema
 * @author Antonio Moruno Gracia
 * @author David Pérez Dueñas
 * @author Marcos Rivera Gavilán
 * @version 1.0
 */

@WebServlet(name = "listSesions", urlPatterns = "/listSesions")
public class listSesionsServlet extends HttpServlet {

  /** Serial ID */
  private static final long serialVersionUID = -5782796844904182648L;

  /**
   * Filtra las sesiones en base a los parámetros del formulario
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
      String day = request.getParameter("day");
      String month = request.getParameter("month");
      String year = request.getParameter("year");
      String category = request.getParameter("category");

      if (
        (day.equals("") || month.equals("") || year.equals("")) &&
        (
          category.equals("obra") ||
          category.equals("concierto") ||
          category.equals("monologo")
        )
      ) {
        customerBean.setFilter("category");
        customerBean.setSearch(category);
        session.setAttribute("customerBean", customerBean);
      } else if (
        (category.equals("")) &&
        (!day.equals("") && !month.equals("") && !year.equals(""))
      ) {
        String search = day + "-" + month + "-" + year;
        customerBean.setFilter("date");
        customerBean.setSearch(search);
        session.setAttribute("customerBean", customerBean);
      } else if (
        (!day.equals("") && !month.equals("") && !year.equals("")) &&
        (
          category.equals("obra") ||
          category.equals("concierto") ||
          category.equals("monologo")
        )
      ) {
        String search = category + "," + day + "-" + month + "-" + year;
        customerBean.setFilter("dateAndCategory");
        customerBean.setSearch(search);
        session.setAttribute("customerBean", customerBean);
      }

      RequestDispatcher dispatcher = request.getRequestDispatcher(
        "/mvc/view/listSesions.jsp"
      );
      dispatcher.include(request, response);
    }
  }

  /**
   * Redirige al usuario a la vista con todas las sesiones
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
        "/mvc/view/listSesions.jsp"
      );
      dispatcher.include(request, response);
    }
  }
}
