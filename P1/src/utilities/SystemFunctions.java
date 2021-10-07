package utilities;

import factories.UserFactory;
import java.util.ArrayList;
import java.util.Scanner;
import managers.ReviewManager;
import managers.UserManager;
import reviews.Review;
import users.User;

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

  public static int printE1SpectatorMenuScreen() {
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
    System.out.println(" - Pulse 0 para salir");
    System.out.print("Escoja una opción y pulse enter: ");
    return scanner.nextInt();
  }

  public static int printE1AdminMenuScreen() {
    scanner = new Scanner(System.in);
    UserManager userManager = UserManager.getInstance();
    System.out.println("Bienvenido " + userManager.getActiveUser().getName());
    System.out.println("¿Qué desea hacer?");
    System.out.println(" - Pulse 1 para acceder a la gestión de críticas");
    System.out.println(" - Pulse 2 para acceder a la gestión de usuarios");
    System.out.print("Escoja una opción y pulse enter: ");
    return scanner.nextInt();
  }

  public static int printE1AdminUsersScreen() {
    scanner = new Scanner(System.in);
    UserManager userManager = UserManager.getInstance();
    System.out.println("Bienvenido " + userManager.getActiveUser().getName());
    System.out.println("¿Qué desea hacer?");
    System.out.println(" - Pulse 1 para dar de alta un usuario");
    System.out.println(" - Pulse 2 para dar de baja un usuario");
    System.out.println(" - Pulse 3 para consultar los datos de un usuario");
    System.out.println(" - Pulse 4 para actualizar los datos de un usuario");
    System.out.println(" - Pulse 0 para salir");
    System.out.print("Escoja una opción y pulse enter: ");
    return scanner.nextInt();
  }

  public static void printE1ExitScreen() {
    System.out.println("Apagando el sistema, por favor espere...");
  }

  public static Boolean loginUser() {
    UserManager userManager = UserManager.getInstance();
    ArrayList<User> users = userManager.getUsers();
    scanner = new Scanner(System.in);

    System.out.print(" - Email: ");
    String email = scanner.nextLine();

    System.out.print(" - Contraseña: ");
    String password = scanner.nextLine();

    for (int i = 0; i < users.size(); i++) {
      if (
        (users.get(i).getEmail().equals(email)) &&
        (users.get(i).getPassword().equals(password))
      ) {
        userManager.setActiveUser(users.get(i));
        return true;
      }
    }
    return false;
  }

  public static Boolean registerUser(String type) {
    User user = UserFactory.getUser(type);
    scanner = new Scanner(System.in);
    UserManager userManager = UserManager.getInstance();

    user.setUserId(userManager.getUserId());
    userManager.setUserId(userManager.getUserId() + 1);
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

    userManager.addUser(user);
    return true;
  }

  public static Boolean registerAdmin() {
    System.out.println("¿Qué tipo de usuario desea crear?");
    System.out.println(" - Pulse 1 para crear un espectador");
    System.out.println(" - Pulse 2 para crear un administrador");
    System.out.println(" - Pulse 0 para cancelar");
    System.out.print("Escoja una opción y pulse enter: ");
    int choice = scanner.nextInt();
    while (choice < 0 || choice > 2) {
      System.out.print(" - Error escoja una opción valida: ");
      choice = scanner.nextInt();
    }

    if (choice != 0) {
      if (choice == 1) {
        return SystemFunctions.registerUser("Spectator");
      }
      if (choice == 2) {
        return SystemFunctions.registerUser("Admin");
      }
    }
    return false;
  }

  public static Boolean deleteUser() {
    scanner = new Scanner(System.in);
    UserManager userManager = UserManager.getInstance();

    SystemFunctions.listUsers();
    System.out.print(
      "Introduzca el identificador del usuario que desea borrar: "
    );
    int deleteUserId = scanner.nextInt();
    return userManager.deleteUser(deleteUserId);
  }

  private static void listUsers() {
    UserManager userManager = UserManager.getInstance();

    ArrayList<User> users = userManager.getUsers();
    System.out.println("UserId | Email ");
    System.out.println("------------------");
    for (int i = 0; i < users.size(); i++) {
      System.out.println(
        "   " + users.get(i).getUserId() + "  | " + users.get(i).getEmail()
      );
    }
  }

  public static void searchUser() {
    SystemFunctions.listUsers();
    System.out.print(
      "Introduzca el identificador del usuario que desea ver la información"
    );
    int userReviewId = scanner.nextInt();
    UserManager userManager = UserManager.getInstance();

    User user = userManager.findUser(userReviewId);

    System.out.println("------------------");
    System.out.println(" - UserId: " + user.getUserId());
    System.out.println(" - Nombre: " + user.getName());
    System.out.println(" - Apellidos: " + user.getSurname());
    System.out.println(" - Tipo: " + user.getType());
    System.out.println(" - Nick: " + user.getNick());
    System.out.println(" - Email: " + user.getEmail());
    System.out.println("------------------");
  }

  public static Boolean modifyUser() {
    scanner = new Scanner(System.in);
    UserManager userManager = UserManager.getInstance();

    int userId;

    SystemFunctions.listUsers();

    System.out.println(
      "Introduzca el identificador del usuario que desea modificar: "
    );
    userId = scanner.nextInt();

    User user = userManager.findUser(userId);

    if (user != null) {
      System.out.println("Introduzca los siguientes datos: ");
      user.setName(scanner.nextLine());
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

      return userManager.modifyUser(user);
    }

    return false;
  }

  public static boolean registerReviewE1() {
    Review review = new Review();
    scanner = new Scanner(System.in);

    ReviewManager reviewManager = ReviewManager.getInstance();
    UserManager userManager = UserManager.getInstance();

    review.setReviewId(reviewManager.getReviewId());
    reviewManager.setReviewId(reviewManager.getReviewId() + 1);
    review.setUserId(userManager.getActiveUser().getUserId());
    review.setSpectacleId(-1);
    System.out.println("Introduzca los siguientes datos: ");
    System.out.print(" - Título: ");
    review.setTitle(scanner.nextLine());
    System.out.print(" - Puntuación del (0-5): ");
    int score = scanner.nextInt();
    while (score < 0 || score > 5) {
      System.out.print(" - Error introduzca una puntuación del (0-5): ");
      score = scanner.nextInt();
    }
    review.setScore(score);
    scanner.nextLine();
    System.out.print(" - Review: ");
    review.setReview(scanner.nextLine());
    reviewManager.addReview(review);
    return true;
  }

  public static void listReviews() {
    ReviewManager reviewManager = ReviewManager.getInstance();
    ArrayList<Review> reviews = reviewManager.getReviews();
    for (int i = 0; i < reviews.size(); i++) {
      System.out.println("Review nº: " + i);
      System.out.println("------------------");
      System.out.println(" - ReviewId: " + reviews.get(i).getReviewId());
      System.out.println(" - AuthorId: " + reviews.get(i).getUserId());
      System.out.println(" - Título: " + reviews.get(i).getTitle());
      System.out.println(
        " - Puntuación del (0-5): " + reviews.get(i).getScore()
      );
      System.out.println(" - Review: " + reviews.get(i).getReview());
      System.out.println(" - Likes: " + reviews.get(i).getLike());
      System.out.println(" - Dislikes: " + reviews.get(i).getDislike());
      System.out.println("------------------");
    }
  }

  public static Boolean deleteReview() {
    scanner = new Scanner(System.in);
    ReviewManager reviewManager = ReviewManager.getInstance();

    SystemFunctions.listReviews();
    System.out.print(
      "Introduzca el identificador de la crítica que desea borrar: "
    );
    int deleteReviewId = scanner.nextInt();
    return reviewManager.deleteReview(deleteReviewId);
  }

  public static void searchUsersReview() {
    ReviewManager reviewManager = ReviewManager.getInstance();

    SystemFunctions.listUsers();
    System.out.print(
      "Introduzca el identificador del usuario para el que desea buscar críticas: "
    );
    int userReviewId = scanner.nextInt();

    ArrayList<Review> userReviews = reviewManager.searchUsersReview(
      userReviewId
    );
    for (int i = 0; i < userReviews.size(); i++) {
      System.out.println("Review nº: " + i);
      System.out.println("------------------");
      System.out.println(" - ReviewId: " + userReviews.get(i).getReviewId());
      System.out.println(" - AuthorId: " + userReviews.get(i).getUserId());
      System.out.println(" - Título: " + userReviews.get(i).getTitle());
      System.out.println(
        " - Puntuación del (0-5): " + userReviews.get(i).getScore()
      );
      System.out.println(" - Review: " + userReviews.get(i).getReview());
      System.out.println(" - Likes: " + userReviews.get(i).getLike());
      System.out.println(" - Dislikes: " + userReviews.get(i).getDislike());
      System.out.println("------------------");
    }
  }

  public static boolean voteReview() {
    UserManager userManager = UserManager.getInstance();
    ReviewManager reviewManager = ReviewManager.getInstance();

    ArrayList<Review> reviews = reviewManager.getReviews();

    SystemFunctions.listReviews();
    System.out.print(
      "Introduzca el identificador de la crítica que desea valorar: "
    );
    int voteReviewId = scanner.nextInt();

    System.out.println("¿Qué desea hacer?");
    System.out.println(" - Pulse 1 para dar un Like");
    System.out.println(" - Pulse 2 para dar un Dislike");
    System.out.println(" - Pulse 0 para cancelar");
    System.out.print("Escoja una opción y pulse enter: ");
    int choice = scanner.nextInt();
    while (choice < 0 || choice > 2) {
      System.out.print(" - Error escoja una opción valida: ");
      choice = scanner.nextInt();
    }

    if (choice != 0) {
      for (int i = 0; i < reviews.size(); i++) {
        if (
          (reviews.get(i).getReviewId() == voteReviewId) &&
          (
            reviews.get(i).getUserId() !=
            userManager.getActiveUser().getUserId()
          )
        ) {
          if (choice == 1) {
            reviews.get(i).like();
            return true;
          }
          if (choice == 2) {
            reviews.get(i).dislike();
            return true;
          }
        }
      }
    }
    return false;
  }
}
