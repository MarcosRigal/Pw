package es.uco.pw.data.dao;

import com.mysql.jdbc.ResultSet;
import es.uco.pw.data.dto.UserDTO;
import java.sql.*;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import es.uco.pw.business.managers.DataBaseManager;

/**
 * A DAO for users which makes use of a MySQL database connection via JDBC.
 * @author Aurora Ramirez
 * @author Jose Raul Romero
 * */

public class UserDAO {

  public ArrayList<UserDTO> getUsers() {
    ArrayList<UserDTO> listOfUsers = new ArrayList<UserDTO>();
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();
      // Important: This query is hard-coded here for illustrative purposes only
      String query = dataBaseManager.getGetUserQuery();

      // Important: We can replace this direct invocation to CRUD operations in DBConnection
      Statement stmt = connection.createStatement();
      ResultSet rs = (ResultSet) stmt.executeQuery(query);

      while (rs.next()) {
        String name = rs.getString("name");
        String type = rs.getString("type");
        String surname = rs.getString("surname");
        String nick = rs.getString("nick");
        String email = rs.getString("email");
        String password = rs.getString("password");
        java.sql.Timestamp timetamp = rs.getTimestamp("registerDate"); // O/P: DD:MM:YYYY HH:mm:ss
        java.util.Date registerDate = new java.util.Date(timetamp.getTime());
        java.sql.Timestamp timestamp = rs.getTimestamp("lastLogin"); // O/P: DD:MM:YYYY HH:mm:ss
        java.util.Date lastLogin = new java.util.Date(timestamp.getTime());
        listOfUsers.add(
          new UserDTO(name, type, surname, nick, email, password, registerDate, lastLogin)
        );
      }

      if (stmt != null) {
        stmt.close();
      }
    } catch (Exception e) {
      System.err.println(e);
      e.printStackTrace();
    }
    return listOfUsers;
  }

  public void updateLastLogin(Date lastLogin, String email) {
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();
      // Important: This query is hard-coded here for illustrative purposes only
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String query = MessageFormat.format(
        dataBaseManager.getUpdateLastLoginQuery(),
        "'",
        formatter.format(lastLogin),
        "'",
        "'",
        email,
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
  }

  public void registerUser(
    String name,
    String type,
    String surname,
    String nick,
    String email,
    String password,
    Date registerDate,
    Date lastLogin
  ) {
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();
      // Important: This query is hard-coded here for illustrative purposes only
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String query = MessageFormat.format(
        dataBaseManager.getRegisterUserQuery(),
        "'",
        name,
        "'",
        "'",
        type,
        "'",
        "'",
        surname,
        "'",
        "'",
        nick,
        "'",
        "'",
        email,
        "'",
        "'",
        password,
        "'",
        "'",
        formatter.format(registerDate),
        "'",
        "'",
        formatter.format(lastLogin),
        "'"
      );

      // Important: We can replace this direct invocation to CRUD operations in DBConnection
      if (!email.equals("")) {
          Statement stmt = connection.createStatement();
          stmt.executeUpdate(query);
          if (stmt != null) {
        	  stmt.close();
          }
      }
    } catch (Exception e) {
      System.err.println(e);
      e.printStackTrace();
    }
  }

  public void deleteUser(String deleteUserMail) {
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();
      // Important: This query is hard-coded here for illustrative purposes only
      String query = MessageFormat.format(
        dataBaseManager.getDeleteUserQuery(),
        "'",
        deleteUserMail,
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
  }

  public void modifyUser(UserDTO user) {
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();
      // Important: This query is hard-coded here for illustrative purposes only

      String query = MessageFormat.format(
        dataBaseManager.getUpdateUserQuery(),
        "'",
        user.getName(),
        "'",
        "'",
        user.getSurname(),
        "'",
        "'",
        user.getNick(),
        "'",
        "'",
        user.getPassword(),
        "'",
        "'",
        user.getEmail(),
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
  }
}
