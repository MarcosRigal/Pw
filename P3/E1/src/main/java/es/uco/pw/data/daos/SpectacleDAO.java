package es.uco.pw.data.daos;

import com.mysql.jdbc.ResultSet;
import es.uco.pw.data.dtos.SpectacleDTO;
import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import es.uco.pw.business.managers.DataBaseManager;
import es.uco.pw.business.managers.SpectacleManager;
import es.uco.pw.business.spectacles.Spectacle;

/**
 * Clase DAO para extraer espectáculos de la BDD
 * @author Antonio Moruno Gracia
 * @author David Pérez Dueñas
 * @author Marcos Rivera Gavilán
 * @version 1.0
 */

public class SpectacleDAO {

  /**
   * Devuelve todos los espectáculos de la base de datos
   * @param none
   * @return ArrayList<SpectacleDTO> Vector con los espectáculos de la base de datos
   */

  public ArrayList<SpectacleDTO> getSpectacles() {
    ArrayList<SpectacleDTO> listOfSpectacles = new ArrayList<SpectacleDTO>();
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();

      String query = dataBaseManager.getGetSpectaclesQuery();

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
    } catch (Exception e) {
      System.err.println(e);
      e.printStackTrace();
    }
    return listOfSpectacles;
  }

  /**
   * Modifica un espectáculo de la base de datos
   * @param SpectacleDTO Espectáculo que se desea modifciar
   * @return Boolean True si se ha podido modificar False si no
   */

  public boolean modifySpectacle(SpectacleDTO spectacle) {
    SpectacleManager spectacleManager = SpectacleManager.getInstance();
    if (spectacleManager.existsSpectacle(spectacle.getSpectacleId())) {
      try {
        DataBaseManager dataBaseManager = DataBaseManager.getInstance();
        Connection connection = dataBaseManager.getConnected();

        String query = MessageFormat.format(
          dataBaseManager.getModifySpectacleQuery(),
          "'",
          spectacle.getTitle(),
          "'",
          "'",
          spectacle.getType(),
          "'",
          "'",
          spectacle.getDescription(),
          "'",
          "'",
          spectacle.getCategory(),
          "'",
          "'",
          spectacle.getPlaces(),
          "'",
          "'",
          spectacle.getSpectacleId(),
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
      return true;
    }
    return false;
  }

  /**
   * Borra un espectáculo de la base de datos
   * @param int Identificador del espectáculo que se desea borrar
   * @return Boolean True si se ha podido borrar False si no
   */

  public boolean deleteSpectacle(int spectacleId) {
    SpectacleManager spectacleManager = SpectacleManager.getInstance();
    if (spectacleManager.existsSpectacle(spectacleId)) {
      try {
        DataBaseManager dataBaseManager = DataBaseManager.getInstance();
        Connection connection = dataBaseManager.getConnected();

        ReviewDAO reviewDAO = new ReviewDAO();
        reviewDAO.deleteSpectacle(spectacleId);
        SesionDAO sesionDAO = new SesionDAO();
        sesionDAO.deleteAllSesionsOfAnSpectacle(spectacleId);
        Statement stmt = connection.createStatement();
        String query = MessageFormat.format(
          dataBaseManager.getDeleteSpectacleQuery(),
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
    return false;
  }

  /**
   * Añade un espectáculo de la base de datos
   * @param Spectacle Espectáculo que se desea añadir
   * @return none
   */

  public void registerSpectacle(Spectacle spectacle) {
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();

      Statement stmt = connection.createStatement();
      String query = MessageFormat.format(
        dataBaseManager.getRegisterSpectacleQuery(),
        "'",
        spectacle.getTitle(),
        "'",
        "'",
        spectacle.getType(),
        "'",
        "'",
        spectacle.getDescription(),
        "'",
        "'",
        spectacle.getCategory(),
        "'",
        "'",
        spectacle.getPlaces(),
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
}
