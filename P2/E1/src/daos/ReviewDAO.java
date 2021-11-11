package daos;

import com.mysql.jdbc.ResultSet;
import dtos.ReviewDTO;
import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import managers.DataBaseManager;

/**
 * A DAO for reviews which makes use of a MySQL database connection via JDBC.
 * @author Aurora Ramirez
 * @author Jose Raul Romero
 * */

public class ReviewDAO {

  public ArrayList<ReviewDTO> getReviews() {
    ArrayList<ReviewDTO> listOfReviews = new ArrayList<ReviewDTO>();
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();
      // Important: This query is hard-coded here for illustrative purposes only
      String query = dataBaseManager.getGetReviewsQuery();

      // Important: We can replace this direct invocation to CRUD operations in DBConnection
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

  public ArrayList<ReviewDTO> getReviewsBySpectacleTitle(
    String searchedSpectacleTitle
  ) {
    ArrayList<ReviewDTO> listOfReviews = new ArrayList<ReviewDTO>();
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();
      // Important: This query is hard-coded here for illustrative purposes only
      String query = MessageFormat.format(
        dataBaseManager.getGetReviewsBySpectacleTitleQuery(),
        "'",
        searchedSpectacleTitle,
        "'"
      );
      // Important: We can replace this direct invocation to CRUD operations in DBConnection
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

  public ArrayList<ReviewDTO> getUserReviews(String searchedEmail) {
    ArrayList<ReviewDTO> listOfReviews = new ArrayList<ReviewDTO>();
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();
      // Important: This query is hard-coded here for illustrative purposes only
      String query = MessageFormat.format(
        dataBaseManager.getGetUserReviewsQuery(),
        "'",
        searchedEmail,
        "'"
      );
      // Important: We can replace this direct invocation to CRUD operations in DBConnection
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
}
