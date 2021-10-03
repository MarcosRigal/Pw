package users;

/**
 * Clase que representa al administrador del sistema. 
 * Este usuario puede acceder a todas las funciones 
 * del usuario base y además puede gestionar los espectáculos.
 * @author Antonio Moruno Gracia
 * @author David Pérez Dueñas
 * @author Marcos Rivera Gavilán
 * @version 1.0
 */

public class Admin extends User {

  private int userId;
  private String name;
  private String surname;
  private String nick;
  private String email;

  /**
   * Constructor de la clase espectador
   * @param none
   */

  public Admin() {}



  @Override
  public int getUserId() {
    return userId;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getSurname() {
    return surname;
  }

  @Override
  public String getNick() {
    return nick;
  }

  @Override
  public String getEmail() {
    return email;
  }

  @Override
  public String getType() {
    return "Admin";
  }

  @Override
  public void setUserId(int userId) {
    this.userId = userId;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public void setSurname(String surname) {
    this.surname = name;
  }

  @Override
  public void setNick(String nick) {
    this.nick = nick;
  }

  @Override
  public void setEmail(String email) {
    this.email = email;
  }
}
