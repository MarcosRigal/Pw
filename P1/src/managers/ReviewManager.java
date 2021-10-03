package managers;

import java.util.ArrayList;
import reviews.Review;

public class ReviewManager {
	private static ReviewManager instance = null;
	
	private ArrayList<Review> reviews = new ArrayList<Review>();
	
	private ReviewManager(){
		
	}
	
	public static ReviewManager getInstance() {
		if(instance == null) {
			instance = new ReviewManager();
		}
		return instance;
	}

	/**
	 * Consulta todas las críticas disponibles
	 * @return the reviews
	 */
	public ArrayList<Review> getReviews() {
		return reviews;
	}

	/**
	 * @param reviews the reviews to set
	 */
	public void setReviews(ArrayList<Review> reviews) {
		this.reviews = reviews;
	}
	
	public boolean registerReview(){
		return true;
	}
	
	public boolean deleteReview(){
		return true;
	}
	
	public boolean voteReview(){
		return true;
	}
	
	public Review searchReview(){
		return null;	
	}
}
