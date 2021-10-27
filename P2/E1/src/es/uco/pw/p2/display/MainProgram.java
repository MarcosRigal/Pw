package es.uco.pw.p2.display;

import es.uco.pw.p2.business.UserManager;

/**
 * Main program to illustrate JDBC usage
 * @author Aurora Ramirez
 * @author Jose Raul Romero
 * */

public class MainProgram {

	public static void main(String[] args) {
		
		System.out.println("Main program: find users between 18 and 35 year-old.");
		UserManager userManager = new UserManager();
		String usersInfo = userManager.findAdultUsersBelowAge(35);
		System.out.println(usersInfo);
	}
}
