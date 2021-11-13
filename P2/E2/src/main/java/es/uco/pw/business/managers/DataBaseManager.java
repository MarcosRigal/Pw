package es.uco.pw.business.managers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
  
  private InputStream properties;

  private String getUserQuery;

  private String updateLastLoginQuery;

  private String registerUserQuery;

  private String deleteUserQuery;

  private String updateUserQuery;

  private String getReviewsQuery;

  private String getReviewsBySpectacleTitleQuery;

  private String getUserReviewsQuery;
  
  private String getSpectaclesQuery;

  protected Connection connection = null;

  /**
   * Constructor del review manager
   * @param none
   */

  private DataBaseManager(String url,String user,String password, InputStream properties) {
	this.url = url;
	this.user = user;
	this.password = password;
	this.properties = properties;
	Properties prop = new Properties();
	try{
      prop.load(properties);

      getUserQuery = prop.getProperty("getUsers");
      updateLastLoginQuery = prop.getProperty("updateLastLogin");
      registerUserQuery = prop.getProperty("registerUser");
      deleteUserQuery = prop.getProperty("deleteUser");
      updateUserQuery = prop.getProperty("updateUser");
      getReviewsQuery = prop.getProperty("getReviews");
      getReviewsBySpectacleTitleQuery =
        prop.getProperty("getReviewsBySpectacleTitle");
      getUserReviewsQuery = prop.getProperty("getUserReviews");
      getSpectaclesQuery = prop.getProperty("getSpectacles");
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

  public static DataBaseManager getInstance(String url,String user,String password, InputStream properties) {
    if (instance == null) {
      instance = new DataBaseManager(url, user, password, properties);
    }
    return instance;
  }
  
  public static DataBaseManager getInstance() {
	    if (instance == null) {
	    	return null;
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

public InputStream getProperties() {
	return properties;
}

public void setProperties(InputStream properties) {
	this.properties = properties;
}

}
