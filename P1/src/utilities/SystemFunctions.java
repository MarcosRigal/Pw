package utilities;

import factories.SpectacleFactory;
import factories.UserFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import managers.ReviewManager;
import managers.SesionManager;
import managers.SpectacleManager;
import managers.UserManager;
import reviews.Review;
import sesions.Sesion;
import spectacles.Spectacle;
import spectacles.Spectacle.category;
import users.User;

public final class SystemFunctions {

  private static Scanner scanner;

  /**
   * Constructor que lanza una excepción ya que esta clase no se puede instanciar
   * @param none
   */

  public SystemFunctions() {
    throw new UnsupportedOperationException();
  }

  /**
   * Imprime el menú de incio
   * @param none
   * @return int Elección del usuario
   */

  public static int printE1LoginScreen() {
	SystemFunctions.clearConsole();
    scanner = new Scanner(System.in);
    System.out.println("Bienvenido, al Gestor de Críticas");
    System.out.println(" - Pulse 1 para registrarse");
    System.out.println(" - Pulse 2 para iniciar sesión");
    System.out.println(" - Pulse 0 para salir");
    System.out.print("Escoja una opción y pulse enter: ");
    return scanner.nextInt();
  }

  /**
   * Imprime el menú del espectador
   * @param none
   * @return int Elección del usuario
   */

  public static int printE1SpectatorMenuScreen() {
	SystemFunctions.clearConsole();
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

  /**
   * Imprime el menú del espectador
   * @param none
   * @return int Elección del usuario
   */

  public static int printE2SpectatorMenuScreen() {
		SystemFunctions.clearConsole();
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
    System.out.println(" - Pulse 6 para ver los espectáculos");
    System.out.println(
      " - Pulse 7 para consultar las críticas de un espectáculo, dado su título"
    );
    System.out.println(" - Pulse 0 para salir");
    System.out.print("Escoja una opción y pulse enter: ");
    return scanner.nextInt();
  }  /**
   * Imprime el menú del espectador
   * @param none
   * @return int Elección del usuario
   */

  public static int printE2SpectatorFullMenuScreen() {
		SystemFunctions.clearConsole();
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
    System.out.println(" - Pulse 6 para ver los espectáculos");
    System.out.println(
      " - Pulse 7 para consultar las críticas de un espectáculo, dado su título"
    );
    System.out.println(
    	      " - Pulse 8 para contabilizar la venta de entradas para una sesión de un espectáculo"
    	    );
    	    System.out.println(
    	      " - Pulse 9 consultar las localidades disponibles para un espectáculo, dada una fecha de representación"
    	    );
    	    System.out.println(
    	      " - Pulse 10 para buscar espectáculos por título o por categoría"
    	    );
    	    System.out.println(
    	      " - Pulse 11 búsqueda de próximos espectáculos con entradas disponibles"
    	    );
    System.out.println(" - Pulse 0 para salir");
    System.out.print("Escoja una opción y pulse enter: ");
    return scanner.nextInt();
  }

  /**
   * Imprime el menú del administrador
   * @param none
   * @return int Elección del usuario
   */

  public static int printE1AdminMenuScreen() {
		SystemFunctions.clearConsole();
	  scanner = new Scanner(System.in);
    UserManager userManager = UserManager.getInstance();
    System.out.println("Bienvenido " + userManager.getActiveUser().getName());
    System.out.println("¿Qué desea hacer?");
    System.out.println(" - Pulse 1 para acceder a la gestión de críticas");
    System.out.println(" - Pulse 2 para acceder a la gestión de usuarios");
    System.out.println(" - Pulse 0 para salir");
    System.out.print("Escoja una opción y pulse enter: ");
    return scanner.nextInt();
  }

  /**
   * Imprime el menú del administrador
   * @param none
   * @return int Elección del usuario
   */

  public static int printE2AdminMenuScreen() {
		SystemFunctions.clearConsole();
    scanner = new Scanner(System.in);
    UserManager userManager = UserManager.getInstance();
    System.out.println("Bienvenido " + userManager.getActiveUser().getName());
    System.out.println("¿Qué desea hacer?");
    System.out.println(" - Pulse 1 para acceder a la gestión de críticas");
    System.out.println(" - Pulse 2 para acceder a la gestión de usuarios");
    System.out.println(" - Pulse 3 para acceder a la gestión de espectáculos");
    System.out.println(" - Pulse 0 para salir");
    System.out.print("Escoja una opción y pulse enter: ");
    return scanner.nextInt();
  }

  /**
   * Imprime el menú de gestión de usuarios
   * @param none
   * @return int Elección del usuario
   */

  public static int printE1AdminUsersScreen() {
		SystemFunctions.clearConsole();
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

  /**
   * Imprime el menú de gestión de espectáculos
   * @param none
   * @return int Elección del usuario
   */

  public static int printE2AdminSpectaclesScreen() {
		SystemFunctions.clearConsole();
    scanner = new Scanner(System.in);
    UserManager userManager = UserManager.getInstance();
    System.out.println("Bienvenido " + userManager.getActiveUser().getName());
    System.out.println("¿Qué desea hacer?");
    System.out.println(" - Pulse 1 para dar de alta un espectáculo");
    System.out.println(" - Pulse 2 para cancelar un espectáculo");
    System.out.println(
      " - Pulse 3 para actualizar los datos de un espectáculo"
    );
    System.out.println(
      " - Pulse 4 para contabilizar la venta de entradas para una sesión de un espectáculo"
    );
    System.out.println(
      " - Pulse 5 consultar las localidades disponibles para un espectáculo, dada una fecha de representación"
    );
    System.out.println(
      " - Pulse 6 para buscar espectáculos por título o por categoría"
    );
    System.out.println(
      " - Pulse 7 búsqueda de próximos espectáculos con entradas disponibles"
    );
    System.out.println(" - Pulse 0 para salir");
    System.out.print("Escoja una opción y pulse enter: ");
    return scanner.nextInt();
  }

  /**
   * Imprime la salida del sistema
   * @param none
   * @return none
   */

  public static void printE1ExitScreen() {
    System.out.println("Apagando el sistema, por favor espere...");
  }

  /**
   * Imprime el menú de login
   * @param none
   * @return boolean True si se ha podido completar el login
   */

  public static Boolean loginUser() {
		SystemFunctions.clearConsole();
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

  /**
   * Imprime el menú de registro
   * @param none
   * @return boolean True si se ha podido registrar
   */

  public static Boolean registerUser(String type) {
		SystemFunctions.clearConsole();
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
    System.out.print(" - Email: ");
    user.setEmail(scanner.nextLine());
    System.out.print(" - Contraseña: ");
    user.setPassword(scanner.nextLine());

    userManager.registerUser(user);
    return true;
  }

  /**
   * Imprime el menú de registro de nuevos usuarios del adminsitrador
   * @param none
   * @return boolean True si se ha podido registrar
   */

  public static Boolean registerAdmin() {
		SystemFunctions.clearConsole();
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

  /**
   * Imprime el menú de borrar un usuario
   * @param none
   * @return boolean True si se ha podido borrar
   */

  public static Boolean deleteUser() {
		SystemFunctions.clearConsole();
    scanner = new Scanner(System.in);
    UserManager userManager = UserManager.getInstance();

    SystemFunctions.listUsers();
    System.out.print(
      "Introduzca el identificador del usuario que desea borrar: "
    );
    int deleteUserId = scanner.nextInt();
    return userManager.deleteUser(deleteUserId);
  }

  /**
   * Lista los usuarios del sistema
   * @param none
   * @return none
   */

  private static void listUsers() {
		SystemFunctions.clearConsole();
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

  /**
   * Busca un usuario del sistema
   * @param none
   * @return none
   */

  public static void searchUser() {
		SystemFunctions.clearConsole();
    SystemFunctions.listUsers();
    System.out.print(
      "Introduzca el identificador del usuario que desea ver la información: "
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

  /**
   * Modifica los usuarios del sistema
   * @param none
   * @return boolean True si se ha podido modificar
   */

  public static Boolean modifyUser() {
		SystemFunctions.clearConsole();
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

  /**
   * Registra una review en el sistema
   * @param none
   * @return boolean True si se ha podido registrar
   */

  public static boolean registerReviewE1() {
		SystemFunctions.clearConsole();
    Review review = new Review();
    scanner = new Scanner(System.in);

    ReviewManager reviewManager = ReviewManager.getInstance();
    UserManager userManager = UserManager.getInstance();

    review.setReviewId(reviewManager.getReviewId());
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
    reviewManager.registerReview(review);
    return true;
  }

  /**
   * Registra una review en el sistema
   * @param none
   * @return boolean True si se ha podido registrar
   */

  public static boolean registerReviewE2() {
		SystemFunctions.clearConsole();
    Review review = new Review();
    scanner = new Scanner(System.in);

    ReviewManager reviewManager = ReviewManager.getInstance();
    UserManager userManager = UserManager.getInstance();

    SystemFunctions.listSpectacles();
    review.setReviewId(reviewManager.getReviewId());
    review.setUserId(userManager.getActiveUser().getUserId());
    System.out.println("Introduzca los siguientes datos: ");
    System.out.print(" - Identificador del espectáculo: ");
    review.setSpectacleId(scanner.nextInt());
    scanner.nextLine();
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
    reviewManager.registerReview(review);
    return true;
  }

  /**
   * Muestra las reviews del sistema
   * @param none
   * @return none
   */

  public static void showReviewsE1() {
		SystemFunctions.clearConsole();
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

  /**
   * Muestra las reviews del sistema
   * @param none
   * @return none
   */

  public static void showReviewsE2() {
		SystemFunctions.clearConsole();
    ReviewManager reviewManager = ReviewManager.getInstance();
    ArrayList<Review> reviews = reviewManager.getReviews();
    for (int i = 0; i < reviews.size(); i++) {
      System.out.println("Review nº: " + i);
      System.out.println("------------------");
      System.out.println(" - ReviewId: " + reviews.get(i).getReviewId());
      System.out.println(" - AuthorId: " + reviews.get(i).getUserId());
      System.out.println(" - SpectacleId: " + reviews.get(i).getSpectacleId());
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

  /**
   * Imprime el menú de borrar una review
   * @param none
   * @return boolean True si se ha podido borrar
   */

  public static Boolean deleteReview() {
		SystemFunctions.clearConsole();
    scanner = new Scanner(System.in);
    ReviewManager reviewManager = ReviewManager.getInstance();

    SystemFunctions.listReviews();
    System.out.print(
      "Introduzca el identificador de la crítica que desea borrar: "
    );
    int deleteReviewId = scanner.nextInt();
    return reviewManager.deleteReview(deleteReviewId);
  }

  /**
   * Imprime las reviews de un usuario en concreto
   * @param none
   * @return none
   */

  public static void searchUsersReview() {
		SystemFunctions.clearConsole();
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

  /**
   * Permite valorar una review
   * @param none
   * @return boolean True si se ha podido votar
   */

  public static boolean voteReview() {
		SystemFunctions.clearConsole();
    ReviewManager reviewManager = ReviewManager.getInstance();

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
      return reviewManager.voteReview(choice, voteReviewId);
    }
    return false;
  }

  /**
   * Imprime las reviews
   * @param none
   * @return none
   */

  public static void listReviews() {
		SystemFunctions.clearConsole();
	  ReviewManager reviewManager = ReviewManager.getInstance();

    ArrayList<Review> reviews = reviewManager.getReviews();
    System.out.println("ReviewId | Título ");
    System.out.println("------------------");
    for (int i = 0; i < reviews.size(); i++) {
      System.out.println(
        "   " +
        reviews.get(i).getReviewId() +
        "  | " +
        reviews.get(i).getTitle()
      );
    }
  }

  /**
   * Imprime los espectáculos
   * @param none
   * @return none
   */

  public static void listSpectacles() {
		SystemFunctions.clearConsole();
    SpectacleManager spectacleManager = SpectacleManager.getInstance();

    ArrayList<Spectacle> spectacles = spectacleManager.getSpectacles();
    System.out.println("SpectacleId | Título ");
    System.out.println("------------------");
    for (int i = 0; i < spectacles.size(); i++) {
      System.out.println(
        "   " +
        spectacles.get(i).getSpectacleId() +
        "  | " +
        spectacles.get(i).getTitle()
      );
    }
  }

  /**
   * Registra un nuevo espectáculo
   * @param none
   * @return boolean True si se ha podido registrar
   */

  public static Boolean registerSpectacle() throws ParseException {
		SystemFunctions.clearConsole();
    System.out.println("¿Qué tipo de espectáculo desea crear?");
    System.out.println(" - Pulse 1 para crear un espectáculo único");
    System.out.println(" - Pulse 2 para crear un espectáculo múltiple");
    System.out.println(" - Pulse 3 para crear un espectáculo de temporada");
    System.out.println(" - Pulse 0 para cancelar");
    System.out.print("Escoja una opción y pulse enter: ");
    int choice = scanner.nextInt();
    while (choice < 0 || choice > 3) {
      System.out.print(" - Error escoja una opción valida: ");
      choice = scanner.nextInt();
    }

    if (choice != 0) {
      if (choice == 1) {
        return SystemFunctions.createSingle();
      }
      if (choice == 2) {
        return SystemFunctions.createMultiple();
      }
      if (choice == 3) {
        return SystemFunctions.createSeason();
      }
    }
    return false;
  }

  /**
   * Crea un espectáculo único
   * @param none
   * @return boolean True si se ha podido registrar
   */

  private static Boolean createSingle() throws ParseException {
		SystemFunctions.clearConsole();
    Spectacle spectacle = SpectacleFactory.getSpectacle("Single");
    Sesion sesion = new Sesion();
    scanner = new Scanner(System.in);

    SpectacleManager spectacleManager = SpectacleManager.getInstance();
    SesionManager sesionManager = SesionManager.getInstance();

    spectacle.setSpectacleId(spectacleManager.getSpectacleId());
    System.out.println("Introduzca los siguientes datos: ");
    System.out.print(" - Título: ");
    spectacle.setTitle(scanner.nextLine());
    System.out.print(" - Descripción: ");
    spectacle.setDescription(scanner.nextLine());
    System.out.print(" - Aforo: ");
    int places = scanner.nextInt();
    while (places < 0) {
      System.out.print(" - Error introduzca un número > 0: ");
      places = scanner.nextInt();
    }
    spectacle.setPlaces(places);
    scanner.nextLine();
    spectacle.setCategory(SystemFunctions.choiceCategory());
    spectacleManager.registerSpectacle(spectacle);

    sesion.setSpectacleId(spectacle.getSpectacleId());
    sesion.setSesionId(sesionManager.getSesionId());
    sesion.setPlacesLeft(spectacle.getPlaces());
    scanner.nextLine();
    SimpleDateFormat formatter6 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    System.out.print(" - Fecha de la sesión (dd-MM-yyyy HH:mm): ");
    String date = scanner.nextLine();
    sesion.setDate(formatter6.parse(date));
    sesionManager.registerSesion(sesion);

    return true;
  }

  /**
   * Crea un espectáculo múltiple
   * @param none
   * @return boolean True si se ha podido registrar
   */

  private static Boolean createMultiple() throws ParseException {
		SystemFunctions.clearConsole();
    Spectacle spectacle = SpectacleFactory.getSpectacle("Multiple");
    scanner = new Scanner(System.in);

    SpectacleManager spectacleManager = SpectacleManager.getInstance();
    SesionManager sesionManager = SesionManager.getInstance();

    spectacle.setSpectacleId(spectacleManager.getSpectacleId());
    System.out.println("Introduzca los siguientes datos: ");
    System.out.print(" - Título: ");
    spectacle.setTitle(scanner.nextLine());
    System.out.print(" - Descripción: ");
    spectacle.setDescription(scanner.nextLine());
    System.out.print(" - Aforo: ");
    int places = scanner.nextInt();
    while (places < 0) {
      System.out.print(" - Error introduzca un número > 0: ");
      places = scanner.nextInt();
    }
    spectacle.setPlaces(places);
    scanner.nextLine();
    spectacle.setCategory(SystemFunctions.choiceCategory());
    spectacleManager.registerSpectacle(spectacle);

    System.out.print(" - Nº de sesiones: ");
    int nSesions = scanner.nextInt();
    while (nSesions < 0) {
      System.out.print(" - Error introduzca un número > 0: ");
      places = scanner.nextInt();
    }
    scanner.nextLine();
    for (int i = 0; i < nSesions; i++) {
      Sesion sesion = new Sesion();
      sesion.setSpectacleId(spectacle.getSpectacleId());
      sesion.setSesionId(sesionManager.getSesionId());
      sesion.setPlacesLeft(spectacle.getPlaces());
      SimpleDateFormat formatter6 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
      System.out.print(
        " - Fecha de la sesión " + (i + 1) + " (dd-MM-yyyy HH:mm): "
      );
      String date = scanner.nextLine();
      sesion.setDate(formatter6.parse(date));
      sesionManager.registerSesion(sesion);
    }

    return true;
  }

  /**
   * Crea un espectáculo de temporada
   * @param none
   * @return boolean True si se ha podido registrar
   */

  private static Boolean createSeason() throws ParseException {
		SystemFunctions.clearConsole();
    Spectacle spectacle = SpectacleFactory.getSpectacle("Season");
    scanner = new Scanner(System.in);

    SpectacleManager spectacleManager = SpectacleManager.getInstance();
    SesionManager sesionManager = SesionManager.getInstance();

    spectacle.setSpectacleId(spectacleManager.getSpectacleId());
    System.out.println("Introduzca los siguientes datos: ");
    System.out.print(" - Título: ");
    spectacle.setTitle(scanner.nextLine());
    System.out.print(" - Descripción: ");
    spectacle.setDescription(scanner.nextLine());
    System.out.print(" - Aforo: ");
    int places = scanner.nextInt();
    while (places < 0) {
      System.out.print(" - Error introduzca un número > 0: ");
      places = scanner.nextInt();
    }
    spectacle.setPlaces(places);
    scanner.nextLine();
    spectacle.setCategory(SystemFunctions.choiceCategory());
    spectacleManager.registerSpectacle(spectacle);

    System.out.print(" - Nº de sesiones: ");
    int nSesions = scanner.nextInt();
    while (nSesions < 0) {
      System.out.print(" - Error introduzca un número > 0: ");
      places = scanner.nextInt();
    }
    scanner.nextLine();
    Sesion sesion = new Sesion();
    sesion.setSpectacleId(spectacle.getSpectacleId());
    sesion.setSesionId(sesionManager.getSesionId());
    sesion.setPlacesLeft(spectacle.getPlaces());
    SimpleDateFormat formatter6 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    System.out.print(" - Fecha de la primera sesión (dd-MM-yyyy HH:mm): ");
    String date = scanner.nextLine();
    sesion.setDate(formatter6.parse(date));
    sesionManager.registerSesion(sesion);
    Calendar cal = Calendar.getInstance();
    cal.setTime(formatter6.parse(date));
    for (int i = 1; i < nSesions; i++) {
      cal.add(Calendar.DATE, 7);
      Sesion cloneSesion = new Sesion();
      cloneSesion.setSpectacleId(sesion.getSpectacleId());
      cloneSesion.setSesionId(sesionManager.getSesionId());
      cloneSesion.setPlacesLeft(sesion.getPlacesLeft());
      cloneSesion.setDate(cal.getTime());
      sesionManager.registerSesion(cloneSesion);
    }
    return true;
  }

  /**
   * Menú para que el usuario escoja una categoría
   * @param none
   * @return category Categoría elegida por el usuario
   */

  private static spectacles.Spectacle.category choiceCategory() {
		SystemFunctions.clearConsole();
    System.out.println("¿De qué categoría es el espectáculo?");
    System.out.println(" - Pulse 1 si es un concierto");
    System.out.println(" - Pulse 2 si es un monólogo");
    System.out.println(" - Pulse 3 si es una obra");
    System.out.print("Escoja una opción y pulse enter: ");
    int choice = scanner.nextInt();
    while (choice < 1 || choice > 3) {
      System.out.print(" - Error escoja una opción valida: ");
      choice = scanner.nextInt();
    }

    if (choice == 1) {
      return category.concierto;
    }

    if (choice == 2) {
      return category.monologo;
    }

    if (choice == 3) {
      return category.obra;
    }
    return null;
  }

  /**
   * Función que convierte una cadena en categoría
   * @param none
   * @return category Categoría elegida por el usuario
   */

  public static spectacles.Spectacle.category convertStringToCategory(
    String categoria
  ) {
    if (categoria.equals("obra")) {
      return category.obra;
    }
    if (categoria.equals("concierto")) {
      return category.concierto;
    }
    if (categoria.equals("monologo")) {
      return category.monologo;
    }
    return null;
  }

  /**
   * Borra un espectáculo del sistema
   * @param none
   * @return none
   */

  public static void deleteSpectacle() {
		SystemFunctions.clearConsole();
    SpectacleManager spectacleManager = SpectacleManager.getInstance();
    SesionManager sesionManager = SesionManager.getInstance();
    SystemFunctions.listSpectacles();
    System.out.print(" - Identificador del espectáculo: ");
    int spectacleId = scanner.nextInt();

    System.out.println("¿Qué desea hacer?");
    System.out.println(" - Pulse 1 para borrar todas las sesiones");
    System.out.println(" - Pulse 2 para borrar una sesión en concreto");
    System.out.print("Escoja una opción y pulse enter: ");
    int choice = scanner.nextInt();
    while (choice < 1 || choice > 2) {
      System.out.print(" - Error escoja una opción valida: ");
      choice = scanner.nextInt();
    }
    if (choice == 1) {
      spectacleManager.deleteSpectacle(spectacleId);
    }
    if (choice == 2) {
      SystemFunctions.listSpectacleSesions(spectacleId);
      System.out.print(" - Identificador de la sesión: ");
      int sesionId = scanner.nextInt();
      sesionManager.deleteSesion(sesionId);
    }
  }

  /**
   * Función que lista las sesiones de un espectáculo
   * @param int spectacleId
   * @return none
   */

  private static void listSpectacleSesions(int spectacleId) {
		SystemFunctions.clearConsole();
    SesionManager sesionManager = SesionManager.getInstance();
    SimpleDateFormat formatter6 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    ArrayList<Sesion> sesions = sesionManager.getSesions();
    System.out.println("sesionId | Hora");
    System.out.println("------------------");
    for (int i = 0; i < sesions.size(); i++) {
      if (sesions.get(i).getSpectacleId() == spectacleId) {
        System.out.println(
          "   " +
          sesions.get(i).getSesionId() +
          "  | " +
          formatter6.format(sesions.get(i).getDate())
        );
      }
    }
  }

  /**
   * Función que modifica un espectáculo del sistema
   * @param none
   * @return none
   */

  public static void modifySpectacle() {
		SystemFunctions.clearConsole();
    SpectacleManager spectacleManager = SpectacleManager.getInstance();
    SystemFunctions.listSpectacles();

    System.out.print(" - Identificador del espectáculo: ");

    int spectacleId = scanner.nextInt();
    scanner.nextLine();
    Spectacle spectacle = spectacleManager.findSpectacle(spectacleId);

    System.out.println("Introduzca los siguientes datos: ");
    System.out.print(" - Título: ");
    spectacle.setTitle(scanner.nextLine());
    System.out.print(" - Descripción: ");
    spectacle.setDescription(scanner.nextLine());
    spectacle.setCategory(SystemFunctions.choiceCategory());
    spectacleManager.modifySpectacle(spectacle);
  }

  /**
   * Función que muestra las plazas que faltan para una sesión
   * @param none
   * @return none
   */

  public static void sesionPlacesLeft() {
		SystemFunctions.clearConsole();
	  SesionManager sesionManager = SesionManager.getInstance();
    SystemFunctions.listSpectacles();
    System.out.print(" - Identificador del espectáculo: ");
    int spectacleId = scanner.nextInt();

    SystemFunctions.listSpectacleSesions(spectacleId);
    System.out.print(" - Identificador de la sesión: ");
    int sesionId = scanner.nextInt();
    System.out.println(
      " - Quedan : " +
      sesionManager.findSesion(sesionId).getPlacesLeft() +
      " plazas libres para esta sesión"
    );
  }

  /**
   * Función que muestra las plazas que faltan para una sesión según su fecha
   * @param none
   * @return none
   */

  public static void sesionPlacesLeftByDate() throws ParseException {
		SystemFunctions.clearConsole();
    SesionManager sesionManager = SesionManager.getInstance();
    SystemFunctions.listSpectacles();
    System.out.print(" - Identificador del espectáculo: ");
    int spectacleId = scanner.nextInt();

    SystemFunctions.listSpectacleSesions(spectacleId);
    scanner.nextLine();
    SimpleDateFormat formatter6 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    System.out.print(" - Fecha de la sesión (dd-MM-yyyy HH:mm): ");
    String date = scanner.nextLine();

    int placesLeft = sesionManager.numberOfPlacesOfSpectacleByDay(
      spectacleId,
      formatter6.parse(date)
    );

    if (placesLeft > 0) {
      System.out.println(" - Quedan : " + placesLeft + " plazas libres");
    } else {
      System.out.println(" - No quedan plazas libres para esa fecha");
    }
  }

  /**
   * Función que muestra los espectáculos con plazas libres
   * @param none
   * @return none
   */

  public static void spectaclesWithFreePlaces() {
		SystemFunctions.clearConsole();
    SpectacleManager spectacleManager = SpectacleManager.getInstance();
    SesionManager sesionManager = SesionManager.getInstance();
    ArrayList<Spectacle> spectacles = spectacleManager.getSpectacles();
    System.out.println("Título | Fecha");
    System.out.println("------------------");
    SimpleDateFormat formatter6 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    for (int i = 0; i < spectacles.size(); i++) {
      ArrayList<Sesion> sesions = sesionManager.searchSpectacleSesions(
        spectacles.get(i).getSpectacleId()
      );
      for (int j = 0; j < sesions.size(); j++) {
        if (sesions.get(j).getPlacesLeft() > 0) {
          System.out.println(
            " " +
            spectacles.get(i).getTitle() +
            "  | " +
            formatter6.format(sesions.get(j).getDate())
          );
        }
      }
    }
  }

  /**
   * Función que busca un espectáculo
   * @param none
   * @return none
   */

  public static void searchSpectacles() {
		SystemFunctions.clearConsole();
	  SpectacleManager spectacleManager = SpectacleManager.getInstance();
    System.out.println("¿Qué desea hacer?");
    System.out.println(" - Pulse 1 para buscar por título");
    System.out.println(" - Pulse 2 para buscar por categoría");
    System.out.print("Escoja una opción y pulse enter: ");
    int choice = scanner.nextInt();
    while (choice < 1 || choice > 2) {
      System.out.print(" - Error escoja una opción valida: ");
      choice = scanner.nextInt();
    }
    scanner.nextLine();
    if (choice == 1) {
      System.out.print(" - Título: ");
      String title = scanner.nextLine();
      ArrayList<Spectacle> spectacles = spectacleManager.searchByTitle(title);
      System.out.println("SpectacleId | Título ");
      System.out.println("------------------");
      for (int i = 0; i < spectacles.size(); i++) {
        System.out.println(
          "   " +
          spectacles.get(i).getSpectacleId() +
          "  | " +
          spectacles.get(i).getTitle()
        );
      }
    }
    if (choice == 2) {
      ArrayList<Spectacle> spectacles = spectacleManager.searchByCategory(
        SystemFunctions.choiceCategory()
      );
      System.out.println("SpectacleId | Título ");
      System.out.println("------------------");
      for (int i = 0; i < spectacles.size(); i++) {
        System.out.println(
          "   " +
          spectacles.get(i).getSpectacleId() +
          "  | " +
          spectacles.get(i).getTitle()
        );
      }
    }
  }

  /**
   * Función que busca una review según el titulo del espectáculo
   * @param none
   * @return none
   */

  public static void searchReviewBySpectacleTitle() {
		SystemFunctions.clearConsole();
    SpectacleManager spectacleManager = SpectacleManager.getInstance();
    ReviewManager reviewManager = ReviewManager.getInstance();
    scanner.nextLine();
    System.out.print(" - Título: ");
    String title = scanner.nextLine();
    ArrayList<Spectacle> spectacles = spectacleManager.searchByTitle(title);
    for (int i = 0; i < spectacles.size(); i++) {
      ArrayList<Review> reviews = reviewManager.searchSpectaclesReview(
        spectacles.get(i).getSpectacleId()
      );
      for (int j = 0; j < reviews.size(); j++) {
        System.out.println("Review nº: " + i);
        System.out.println("------------------");
        System.out.println(" - ReviewId: " + reviews.get(i).getReviewId());
        System.out.println(" - AuthorId: " + reviews.get(i).getUserId());
        System.out.println(
          " - SpectacleId: " + reviews.get(i).getSpectacleId()
        );
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
  }
  
  /**
   * Función que limpia la pantalla
   * @param none
   * @return none
   */
  
  public final static void clearConsole()
  {
      try
      {
          final String os = System.getProperty("os.name");

          if (os.contains("Windows"))
          {
              Runtime.getRuntime().exec("cls");
          }
          else
          {
              Runtime.getRuntime().exec("clear");
          }
      }
      catch (final Exception e)
      {
          //  Handle any exceptions.
      }
  }
}
