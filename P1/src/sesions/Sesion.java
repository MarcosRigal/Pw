package sesions;

import java.util.Date;

/**
 * Clase que representa las sesiones de los diferentes espectáculos
 * @author Antonio Moruno Gracia
 * @author David Pérez Dueñas
 * @author Marcos Rivera Gavilán
 * @version 1.0
 */

public class Sesion {

  private int spectacleId;
  private int sesionId;
  private int placesLeft;
  private Date date;

  public Sesion() {}

  public int getSpectacleId() {
    return spectacleId;
  }

  public int getPlacesLeft() {
    return placesLeft;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public void setPlacesLeft(int placesLeft) {
    this.placesLeft = placesLeft;
  }

  public void setSpectacleId(int spectacleId) {
    this.spectacleId = spectacleId;
  }

  public int getSesionId() {
    return sesionId;
  }

  public void setSesionId(int sesionId) {
    this.sesionId = sesionId;
  }
}
