package factories;

import users.Admin;
import users.Spectator;
import users.User;

public class UserFactory {
	
	public static User getUser(String type){
		if("Spectator".equalsIgnoreCase(type)){
			return new Spectator();
		}
		if("Admin".equalsIgnoreCase(type)){
			return new Admin();
		}
		return null;
	}
}
