package es.uco.pw.business.spectacles;

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
}
