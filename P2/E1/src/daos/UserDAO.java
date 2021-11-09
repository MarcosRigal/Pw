package daos;

import com.mysql.jdbc.ResultSet;

import dtos.UserDTO;

import java.sql.*;
import java.util.ArrayList;

import managers.DataBaseManager;

/**
 * A DAO for users which makes use of a MySQL database connection via JDBC.
 * @author Aurora Ramirez
 * @author Jose Raul Romero
 * */

public class UserDAO {

  public ArrayList<UserDTO> requestUsers() {
    ArrayList<UserDTO> listOfUsers = new ArrayList<UserDTO>();
    try {
        DataBaseManager dataBaseManager = DataBaseManager.getInstance();
        Connection connection = dataBaseManager.getConnected();
      // Important: This query is hard-coded here for illustrative purposes only
      String query = "select * from User";

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
        listOfUsers.add(
          new UserDTO(name, type, surname, nick, email, password)
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
}
