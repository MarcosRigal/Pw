package daos;

import com.mysql.jdbc.ResultSet;
import dtos.ReviewDTO;
import java.sql.*;
import java.util.ArrayList;
import storage.DBConnection;

/**
 * A DAO for reviews which makes use of a MySQL database connection via JDBC.
 * @author Aurora Ramirez
 * @author Jose Raul Romero
 * */

public class ReviewDAO {

  public ArrayList<ReviewDTO> requestReviews() {
    ArrayList<ReviewDTO> listOfReviews = new ArrayList<ReviewDTO>();
    try {
      DBConnection dbConnection = new DBConnection();
      Connection connection = dbConnection.getConnection();
      // Important: This query is hard-coded here for illustrative purposes only
      String query = "select * from Review";

      // Important: We can replace this direct invocation to CRUD operations in DBConnection
      Statement stmt = connection.createStatement();
      ResultSet rs = (ResultSet) stmt.executeQuery(query);

      while (rs.next()) {
        int reviewId = rs.getInt("reviewId");
        String email = rs.getString("email");
        int spectacleId = rs.getInt("spectacleId");
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
      dbConnection.closeConnection();
    } catch (Exception e) {
      System.err.println(e);
      e.printStackTrace();
    }
    return listOfReviews;
  }
}
