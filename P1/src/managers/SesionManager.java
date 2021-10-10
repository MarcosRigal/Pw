package managers;

import java.util.ArrayList;
import java.util.Date;

import sesions.Sesion;

/**
 * Clase que implementa el patrón de diseño
 * singleton encargada de gestionar las Sesions
 * @author Antonio Moruno Gracia
 * @author David Pérez Dueñas
 * @author Marcos Rivera Gavilán
 * @version 1.0
 */

public class SesionManager {

	private static SesionManager instance = null;
	
	private ArrayList<Sesion> sesions = new ArrayList<Sesion>();
	
	private int sesionId;
	
	private SesionManager() {
		setSesionId(0);
	}
	
	public static SesionManager getInstance() {
	  if (instance == null) {
	    instance = new SesionManager();
	  }
	  return instance;
	}

	public ArrayList<Sesion> getSesions() {
		return sesions;
	}

	public void setSesions(ArrayList<Sesion> sesions) {
		this.sesions = sesions;
	}
	
	public void registerSesion(Sesion sesion) {
		this.sesions.add(sesion);
		setSesionId(getSesionId() + 1);
	}
	
	public void addSesion(Sesion sesion) {
		this.sesions.add(sesion);
	}

	public int getSesionId() {
		return sesionId;
	}

	public void setSesionId(int sesionId) {
		this.sesionId = sesionId;
	}

	public boolean deleteSesion(int sesionId) {
		return sesions.removeIf(
	    	      n ->
	    	        (
	    	          (n.getSesionId() == sesionId)
	    	        )
	    	    );
	}

	public boolean deleteAllSesions(int spectacleId) {
		  return sesions.removeIf(
	    	      n ->
	    	        (
	    	          (n.getSpectacleId() == spectacleId)
	    	        )
	    	    );
	}
	
	 public Sesion findSesion(int sesionId){
		    for (int i = 0; i < sesions.size(); i++) {
			      if (sesions.get(i).getSesionId() == sesionId) {
			        return sesions.get(i);
			      }
		    }
	 return null;
	 }
	 public int numberOfPlacesOfSpectacleByDay(int spectacleId, Date date){
		    for (int i = 0; i < sesions.size(); i++) {
		    	if((sesions.get(i).getSpectacleId() == spectacleId)){ 
			      if (sesions.get(i).getDate().equals(date)){
			        return sesions.get(i).getPlacesLeft();
			      }
		    	}
		    }
		 return -1;
	 }
	 
	  public ArrayList<Sesion> searchSpectacleSesions(int SpectacleId) {
		    ArrayList<Sesion> spectacleSesions = new ArrayList<Sesion>();

		    for (int i = 0; i < sesions.size(); i++) {
		      if (sesions.get(i).getSpectacleId() == SpectacleId) {
		    	  spectacleSesions.add(sesions.get(i));
		      }
		    }
		    return spectacleSesions;
		  }
	 
}
