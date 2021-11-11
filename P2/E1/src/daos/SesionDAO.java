package daos;

import com.mysql.jdbc.ResultSet;
import dtos.SesionDTO;
import java.sql.*;
import java.util.ArrayList;
import managers.DataBaseManager;

/**
 * A DAO for sesions which makes use of a MySQL database connection via JDBC.
 * @author Aurora Ramirez
 * @author Jose Raul Romero
 * */

public class SesionDAO {

  public ArrayList<SesionDTO> requestSesions() {
    ArrayList<SesionDTO> listOfSesions = new ArrayList<SesionDTO>();
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();
      // Important: This query is hard-coded here for illustrative purposes only
      String query = "select * from Sesion";

      // Important: We can replace this direct invocation to CRUD operations in DBConnection
      Statement stmt = connection.createStatement();
      ResultSet rs = (ResultSet) stmt.executeQuery(query);

      while (rs.next()) {
        int sesionId = rs.getInt("sesionId");
        int spectacleId = rs.getInt("spectacleId");
        int placesLeft = rs.getInt("placesLeft");
        java.sql.Timestamp timestamp = rs.getTimestamp("date"); // O/P: DD:MM:YYYY HH:mm:ss
        java.util.Date date = new java.util.Date(timestamp.getTime());
        listOfSesions.add(
          new SesionDTO(spectacleId, sesionId, placesLeft, date)
        );
      }

      if (stmt != null) {
        stmt.close();
      }
    } catch (Exception e) {
      System.err.println(e);
      e.printStackTrace();
    }
    return listOfSesions;
  }
}
