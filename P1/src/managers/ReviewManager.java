package managers;

public class ReviewManager {
	private static ReviewManager instance = null;

	private ReviewManager(){
		
	}
	
	public static ReviewManager getInstance() {
		if(instance == null) {
			instance = new ReviewManager();
		}
		return instance;
	}
}
