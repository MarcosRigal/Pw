package managers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Clase que implementa el patrón de diseño
 * singleton encargada de gestionar las
 * conexiones a la base de datos
 * @author Antonio Moruno Gracia
 * @author David Pérez Dueñas
 * @author Marcos Rivera Gavilán
 * @version 1.0
 */

public class DataBaseManager {

  private static DataBaseManager instance = null;

  private String url;

  private String user;

  private String password;

  private String getUserQuery;

  private String updateLastLoginQuery;

  private String registerUserQuery;

  private String deleteUserQuery;

  private String updateUserQuery;

  private String getReviewsQuery;

  private String getReviewsBySpectacleTitleQuery;

  private String getUserReviewsQuery;
  
  private String getSpectaclesQuery;
  
  private String registerReviewQuery;
  
  private String getLastReviewQuery;
  
  private String registerUserReviewQuery;
  
  private String deleteReviewQuery;
  
  private String deleteUserFromUserReviewQuery;
  
  private String deleteReviewFromUserReviewQuery;
  
  private String deleteUserFromReviewQuery;
  
  private String getUserWhoCanVoteQuery;
  
  private String likeQuery;
  
  private String dislikeQuery;
  
  private String modifySpectacleQuery;
  
  private String deleteSpectacleFromReviewQuery;
  
  private String deleteSpectacleFromUserReviewQuery;

  private String deleteSpectacleQuery;
  
  private String deleteSpectacleFromSesions;
  
  private String deleteSesion;
  
  private String registerSesionQuery;
  
  private String registerSpectacleQuery;
  
  private String lastSpectacleQuery;
  
  protected Connection connection = null;

  /**
   * Constructor del review manager
   * @param none
   */

  private DataBaseManager() {
    Properties prop = new Properties();
    String filename = "config.properties";
    try {
      BufferedReader reader = new BufferedReader(
        new FileReader(new File(filename))
      );
      prop.load(reader);

      url = prop.getProperty("url");
      user = prop.getProperty("user");
      password = prop.getProperty("password");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    prop = new Properties();
    filename = "sql.properties";
    try {
      BufferedReader reader = new BufferedReader(
        new FileReader(new File(filename))
      );
      prop.load(reader);

      getUserQuery = prop.getProperty("getUsers");
      updateLastLoginQuery = prop.getProperty("updateLastLogin");
      registerUserQuery = prop.getProperty("registerUser");
      deleteUserQuery = prop.getProperty("deleteUser");
      deleteUserFromUserReviewQuery = prop.getProperty("deleteUserFromUserReview");
      deleteUserFromReviewQuery = prop.getProperty("deleteUserFromReview");
      updateUserQuery = prop.getProperty("updateUser");
      getReviewsQuery = prop.getProperty("getReviews");
      getReviewsBySpectacleTitleQuery =
        prop.getProperty("getReviewsBySpectacleTitle");
      getUserReviewsQuery = prop.getProperty("getUserReviews");
      getSpectaclesQuery = prop.getProperty("getSpectacles");
      registerReviewQuery = prop.getProperty("registerReview");
      getLastReviewQuery = prop.getProperty("getLastReview");
      registerUserReviewQuery = prop.getProperty("registerUserReview");
      deleteReviewQuery = prop.getProperty("deleteReview");
      deleteReviewFromUserReviewQuery = prop.getProperty("deleteReviewFromUserReview");
      getUserWhoCanVoteQuery = prop.getProperty("getUserWhoCanVote");
      likeQuery = prop.getProperty("like");
      dislikeQuery = prop.getProperty("dislike");
      modifySpectacleQuery = prop.getProperty("modifySpectacle");
      deleteSpectacleFromReviewQuery = prop.getProperty("deleteSpectacleFromReview");
      deleteSpectacleFromUserReviewQuery = prop.getProperty("deleteSpectacleFromUserReview");
      deleteSpectacleQuery = prop.getProperty("deleteSpectacle");
      deleteSpectacleFromSesions = prop.getProperty("deleteSpectacleFromSesions");
      deleteSesion = prop.getProperty("deleteSesion");
      registerSpectacleQuery = prop.getProperty("registerSpectacle");
      registerSesionQuery = prop.getProperty("registerSesion");
      lastSpectacleQuery = prop.getProperty("getLastSpectacle");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  /**
   * Método público encargado de devolver
   * la única instancia de la clase
   * @param none
   * @return ReviewManager Instancia de la clase
   */

  public static DataBaseManager getInstance() {
    if (instance == null) {
      instance = new DataBaseManager();
    }
    return instance;
  }

  private Connection connect() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      this.connection =
        (Connection) DriverManager.getConnection(url, user, password);
      System.out.println("Database connection successfully opened!");
    } catch (SQLException e) {
      System.err.println("Connection to MySQL has failed!");
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      System.err.println("JDBC Driver not found.");
      e.printStackTrace();
    }
    return this.connection;
  }

  public Connection getConnected() {
    if (connection == null) {
      connection = connect();
    }
    return connection;
  }

  private void disconnect() {
    try {
      if (this.connection != null && !this.connection.isClosed()) {
        this.connection.close();
        System.out.println("Database connection successfully closed!");
      }
    } catch (SQLException e) {
      System.err.println("Error while trying to close the connection.");
      e.printStackTrace();
    }
  }

  public boolean getDisconnected() {
    boolean status = false;
    if (connection != null) {
      disconnect();
      status = true;
    }
    return status;
  }

  public String getGetUserQuery() {
    return getUserQuery;
  }

  public void setGetUserQuery(String getUserQuery) {
    this.getUserQuery = getUserQuery;
  }

  public String getUpdateLastLoginQuery() {
    return updateLastLoginQuery;
  }

  public void setUpdateLastLoginQuery(String updateLastLoginQuery) {
    this.updateLastLoginQuery = updateLastLoginQuery;
  }

  public String getRegisterUserQuery() {
    return registerUserQuery;
  }

  public void setRegisterUserQuery(String registerUserQuery) {
    this.registerUserQuery = registerUserQuery;
  }

  public String getDeleteUserQuery() {
    return deleteUserQuery;
  }

  public void setDeleteUserQuery(String deleteUserQuery) {
    this.deleteUserQuery = deleteUserQuery;
  }

  public String getUpdateUserQuery() {
    return updateUserQuery;
  }

  public void setUpdateUserQuery(String updateUserQuery) {
    this.updateUserQuery = updateUserQuery;
  }

  public String getGetReviewsQuery() {
    return getReviewsQuery;
  }

  public void setGetReviewsQuery(String getReviewsQuery) {
    this.getReviewsQuery = getReviewsQuery;
  }

  public String getGetReviewsBySpectacleTitleQuery() {
    return getReviewsBySpectacleTitleQuery;
  }

  public void setGetReviewsBySpectacleTitleQuery(
    String getReviewsBySpectacleTitleQuery
  ) {
    this.getReviewsBySpectacleTitleQuery = getReviewsBySpectacleTitleQuery;
  }

  public String getGetUserReviewsQuery() {
    return getUserReviewsQuery;
  }

  public void setGetUserReviewsQuery(String getUserReviewsQuery) {
    this.getUserReviewsQuery = getUserReviewsQuery;
  }

public String getGetSpectaclesQuery() {
	return getSpectaclesQuery;
}

public void setGetSpectaclesQuery(String getSpectaclesQuery) {
	this.getSpectaclesQuery = getSpectaclesQuery;
}

public String getRegisterReviewQuery() {
	return registerReviewQuery;
}

public void setRegisterReviewQuery(String registerReviewQuery) {
	this.registerReviewQuery = registerReviewQuery;
}

public String getGetLastReviewQuery() {
	return getLastReviewQuery;
}

public void setGetLastReviewQuery(String getLastReviewQuery) {
	this.getLastReviewQuery = getLastReviewQuery;
}

public String getRegisterUserReviewQuery() {
	return registerUserReviewQuery;
}

public void setRegisterUserReviewQuery(String registerUserReviewQuery) {
	this.registerUserReviewQuery = registerUserReviewQuery;
}

public String getDeleteReviewQuery() {
	return deleteReviewQuery;
}

public void setDeleteReviewQuery(String deleteReviewQuery) {
	this.deleteReviewQuery = deleteReviewQuery;
}

public String getDeleteUserFromUserReviewQuery() {
	return deleteUserFromUserReviewQuery;
}

public void setDeleteUserFromUserReviewQuery(
		String deleteUserFromUserReviewQuery) {
	this.deleteUserFromUserReviewQuery = deleteUserFromUserReviewQuery;
}

public String getDeleteReviewFromUserReviewQuery() {
	return deleteReviewFromUserReviewQuery;
}

public void setDeleteReviewFromUserReviewQuery(
		String deleteReviewFromUserReviewQuery) {
	this.deleteReviewFromUserReviewQuery = deleteReviewFromUserReviewQuery;
}

public String getDeleteUserFromReviewQuery() {
	return deleteUserFromReviewQuery;
}

public void setDeleteUserFromReviewQuery(String deleteUserFromReviewQuery) {
	this.deleteUserFromReviewQuery = deleteUserFromReviewQuery;
}

public String getGetUserWhoCanVoteQuery() {
	return getUserWhoCanVoteQuery;
}

public void setGetUserWhoCanVoteQuery(String getUserWhoCanVoteQuery) {
	this.getUserWhoCanVoteQuery = getUserWhoCanVoteQuery;
}

public String getLikeQuery() {
	return likeQuery;
}

public void setLikeQuery(String likeQuery) {
	this.likeQuery = likeQuery;
}

public String getDislikeQuery() {
	return dislikeQuery;
}

public void setDislikeQuery(String dislikeQuery) {
	this.dislikeQuery = dislikeQuery;
}

public String getModifySpectacleQuery() {
	return modifySpectacleQuery;
}

public void setModifySpectacleQuery(String modifySpectacleQuery) {
	this.modifySpectacleQuery = modifySpectacleQuery;
}

public String getDeleteSpectacleFromReviewQuery() {
	return deleteSpectacleFromReviewQuery;
}

public void setDeleteSpectacleFromReviewQuery(
		String deleteSpectacleFromReviewQuery) {
	this.deleteSpectacleFromReviewQuery = deleteSpectacleFromReviewQuery;
}

public String getDeleteSpectacleFromUserReviewQuery() {
	return deleteSpectacleFromUserReviewQuery;
}

public void setDeleteSpectacleFromUserReviewQuery(
		String deleteSpectacleFromUserReviewQuery) {
	this.deleteSpectacleFromUserReviewQuery = deleteSpectacleFromUserReviewQuery;
}

public String getDeleteSpectacleQuery() {
	return deleteSpectacleQuery;
}

public void setDeleteSpectacleQuery(String deleteSpectacleQuery) {
	this.deleteSpectacleQuery = deleteSpectacleQuery;
}

public String getDeleteSpectacleFromSesions() {
	return deleteSpectacleFromSesions;
}

public void setDeleteSpectacleFromSesions(String deleteSpectacleFromSesions) {
	this.deleteSpectacleFromSesions = deleteSpectacleFromSesions;
}

public String getDeleteSesion() {
	return deleteSesion;
}

public void setDeleteSesion(String deleteSesion) {
	this.deleteSesion = deleteSesion;
}

public String getRegisterSesionQuery() {
	return registerSesionQuery;
}

public void setRegisterSesionQuery(String registerSesionQuery) {
	this.registerSesionQuery = registerSesionQuery;
}

public String getRegisterSpectacleQuery() {
	return registerSpectacleQuery;
}

public void setRegisterSpectacleQuery(String registerSpectacleQuery) {
	this.registerSpectacleQuery = registerSpectacleQuery;
}

public String getLastSpectacleQuery() {
	return lastSpectacleQuery;
}

public void setLastSpectacleQuery(String lastSpectacleQuery) {
	this.lastSpectacleQuery = lastSpectacleQuery;
}

}
