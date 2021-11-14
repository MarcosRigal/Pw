package daos;

import com.mysql.jdbc.ResultSet;

import dtos.SpectacleDTO;

import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;

import spectacles.Spectacle;
import managers.DataBaseManager;
import managers.SpectacleManager;

/**
 * A DAO for users which makes use of a MySQL database connection via JDBC.
 * @author Aurora Ramirez
 * @author Jose Raul Romero
 * */

public class SpectacleDAO {

  public ArrayList<SpectacleDTO> getSpectacles() {
    ArrayList<SpectacleDTO> listOfSpectacles = new ArrayList<SpectacleDTO>();
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();
      // Important: This query is hard-coded here for illustrative purposes only
      String query = dataBaseManager.getGetSpectaclesQuery();

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
    } catch (Exception e) {
      System.err.println(e);
      e.printStackTrace();
    }
    return listOfSpectacles;
  }

public boolean modifySpectacle(SpectacleDTO spectacle) {
	SpectacleManager spectacleManager = SpectacleManager.getInstance();
if (spectacleManager.existsSpectacle(spectacle.getSpectacleId())) {
	try {
		DataBaseManager dataBaseManager = DataBaseManager.getInstance();
	    Connection connection = dataBaseManager.getConnected();
	    // Important: This query is hard-coded here for illustrative purposes only

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

	    // Important: We can replace this direct invocation to CRUD operations in DBConnection
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

public boolean deleteSpectacle(int spectacleId) {
	SpectacleManager spectacleManager = SpectacleManager.getInstance();
if (spectacleManager.existsSpectacle(spectacleId)) {
	
    try {
        DataBaseManager dataBaseManager = DataBaseManager.getInstance();
        Connection connection = dataBaseManager.getConnected();
        // Important: This query is hard-coded here for illustrative purposes only
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

public void registerSpectacle(Spectacle spectacle) {
    try {
        DataBaseManager dataBaseManager = DataBaseManager.getInstance();
        Connection connection = dataBaseManager.getConnected();
        // Important: This query is hard-coded here for illustrative purposes only
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
