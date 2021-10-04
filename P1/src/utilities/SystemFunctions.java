package utilities;

import java.util.Scanner;

import managers.UserManager;
import factories.UserFactory;
import users.User;

public final class SystemFunctions {
	
	private static Scanner scanner;

	public SystemFunctions() {
		throw new UnsupportedOperationException();
	}
	
	public static void printE1WelcomeScreen() {
		   System.out.println(" ___________________________________________________");
		   System.out.println("|                                                   |");
		   System.out.println("|--------------- Gestor de Críticas  ---------------|");
		   System.out.println("|___________________________________________________|");
		   System.out.println("|                                                   |");
		   System.out.println("|                                                   |");
		   System.out.println("|                                                   |");
		   System.out.println("|           Bienvenido, pulse enter para            |");
		   System.out.println("|       acceder al menú de inicio de sesión         |");
		   System.out.println("|                                                   |");
		   System.out.println("|                                                   |");
		   System.out.println("|                                                   |");
		   System.out.println("|___________________________________________________|");
	}
	
	public static void printE1LoginScreen() {
		   System.out.println(" ___________________________________________________");
		   System.out.println("|                                                   |");
		   System.out.println("|--------------- Gestor de Críticas  ---------------|");
		   System.out.println("|___________________________________________________|");
		   System.out.println("|                                                   |");
		   System.out.println("| - Escoja una opción y pulse enter:                |");
		   System.out.println("|                                                   |");
		   System.out.println("|     * Pulse 1 para registrarse                    |");
		   System.out.println("|     * Pulse 2 para iniciar sesión                 |");
		   System.out.println("|                                                   |");
		   System.out.println("|                                                   |");
		   System.out.println("|                                                   |");
		   System.out.println("|___________________________________________________|");
	}
	
	public static User registerUser(String type)
	{
		User user = UserFactory.getUser(type);
		scanner = new Scanner(System.in);
		UserManager userManager = UserManager.getInstance();
		
		user.setUserId(userManager.getUserId());
		System.out.println("Introduzca los siguientes datos: ");
		System.out.print(" - Nombre: ");
		user.setName(scanner.nextLine());  
		System.out.print(" - Apellidos: ");
		user.setSurname(scanner.nextLine());  		
		System.out.print(" - Nick: ");
		user.setNick(scanner.nextLine());
		System.out.print(" - Email:");
		user.setEmail(scanner.nextLine());
		
		return user;
	}
	
	public static User loginUser(String type)
	{
		User user = UserFactory.getUser(type);
		scanner = new Scanner(System.in);
		UserManager userManager = UserManager.getInstance();
		
		user.setUserId(userManager.getUserId());
		System.out.println("Introduzca los siguientes datos: ");
		System.out.print(" - Nombre: ");
		user.setName(scanner.nextLine());  
		System.out.print(" - Apellidos: ");
		user.setSurname(scanner.nextLine());  		
		System.out.print(" - Nick: ");
		user.setNick(scanner.nextLine());
		System.out.print(" - Email:");
		user.setEmail(scanner.nextLine());
		
		return user;
	}
	
	public static void printE1ExitScreen() {
		   System.out.println(" ___________________________________________________");
		   System.out.println("|                                                   |");
		   System.out.println("|--------------- Gestor de Críticas  ---------------|");
		   System.out.println("|___________________________________________________|");
		   System.out.println("|                                                   |");
		   System.out.println("|                                                   |");
		   System.out.println("|                                                   |");
		   System.out.println("|       Apagando el sistema, por favor espere       |");
		   System.out.println("|                                                   |");
		   System.out.println("|                                                   |");
		   System.out.println("|                                                   |");
		   System.out.println("|___________________________________________________|");
	}
}
