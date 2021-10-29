package daos;

import com.mysql.jdbc.ResultSet;
import dtos.SpectacleDTO;
import java.sql.*;
import java.util.ArrayList;
import storage.DBConnection;

/**
 * A DAO for users which makes use of a MySQL database connection via JDBC.
 * @author Aurora Ramirez
 * @author Jose Raul Romero
 * */

public class SpectacleDAO {

  public ArrayList<SpectacleDTO> requestSpectacles() {
    ArrayList<SpectacleDTO> listOfSpectacles = new ArrayList<SpectacleDTO>();
    try {
      DBConnection dbConnection = new DBConnection();
      Connection connection = dbConnection.getConnection();
      // Important: This query is hard-coded here for illustrative purposes only
      String query = "select * from Spectacle";

      // Important: We can replace this direct invocation to CRUD operations in DBConnection
      Statement stmt = connection.createStatement();
      ResultSet rs = (ResultSet) stmt.executeQuery(query);

      while (rs.next()) {
        int spectacleId = rs.getInt("spectacleId");
        String title = rs.getString("title");
        String type = rs.getString("type");
        String description = rs.getString("description");
        String category = rs.getString("category");
        int places = rs.getInt("places");
        listOfSpectacles.add(
          new SpectacleDTO(
            spectacleId,
            title,
            type,
            description,
            category,
            places
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
    return listOfSpectacles;
  }
}
