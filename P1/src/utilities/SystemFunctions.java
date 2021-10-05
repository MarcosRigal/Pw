package utilities;

import java.util.Scanner;
import managers.UserManager;

public final class SystemFunctions {

  private static Scanner scanner;

  public SystemFunctions() {
    throw new UnsupportedOperationException();
  }

  public static int printE1LoginScreen() {
    scanner = new Scanner(System.in);
    System.out.println("Bienvenido, al Gestor de Críticas");
    System.out.println(" - Pulse 1 para registrarse");
    System.out.println(" - Pulse 2 para iniciar sesión");
    System.out.println(" - Pulse 0 para salir");
    System.out.print("Escoja una opción y pulse enter: ");
    return scanner.nextInt();
  }

  public static int printE1MenuScreen() {
    scanner = new Scanner(System.in);
    UserManager userManager = UserManager.getInstance();
    System.out.println("Bienvenido " + userManager.getActiveUser().getName());
    System.out.println("¿Qué desea hacer?");
    System.out.println(" - Pulse 1 para crear una crítica");
    System.out.println(
      " - Pulse 2 para consultar todas las críticas disponibles"
    );
    System.out.println(" - Pulse 3 para borrar una crítica");
    System.out.println(" - Pulse 4 para valorar una crítica");
    System.out.println(" - Pulse 5 para buscar las críticas de un usuario");
    System.out.println(" - Pulse 0 para cerrar sesión");
    System.out.print("Escoja una opción y pulse enter: ");
    return scanner.nextInt();
  }

  public static void printE1ExitScreen() {
    System.out.println("Apagando el sistema, por favor espere...");
  }
}
