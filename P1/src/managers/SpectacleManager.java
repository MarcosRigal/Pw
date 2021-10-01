package managers;

import java.time.LocalDate;
import java.util.ArrayList;

import spectacles.Spectacle;
import spectacles.Spectacle.category;

public class SpectacleManager {

	private static SpectacleManager instance = null;

	private ArrayList<Spectacle> spectacles = new ArrayList<Spectacle>();
	
	private SpectacleManager(){
		
	}
	
	public static SpectacleManager getInstance() {
		if(instance == null) {
			instance = new SpectacleManager();
		}
		return instance;
	}

	/**
	 * @return the spectacles
	 */
	public ArrayList<Spectacle> getSpectacles() {
		return spectacles;
	}

	/**
	 * @param spectacles the spectacles to set
	 */
	public void setSpectacles(ArrayList<Spectacle> spectacles) {
		this.spectacles = spectacles;
	}
	
	public boolean registerSpectacle(){
		return true;
	}
	
	public boolean modifySpectacle(){
		return true;
	}
	
	public boolean deleteSpectacle(){
		return true;
	}
	
	public int getPlacesSold(int spectacleId){
		return 0;
	}
	
	public int getPlacesLeft(LocalDate date){
		return 0;
	}
	
	public ArrayList<Spectacle> findSpectacles(String title){
		return spectacles;
	}
	
	public ArrayList<Spectacle> findSpectacles(category category){
		return spectacles;
	}
	
	public ArrayList<Spectacle> nextSpectaclesWithPlaces(){
		return spectacles;
	}

	public ArrayList<Spectacle> nextSpectaclesWithPlaces(category category){
		return spectacles;
	}
	
	public boolean registerReview(){
		return true;
	}

	public boolean viewReviews(){
		return true;
	}
	
	public boolean deleteReview(){
		return true;
	}
	
	public boolean reviewReview(){
		return true;
	}	
}
