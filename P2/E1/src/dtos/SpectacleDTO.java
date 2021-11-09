package dtos;

import utilities.SystemFunctions;

/**
 * Clase que representa los espectáculos multiples
 * author Antonio Moruno Gracia
 * author David Pérez Dueñas
 * author Marcos Rivera Gavilán
 * version 1.0
 */

public class SpectacleDTO {

  private int spectacleId;
  private String title;
  private String description;
  private spectacles.Spectacle.category category;
  private int places;

  /**
   * Constructor de la clase multiple spectacle
   * param none
   * @param places2
   * @param category2
   * @param description2
   * @param type
   * @param title2
   * @param spectacleId2
   */

  public SpectacleDTO(
    int spectacleId2,
    String title2,
    String type,
    String description2,
    String category2,
    int places2
  ) {
    this.spectacleId = spectacleId2;
    this.title = title2;
    this.description = description2;
    this.category = SystemFunctions.convertStringToCategory(category2);
    this.places = places2;
  }

  /**
   * Devuelve el identificador del espectáculo
   * param none
   * return int Identificador del espectáculo
   */

  public int getSpectacleId() {
    return spectacleId;
  }

  /**
   * Devuelve el título del espectáculo
   * param none
   * return String Título del espectáculo
   */

  public String getTitle() {
    return title;
  }

  /**
   * Devuelve la descripción del espectáculo
   * param none
   * return String Descripción del espectáculo
   */

  public String getDescription() {
    return description;
  }

  /**
   * Devuelve la categoría del espectáculo
   * param none
   * return category Categoría del espectáculo
   */

  public spectacles.Spectacle.category getCategory() {
    return category;
  }

  /**
   * Devuelve el número de plazas del espectáculo
   * param none
   * return int Numero de plazas del espectáculo
   */

  public int getPlaces() {
    return places;
  }

  /**
   * Devuelve el tipo de espectáculo
   * param none
   * return String Tipo de espectáculo
   */

  public String getType() {
    return "Multiple";
  }

  /**
   * Cambia el identificador del espectáculo
   * param int Identificador del espectáculo
   * return none
   */

  public void setSpectacleId(int spectacleId) {
    this.spectacleId = spectacleId;
  }

  /**
   * Cambia el título del espectáculo
   * param int Título del espectáculo
   * return none
   */

  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Cambia la descripción del espectáculo
   * param String Descripición del espectáculo
   * return none
   */

  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Cambia la categoría del espectáculo
   * param category Tipo del espectáculo
   * return none
   */

  public void setCategory(spectacles.Spectacle.category category) {
    this.category = category;
  }

  /**
   * Cambia el número de plazas del espectáculo
   * param int Número de plazas del espectáculo
   * return none
   */

  public void setPlaces(int places) {
    this.places = places;
  }

  public String toString() {
    String spectacleInfo =
      "SpectacleId: " +
      this.spectacleId +
      " Title: " +
      this.title +
      " Description: " +
      this.description +
      " Category: " +
      this.category +
      " Places: " +
      this.places;
    return spectacleInfo;
  }
}
