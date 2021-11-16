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
   * Constructor del dataBase manager
   * @param none
   */

  private DataBaseManager(
    String url,
    String user,
    String password,
    InputStream properties
  ) {
    this.url = url;
    this.user = user;
    this.password = password;
    this.properties = properties;
    Properties prop = new Properties();
    try {
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
      e.printStackTrace();
    }
  }

  /**
   * Método público encargado de devolver
   * la única instancia de la clase
   * @param none
   * @return ReviewManager Instancia de la clase
   */

  public static DataBaseManager getInstance(
    String url,
    String user,
    String password,
    InputStream properties
  ) {
    if (instance == null) {
      instance = new DataBaseManager(url, user, password, properties);
    }
    return instance;
  }

  /**
   * Método público encargado de devolver
   * la única instancia de la clase
   * @param none
   * @return ReviewManager Instancia de la clase
   */

  public static DataBaseManager getInstance() {
    if (instance == null) {
      return null;
    }
    return instance;
  }

  /**
   * Método privado para establecer
   * la conexión de la base de datos
   * @param none
   * @return Connection Conexión a la base de datos
   */

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

  /**
   * Método público para obtener
   * la conexión de la base de datos
   * @param none
   * @return Connection Conexión a la base de datos
   */

  public Connection getConnected() {
    if (connection == null) {
      connection = connect();
    }
    return connection;
  }

  /**
   * Método privado para establecer
   * la desconexión de la base de datos
   * @param none
   * @return none
   */

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

  /**
   * Método público para establecer
   * la desconexión de la base de datos
   * @param none
   * @return Connection Conexión a la base de datos
   */

  public boolean getDisconnected() {
    boolean status = false;
    if (connection != null) {
      disconnect();
      status = true;
    }
    return status;
  }

  /**
   * Método público para obtener una query
   * @param none
   * @return String Query buscada
   */

  public String getGetUserQuery() {
    return getUserQuery;
  }

  /**
   * Método público para modificar una query
   * @param String Query a modificar
   * @return none
   */

  public void setGetUserQuery(String getUserQuery) {
    this.getUserQuery = getUserQuery;
  }

  /**
   * Método público para obtener una query
   * @param none
   * @return String Query buscada
   */

  public String getUpdateLastLoginQuery() {
    return updateLastLoginQuery;
  }

  /**
   * Método público para modificar una query
   * @param String Query a modificar
   * @return none
   */

  public void setUpdateLastLoginQuery(String updateLastLoginQuery) {
    this.updateLastLoginQuery = updateLastLoginQuery;
  }

  /**
   * Método público para obtener una query
   * @param none
   * @return String Query buscada
   */

  public String getRegisterUserQuery() {
    return registerUserQuery;
  }

  /**
   * Método público para modificar una query
   * @param String Query a modificar
   * @return none
   */

  public void setRegisterUserQuery(String registerUserQuery) {
    this.registerUserQuery = registerUserQuery;
  }

  /**
   * Método público para obtener una query
   * @param none
   * @return String Query buscada
   */

  public String getDeleteUserQuery() {
    return deleteUserQuery;
  }

  /**
   * Método público para modificar una query
   * @param String Query a modificar
   * @return none
   */

  public void setDeleteUserQuery(String deleteUserQuery) {
    this.deleteUserQuery = deleteUserQuery;
  }

  /**
   * Método público para obtener una query
   * @param none
   * @return String Query buscada
   */

  public String getUpdateUserQuery() {
    return updateUserQuery;
  }

  /**
   * Método público para modificar una query
   * @param String Query a modificar
   * @return none
   */

  public void setUpdateUserQuery(String updateUserQuery) {
    this.updateUserQuery = updateUserQuery;
  }

  /**
   * Método público para obtener una query
   * @param none
   * @return String Query buscada
   */

  public String getGetReviewsQuery() {
    return getReviewsQuery;
  }

  /**
   * Método público para modificar una query
   * @param String Query a modificar
   * @return none
   */

  public void setGetReviewsQuery(String getReviewsQuery) {
    this.getReviewsQuery = getReviewsQuery;
  }

  /**
   * Método público para obtener una query
   * @param none
   * @return String Query buscada
   */

  public String getGetReviewsBySpectacleTitleQuery() {
    return getReviewsBySpectacleTitleQuery;
  }

  /**
   * Método público para modificar una query
   * @param String Query a modificar
   * @return none
   */

  public void setGetReviewsBySpectacleTitleQuery(
    String getReviewsBySpectacleTitleQuery
  ) {
    this.getReviewsBySpectacleTitleQuery = getReviewsBySpectacleTitleQuery;
  }

  /**
   * Método público para obtener una query
   * @param none
   * @return String Query buscada
   */

  public String getGetUserReviewsQuery() {
    return getUserReviewsQuery;
  }

  /**
   * Método público para modificar una query
   * @param String Query a modificar
   * @return none
   */

  public void setGetUserReviewsQuery(String getUserReviewsQuery) {
    this.getUserReviewsQuery = getUserReviewsQuery;
  }

  /**
   * Método público para obtener una query
   * @param none
   * @return String Query buscada
   */

  public String getGetSpectaclesQuery() {
    return getSpectaclesQuery;
  }

  /**
   * Método público para modificar una query
   * @param String Query a modificar
   * @return none
   */

  public void setGetSpectaclesQuery(String getSpectaclesQuery) {
    this.getSpectaclesQuery = getSpectaclesQuery;
  }

  /**
   * Método público para obtener una query
   * @param none
   * @return String Query buscada
   */

  public InputStream getProperties() {
    return properties;
  }

  /**
   * Método público para modificar una query
   * @param String Query a modificar
   * @return none
   */

  public void setProperties(InputStream properties) {
    this.properties = properties;
  }
}
