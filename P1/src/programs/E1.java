package programs;

import java.io.IOException;
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
	private static Scanner scanner;

	public static void main(String[] args) throws IOException{
		
		IRepository entityRepository = new FileStorage();
		scanner = new Scanner(System.in);
		UserManager userManager = UserManager.getInstance();
		
		entityRepository.loadSystem();
		
		int choice;
		
		SystemFunctions.printE1LoginScreen();
		
		choice = scanner.nextInt();
		
		while (choice != 0) {
			if (choice == 1) {
				userManager.registerUser(SystemFunctions.registerUser("Spectator"));
			}
			
			if (choice == 2){
				String type = SystemFunctions.loginUser();
				if (type.equals("Spectator")) {
					System.out.println("Bienvenido Usuario");
				}
				if (type.equals("Admin")) {
					System.out.println("Bienvenido Administrador");
				}
				if (type.equals("none")) {
					System.out.println("Error de autentificación");
				}
			}
			SystemFunctions.printE1LoginScreen();
			choice = scanner.nextInt();
		}
		ArrayList<User> users = userManager.getUsers();
		entityRepository.saveSystem();
		SystemFunctions.printE1ExitScreen();
	
	}
}
