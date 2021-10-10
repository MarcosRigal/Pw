package managers;

import java.time.LocalDate;
import java.util.ArrayList;
import reviews.Review;
import spectacles.Spectacle;
import spectacles.Spectacle.category;

/**
 * Clase que implementa el patrón de diseño
 * singleton encargada de gestionar los espectáculos
 * @author Antonio Moruno Gracia
 * @author David Pérez Dueñas
 * @author Marcos Rivera Gavilán
 * @version 1.0
 */

public class SpectacleManager {

  private static SpectacleManager instance = null;

  private ArrayList<Spectacle> spectacles = new ArrayList<Spectacle>();

  private int spectacleId;

  /**
   * Constructor del spectacle manager
   * @param none
   */

  private SpectacleManager() {
    spectacleId = 0;
  }

  /**
   * Método público encargado de devolver
   * la única instancia de la clase
   * @param none
   * @return SpectacleManager Instancia de la clase
   */

  public static SpectacleManager getInstance() {
    if (instance == null) {
      instance = new SpectacleManager();
    }
    return instance;
  }

  /**
   * Devuelve todos los espectáculos disponibles
   * @param none
   * @return ArrayList<Spectacle> Vector con los espectáculos
   */

  public ArrayList<Spectacle> getSpectacles() {
    return spectacles;
  }

  /**
   * Modifica la lista de los espectáculos
   * @param ArrayList<Spectacle> La nueva lista de espectáculos
   * @return none
   */

  public void setSpectacles(ArrayList<Spectacle> spectacles) {
    this.spectacles = spectacles;
  }

  /**
   * Registra un espectáculo nuevo
   * @param Spectacle Espectáculo que se desea añadir
   * @return none
   */

  public void registerSpectacle(Spectacle spectacle) {
    this.spectacles.add(spectacle);
    spectacleId += 1;
  }

  /**
   * Añade un espectáculo al sistema
   * @param Spectacle Espectáculo que se desea añadir
   * @return none
   */

  public void addSpectacle(Spectacle spectacle) {
    this.spectacles.add(spectacle);
  }

  /**
   * Borra un espectáculo
   * @param int Identificador del espectáculo que se desea borrar
   * @return Boolean True si se ha podido borrar false si no
   */

  public boolean deleteSpectacle(int spectacleId) {
    SesionManager sesionManager = SesionManager.getInstance();
    sesionManager.deleteAllSesions(spectacleId);
    return spectacles.removeIf(n -> ((n.getSpectacleId() == spectacleId)));
  }

  /**
   * Devuelve un identificador para los nuevos espectaculos creados
   * @param none
   * @return int Identificador del próximo espectáculo
   */

  public int getSpectacleId() {
    return spectacleId;
  }

  /**
   * Se usa en la carga del sistema para recuperar el indice
   * @param int Identificador del espectáculo que se desea asignar
   * @return none
   */

  public void setSpectacleId(int spectacleId) {
    this.spectacleId = spectacleId;
  }

  /**
   * Modifica un espectáculo
   * @param int Identificador del espectáculo que se desea modificar
   * @return Boolean True si se ha modificado False si no
   */

  public boolean modifySpectacle(Spectacle spectacle) {
    for (int i = 0; i < spectacles.size(); i++) {
      if (spectacles.get(i).getSpectacleId() == spectacle.getSpectacleId()) {
        spectacles.get(i).setTitle(spectacle.getTitle());
        spectacles.get(i).setDescription(spectacle.getDescription());
        spectacles.get(i).setCategory(spectacle.getCategory());
        return true;
      }
    }
    return false;
  }

  /**
   * Busca un espectáculo dado su identificador
   * @param int Identificador del espectáculo que se desea buscar
   * @return none
   */

  public Spectacle findSpectacle(int spectacleId) {
    for (int i = 0; i < spectacles.size(); i++) {
      if (spectacles.get(i).getSpectacleId() == spectacleId) {
        return spectacles.get(i);
      }
    }
    return null;
  }

  /**
   * Devuelve los espectáculos de una categoría en concreto
   * @param category Categoría de los espectáculos que buscamos
   * @return ArrayList<Spectacle> Lista con los espectáculos de dicha categoría
   */

  public ArrayList<Spectacle> searchByCategory(category choiceCategory) {
    ArrayList<Spectacle> searchedSpectacles = new ArrayList<Spectacle>();

    for (int i = 0; i < spectacles.size(); i++) {
      if (spectacles.get(i).getCategory().equals(choiceCategory)) {
        searchedSpectacles.add(spectacles.get(i));
      }
    }
    return searchedSpectacles;
  }

  /**
   * Devuelve los espectáculos con un título en concreto
   * @param String Título de los espectáculos que buscamos
   * @return ArrayList<Spectacle> Lista con los espectáculos con dicho titulo
   */

  public ArrayList<Spectacle> searchByTitle(String title) {
    ArrayList<Spectacle> searchedSpectacles = new ArrayList<Spectacle>();

    for (int i = 0; i < spectacles.size(); i++) {
      if (spectacles.get(i).getTitle().equals(title)) {
        searchedSpectacles.add(spectacles.get(i));
      }
    }
    return searchedSpectacles;
  }
}
