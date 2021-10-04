package spectacles;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase abastracta de la que heredan los distintos tipos de espectáculos
 * @author Antonio Moruno Gracia
 * @author David Pérez Dueñas
 * @author Marcos Rivera Gavilán
 * @version 1.0
 */

public abstract class Spectacle {

  public enum category {
    concierto,
    monologo,
    obra,
  }

  /**
   * Devuelve el identificador del espectáculo
   * @param none
   * @return int Identificador del espectáculo
   */

  public abstract int getSpectacleId();

  /**
   * Devuelve el título del espectáculo
   * @param none
   * @return String Título del espectáculo
   */

  public abstract String getTitle();

  /**
   * Devuelve la descripción del espectáculo
   * @param none
   * @return String Descripción del espectáculo
   */

  public abstract String getDescription();

  /**
   * Devuelve la categoría del espectáculo
   * @param none
   * @return category Categoría del espectáculo
   */

  public abstract category getCategory();

  /**
   * Devuelve el número de plazas del espectáculo
   * @param none
   * @return int Numero de plazas del espectáculo
   */

  public abstract int getPlaces();

  /**
   * Devuelve el número de plazas del espectáculo
   * @param none
   * @return int Número de plazas del espectáculo
   */

  public abstract int getPlacesLeft();

  /**
   * Devuelve las fechas en las que se realiza el espectáculo
   * @param none
   * @return ArrayList<LocalDate> Vector con las fechas del espectáculo
   */

  public abstract ArrayList<LocalDate> getDates();

  /**
   * Devuelve el tipo de espectáculo
   * @param none
   * @return String Tipo de espectáculo
   */

  public abstract String getType();

  /**
   * Cambia el identificador del espectáculo
   * @param int Identificador del espectáculo
   * @return none
   */

  public abstract void setSpectacleId(int spectacleId);

  /**
   * Cambia el título del espectáculo
   * @param int Título del espectáculo
   * @return none
   */

  public abstract void setTitle(String title);

  /**
   * Cambia la descripción del espectáculo
   * @param String Descripición del espectáculo
   * @return none
   */

  public abstract void setDescription(String description);

  /**
   * Cambia la categoría del espectáculo
   * @param category Tipo del espectáculo
   * @return none
   */

  public abstract void setCategory(category category);

  /**
   * Cambia el número de plazas del espectáculo
   * @param int Número de plazas del espectáculo
   * @return none
   */

  public abstract void setPlaces(int places);

  /**
   * Cambia el número de plazas libres del espectáculo
   * @param int Número de plazas libres del espectáculo
   * @return none
   */

  public abstract void setPlacesLeft(int placesLeft);

  /**
   * Cambia las fechas del espectáculo
   * @param ArrayList<LocalDate> Fechas del espectáculo
   * @return none
   */

  public abstract void setDates(ArrayList<LocalDate> dates);
}
