package es.uco.pw.business.factories;

import es.uco.pw.business.users.Admin;
import es.uco.pw.business.users.Spectator;
import es.uco.pw.business.users.User;

/**
 * Clase que implementa el patrón de diseño
 * factoría para crear los usuarios.
 * @author Antonio Moruno Gracia
 * @author David Pérez Dueñas
 * @author Marcos Rivera Gavilán
 * @version 1.0
 */

public class UserFactory {

  /**
   * Método de la factoria para crear los usuarios
   * @param string El tipo de usuario que se desea crear.
   * @return User Una instancia del tipo de usuario.
   */

  public static User getUser(String type) {
    if ("Spectator".equalsIgnoreCase(type)) {
      return new Spectator();
    }
    if ("Admin".equalsIgnoreCase(type)) {
      return new Admin();
    }
    return null;
  }
}
