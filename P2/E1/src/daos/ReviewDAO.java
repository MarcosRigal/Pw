package daos;

import com.mysql.jdbc.ResultSet;
import dtos.ReviewDTO;
import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import managers.DataBaseManager;
import reviews.Review;

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

  public boolean registerReview(Review review) {
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();
      // Important: This query is hard-coded here for illustrative purposes only
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

      // Important: We can replace this direct invocation to CRUD operations in DBConnection
      Statement stmt = connection.createStatement();
      stmt.executeUpdate(query);

      query = dataBaseManager.getGetLastReviewQuery();
      ResultSet rs = (ResultSet) stmt.executeQuery(query);
      String email = "";
      int reviewId = 0;
      String spectacleId = "";
      while (rs.next()) {
        email = rs.getString("email");
        reviewId = rs.getInt("LastReview");
        spectacleId = rs.getString("spectacleId");
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

  public Boolean deleteReview(int deleteReviewId) {
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();
      // Important: This query is hard-coded here for illustrative purposes only
      String query = MessageFormat.format(
        dataBaseManager.getDeleteReviewQuery(),
        "'",
        deleteReviewId,
        "'"
      );

      // Important: We can replace this direct invocation to CRUD operations in DBConnection
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

  public Boolean deleteSpectacle(int deleteSpectacleId) {
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();
      // Important: This query is hard-coded here for illustrative purposes only
      String query = MessageFormat.format(
        dataBaseManager.getDeleteSpectacleFromReviewQuery(),
        "'",
        deleteSpectacleId,
        "'"
      );

      // Important: We can replace this direct invocation to CRUD operations in DBConnection
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

  public boolean canUserVote(String email, int voteReviewId) {
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();
      // Important: This query is hard-coded here for illustrative purposes only
      String query = MessageFormat.format(
        dataBaseManager.getGetUserWhoCanVoteQuery(),
        "'",
        email,
        "'",
        voteReviewId
      );
      // Important: We can replace this direct invocation to CRUD operations in DBConnection
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

  public boolean like(String voterEmail, ReviewDTO review) {
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();
      // Important: This query is hard-coded here for illustrative purposes only
      String query = MessageFormat.format(
        dataBaseManager.getLikeQuery(),
        review.getLike() + 1,
        review.getReviewId()
      );
      // Important: We can replace this direct invocation to CRUD operations in DBConnection
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

  public boolean dislike(String voterEmail, ReviewDTO review) {
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();
      // Important: This query is hard-coded here for illustrative purposes only
      String query = MessageFormat.format(
        dataBaseManager.getDislikeQuery(),
        review.getDislike() + 1,
        review.getReviewId()
      );
      // Important: We can replace this direct invocation to CRUD operations in DBConnection
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
