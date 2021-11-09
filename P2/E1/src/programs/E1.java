package programs;

import java.io.IOException;
import java.text.ParseException;
import managers.UserManager;
import utilities.SystemFunctions;

/**
 * Programa principal del ejercicio 2
 * de la práctica 1
 * @author Antonio Moruno Gracia
 * @author David Pérez Dueñas
 * @author Marcos Rivera Gavilán
 * @version 1.0
 */

public class E1 {

  public static void main(String[] args) throws IOException, ParseException {
    UserManager userManager = UserManager.getInstance();

    int choice;

    choice = SystemFunctions.printLoginScreen();

    while (choice != 0) {
      if (choice == 1) {
        SystemFunctions.registerUser("Spectator");
      }

      if (choice == 2) {
        if (SystemFunctions.loginUser()) {
          if (userManager.getActiveUser().getType().equals("Spectator")) {
            choice = SystemFunctions.printSpectatorMenuScreen();
            while (choice != 0) {
              if (choice == 1) {
                SystemFunctions.registerReview();
              }
              if (choice == 2) {
                SystemFunctions.showReviews();
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
              if (choice == 6) {
                SystemFunctions.listSpectacles();
              }
              if (choice == 7) {
                SystemFunctions.searchReviewBySpectacleTitle();
              }
              if (choice == 8) {
                SystemFunctions.sesionPlacesLeft();
              }
              if (choice == 9) {
                SystemFunctions.sesionPlacesLeftByDate();
              }
              if (choice == 10) {
                SystemFunctions.searchSpectacles();
              }
              if (choice == 11) {
                SystemFunctions.spectaclesWithFreePlaces();
              }
              choice = SystemFunctions.printSpectatorMenuScreen();
            }
          }
          if (userManager.getActiveUser().getType().equals("Admin")) {
            choice = SystemFunctions.printAdminMenuScreen();
            while (choice != 0) {
              if (choice == 1) {
                choice = SystemFunctions.printAdminReviewsScreen();
                while (choice != 0) {
                  if (choice == 1) {
                    SystemFunctions.registerReview();
                  }
                  if (choice == 2) {
                    SystemFunctions.showReviews();
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
                  if (choice == 6) {
                    SystemFunctions.listSpectacles();
                  }
                  if (choice == 7) {
                    SystemFunctions.searchReviewBySpectacleTitle();
                  }
                  choice = SystemFunctions.printAdminReviewsScreen();
                }
              }
              if (choice == 2) {
                choice = SystemFunctions.printAdminUsersScreen();
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
                  choice = SystemFunctions.printAdminUsersScreen();
                }
              }
              if (choice == 3) {
                choice = SystemFunctions.printAdminSpectaclesScreen();
                while (choice != 0) {
                  if (choice == 1) {
                    SystemFunctions.registerSpectacle();
                  }
                  if (choice == 2) {
                    SystemFunctions.deleteSpectacle();
                  }
                  if (choice == 3) {
                    SystemFunctions.modifySpectacle();
                  }
                  if (choice == 4) {
                    SystemFunctions.sesionPlacesLeft();
                  }
                  if (choice == 5) {
                    SystemFunctions.sesionPlacesLeftByDate();
                  }
                  if (choice == 6) {
                    SystemFunctions.searchSpectacles();
                  }
                  if (choice == 7) {
                    SystemFunctions.spectaclesWithFreePlaces();
                  }
                  choice = SystemFunctions.printAdminSpectaclesScreen();
                }
              }
              choice = SystemFunctions.printAdminMenuScreen();
            }
          }
        } else {
          System.out.println("Error de autentificación");
        }
      }
      choice = SystemFunctions.printLoginScreen();
    }
    SystemFunctions.printExitScreen();
  }
}
