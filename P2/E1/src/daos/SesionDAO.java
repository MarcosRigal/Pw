package daos;

import com.mysql.jdbc.ResultSet;
import dtos.SesionDTO;
import java.sql.*;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import managers.DataBaseManager;
import sesions.Sesion;

/**
 * A DAO for sesions which makes use of a MySQL database connection via JDBC.
 * @author Aurora Ramirez
 * @author Jose Raul Romero
 * */

public class SesionDAO {

  public ArrayList<SesionDTO> getSesions() {
    ArrayList<SesionDTO> listOfSesions = new ArrayList<SesionDTO>();
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();
      // Important: This query is hard-coded here for illustrative purposes only
      String query =
        "SELECT sesionId, Sesion.spectacleId, Spectacle.title, placesLeft, date FROM `Sesion` INNER JOIN Spectacle ON Sesion.spectacleId = Spectacle.spectacleId";

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

  public boolean deleteAllSesionsOfAnSpectacle(int spectacleId) {
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();
      // Important: This query is hard-coded here for illustrative purposes only
      Statement stmt = connection.createStatement();
      String query = MessageFormat.format(
        dataBaseManager.getDeleteSpectacleFromSesions(),
        "'",
        spectacleId,
        "'"
      );
      stmt.executeUpdate(query);
      if (stmt != null) {
        stmt.close();
      }
      return true;
    } catch (Exception e) {
      System.err.println(e);
      e.printStackTrace();
    }
    return false;
  }

  public boolean deleteSesion(int sesionId) {
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();
      // Important: This query is hard-coded here for illustrative purposes only
      Statement stmt = connection.createStatement();
      String query = MessageFormat.format(
        dataBaseManager.getDeleteSesion(),
        "'",
        sesionId,
        "'"
      );
      stmt.executeUpdate(query);
      if (stmt != null) {
        stmt.close();
      }
      return true;
    } catch (Exception e) {
      System.err.println(e);
      e.printStackTrace();
    }
    return false;
  }

  public void registerSesion(Sesion sesion) {
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();
      // Important: This query is hard-coded here for illustrative purposes only
      Statement stmt = connection.createStatement();
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String query = MessageFormat.format(
        dataBaseManager.getRegisterSesionQuery(),
        "'",
        sesion.getSpectacleId(),
        "'",
        "'",
        sesion.getPlacesLeft(),
        "'",
        "'",
        formatter.format(sesion.getDate()),
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
  }

  public int getLastSpectacle() {
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();
      Statement stmt = connection.createStatement();
      String query = dataBaseManager.getLastSpectacleQuery();
      ResultSet rs = (ResultSet) stmt.executeQuery(query);
      int lastSpectacleId = 0;
      while (rs.next()) {
        lastSpectacleId = rs.getInt("LastSpectacle");
      }

      if (stmt != null) {
        stmt.close();
      }
      return lastSpectacleId;
    } catch (Exception e) {
      System.err.println(e);
      e.printStackTrace();
    }
    return -1;
  }
}
