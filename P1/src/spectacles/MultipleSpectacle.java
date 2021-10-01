package spectacles;

import java.time.LocalDate;
import java.util.ArrayList;

public class MultipleSpectacle extends Spectacle{
	
	private int spectacleId; //Identificador del espectáculo debe ser único
	private String title; //Titulo del espectaculo
	private String description; //Descripción del espectaculo
	private category category; //Categoria del espectaculo
	private int places; //Aforo máximo del espectaculo
	private int placesLeft; //Plazas libres
	private ArrayList<LocalDate> dates; //Array de fechas
	
	public MultipleSpectacle() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getSpectacleId() {
		return spectacleId;
	}
	
	@Override
	public String getTitle() {
		return title;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	
	@Override
	public spectacles.Spectacle.category getCategory() {
		return category;
	}
	
	@Override
	public int getPlaces() {
		return places;
	}
	
	@Override
	public int getPlacesLeft() {
		return placesLeft;
	}
	
	@Override
	public ArrayList<LocalDate> getDates() {
		return dates;
	}
	
	@Override
	public String getType() {
		return "Multiple";
	}
	
	@Override
	public void setSpectacleId(int spectacleId) {
		this.spectacleId = spectacleId;
	}
	
	@Override
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public void setCategory(spectacles.Spectacle.category category) {
		this.category = category;
	}
	
	@Override
	public void setPlaces(int places) {
		this.places = places;
	}
	
	@Override
	public void setPlacesLeft(int placesLeft) {
		this.placesLeft = placesLeft;
	}
	
	@Override
	public void setDates(ArrayList<LocalDate> dates) {
		this.dates = dates;
	}
}
