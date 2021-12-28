package es.uco.pw.servlet;

import es.uco.pw.business.managers.SesionManager;
import es.uco.pw.data.dtos.SesionDTO;
import es.uco.pw.display.javabean.CustomerBean;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "modifySesion", urlPatterns = "/modifySesion")
public class modifySesionServlet extends HttpServlet {

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
        SesionManager sesionManager = SesionManager.getInstance();

        int sesionId = Integer.parseInt(request.getParameter("sesionId"));
        int placesLeft = Integer.parseInt(request.getParameter("numberOfPlacesLeft"));
        String hour = request.getParameter("hour");
        String minutes = request.getParameter("minutes");
        String day = request.getParameter("day");
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        SimpleDateFormat formatter6 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String stringDate = day + "-" + month + "-" + year + " " + hour + ":" + minutes;

        SesionDTO sesion = sesionManager.findSesion(sesionId);
       
        Date date = new Date();
        try {
      	  date = formatter6.parse(stringDate);
        } catch (ParseException e) {
      	  // TODO Auto-generated catch block
      	  e.printStackTrace();
        }
        if (date.compareTo(new java.util.Date())>0) {
          
        	
          sesion.setPlacesLeft(placesLeft);
          sesion.setDate(date);
          
          System.out.println(sesion.getSesionId());
          System.out.println(sesion.getSpectacleId());
          System.out.println(sesion.getPlacesLeft());
          System.out.println(sesion.getDate());
          
          sesionManager.modifySesion(sesion);
          
        }else{
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
		    } else {
				String search = request.getParameter("sesionId");
				
				customerBean.setSearch(search);
				
				session.setAttribute("customerBean", customerBean);
		    	
		      RequestDispatcher dispatcher = request.getRequestDispatcher("/mvc/view/modifySesion.jsp");
		      dispatcher.include(request, response);
		    }
		  }
}
