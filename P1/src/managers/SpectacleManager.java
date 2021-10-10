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
   * Busca y devuelve una review en concreto
   * @param int Identificador de la review que se desea buscar
   * @return Review review buscada o null si no la encuentra
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
   * Añade un espectáculo al listado de espectáculos
   * @param Spectacle Espectáculo que se desea añadir
   * @return Boolean True si se ha podido añadir false si no
   */

  public void registerSpectacle(Spectacle spectacle) {
    this.spectacles.add(spectacle);
    spectacleId += 1;
  }

  public void addSpectacle(Spectacle spectacle) {
    this.spectacles.add(spectacle);
  }

  /**
   * Modifica un espectáculo
   * @param int Identificador del espectáculo que se desea modificar
   * @return Boolean True si se ha podido modificar false si no
   */
  public boolean modifySpectacle(int spectacleId) {
    return true;
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
   * Devuelve el numéro de entradas vendidas para un espectáculo
   * @param int Identificador del espectáculo que se desea consultar
   * @return int Número de plazas vendidas -1 si no se ha podido encontrar
   */

  public int getPlacesSold(int spectacleId) {
    return 0;
  }

  /**
   * Devuelve las plazas disponibles para una fecha en concreto
   * @param int Identificador del espectáculo que se desea consultar
   * @param LocalDate Fecha en la que se desea consultar
   * @return int Número de plazas restante -1 si no se ha podido encontrar
   */

  public int getPlacesLeft(int spectacleId, LocalDate date) {
    return 0;
  }

  /**
   * Busca espectáculos en el sistema por su titulo
   * @param String Titulo del espectáculo
   * @return ArrayList<Spectacle> Listado con los espectáculos
   */

  public ArrayList<Spectacle> findSpectacles(String title) {
    return spectacles;
  }

  /**
   * Busca espectáculos en el sistema por su categoria
   * @param category Categoría del espectáculo
   * @return ArrayList<Spectacle> Listado con los espectáculos
   */

  public ArrayList<Spectacle> findSpectacles(category category) {
    return spectacles;
  }

  /**
   * Busca en el sistema espectaculos con plaza libres
   * @param category none
   * @return ArrayList<Spectacle> Listado con los espectáculos
   */

  public ArrayList<Spectacle> nextSpectaclesWithPlaces() {
    return spectacles;
  }

  /**
   * Busca en el sistema espectaculos con plaza libres
   * que pertenezcan a una categoría
   * @param category Categoría del espectáculo
   * @return ArrayList<Spectacle> Listado con los espectáculos
   */

  public ArrayList<Spectacle> nextSpectaclesWithPlaces(category category) {
    return spectacles;
  }

  /**
   * Añade una review a un espectáculo
   * @param int Identificador del espectáculo
   * @param Review Que se desea añadir
   * @return Boolean True si se ha podiado False si no
   */

  public boolean registerReview(int spectacleId, Review review) {
    return true;
  }

  /**
   * Muestra las reviews de un espectáculo
   * @param int Identificador del espectáculo
   * @return Boolean True si se ha podiado False si no
   */

  public boolean viewReviews(int spectacleId) {
    return true;
  }

  /**
   * Borra la review de un espectáculo
   * @param int Identificador del espectáculo
   * @param int Identificador de la review
   * @return Boolean True si se ha podiado False si no
   */

  public boolean deleteReview() {
    return true;
  }

  /**
   * Asigna una valoración a una review
   * @param int reviewId Identificador de la review
   * @param Boolean Valoración del usuario true positiva false negativa
   * @return Boolean True si se ha podido asignar false si no
   */

  public boolean reviewReview() {
    return true;
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

  public Spectacle findSpectacle(int spectacleId) {
    for (int i = 0; i < spectacles.size(); i++) {
      if (spectacles.get(i).getSpectacleId() == spectacleId) {
        return spectacles.get(i);
      }
    }
    return null;
  }

  public ArrayList<Spectacle> searchByCategory(category choiceCategory) {
    ArrayList<Spectacle> searchedSpectacles = new ArrayList<Spectacle>();

    for (int i = 0; i < spectacles.size(); i++) {
      if (spectacles.get(i).getCategory().equals(choiceCategory)) {
        searchedSpectacles.add(spectacles.get(i));
      }
    }
    return searchedSpectacles;
  }

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
