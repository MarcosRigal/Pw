package daos;

import com.mysql.jdbc.ResultSet;
import dtos.UserDTO;
import java.sql.*;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import managers.DataBaseManager;

/**
 * Clase DAO para extraer usuarios de la BDD
 * @author Antonio Moruno Gracia
 * @author David Pérez Dueñas
 * @author Marcos Rivera Gavilán
 * @version 1.0
 */

public class UserDAO {

  /**
   * Devuelve todos los usuarios de la base de datos
   * @param none
   * @return ArrayList<UserDTO> Vector con los usuarios de la base de datos
   */

  public ArrayList<UserDTO> getUsers() {
    ArrayList<UserDTO> listOfUsers = new ArrayList<UserDTO>();
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();

      String query = dataBaseManager.getGetUserQuery();

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
          new UserDTO(
            name,
            type,
            surname,
            nick,
            email,
            password,
            registerDate,
            lastLogin
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
    return listOfUsers;
  }

  /**
   * Actualiza la fecha del último login de un usuario
   * @param Date Última fecha de conexión
   * @param String email del usuario
   * @return none
   */

  public void updateLastLogin(Date lastLogin, String email) {
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();
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

  /**
   * Registra un usuario en el sistema
   * @param String nombre del usuario
   * @param String tipo del usuario
   * @param String apellidos del usuario
   * @param String nick del usuario
   * @param String email del usuario
   * @param String contraseña del usuario
   * @param Date Última fecha de conexión
   * @param Date Fecha de registro
   * @return none
   */

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

  /**
   * Borra un usuario del sistema
   * @param String email del usuario
   * @return none
   */

  public void deleteUser(String deleteUserMail) {
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();

      Statement stmt = connection.createStatement();
      String query = MessageFormat.format(
        dataBaseManager.getDeleteUserQuery(),
        "'",
        deleteUserMail,
        "'"
      );

      stmt.executeUpdate(query);
      query =
        MessageFormat.format(
          dataBaseManager.getDeleteUserFromUserReviewQuery(),
          "'",
          deleteUserMail,
          "'"
        );
      stmt.executeUpdate(query);
      query =
        MessageFormat.format(
          dataBaseManager.getDeleteUserFromReviewQuery(),
          "'",
          deleteUserMail,
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

  /**
   * Modifica un usuario del sistema
   * @param UserDTO Usuario a modificar
   * @return none
   */

  public void modifyUser(UserDTO user) {
    try {
      DataBaseManager dataBaseManager = DataBaseManager.getInstance();
      Connection connection = dataBaseManager.getConnected();

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
