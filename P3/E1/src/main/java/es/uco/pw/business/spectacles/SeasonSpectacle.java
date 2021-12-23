package es.uco.pw.business.spectacles;

/**
 * Clase que representa los espectáculos de temporada
 * @author Antonio Moruno Gracia
 * @author David Pérez Dueñas
 * @author Marcos Rivera Gavilán
 * @version 1.0
 */

public class SeasonSpectacle extends Spectacle {

  private int spectacleId;
  private String title;
  private String description;
  private category category;
  private int places;

  /**
   * Constructor de la clase season spectacle
   * @param none
   */

  public SeasonSpectacle() {}

  /**
   * Devuelve el identificador del espectáculo
   * @param none
   * @return int Identificador del espectáculo
   */

  @Override
  public int getSpectacleId() {
    return spectacleId;
  }

  /**
   * Devuelve el título del espectáculo
   * @param none
   * @return String Título del espectáculo
   */

  @Override
  public String getTitle() {
    return title;
  }

  /**
   * Devuelve la descripción del espectáculo
   * @param none
   * @return String Descripción del espectáculo
   */

  @Override
  public String getDescription() {
    return description;
  }

  /**
   * Devuelve la categoría del espectáculo
   * @param none
   * @return category Categoría del espectáculo
   */

  @Override
  public Spectacle.category getCategory() {
    return category;
  }

  /**
   * Devuelve el número de plazas del espectáculo
   * @param none
   * @return int Numero de plazas del espectáculo
   */

  @Override
  public int getPlaces() {
    return places;
  }

  /**
   * Devuelve el tipo de espectáculo
   * @param none
   * @return String Tipo de espectáculo
   */

  @Override
  public String getType() {
    return "Season";
  }

  /**
   * Cambia el identificador del espectáculo
   * @param int Identificador del espectáculo
   * @return none
   */

  @Override
  public void setSpectacleId(int spectacleId) {
    this.spectacleId = spectacleId;
  }

  /**
   * Cambia el título del espectáculo
   * @param int Título del espectáculo
   * @return none
   */

  @Override
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Cambia la descripción del espectáculo
   * @param String Descripición del espectáculo
   * @return none
   */

  @Override
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Cambia la categoría del espectáculo
   * @param category Tipo del espectáculo
   * @return none
   */

  @Override
  public void setCategory(Spectacle.category category) {
    this.category = category;
  }

  /**
   * Cambia el número de plazas del espectáculo
   * @param int Número de plazas del espectáculo
   * @return none
   */

  @Override
  public void setPlaces(int places) {
    this.places = places;
  }
}
