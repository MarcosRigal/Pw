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

  private User activeUser;

  private int userId;

  /**
   * Constructor de la clase privado
   * para evitar que se instancie más de una vez
   * @param none
   */

  private UserManager() {
    userId = 0;
  }

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

  public boolean addUser(User user) {
    users.add(user);
    return true;
  }

  public boolean registerUser(User user) {
    users.add(user);
    userId += 1;
    return true;
  }

  /**
   * Elimina un usuario en concreto
   * @param int Identificador del usuario que se desea eliminar
   * @return Boolean True si se ha podido borrar false si no
   */

  public boolean deleteUser(int deleteUserId) {
    return users.removeIf(
      n ->
        (
          (n.getUserId() == deleteUserId) &&
          (n.getUserId() != activeUser.getUserId()) &&
          (getActiveUser().getType().equals("Admin"))
        )
    );
  }

  /**
   * Modifica un usuario en concreto
   * @param int Identificador del usuario que se desea modificar
   * @return Boolean True si se ha podido añadir false si no
   */

  public boolean modifyUser(User user) {
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUserId() == user.getUserId()) {
        users.get(i).setName(user.getName());
        users.get(i).setSurname(user.getSurname());
        users.get(i).setNick(user.getNick());
        users.get(i).setEmail(user.getEmail());
        users.get(i).setPassword(user.getPassword());
        if (activeUser.getUserId() == user.getUserId()) {
          activeUser = users.get(i);
        }
        return true;
      }
    }
    return false;
  }

  /**
   * Busca y devuelve un usuario en concreto
   * @param int Identificador del usuario que se desea buscar
   * @return User Usuario buscado o null si no la encuentra
   */

  public User findUser(int userId) {
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUserId() == userId) {
        User user = users.get(i);
        return user;
      }
    }
    return null;
  }

  /**
   * Devuelve un identificador para los nuevos usuarios creados
   * @param none
   * @return int Identificador del próximo usuario
   */

  public int getUserId() {
    return userId;
  }

  /**
   * Se usa en la carga del sistema para recuperar el indice
   * @param int Identificador del usuario que se desea asignar
   * @return none
   */

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public User getActiveUser() {
    return activeUser;
  }

  public void setActiveUser(User activeUser) {
    this.activeUser = activeUser;
  }
}
