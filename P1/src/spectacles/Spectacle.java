package spectacles;

import java.time.LocalDate;
import java.util.ArrayList;

//Clase de la que heredan el resto de espectaculos.

public abstract class Spectacle {
	
	public enum category{
		concierto, monologo, obra;
	}
	
	//Observadores que deben implementar obligatoriamente los espectáculos
	
	public abstract int getSpectacleId();
	public abstract String getTitle();
	public abstract String getDescription();
	public abstract category getCategory();
	public abstract int getPlaces();
	public abstract int getPlacesLeft();
	public abstract ArrayList<LocalDate> getDates();
	
	public abstract String getType();
	
	//Modificadores que deben implementar obligatoriamente los espectaculos
	
	public abstract void setSpectacleId(int spectacleId);
	public abstract void setTitle(String title);
	public abstract void setDescription(String description);
	public abstract void setCategory(category category);
	public abstract void setPlaces(int places);
	public abstract void setPlacesLeft(int placesLeft);
	public abstract void setDates(ArrayList<LocalDate> dates); 
}
