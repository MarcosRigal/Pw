package es.uco.pw.data.storage;

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
 * A class to manage the MySQL connection (general methods and configuration).
 * @author Aurora Ramirez
 * @author Jose Raul Romero
 * */

public class DBConnection {

  protected Connection connection = null;

  // Important: This configuration is hard-coded here for illustrative purposes only

  protected String url;

  protected String user;

  protected String password;

  public DBConnection() {
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
  }

  public Connection getConnection() {
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

  // We can include here other methods to encapsulate CRUD commands...

  public void closeConnection() {
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
}
