package managers;

import java.util.ArrayList;

import users.User;

public class UserManager {

	private static UserManager instance = null;

	private ArrayList<User> users = new ArrayList<User>();
	
	private UserManager(){
		
	}
	
	public static UserManager getInstance() {
		if(instance == null) {
			instance = new UserManager();
		}
		return instance;
	}

	/**
	 * @return the users
	 */
	public ArrayList<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
	public boolean registerUser(){
		return true;
	}
	
	public boolean deleteUser(){
		return true;
	}
	
	public boolean modifyUser(){
		return true;
	}
	
	public User searchUser(){
		return null;	
	}
}
