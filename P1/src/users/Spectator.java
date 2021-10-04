package users;

//Este usuario solo puede crear y valorar críticas además puede borrar sus propias criticas y ver la información de los espectaculos

public class Spectator extends User {

  private int userId; //Identificador del usuario debe ser único
  private String name; //Nombre del usuario
  private String surname; //Apellidos del usuario
  private String nick; //Nick del usuario
  private String email; //Email del usuario

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
    this.surname = name;
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
}
