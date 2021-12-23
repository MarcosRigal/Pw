package es.uco.pw.business.users;

import java.util.Date;

/**
 * Clase que representa al usuario del sistema.
 * @author Antonio Moruno Gracia
 * @author David Pérez Dueñas
 * @author Marcos Rivera Gavilán
 * @version 1.0
 */

public class Spectator extends User {

  private int userId;
  private String name;
  private String surname;
  private String nick;
  private String email;
  private String password;
  private Date lastLogin;

  /**
   * Constructor de la clase usuario
   * @param none
   */

  public Spectator() {}

  /**
   * Devuelve el identificador del usuario
   * @param none
   * @return int Identificador del usuario
   */

  @Override
  public int getUserId() {
    return userId;
  }

  /**
   * Devuelve el Nombre del usuario
   * @param none
   * @return String Nombre del usuario
   */

  @Override
  public String getName() {
    return name;
  }

  /**
   * Devuelve los apellidos del usuario
   * @param none
   * @return String Apellidos del usuario
   */

  @Override
  public String getSurname() {
    return surname;
  }

  /**
   * Devuelve el nick del usuario
   * @param none
   * @return String Nick del usuario
   */

  @Override
  public String getNick() {
    return nick;
  }

  /**
   * Devuelve el email del usuario
   * @param none
   * @return String Email del usuario
   */

  @Override
  public String getEmail() {
    return email;
  }

  /**
   * Devuelve el tipo de usuario
   * @param none
   * @return String Tipo del usuario
   */

  @Override
  public String getType() {
    return "Spectator";
  }

  /**
   * Devuelve la contraseña del usuario
   * @param none
   * @return string contraseña del usuario
   */

  @Override
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
   * Cambia el identificador del usuario
   * @param int Identificador del usuario
   * @return none
   */

  @Override
  public void setUserId(int userId) {
    this.userId = userId;
  }

  /**
   * Cambia el nombre del usuario
   * @param String Nombre del usuario
   * @return none
   */

  @Override
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Cambia los apellidos del usuario
   * @param String Apellidos del usuario
   * @return none
   */

  @Override
  public void setSurname(String surname) {
    this.surname = surname;
  }

  /**
   * Cambia el nick del usuario
   * @param String Nick del usuario
   * @return none
   */

  @Override
  public void setNick(String nick) {
    this.nick = nick;
  }

  /**
   * Cambia el email del usuario
   * @param String Email del usuario
   * @return none
   */

  @Override
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Permite asignar una contraseña al usuario
   * @param String Contraseña del usuario
   * @return none
   */

  @Override
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Permite asignar una última hora de conexión al usuario
   * @param lastLogin Última hora de conexión del usuario
   * @return none
   */

  public void setLastLogin(Date lastLogin) {
    this.lastLogin = lastLogin;
  }
}
