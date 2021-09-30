package managers;

public class UserManager {

	private static UserManager instance = null;

	private UserManager(){
		
	}
	
	public static UserManager getInstance() {
		if(instance == null) {
			instance = new UserManager();
		}
		return instance;
	}
}
