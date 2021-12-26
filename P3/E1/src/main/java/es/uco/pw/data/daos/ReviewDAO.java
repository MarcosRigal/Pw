package es.uco.pw.data.daos;

import com.mysql.jdbc.ResultSet;
import es.uco.pw.data.dtos.ReviewDTO;
import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import es.uco.pw.business.managers.DataBaseManager;
import es.uco.pw.business.reviews.Review;

/**
 * Clase DAO para extraer las reviews de la BDD
 * @author Antonio Moruno Gracia
 * @author David Pérez Dueñas
 * @author Marcos Rivera Gavilán
 * @version 1.0
 */

public class ReviewDAO {

  /**
   * Devuelve todas las reviews de la base de datos
   * @param none
   * @return ArrayList<ReviewDTO> Vector con las reviews de la base de datos
   */

  public ArrayList<ReviewDTO> getReviews() {
    ArrayList<ReviewDTO> listOfReviews = new ArrayList<ReviewDTO>();
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();

      String query = dataBaseManager.getGetReviewsQuery();

      Statement stmt = connection.createStatement();
      ResultSet rs = (ResultSet) stmt.executeQuery(query);

      while (rs.next()) {
        int reviewId = rs.getInt("reviewId");
        String email = rs.getString("email");
        int spectacleId = rs.getInt("spectacleId");
        String spectacleTitle = rs.getString("spectacleTitle");
        String title = rs.getString("title");
        int score = rs.getInt("score");
        String review = rs.getString("review");
        int like = rs.getInt("likes");
        int dislike = rs.getInt("dislikes");
        listOfReviews.add(
          new ReviewDTO(
            reviewId,
            email,
            spectacleId,
            spectacleTitle,
            title,
            score,
            review,
            like,
            dislike
          )
        );
      }

      if (stmt != null) {
        stmt.close();
      }
    } catch (Exception e) {
      System.err.println(e);
      e.printStackTrace();
    }
    return listOfReviews;
  }

  /**
   * Devuelve todas las reviews de la base de datos que coincidan con el título
   * @param String Titulo de la review que buscamos
   * @return ArrayList<ReviewDTO> Vector con las reviews de la base de datos
   */

  public ArrayList<ReviewDTO> getReviewsBySpectacleTitle(
    String searchedSpectacleTitle
  ) {
    ArrayList<ReviewDTO> listOfReviews = new ArrayList<ReviewDTO>();
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();

      String query = MessageFormat.format(
        dataBaseManager.getGetReviewsBySpectacleTitleQuery(),
        "'",
        searchedSpectacleTitle,
        "'"
      );

      Statement stmt = connection.createStatement();
      ResultSet rs = (ResultSet) stmt.executeQuery(query);

      while (rs.next()) {
        int reviewId = rs.getInt("reviewId");
        String email = rs.getString("email");
        int spectacleId = rs.getInt("spectacleId");
        String spectacleTitle = rs.getString("spectacleTitle");
        String title = rs.getString("title");
        int score = rs.getInt("score");
        String review = rs.getString("review");
        int like = rs.getInt("likes");
        int dislike = rs.getInt("dislikes");
        listOfReviews.add(
          new ReviewDTO(
            reviewId,
            email,
            spectacleId,
            spectacleTitle,
            title,
            score,
            review,
            like,
            dislike
          )
        );
      }

      if (stmt != null) {
        stmt.close();
      }
    } catch (Exception e) {
      System.err.println(e);
      e.printStackTrace();
    }
    return listOfReviews;
  }

  /**
   * Devuelve todas las reviews de la base de datos que tienen un mismo autor
   * @param String email del autor
   * @return ArrayList<ReviewDTO> Vector con las reviews de la base de datos
   */

  public ArrayList<ReviewDTO> getUserReviews(String searchedEmail) {
    ArrayList<ReviewDTO> listOfReviews = new ArrayList<ReviewDTO>();
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();

      String query = MessageFormat.format(
        dataBaseManager.getGetUserReviewsQuery(),
        "'",
        searchedEmail,
        "'"
      );

      Statement stmt = connection.createStatement();
      ResultSet rs = (ResultSet) stmt.executeQuery(query);

      while (rs.next()) {
        int reviewId = rs.getInt("reviewId");
        String email = rs.getString("email");
        int spectacleId = rs.getInt("spectacleId");
        String spectacleTitle = rs.getString("spectacleTitle");
        String title = rs.getString("title");
        int score = rs.getInt("score");
        String review = rs.getString("review");
        int like = rs.getInt("likes");
        int dislike = rs.getInt("dislikes");
        listOfReviews.add(
          new ReviewDTO(
            reviewId,
            email,
            spectacleId,
            spectacleTitle,
            title,
            score,
            review,
            like,
            dislike
          )
        );
      }

      if (stmt != null) {
        stmt.close();
      }
    } catch (Exception e) {
      System.err.println(e);
      e.printStackTrace();
    }
    return listOfReviews;
  }

  /**
   * Devuelve todas las reviews de la base de datos que tienen un mismo autor
   * @param Review Review que queremos registrar en el sistema
   * @return Boolean True si se ha podido registrar false si no
   */

  public boolean registerReview(Review review) {
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();

      String query = MessageFormat.format(
        dataBaseManager.getRegisterReviewQuery(),
        "'",
        review.getEmail(),
        "'",
        "'",
        review.getSpectacleId(),
        "'",
        "'",
        review.getTitle(),
        "'",
        "'",
        review.getScore(),
        "'",
        "'",
        review.getReview(),
        "'",
        "'",
        review.getLike(),
        "'",
        "'",
        review.getDislike(),
        "'"
      );

      Statement stmt = connection.createStatement();
      stmt.executeUpdate(query);

      String email = "";
      int reviewId = 0;
      int spectacleId = 0;
      query = dataBaseManager.getGetLastReviewQuery();
      ResultSet rs = (ResultSet) stmt.executeQuery(query);
      rs = (ResultSet) stmt.executeQuery(query);
      while (rs.next()) {
        email = rs.getString("email");
        reviewId = rs.getInt("LastReview");
        spectacleId = rs.getInt("spectacleId");
      }
      query =
        MessageFormat.format(
          dataBaseManager.getRegisterUserReviewQuery(),
          "'",
          email,
          "'",
          "'",
          reviewId,
          "'",
          "'",
          spectacleId,
          "'"
        );

      stmt.executeUpdate(query);

      if (stmt != null) {
        stmt.close();
      }
    } catch (Exception e) {
      System.err.println(e);
      e.printStackTrace();
    }
    return true;
  }

  /**
   * Borra una review del sistema
   * @param int Identificador de la review a borrar
   * @return Boolean True si se ha podido borrar False si no
   */

  public Boolean deleteReview(int deleteReviewId) {
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();

      String query = MessageFormat.format(
        dataBaseManager.getDeleteReviewQuery(),
        "'",
        deleteReviewId,
        "'"
      );

      Statement stmt = connection.createStatement();
      stmt.executeUpdate(query);
      query =
        MessageFormat.format(
          dataBaseManager.getDeleteReviewFromUserReviewQuery(),
          "'",
          deleteReviewId,
          "'"
        );
      stmt.executeUpdate(query);
      if (stmt != null) {
        stmt.close();
      }
    } catch (Exception e) {
      System.err.println(e);
      e.printStackTrace();
    }
    return true;
  }

  /**
   * Borra las review del sistema asociadas a un espectáculo
   * @param int Identificador del espectáculo a borrar
   * @return Boolean True si se ha podido borrar False si no
   */

  public Boolean deleteSpectacle(int deleteSpectacleId) {
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();

      String query = MessageFormat.format(
        dataBaseManager.getDeleteSpectacleFromReviewQuery(),
        "'",
        deleteSpectacleId,
        "'"
      );

      Statement stmt = connection.createStatement();
      stmt.executeUpdate(query);
      query =
        MessageFormat.format(
          dataBaseManager.getDeleteSpectacleFromUserReviewQuery(),
          "'",
          deleteSpectacleId,
          "'"
        );
      stmt.executeUpdate(query);
      if (stmt != null) {
        stmt.close();
      }
    } catch (Exception e) {
      System.err.println(e);
      e.printStackTrace();
    }
    return true;
  }

  /**
   * Indica si un usuario puede votar una review
   * @param String Identificador del usuario que queire votar
   * @param int Identificador de la review a votar
   * @return Boolean True si puede votar False si no
   */

  public boolean canUserVote(String email, int voteReviewId) {
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();

      String query = MessageFormat.format(
        dataBaseManager.getGetUserWhoCanVoteQuery(),
        "'",
        email,
        "'",
        voteReviewId
      );

      Statement stmt = connection.createStatement();
      ResultSet rs = (ResultSet) stmt.executeQuery(query);
      int count = 0;
      while (rs.next()) {
        count = rs.getInt("Count");
      }
      if (stmt != null) {
        stmt.close();
      }
      if (count == 0) {
        return true;
      }
    } catch (Exception e) {
      System.err.println(e);
      e.printStackTrace();
    }
    return false;
  }

  /**
   * Le da un like a una review
   * @param String Identificador del usuario que queire votar
   * @param int Identificador de la review a votar
   * @return Boolean True si se ha podido votar False si no
   */

  public boolean like(String voterEmail, ReviewDTO review) {
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();

      String query = MessageFormat.format(
        dataBaseManager.getLikeQuery(),
        review.getLike() + 1,
        review.getReviewId()
      );

      Statement stmt = connection.createStatement();
      stmt.executeUpdate(query);
      query =
        MessageFormat.format(
          dataBaseManager.getRegisterUserReviewQuery(),
          "'",
          voterEmail,
          "'",
          "'",
          review.getReviewId(),
          "'",
          "'",
          review.getSpectacleId(),
          "'"
        );

      stmt.executeUpdate(query);
      if (stmt != null) {
        stmt.close();
      }
    } catch (Exception e) {
      System.err.println(e);
      e.printStackTrace();
    }
    return false;
  }

  /**
   * Le da un dislike a una review
   * @param String Identificador del usuario que queire votar
   * @param int Identificador de la review a votar
   * @return Boolean True si se ha podido votar False si no
   */

  public boolean dislike(String voterEmail, ReviewDTO review) {
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();

      String query = MessageFormat.format(
        dataBaseManager.getDislikeQuery(),
        review.getDislike() + 1,
        review.getReviewId()
      );

      Statement stmt = connection.createStatement();
      stmt.executeUpdate(query);
      query =
        MessageFormat.format(
          dataBaseManager.getRegisterUserReviewQuery(),
          "'",
          voterEmail,
          "'",
          "'",
          review.getReviewId(),
          "'",
          "'",
          review.getSpectacleId(),
          "'"
        );

      stmt.executeUpdate(query);
      if (stmt != null) {
        stmt.close();
      }
    } catch (Exception e) {
      System.err.println(e);
      e.printStackTrace();
    }
    return false;
  }
}
