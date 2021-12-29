package es.uco.pw.servlet;

import es.uco.pw.business.factories.SpectacleFactory;
import es.uco.pw.business.managers.SpectacleManager;
import es.uco.pw.business.spectacles.Spectacle;
import es.uco.pw.business.spectacles.Spectacle.category;
import es.uco.pw.business.utilities.SystemFunctions;
import es.uco.pw.display.javabean.CustomerBean;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "addSpectacle", urlPatterns = "/addSpectacle")
public class addSpectacleServlet extends HttpServlet {

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
	} else if (customerBean.getTypeUser().equals("Spectator")) {
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/mvc/view/userHome.jsp");
		dispatcher.include(request, response);
	} else {
      SpectacleManager spectacleManager = SpectacleManager.getInstance();

      String title = request.getParameter("title");
      String description = request.getParameter("description");
      String type = request.getParameter("type");
      int places = Integer.parseInt(request.getParameter("places"));
      category category = SystemFunctions.convertStringToCategory(
        request.getParameter("category")
      );

      Spectacle spectacle = SpectacleFactory.getSpectacle(type);

      spectacle.setTitle(title);
      spectacle.setCategory(category);
      spectacle.setDescription(description);
      spectacle.setPlaces(places);

      spectacleManager.registerSpectacle(spectacle);

      RequestDispatcher dispatcher = request.getRequestDispatcher(
        "/mvc/view/listSpectacles.jsp"
      );
      dispatcher.include(request, response);
    }
  }

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
	} else if (customerBean.getTypeUser().equals("Spectator")) {
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/mvc/view/userHome.jsp");
		dispatcher.include(request, response);
	} else {
      RequestDispatcher dispatcher = request.getRequestDispatcher(
        "/mvc/view/addSpectacle.jsp"
      );
      dispatcher.include(request, response);
    }
  }
}
