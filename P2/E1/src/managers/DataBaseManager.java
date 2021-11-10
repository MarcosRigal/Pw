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
}