package es.uco.pw.business.factories;

import es.uco.pw.business.spectacles.MultipleSpectacle;
import es.uco.pw.business.spectacles.SeasonSpectacle;
import es.uco.pw.business.spectacles.SingleSpectacle;
import es.uco.pw.business.spectacles.Spectacle;

/**
 * Clase que implementa el patrón de diseño
 * factoría para crear los espectáculos.
 * @author Antonio Moruno Gracia
 * @author David Pérez Dueñas
 * @author Marcos Rivera Gavilán
 * @version 1.0
 */

public class SpectacleFactory {

  /**
   * Método de la factoria para crear los espectáculos
   * @param string El tipo de espectáculo que se desea crear.
   * @return Spectacle Una instancia del tipo de espectáculo.
   */

  public static Spectacle getSpectacle(String type) {
    if ("Single".equalsIgnoreCase(type)) {
      return new SingleSpectacle();
    }
    if ("Multiple".equalsIgnoreCase(type)) {
      return new MultipleSpectacle();
    }
    if ("Season".equalsIgnoreCase(type)) {
      return new SeasonSpectacle();
    }
    return null;
  }
}
