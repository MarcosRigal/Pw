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
 * Clase DAO para extraer sesiones de la BDD
 * @author Antonio Moruno Gracia
 * @author David Pérez Dueñas
 * @author Marcos Rivera Gavilán
 * @version 1.0
 */

public class SesionDAO {

  /**
   * Devuelve todos las sesiones de la base de datos
   * @param none
   * @return ArrayList<SesionsDTO> Vector con las sesiones de la base de datos
   */

  public ArrayList<SesionDTO> getSesions() {
    ArrayList<SesionDTO> listOfSesions = new ArrayList<SesionDTO>();
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();

      String query = dataBaseManager.getGetSesionsQuery();

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

  /**
   * Borra todos las sesiones de un espectáculo de la base de datos
   * @param int spectacleId Identificador del espectáculo a borrar
   * @return Boolean True si se ha podido borrar False si no
   */

  public boolean deleteAllSesionsOfAnSpectacle(int spectacleId) {
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();

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

  /**
   * Borra todos una sesion en concreto de un espectáculo de la base de datos
   * @param int sesionId Identificador de la sesión a borrar
   * @return Boolean True si se ha podido borrar False si no
   */

  public boolean deleteSesion(int sesionId) {
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();
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

  /**
   * Registra una sesión en el sistem
   * @param Sesion sesión que se va a añadir
   * @return none
   */

  public void registerSesion(Sesion sesion) {
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();
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

  /**
   * Devuelve el identificador del último espectáculo
   * @param none
   * @return int Identificador del último espectáculo
   */

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

    public void modifySesion(SesionDTO sesion) {
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();

      String query = MessageFormat.format(
        dataBaseManager.getUpdateSesionQuery(),
        "'",
        sesion.getPlacesLeft(),
        "'",
        "'",
        sesion.getDate(),
        "'",
        "'",
        sesion.getSesionId(),
        "'"
      );

      Statement stmt = connection.createStatement();
      stmt.executeUpdate(query);
      if (stmt != null) {
        stmt.close();
      }
    } catch (Exception e) {
      System.err.println(e);
      e.printStackTrace();
    }
  }
}
}
