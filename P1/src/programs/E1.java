package programs;

import java.io.IOException;
import managers.ReviewManager;
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

  public static void main(String[] args) throws IOException {
    IRepository entityRepository = new FileStorage();
    UserManager userManager = UserManager.getInstance();
    ReviewManager reviewManager = ReviewManager.getInstance();

    entityRepository.loadSystem();

    int choice;

    choice = SystemFunctions.printE1LoginScreen();

    while (choice != 0) {
      if (choice == 1) {
        userManager.registerUser("Spectator");
      }

      if (choice == 2) {
        if (userManager.loginUser()) {
          choice = SystemFunctions.printE1MenuScreen();
          while (choice != 0) {
            if (choice == 1) {
              reviewManager.registerReviewE1();
            }
            if (choice == 2) {
              reviewManager.listReviews();
            }
            if (choice == 3) {
            	reviewManager.deleteReview();
            	
            }
            if (choice == 4) {}
            if (choice == 5) {}
            choice = SystemFunctions.printE1MenuScreen();
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
