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

  private String getSesionsQuery;

  private String getUpdateSesionsQuery;

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
    this.setProperties(properties);
    Properties prop = new Properties();
    try {
      prop.load(properties);

      getUserQuery = prop.getProperty("getUsers");
      updateLastLoginQuery = prop.getProperty("updateLastLogin");
      registerUserQuery = prop.getProperty("registerUser");
      deleteUserQuery = prop.getProperty("deleteUser");
      deleteUserFromUserReviewQuery =
        prop.getProperty("deleteUserFromUserReview");
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
      deleteReviewFromUserReviewQuery =
        prop.getProperty("deleteReviewFromUserReview");
      getUserWhoCanVoteQuery = prop.getProperty("getUserWhoCanVote");
      likeQuery = prop.getProperty("like");
      dislikeQuery = prop.getProperty("dislike");
      modifySpectacleQuery = prop.getProperty("modifySpectacle");
      deleteSpectacleFromReviewQuery =
        prop.getProperty("deleteSpectacleFromReview");
      deleteSpectacleFromUserReviewQuery =
        prop.getProperty("deleteSpectacleFromUserReview");
      deleteSpectacleQuery = prop.getProperty("deleteSpectacle");
      deleteSpectacleFromSesions =
        prop.getProperty("deleteSpectacleFromSesions");
      deleteSesion = prop.getProperty("deleteSesion");
      registerSpectacleQuery = prop.getProperty("registerSpectacle");
      registerSesionQuery = prop.getProperty("registerSesion");
      lastSpectacleQuery = prop.getProperty("getLastSpectacle");
      getSesionsQuery = prop.getProperty("getSesions");
      getUpdateSesionsQuery = prop.getProperty("updateSesions");
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
   * @return DataBaseManager Instancia de la clase
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

  public String getRegisterReviewQuery() {
    return registerReviewQuery;
  }

  /**
   * Método público para modificar una query
   * @param String Query a modificar
   * @return none
   */

  public void setRegisterReviewQuery(String registerReviewQuery) {
    this.registerReviewQuery = registerReviewQuery;
  }

  /**
   * Método público para obtener una query
   * @param none
   * @return String Query buscada
   */

  public String getGetLastReviewQuery() {
    return getLastReviewQuery;
  }

  /**
   * Método público para modificar una query
   * @param String Query a modificar
   * @return none
   */

  public void setGetLastReviewQuery(String getLastReviewQuery) {
    this.getLastReviewQuery = getLastReviewQuery;
  }

  /**
   * Método público para obtener una query
   * @param none
   * @return String Query buscada
   */

  public String getRegisterUserReviewQuery() {
    return registerUserReviewQuery;
  }

  /**
   * Método público para modificar una query
   * @param String Query a modificar
   * @return none
   */

  public void setRegisterUserReviewQuery(String registerUserReviewQuery) {
    this.registerUserReviewQuery = registerUserReviewQuery;
  }

  /**
   * Método público para obtener una query
   * @param none
   * @return String Query buscada
   */

  public String getDeleteReviewQuery() {
    return deleteReviewQuery;
  }

  /**
   * Método público para modificar una query
   * @param String Query a modificar
   * @return none
   */

  public void setDeleteReviewQuery(String deleteReviewQuery) {
    this.deleteReviewQuery = deleteReviewQuery;
  }

  /**
   * Método público para obtener una query
   * @param none
   * @return String Query buscada
   */

  public String getDeleteUserFromUserReviewQuery() {
    return deleteUserFromUserReviewQuery;
  }

  /**
   * Método público para modificar una query
   * @param String Query a modificar
   * @return none
   */

  public void setDeleteUserFromUserReviewQuery(
    String deleteUserFromUserReviewQuery
  ) {
    this.deleteUserFromUserReviewQuery = deleteUserFromUserReviewQuery;
  }

  /**
   * Método público para obtener una query
   * @param none
   * @return String Query buscada
   */

  public String getDeleteReviewFromUserReviewQuery() {
    return deleteReviewFromUserReviewQuery;
  }

  /**
   * Método público para modificar una query
   * @param String Query a modificar
   * @return none
   */

  public void setDeleteReviewFromUserReviewQuery(
    String deleteReviewFromUserReviewQuery
  ) {
    this.deleteReviewFromUserReviewQuery = deleteReviewFromUserReviewQuery;
  }

  /**
   * Método público para obtener una query
   * @param none
   * @return String Query buscada
   */

  public String getDeleteUserFromReviewQuery() {
    return deleteUserFromReviewQuery;
  }

  /**
   * Método público para modificar una query
   * @param String Query a modificar
   * @return none
   */

  public void setDeleteUserFromReviewQuery(String deleteUserFromReviewQuery) {
    this.deleteUserFromReviewQuery = deleteUserFromReviewQuery;
  }

  /**
   * Método público para obtener una query
   * @param none
   * @return String Query buscada
   */

  public String getGetUserWhoCanVoteQuery() {
    return getUserWhoCanVoteQuery;
  }

  /**
   * Método público para modificar una query
   * @param String Query a modificar
   * @return none
   */

  public void setGetUserWhoCanVoteQuery(String getUserWhoCanVoteQuery) {
    this.getUserWhoCanVoteQuery = getUserWhoCanVoteQuery;
  }

  /**
   * Método público para obtener una query
   * @param none
   * @return String Query buscada
   */

  public String getLikeQuery() {
    return likeQuery;
  }

  /**
   * Método público para modificar una query
   * @param String Query a modificar
   * @return none
   */

  public void setLikeQuery(String likeQuery) {
    this.likeQuery = likeQuery;
  }

  /**
   * Método público para obtener una query
   * @param none
   * @return String Query buscada
   */

  public String getDislikeQuery() {
    return dislikeQuery;
  }

  /**
   * Método público para modificar una query
   * @param String Query a modificar
   * @return none
   */

  public void setDislikeQuery(String dislikeQuery) {
    this.dislikeQuery = dislikeQuery;
  }

  /**
   * Método público para obtener una query
   * @param none
   * @return String Query buscada
   */

  public String getModifySpectacleQuery() {
    return modifySpectacleQuery;
  }

  /**
   * Método público para modificar una query
   * @param String Query a modificar
   * @return none
   */

  public void setModifySpectacleQuery(String modifySpectacleQuery) {
    this.modifySpectacleQuery = modifySpectacleQuery;
  }

  /**
   * Método público para obtener una query
   * @param none
   * @return String Query buscada
   */

  public String getDeleteSpectacleFromReviewQuery() {
    return deleteSpectacleFromReviewQuery;
  }

  /**
   * Método público para modificar una query
   * @param String Query a modificar
   * @return none
   */

  public void setDeleteSpectacleFromReviewQuery(
    String deleteSpectacleFromReviewQuery
  ) {
    this.deleteSpectacleFromReviewQuery = deleteSpectacleFromReviewQuery;
  }

  /**
   * Método público para obtener una query
   * @param none
   * @return String Query buscada
   */

  public String getDeleteSpectacleFromUserReviewQuery() {
    return deleteSpectacleFromUserReviewQuery;
  }

  /**
   * Método público para modificar una query
   * @param String Query a modificar
   * @return none
   */

  public void setDeleteSpectacleFromUserReviewQuery(
    String deleteSpectacleFromUserReviewQuery
  ) {
    this.deleteSpectacleFromUserReviewQuery =
      deleteSpectacleFromUserReviewQuery;
  }

  /**
   * Método público para obtener una query
   * @param none
   * @return String Query buscada
   */

  public String getDeleteSpectacleQuery() {
    return deleteSpectacleQuery;
  }

  /**
   * Método público para modificar una query
   * @param String Query a modificar
   * @return none
   */

  public void setDeleteSpectacleQuery(String deleteSpectacleQuery) {
    this.deleteSpectacleQuery = deleteSpectacleQuery;
  }

  /**
   * Método público para obtener una query
   * @param none
   * @return String Query buscada
   */

  public String getDeleteSpectacleFromSesions() {
    return deleteSpectacleFromSesions;
  }

  /**
   * Método público para modificar una query
   * @param String Query a modificar
   * @return none
   */

  public void setDeleteSpectacleFromSesions(String deleteSpectacleFromSesions) {
    this.deleteSpectacleFromSesions = deleteSpectacleFromSesions;
  }

  /**
   * Método público para obtener una query
   * @param none
   * @return String Query buscada
   */

  public String getDeleteSesion() {
    return deleteSesion;
  }

  /**
   * Método público para modificar una query
   * @param String Query a modificar
   * @return none
   */

  public void setDeleteSesion(String deleteSesion) {
    this.deleteSesion = deleteSesion;
  }

  /**
   * Método público para obtener una query
   * @param none
   * @return String Query buscada
   */

  public String getRegisterSesionQuery() {
    return registerSesionQuery;
  }

  /**
   * Método público para modificar una query
   * @param String Query a modificar
   * @return none
   */

  public void setRegisterSesionQuery(String registerSesionQuery) {
    this.registerSesionQuery = registerSesionQuery;
  }

  /**
   * Método público para obtener una query
   * @param none
   * @return String Query buscada
   */

  public String getRegisterSpectacleQuery() {
    return registerSpectacleQuery;
  }

  /**
   * Método público para modificar una query
   * @param String Query a modificar
   * @return none
   */

  public void setRegisterSpectacleQuery(String registerSpectacleQuery) {
    this.registerSpectacleQuery = registerSpectacleQuery;
  }

  /**
   * Método público para obtener una query
   * @param none
   * @return String Query buscada
   */

  public String getLastSpectacleQuery() {
    return lastSpectacleQuery;
  }

  /**
   * Método público para modificar una query
   * @param String Query a modificar
   * @return none
   */

  public void setLastSpectacleQuery(String lastSpectacleQuery) {
    this.lastSpectacleQuery = lastSpectacleQuery;
  }

  /**
   * Método público para obtener una query
   * @param none
   * @return String Query buscada
   */

  public String getGetSesionsQuery() {
    return getSesionsQuery;
  }

  /**
   * Método público para modificar una query
   * @param String Query a modificar
   * @return none
   */

  public void setGetSesionsQuery(String getSesionsQuery) {
    this.getSesionsQuery = getSesionsQuery;
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

  /**
   * Método público para obtener una query
   * @param none
   * @return String Query buscada
   */

  public String getGetUpdateSesionsQuery() {
    return getUpdateSesionsQuery;
  }

  /**
   * Método público para modificar una query
   * @param String Query a modificar
   * @return none
   */

  public void setGetUpdateSesionsQuery(String getUpdateSesionsQuery) {
    this.getUpdateSesionsQuery = getUpdateSesionsQuery;
  }
}
