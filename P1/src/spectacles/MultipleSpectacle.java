package spectacles;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase que representa los espectáculos multiples
 * @author Antonio Moruno Gracia
 * @author David Pérez Dueñas
 * @author Marcos Rivera Gavilán
 * @version 1.0
 */

public class MultipleSpectacle extends Spectacle {

  private int spectacleId;
  private String title;
  private String description;
  private category category;
  private int places;
  private int placesLeft;
  private ArrayList<LocalDate> dates;

  /**
   * Constructor de la clase multiple spectacle
   * @param none
   */

  public MultipleSpectacle() {}

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
  public spectacles.Spectacle.category getCategory() {
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
   * Devuelve el número de plazas del espectáculo
   * @param none
   * @return int Número de plazas del espectáculo
   */

  @Override
  public int getPlacesLeft() {
    return placesLeft;
  }

  /**
   * Devuelve las fechas en las que se realiza el espectáculo
   * @param none
   * @return ArrayList<LocalDate> Vector con las fechas del espectáculo
   */

  @Override
  public ArrayList<LocalDate> getDates() {
    return dates;
  }

  /**
   * Devuelve el tipo de espectáculo
   * @param none
   * @return String Tipo de espectáculo
   */

  @Override
  public String getType() {
    return "Multiple";
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
  public void setCategory(spectacles.Spectacle.category category) {
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

  /**
   * Cambia el número de plazas libres del espectáculo
   * @param int Número de plazas libres del espectáculo
   * @return none
   */

  @Override
  public void setPlacesLeft(int placesLeft) {
    this.placesLeft = placesLeft;
  }

  /**
   * Cambia las fechas del espectáculo
   * @param ArrayList<LocalDate> Fechas del espectáculo
   * @return none
   */

  @Override
  public void setDates(ArrayList<LocalDate> dates) {
    this.dates = dates;
  }
}
