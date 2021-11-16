package es.uco.pw.business.managers;

import es.uco.pw.business.users.User;
import es.uco.pw.data.dao.UserDAO;
import es.uco.pw.data.dto.UserDTO;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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

  private UserDTO activeUser;

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
   * @return Manager Instancia de la clase
   */

  public static UserManager getInstance() {
    if (instance == null) {
      instance = new UserManager();
    }
    return instance;
  }

  /**
   * Devuelve todos los usuarios disponibles
   * @param none
   * @return ArrayList<User> Vector con los usuarios
   */

  public ArrayList<UserDTO> getUsers() {
    UserDAO users = new UserDAO();
    return users.getUsers();
  }

  /**
   * Devuelve todos los usuarios disponibles
   * @param none
   * @return ArrayList<User> Vector con los usuarios
   */

  public Boolean loginUser(String email, String password) {
    ArrayList<UserDTO> users = getUsers();
    for (int i = 0; i < users.size(); i++) {
      if (
        (users.get(i).getEmail().equals(email)) &&
        (users.get(i).getPassword().equals(password))
      ) {
        setActiveUser(users.get(i));
        new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date lastLogin = new Date(System.currentTimeMillis());
        activeUser.setLastLogin(lastLogin);
        UserDAO user = new UserDAO();
        user.updateLastLogin(lastLogin, email);
        return true;
      }
    }
    return false;
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

  /**
   * Registra un nuevo usuario en el sistema
   * @param User Usuario que se desea añadir
   * @return Boolean True si se ha podido añadir false si no
   */

  public boolean registerUser(User user) {
    ArrayList<UserDTO> users = getUsers();
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getEmail().equals(user.getEmail())) {
        return false;
      }
    }
    UserDAO userDAO = new UserDAO();
    new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    Date registerDate = new Date(System.currentTimeMillis());
    Date lastLogin = new Date(System.currentTimeMillis());
    userDAO.registerUser(
      user.getName(),
      user.getType(),
      user.getSurname(),
      user.getNick(),
      user.getEmail(),
      user.getPassword(),
      registerDate,
      lastLogin
    );
    return true;
  }

  /**
   * Elimina un usuario en concreto
   * @param int Identificador del usuario que se desea eliminar
   * @return Boolean True si se ha podido borrar false si no
   */

  public boolean deleteUser(String deleteUserMail) {
    if (activeUser.getEmail().equals(deleteUserMail)) {
      return false;
    }
    ArrayList<UserDTO> users = getUsers();
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getEmail().equals(deleteUserMail)) {
        UserDAO userDAO = new UserDAO();
        userDAO.deleteUser(deleteUserMail);
        return true;
      }
    }
    return false;
  }

  /**
   * Modifica un usuario en concreto
   * @param int Identificador del usuario que se desea modificar
   * @return Boolean True si se ha podido añadir false si no
   */

  public boolean modifyUser(UserDTO user) {
    UserDAO userDAO = new UserDAO();
    userDAO.modifyUser(user);
    if (activeUser.getEmail().equals(user.getEmail())) {
      setActiveUser(user);
    }
    return true;
  }

  /**
   * Busca y devuelve un usuario en concreto
   * @param int Identificador del usuario que se desea buscar
   * @return User Usuario buscado o null si no la encuentra
   */

  public UserDTO findUser(String email) {
    ArrayList<UserDTO> users = getUsers();
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getEmail().equals(email)) {
        return users.get(i);
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

  /**
   * Devuelve el usuario que ha iniciado sesión
   * @param none
   * @return User usuario logeado
   */

  public UserDTO getActiveUser() {
    return activeUser;
  }

  /**
   * Permite indicar que usuario ha iniciado sesión
   * @param User usuario logeado
   * @return none
   */

  public void setActiveUser(UserDTO activeUser) {
    this.activeUser = activeUser;
  }

  /**
   * Devuelve una lista con los usuarios en forma de cadena
   * @param none
   * @return String Lista de usuarios
   */

  public String listUsers() {
    UserDAO userByAge = new UserDAO();
    String usersInfo = "";
    ArrayList<UserDTO> users = userByAge.getUsers();
    for (UserDTO u : users) {
      usersInfo += u.toString() + "\n";
    }
    return usersInfo;
  }
}
