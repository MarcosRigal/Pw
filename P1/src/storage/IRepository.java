package storage;

/**
 * Interfaz para implementar los métodos encargados de leer y escribir
 * @author Antonio Moruno Gracia
 * @author David Pérez Dueñas
 * @author Marcos Rivera Gavilán
 * @version 1.0
 */

public interface IRepository {
  /**
   * Función encargada de guardar el estado del sistema en el alamacenamiento
   * @param none
   * @return none
   */
  public abstract boolean saveSystem(); //Interfaz para guardar el estado del sistema

  /**
   * Función encargada de cargar el sistema
   * @param none
   * @return none
   */
  public abstract boolean loadSystem(); //Interfaz para cargar el sistema
}
