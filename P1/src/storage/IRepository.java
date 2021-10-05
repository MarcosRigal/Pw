package storage;

import java.io.FileNotFoundException;
import java.io.IOException;

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
 * @throws IOException 
   */
  public abstract boolean saveSystem() throws IOException; //Interfaz para guardar el estado del sistema

  /**
   * Función encargada de cargar el sistema
   * @param none
   * @return none
 * @throws FileNotFoundException 
   */
  public abstract boolean loadSystem() throws FileNotFoundException; //Interfaz para cargar el sistema
}
