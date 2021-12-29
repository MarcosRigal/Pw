package es.uco.pw.servlet;

import es.uco.pw.business.managers.SesionManager;
import es.uco.pw.business.managers.SpectacleManager;
import es.uco.pw.business.sesions.Sesion;
import es.uco.pw.data.dtos.SesionDTO;
import es.uco.pw.data.dtos.SpectacleDTO;
import es.uco.pw.display.javabean.CustomerBean;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "addSesion", urlPatterns = "/addSesion")
public class addSesionServlet extends HttpServlet {

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
      Sesion sesion = new Sesion();
      SpectacleManager spectacleManager = SpectacleManager.getInstance();
      SesionManager sesionManager = SesionManager.getInstance();

      String hour = request.getParameter("hour");
      String minutes = request.getParameter("minutes");
      String day = request.getParameter("day");
      String month = request.getParameter("month");
      String year = request.getParameter("year");
      int spectacleId = Integer.parseInt(request.getParameter("spectacleId"));
      SimpleDateFormat formatter6 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
      String stringDate =
        day + "-" + month + "-" + year + " " + hour + ":" + minutes;

      SpectacleDTO spectacle = spectacleManager.findSpectacle(spectacleId);

      System.out.println(spectacle.getTitle());
      System.out.println(spectacle.getType());

      ArrayList<SesionDTO> spectacleSesions = sesionManager.searchSpectacleSesions(
        spectacleId
      );
      Date date = new Date();
      try {
        date = formatter6.parse(stringDate);
      } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      System.out.println(spectacleSesions.size());
      int numberOfSesionsAfter = spectacleSesions.size() + 1;
      if (
        (date.compareTo(new java.util.Date()) > 0) &&
        (
          (spectacle.getType().equals("Single") && numberOfSesionsAfter < 2) ||
          (spectacle.getType().equals("Multiple")) ||
          (spectacle.getType().equals("Season"))
        )
      ) {
        System.out.println(spectacle.getType());
        sesion.setSpectacleId(spectacleId);
        sesion.setPlacesLeft(spectacle.getPlaces());
        sesion.setDate(date);
        System.out.println(sesion.getSpectacleId());
        System.out.println(sesion.getPlacesLeft());
        System.out.println(sesion.getDate());
        if (
          (spectacle.getType().equals("Single")) ||
          (spectacle.getType().equals("Multiple"))
        ) {
          sesionManager.registerSesion(sesion);
        } else {
          String parameterNumberOfSesions = request.getParameter(
            "numberOfSesions"
          );
          if (parameterNumberOfSesions.equals("")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(
              "/mvc/view/errorAdingSesion.html"
            );
            dispatcher.include(request, response);
          }
          int numberOfSesions = Integer.parseInt(parameterNumberOfSesions);
          sesionManager.registerSesion(sesion);
          Calendar cal = Calendar.getInstance();
          cal.setTime(date);
          for (int i = 1; i < numberOfSesions; i++) {
            cal.add(Calendar.DATE, 7);
            Sesion cloneSesion = new Sesion();
            cloneSesion.setSpectacleId(spectacleId);
            cloneSesion.setPlacesLeft(sesion.getPlacesLeft());
            cloneSesion.setDate(cal.getTime());
            sesionManager.registerSesion(cloneSesion);
          }
        }
      } else {
        RequestDispatcher dispatcher = request.getRequestDispatcher(
          "/mvc/view/errorAdingSesion.html"
        );
        dispatcher.include(request, response);
      }

      RequestDispatcher dispatcher = request.getRequestDispatcher(
        "/mvc/view/listSesions.jsp"
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
        "/mvc/view/addSesion.jsp"
      );
      dispatcher.include(request, response);
    }
  }
}
