package programs;

import java.util.ArrayList;
import java.util.Scanner;

import managers.UserManager;
import storage.FileStorage;
import storage.IRepository;
import users.User;
import utilities.SystemFunctions;

/**
 * Programa principal del ejercicio 1
 * de la práctica 1
 * @author Antonio Moruno Gracia
 * @author David Pérez Dueñas
 * @author Marcos Rivera Gavilán
 * @version 1.0
 */


public class E1 {
	public static void main(String[] args){
		
		IRepository entityRepository = new FileStorage();
		Scanner scanner = new Scanner(System.in);
		UserManager userManager = UserManager.getInstance();
		
		int choice;
		String input;

		SystemFunctions.printE1WelcomeScreen();
		
		input = scanner.nextLine();  
		
		SystemFunctions.printE1LoginScreen();
		
		choice = scanner.nextInt();
		
		if (choice == 1) {
			userManager.registerUser(SystemFunctions.registerUser("Spectator"));
			ArrayList<User> users = userManager.getUsers();
			System.out.println(users.get(0).getUserId());
			System.out.println(users.get(0).getName());
			System.out.println(users.get(0).getSurname());
			System.out.println(users.get(0).getNick());
			System.out.println(users.get(0).getEmail());
		}
		
		if (choice == 2){
			SystemFunctions.printE1WelcomeScreen();
		}
		
		SystemFunctions.printE1ExitScreen();
	
	}
}
