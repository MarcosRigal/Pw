package managers;

import java.util.ArrayList;
import java.util.Date;
import sesions.Sesion;

/**
 * Clase que implementa el patrón de diseño
 * singleton encargada de gestionar las sesiones
 * @author Antonio Moruno Gracia
 * @author David Pérez Dueñas
 * @author Marcos Rivera Gavilán
 * @version 1.0
 */

public class SesionManager {

  private static SesionManager instance = null;

  private ArrayList<Sesion> sesions = new ArrayList<Sesion>();

  private int sesionId;

  /**
   * Constructor del sesion manager
   * @param none
   */

  private SesionManager() {
    setSesionId(0);
  }

  /**
   * Método público encargado de devolver
   * la única instancia de la clase
   * @param none
   * @return SesionManager Instancia de la clase
   */

  public static SesionManager getInstance() {
    if (instance == null) {
      instance = new SesionManager();
    }
    return instance;
  }

  /**
   * Devuelve todas las sesiones disponibles
   * @param none
   * @return ArrayList<Sesion> Vector con las sesiones
   */

  public ArrayList<Sesion> getSesions() {
    return sesions;
  }

  /**
   * Modifica la lista de las sesiones
   * @param ArrayList<Sesion> La nueva lista de sesiones
   * @return none
   */

  public void setSesions(ArrayList<Sesion> sesions) {
    this.sesions = sesions;
  }

  /**
   * Registra en el sistema una nueva sesión
   * @param Sesion sesion que se acaba de crear
   * @return none
   */

  public void registerSesion(Sesion sesion) {
    this.sesions.add(sesion);
    setSesionId(getSesionId() + 1);
  }

  /**
   * Añade una sesion al listado de sesiones
   * @param Sesion sesion que se desea añadir
   * @return none
   */

  public void addSesion(Sesion sesion) {
    this.sesions.add(sesion);
  }

  /**
   * Devuelve un identificador para las nuevas sesiones creadas
   * @param none
   * @return int Identificador de la próxima sesion que se cree
   */

  public int getSesionId() {
    return sesionId;
  }

  /**
   * Se usa en la carga del sistema para recuperar el indice
   * @param int Identificador de la próxima sesion que se va a crear
   * @return none
   */

  public void setSesionId(int sesionId) {
    this.sesionId = sesionId;
  }

  /**
   * Elimina una sesión en concreto
   * @param int Identificador de la sesion que se desea eliminar
   * @return Boolean True si se ha podido borrar false si no
   */

  public boolean deleteSesion(int sesionId) {
    return sesions.removeIf(n -> ((n.getSesionId() == sesionId)));
  }

  /**
   * Elimina todas las sesiones de un espectáculo
   * @param int Identificador del espectáculo que se desea eliminar
   * @return Boolean True si se ha podido borrar false si no
   */

  public boolean deleteAllSesions(int spectacleId) {
    return sesions.removeIf(n -> ((n.getSpectacleId() == spectacleId)));
  }

  /**
   * Busca una sesión en concreto
   * @param int Identificador de la sesión que se desea buscar
   * @return Sesion La sesión si la ha encontrado
   */

  public Sesion findSesion(int sesionId) {
    for (int i = 0; i < sesions.size(); i++) {
      if (sesions.get(i).getSesionId() == sesionId) {
        return sesions.get(i);
      }
    }
    return null;
  }

  /**
   * Numero de plazas de una sesión dado un día concreto
   * @param int Identificador del espectáculo
   * @param Date Fecha de la sesión
   * @return int Número de plazas disponibles -1 si no quedan
   */

  public int numberOfPlacesOfSpectacleByDay(int spectacleId, Date date) {
    for (int i = 0; i < sesions.size(); i++) {
      if ((sesions.get(i).getSpectacleId() == spectacleId)) {
        if (sesions.get(i).getDate().equals(date)) {
          return sesions.get(i).getPlacesLeft();
        }
      }
    }
    return -1;
  }

  /**
   * Sesiones de un espectáculo
   * @param int Identificador del espectáculo
   * @return ArrayList<Sesion> Lista con las sesiones relativas a ese espectáculo
   */

  public ArrayList<Sesion> searchSpectacleSesions(int SpectacleId) {
    ArrayList<Sesion> spectacleSesions = new ArrayList<Sesion>();

    for (int i = 0; i < sesions.size(); i++) {
      if (sesions.get(i).getSpectacleId() == SpectacleId) {
        spectacleSesions.add(sesions.get(i));
      }
    }
    return spectacleSesions;
  }
}
