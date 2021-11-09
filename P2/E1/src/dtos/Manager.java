package dtos;

import daos.ReviewDAO;
import daos.SesionDAO;
import daos.SpectacleDAO;
import daos.UserDAO;
import java.util.ArrayList;

/**
 * A user manager that communicates with DAO and uses DTO to implement functionalities related to users.
 * @author Aurora Ramirez
 * @author Jose Raul Romero
 * */

public class Manager {

  public Manager() {}

  public String findUsers() {
    UserDAO userByAge = new UserDAO();
    String usersInfo = "";
    ArrayList<UserDTO> users = userByAge.requestUsers();
    for (UserDTO u : users) {
      usersInfo += u.toString() + "\n";
    }
    return usersInfo;
  }

  public String findSpectacles() {
    SpectacleDAO spectacles = new SpectacleDAO();
    String spectaclesInfo = "";
    ArrayList<SpectacleDTO> listOfSpectacles = spectacles.requestSpectacles();
    for (SpectacleDTO s : listOfSpectacles) {
      spectaclesInfo += s.toString() + "\n";
    }
    return spectaclesInfo;
  }

  public String findReviews() {
    ReviewDAO reviews = new ReviewDAO();
    String reviewsInfo = "";
    ArrayList<ReviewDTO> listOfReviews = reviews.requestReviews();
    for (ReviewDTO s : listOfReviews) {
      reviewsInfo += s.toString() + "\n";
    }
    return reviewsInfo;
  }

  public String findSesions() {
    SesionDAO sesions = new SesionDAO();
    String sesionsInfo = "";
    ArrayList<SesionDTO> listOfSesions = sesions.requestSesions();
    for (SesionDTO s : listOfSesions) {
      sesionsInfo += s.toString() + "\n";
    }
    return sesionsInfo;
  }
  // Other methods to manage users...
}
