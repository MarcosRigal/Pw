package managers;

import java.util.ArrayList;
import users.User;

/**
 * Clase que implementa el patrón de diseño
 * singleton encargada de gestionar los usuarios
 * @author Antonio Moruno Gracia
 * @author David Pérez Dueñas
 * @author Marcos Rivera Gavilán
 * @version 1.0
 */

public class UserManager {

  private static UserManager instance = null;

  private ArrayList<User> users = new ArrayList<User>();

  /**
   * Constructor de la clase privado
   * para evitar que se instancie más de una vez
   * @param none
   */

  private UserManager() {}

  /**
   * Método público encargado de devolver
   * la única instancia de la clase
   * @param none
   * @return UserManager Instancia de la clase
   */

  public static UserManager getInstance() {
    if (instance == null) {
      instance = new UserManager();
    }
    return instance;
  }

  /**
   * Devuelve todos los usuarios disponibles
   * @return ArrayList<User> Vector con los usuarios
   */

  public ArrayList<User> getUsers() {
    return users;
  }

  /**
   * Modifica la lista de los usuarios
   * @param ArrayList<User> La nueva lista de usuarios
   * @return none
   */

  public void setUsers(ArrayList<User> users) {
    this.users = users;
  }

  /**
   * Añade un usuario al listado de usuarios
   * @param User Usuario que se desea añadir
   * @return Boolean True si se ha podido añadir false si no
   */

  public boolean registerUser(User user) {
    return true;
  }

  /**
   * Elimina un usuario en concreto
   * @param int Identificador del usuario que se desea eliminar
   * @return Boolean True si se ha podido borrar false si no
   */

  public boolean deleteUser(int userId) {
    return true;
  }

  /**
   * Modifica un usuario en concreto
   * @param int Identificador del usuario que se desea modificar
   * @return Boolean True si se ha podido añadir false si no
   */

  public boolean modifyUser(int userId) {
    return true;
  }

  /**
   * Busca y devuelve un usuario en concreto
   * @param int Identificador del usuario que se desea buscar
   * @return User Usuario buscado o null si no la encuentra
   */

  public User searchUser(int userId) {
    return null;
  }
}
