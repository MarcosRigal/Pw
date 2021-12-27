package es.uco.pw.display.javabean;

import es.uco.pw.business.spectacles.Spectacle;

/**
 * Clase que representa al javaBean necesario
 * para poder crear espectáculos en el sistema.
 * @author Antonio Moruno Gracia
 * @author David Pérez Dueñas
 * @author Marcos Rivera Gavilán
 * @version 1.0
 */

public class SpectacleBean implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  private String title = "";
  private String description = "";  
  private int places = 0;
  private Spectacle.category category;
  private int numberOfSesions = 0;
  
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getPlaces() {
	return places;
}
public void setPlaces(int places) {
	this.places = places;
}
public Spectacle.category getCategory() {
	return category;
}
public void setCategory(Spectacle.category category) {
	this.category = category;
}
public int getNumberOfSesions() {
	return numberOfSesions;
}
public void setNumberOfSesions(int numberOfSesions) {
	this.numberOfSesions = numberOfSesions;
}
}
