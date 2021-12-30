package es.uco.pw.display.javabean;

/**
 * Clase que representa al javaBean necesario
 * para poder realizar el login en el sistema.
 * @author Antonio Moruno Gracia
 * @author David Pérez Dueñas
 * @author Marcos Rivera Gavilán
 * @version 1.0
 */

public class CustomerBean implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  private String emailUser = "";
  private String typeUser = "";
  private String nickUser = "";
  private String filter = "";
  private String search = "";

  /**
   * Devuelve el correo del usuario
   * @param none
   * @return String Correo del usuario
   */

  public String getEmailUser() {
    return emailUser;
  }

  /**
   * Establece el correo del usuario
   * @param String Correo del usuario
   * @return none
   */

  public void setEmailUser(String emailUser) {
    this.emailUser = emailUser;
  }

  /**
   * Devuelve el tipo del usuario
   * @param none
   * @return String Tipo del usuario
   */

  public String getTypeUser() {
    return typeUser;
  }

  /**
   * Establece el tipo del usuario
   * @param String Tipo del usuario
   * @return none
   */

  public void setTypeUser(String typeUser) {
    this.typeUser = typeUser;
  }

  /**
   * Devuelve el nick del usuario
   * @param none
   * @return String Nick del usuario
   */

  public String getNickUser() {
    return nickUser;
  }

  /**
   * Establece el nick del usuario
   * @param String Nick del usuario
   * @return none
   */

  public void setNickUser(String nickUser) {
    this.nickUser = nickUser;
  }

  /**
   * Devuelve el filtro establecido por el usuario
   * @param none
   * @return String Filtro del usuario
   */

  public String getFilter() {
    return filter;
  }

  /**
   * Establece el filtro del usuario
   * @param String Filtro del usuario
   * @return none
   */

  public void setFilter(String filter) {
    this.filter = filter;
  }

  /**
   * Devuelve la búsqueda del usuario
   * @param none
   * @return String Busqueda del usuario
   */

  public String getSearch() {
    return search;
  }

  /**
   * Establece la búsqueda del usuario
   * @param String Búsqueda del usuario
   * @return none
   */

  public void setSearch(String search) {
    this.search = search;
  }
}
