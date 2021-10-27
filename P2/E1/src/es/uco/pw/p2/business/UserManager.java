package es.uco.pw.p2.business;

import java.util.ArrayList;

import es.uco.pw.p2.data.dao.UserDAO;

/**
 * A user manager that communicates with DAO and uses DTO to implement functionalities related to users.
 * @author Aurora Ramirez
 * @author Jose Raul Romero
 * */

public class UserManager {
	
	public UserManager() {

	}
	
	public String findAdultUsersBelowAge(int age){
		
		UserDAO userByAge = new UserDAO();
		String usersInfo = "";
		ArrayList<UserDTO> users = userByAge.requestUsersByAge(35);
		for (UserDTO u: users) {
			usersInfo += u.toString() + "\n";
		}
		return usersInfo;
	}
	
	
	// Other methods to manage users...
}
