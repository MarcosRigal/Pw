package es.uco.pw.data.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase que representa al usuario del sistema.
 * @author Antonio Moruno Gracia
 * @author David Pérez Dueñas
 * @author Marcos Rivera Gavilán
 * @version 1.0
 */

public class UserDTO {

  private String name;
  private String type;
  private String surname;
  private String nick;
  private String email;
  private String password;
  private Date registerDate;
  private Date lastLogin;

  /**
   * Constructor de la clase usuario
   * @param nick
   * @param surname
   * @param name
   */

  public UserDTO(
    String name,
    String type,
    String surname,
    String nick,
    String email,
    String password,
    Date registerDate,
    Date lastLogin
  ) {
    this.name = name;
    this.type = type;
    this.surname = surname;
    this.nick = nick;
    this.email = email;
    this.password = password;
    this.registerDate = registerDate;
    this.lastLogin = lastLogin;
  }

  /**
   * Devuelve el Nombre del usuario
   * @param none
   * @return String Nombre del usuario
   */

  public String getName() {
    return name;
  }

  /**
   * Devuelve el Identificador del usuario
   * @param none
   * @return int Identificador del usuario
   */

  public int getUserId() {
    return 1;
  }

  /**
   * Devuelve los apellidos del usuario
   * @param none
   * @return String Apellidos del usuario
   */

  public String getSurname() {
    return surname;
  }

  /**
   * Devuelve el nick del usuario
   * @param none
   * @return String Nick del usuario
   */

  public String getNick() {
    return nick;
  }

  /**
   * Devuelve el email del usuario
   * @param none
   * @return String Email del usuario
   */

  public String getEmail() {
    return email;
  }

  /**
   * Devuelve el tipo de usuario
   * @param none
   * @return String Tipo del usuario
   */

  public String getType() {
    return type;
  }

  /**
   * Devuelve la contraseña del usuario
   * @param none
   * @return string contraseña del usuario
   */

  public String getPassword() {
    return password;
  }

  /**
   * Devuelve la ultima hora de conexión del usuario
   * @param none
   * @return lastLogin ultima hora de conexión del usuario
   */

  public Date getLastLogin() {
    return lastLogin;
  }

  /**
   * Devuelve la fecha de registro de un usuario
   * @param none
   * @return Date Fecha de registro del usuario serializado
   */

  public Date getRegisterDate() {
    return registerDate;
  }

  /**
   * Cambia el nombre del usuario
   * @param String Nombre del usuario
   * @return none
   */

  public void setName(String name) {
    this.name = name;
  }

  /**
   * Cambia los apellidos del usuario
   * @param String Apellidos del usuario
   * @return none
   */

  public void setSurname(String surname) {
    this.surname = surname;
  }

  /**
   * Cambia el nick del usuario
   * @param String Nick del usuario
   * @return none
   */

  public void setNick(String nick) {
    this.nick = nick;
  }

  /**
   * Cambia el email del usuario
   * @param String Email del usuario
   * @return none
   */

  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Permite asignar una contraseña al usuario
   * @param String Contraseña del usuario
   * @return none
   */

  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Permite asignar un rol al usuario
   * @param String rol del usuario
   * @return none
   */

  public void setType(String type) {
    this.type = type;
  }

  /**
   * Permite asignar una última hora de conexión al usuario
   * @param lastLogin Última hora de conexión del usuario
   * @return none
   */

  public void setLastLogin(Date lastLogin) {
    this.lastLogin = lastLogin;
  }

  /**
   * Permite serializar un usuario
   * @param none
   * @return String Usuario serializado
   */

  public String toString() {
    SimpleDateFormat formatter6 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    String userInfo =
      "Last Login: " +
      formatter6.format(this.lastLogin) +
      " Rol: " +
      this.type +
      ", Nick: " +
      this.nick;
    return userInfo;
  }

  /**
   * Modifica la fecha de registro de un usuario
   * @param Date Fecha de registro del usuario serializado
   * @return none
   */

  public void setRegisterDate(Date registerDate) {
    this.registerDate = registerDate;
  }
}
