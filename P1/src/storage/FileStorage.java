package storage;

/**
 * Implementación de la interfaz repository para trabajar con ficheros
 * @author Antonio Moruno Gracia
 * @author David Pérez Dueñas
 * @author Marcos Rivera Gavilán
 * @version 1.0
 */

public class FileStorage implements IRepository {

  /**
   * Función encargada de guardar el estado del sistema en el alamacenamiento
   * @param none
   * @return none
   */
  @Override
  public boolean loadSystem() {
    return false;
  }

  /**
   * Función encargada de cargar el sistema
   * @param none
   * @return none
   */
  @Override
  public boolean saveSystem() {
    return false;
  }
}
