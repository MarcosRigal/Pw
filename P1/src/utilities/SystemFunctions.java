package utilities;

import java.util.ArrayList;
import java.util.Scanner;

import managers.UserManager;
import factories.UserFactory;
import users.User;

public final class SystemFunctions {
	
	private static Scanner scanner;

	public SystemFunctions() {
		throw new UnsupportedOperationException();
	}
	
	public static void printE1LoginScreen() {
		System.out.println("Bienvenido, al Gestor de Críticas");
		System.out.println(" - Pulse 1 para registrarse");
		System.out.println(" - Pulse 2 para iniciar sesión");
		System.out.println(" - Pulse 0 para salir");
		System.out.print("Escoja una opción y pulse enter: ");
	}
	
	public static User registerUser(String type)
	{
		User user = UserFactory.getUser(type);
		scanner = new Scanner(System.in);
		UserManager userManager = UserManager.getInstance();
		
		user.setUserId(userManager.getUserId());
		userManager.setUserId(userManager.getUserId()+1);
		System.out.println("Introduzca los siguientes datos: ");
		System.out.print(" - Nombre: ");
		user.setName(scanner.nextLine());  
		System.out.print(" - Apellidos: ");
		user.setSurname(scanner.nextLine());  		
		System.out.print(" - Nick: ");
		user.setNick(scanner.nextLine());
		System.out.print(" - Email: ");
		user.setEmail(scanner.nextLine());
		System.out.print(" - Contraseña: ");
		user.setPassword(scanner.nextLine());
		
		return user;
	}
	
	public static String loginUser()
	{
		UserManager userManager = UserManager.getInstance();
		ArrayList<User> users = userManager.getUsers();
		scanner = new Scanner(System.in);
		
		System.out.print(" - Email: ");
		String email = scanner.nextLine();
		
		System.out.print(" - Contraseña: ");
		String password = scanner.nextLine();
		
		  for (int i = 0; i < users.size(); i++) {
		      if ((users.get(i).getEmail().equals(email)) && (users.get(i).getUserPassword().equals(password))) {
		    	  return users.get(i).getType();
			}
		  }
		  return "none";
	}
	
	public static void printE1ExitScreen() {
		   System.out.println("Apagando el sistema, por favor espere...");
	}
}
