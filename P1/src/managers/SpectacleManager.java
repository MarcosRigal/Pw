package managers;

public class SpectacleManager {
	private static SpectacleManager instance = null;

	private SpectacleManager(){
		
	}
	
	public static SpectacleManager getInstance() {
		if(instance == null) {
			instance = new SpectacleManager();
		}
		return instance;
	}
}
