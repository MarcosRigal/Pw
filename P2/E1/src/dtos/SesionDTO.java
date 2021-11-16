package dtos;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase que representa las sesiones de los diferentes espectáculos
 * @author Antonio Moruno Gracia
 * @author David Pérez Dueñas
 * @author Marcos Rivera Gavilán
 * @version 1.0
 */

public class SesionDTO {

  private int spectacleId;
  private int sesionId;
  private int placesLeft;
  private Date date;

  /**
   * Constructor de la clase
   * @param int Identificador del espectáculo
   * @param int Identificador de la sesión
   * @param int Plazas restantes
   * @param Date Fecha de la sesión
   */

  public SesionDTO(int spectacleId, int sesionId, int placesLeft, Date date) {
    this.spectacleId = spectacleId;
    this.sesionId = sesionId;
    this.placesLeft = placesLeft;
    this.date = date;
  }

  /**
   * Devuelve el identificador del espectaculo
   * @param none
   * @return int identificador del espectáculo
   */

  public int getSpectacleId() {
    return spectacleId;
  }

  /**
   * Devuelve las plazas libres de la sesión
   * @param none
   * @return int plazas libres de la sesión
   */

  public int getPlacesLeft() {
    return placesLeft;
  }

  /**
   * Devuelve la fecha de la sesión
   * @param none
   * @return Date fecha del espectáculo
   */

  public Date getDate() {
    return date;
  }

  /**
   * Devuelve el identificador de la sesión
   * @param none
   * @return int identificador de la sesión
   */

  public int getSesionId() {
    return sesionId;
  }

  /**
   * Modifica la fecha de la sesión
   * @param Date nueva fecha
   * @return none
   */

  public void setDate(Date date) {
    this.date = date;
  }

  /**
   * Modifica el numero de plazas la sesión
   * @param Date nueva fecha
   * @return none
   */

  public void setPlacesLeft(int placesLeft) {
    this.placesLeft = placesLeft;
  }

  /**
   * Modifica el identificador del espectáculo
   * @param int Nuevo identificador
   * @return none
   */

  public void setSpectacleId(int spectacleId) {
    this.spectacleId = spectacleId;
  }

  /**
   * Modifica el identificador de la sesión
   * @param int nuevo identificador
   * @return none
   */

  public void setSesionId(int sesionId) {
    this.sesionId = sesionId;
  }

  /**
   * Serializa una sesión
   * @param none
   * @return String sesión serialziada
   */

  public String toString() {
    SimpleDateFormat formatter6 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    String sesionInfo =
      "SesionId: " +
      this.sesionId +
      "SpectacleId: " +
      this.spectacleId +
      " PlacesLeft: " +
      this.placesLeft +
      " Date: " +
      formatter6.format(this.date);
    return sesionInfo;
  }
}
