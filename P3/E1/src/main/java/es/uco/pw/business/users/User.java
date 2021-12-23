package es.uco.pw.business.users;

import java.util.Date;

/**
 * Clase abstracta de la que heredan las clases User y Admin
 * @author Antonio Moruno Gracia
 * @author David Pérez Dueñas
 * @author Marcos Rivera Gavilán
 * @version 1.0
 */

public abstract class User {

  /**
   * Devuelve la contraseña del usuario
   * @param none
   * @return string contraseña del usuario
   */

  public abstract String getPassword();

  /**
   * Devuelve el identificador del usuario
   * @param none
   * @return int Identificador del usuario
   */

  public abstract int getUserId();

  /**
   * Devuelve el Nombre del usuario
   * @param none
   * @return String Nombre del usuario
   */

  public abstract String getName();

  /**
   * Devuelve los apellidos del usuario
   * @param none
   * @return String Apellidos del usuario
   */

  public abstract String getSurname();

  /**
   * Devuelve el nick del usuario
   * @param none
   * @return String Nick del usuario
   */

  public abstract String getNick();

  /**
   * Devuelve el email del usuario
   * @param none
   * @return String Email del usuario
   */

  public abstract String getEmail();

  /**
   * Devuelve el tipo de usuario
   * @param none
   * @return String Tipo del usuario
   */

  public abstract String getType();

  /**
   * Devuelve la ultima hora de conexión del usuario
   * @param none
   * @return lastLogin ultima hora de conexión del usuario
   */

  public abstract Date getLastLogin();

  /**
   * Cambia el identificador del usuario
   * @param int Identificador del usuario
   * @return none
   */

  public abstract void setUserId(int userId);

  /**
   * Cambia el nombre del usuario
   * @param String Nombre del usuario
   * @return none
   */

  public abstract void setName(String name);

  /**
   * Cambia los apellidos del usuario
   * @param String Apellidos del usuario
   * @return none
   */

  public abstract void setSurname(String surname);

  /**
   * Cambia el nick del usuario
   * @param String Nick del usuario
   * @return none
   */

  public abstract void setNick(String nick);

  /**
   * Cambia el email del usuario
   * @param String Email del usuario
   * @return none
   */

  public abstract void setEmail(String email);

  /**
   * Permite asignar una contraseña al usuario
   * @param String Contraseña del usuario
   * @return none
   */
  public abstract void setPassword(String password);

  /**
   * Permite asignar una última hora de conexión al usuario
   * @param lastLogin Última hora de conexión del usuario
   * @return none
   */

  public abstract void setLastLogin(Date lastLogin);
}
