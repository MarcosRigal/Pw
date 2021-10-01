package reviews;

import java.util.ArrayList;
// Esta clase implementa las Reviews

public class Review {

	private int reviewId; //Identificador de la critica debe ser único
	private int userId; //Identificador del usuario que ha hecho la crítica
	private int spectacleId; //Identificador del espectáculo que recibe la crítica
	private String title; //Titulo de la critica
	private int score; //Puntuación otorgada al espectáculo por el usuario
	private String review; //Cuerpo de la crítica
	private ArrayList<Boolean> usersOpinions; //Vector que almacena las valoraciones que los usuarios han hecho de la crítica True=util False=inutil
	
	public Review() {
		// TODO Auto-generated constructor stub
	}
	
	public int getReviewId() {
		return reviewId;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public int getSpectacleId() {
		return spectacleId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getScore() {
		return score;
	}
	
	public String getReview() {
		return review;
	}
	
	public ArrayList<Boolean> getUsersOpinions() {
		return usersOpinions;
	}
	
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public void setSpectacleId(int spectacleId) {
		this.spectacleId = spectacleId;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public void setReview(String review) {
		this.review = review;
	}
	
	public void setUsersOpinions(ArrayList<Boolean> usersOpinions) {
		this.usersOpinions = usersOpinions;
	}
}
