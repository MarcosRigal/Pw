package programs;

import java.io.IOException;
import java.text.ParseException;
import managers.UserManager;
import storage.FileStorage;
import storage.IRepository;
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

  public static void main(String[] args) throws IOException, ParseException {
    IRepository entityRepository = new FileStorage();
    UserManager userManager = UserManager.getInstance();

    entityRepository.loadSystem();

    int choice;

    choice = SystemFunctions.printE1LoginScreen();

    while (choice != 0) {
      if (choice == 1) {
        SystemFunctions.registerUser("Spectator");
      }

      if (choice == 2) {
        if (SystemFunctions.loginUser()) {
          if (userManager.getActiveUser().getType().equals("Spectator")) {
            choice = SystemFunctions.printE1SpectatorMenuScreen();
            while (choice != 0) {
              if (choice == 1) {
                SystemFunctions.registerReviewE1();
              }
              if (choice == 2) {
                SystemFunctions.showReviewsE1();
              }
              if (choice == 3) {
                if (SystemFunctions.deleteReview()) {
                  System.out.println("Borrado correcto");
                } else {
                  System.out.println("Error en el borrado");
                }
              }
              if (choice == 4) {
                if (SystemFunctions.voteReview()) {
                  System.out.println("Valoración correcta");
                } else {
                  System.out.println("Error en la valoración");
                }
              }
              if (choice == 5) {
                SystemFunctions.searchUsersReview();
              }
              choice = SystemFunctions.printE1SpectatorMenuScreen();
            }
          }
          if (userManager.getActiveUser().getType().equals("Admin")) {
            choice = SystemFunctions.printE1AdminMenuScreen();
            while (choice != 0) {
              if (choice == 1) {
                choice = SystemFunctions.printE1SpectatorMenuScreen();
                while (choice != 0) {
                  if (choice == 1) {
                    SystemFunctions.registerReviewE1();
                  }
                  if (choice == 2) {
                    SystemFunctions.showReviewsE1();
                  }
                  if (choice == 3) {
                    if (SystemFunctions.deleteReview()) {
                      System.out.println("Borrado correcto");
                    } else {
                      System.out.println("Error en el borrado");
                    }
                  }
                  if (choice == 4) {
                    if (SystemFunctions.voteReview()) {
                      System.out.println("Valoración correcta");
                    } else {
                      System.out.println("Error en la valoración");
                    }
                  }
                  if (choice == 5) {
                    SystemFunctions.searchUsersReview();
                  }
                  choice = SystemFunctions.printE1SpectatorMenuScreen();
                }
              }
              if (choice == 2) {
                choice = SystemFunctions.printE1AdminUsersScreen();
                while (choice != 0) {
                  if (choice == 1) {
                    SystemFunctions.registerAdmin();
                  }
                  if (choice == 2) {
                    if (SystemFunctions.deleteUser()) {
                      System.out.println("Borrado correcto");
                    } else {
                      System.out.println("Error en el borrado");
                    }
                  }
                  if (choice == 3) {
                    SystemFunctions.searchUser();
                  }
                  if (choice == 4) {
                    SystemFunctions.modifyUser();
                  }
                  choice = SystemFunctions.printE1AdminUsersScreen();
                }
              }
              choice = SystemFunctions.printE1AdminMenuScreen();
            }
          }
        } else {
          System.out.println("Error de autentificación");
        }
      }
      choice = SystemFunctions.printE1LoginScreen();
    }
    entityRepository.saveSystem();
    SystemFunctions.printE1ExitScreen();
  }
}
