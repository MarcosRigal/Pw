package managers;

import java.util.ArrayList;
import java.util.Scanner;

import reviews.Review;

/**
 * Clase que implementa el patrón de diseño
 * singleton encargada de gestionar las reviews
 * @author Antonio Moruno Gracia
 * @author David Pérez Dueñas
 * @author Marcos Rivera Gavilán
 * @version 1.0
 */

public class ReviewManager {

  private static ReviewManager instance = null;

  private ArrayList<Review> reviews = new ArrayList<Review>();

  private int reviewId;

  private Scanner scanner;

  /**
   * Busca y devuelve una review en concreto
   * @param int Identificador de la review que se desea buscar
   * @return Review review buscada o null si no la encuentra
   */

  private ReviewManager() {
    reviewId = 0;
  }

  /**
   * Método público encargado de devolver
   * la única instancia de la clase
   * @param none
   * @return ReviewManager Instancia de la clase
   */

  public static ReviewManager getInstance() {
    if (instance == null) {
      instance = new ReviewManager();
    }
    return instance;
  }

  /**
   * Devuelve todas las críticas disponibles
   * @return ArrayList<Review> Vector con las criticas
   */

  public ArrayList<Review> getReviews() {
    return reviews;
  }

  /**
   * Modifica la lista de las reviews
   * @param ArrayList<Review> La nueva lista de reviews
   * @return none
   */
  public void setReviews(ArrayList<Review> reviews) {
    this.reviews = reviews;
  }

  /**
   * Añade una review al listado de reviews
   * @param Review Review que se desea añadir
   * @return Boolean True si se ha podido añadir false si no
   */

  public boolean registerReviewE1() {
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
    reviews.add(review);
    return true;
  }

  /**
   * Elimina una review en concreto
   * @param int Identificador de la review que se desea eliminar
   * @return Boolean True si se ha podido borrar false si no
   */

  public Boolean deleteReview() {
	ReviewManager reviewManager = ReviewManager.getInstance();
	UserManager userManager = UserManager.getInstance();

    scanner = new Scanner(System.in);
    
    reviewManager.listReviews();
    System.out.print("Introduzca el identificador de la crítica que desea borrar: ");
    int deleteReviewId = scanner.nextInt();
    
    return reviews.removeIf(n -> ((n.getReviewId() == deleteReviewId) && (n.getUserId() == userManager.getActiveUser().getUserId())));
  }

  /**
   * Asigna una valoración a una review
   * @param int reviewId Identificador de la review
   * @param Boolean Valoración del usuario true positiva false negativa
   * @return Boolean True si se ha podido asignar false si no
   */

  public boolean voteReview() {
		ReviewManager reviewManager = ReviewManager.getInstance();
		UserManager userManager = UserManager.getInstance();

	    reviewManager.listReviews();
	    System.out.print("Introduzca el identificador de la crítica que desea valorar: ");
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
		        if ((reviews.get(i).getReviewId() == voteReviewId) && (reviews.get(i).getUserId() != userManager.getActiveUser().getUserId())) {
		        	if (choice == 1) {
			        	reviews.get(i).like();
			        	return true;
					}
		        	if (choice == 2){
		        		reviews.get(i).dislike();
				        return true;
		        	}
		        }
		    }
		}
	    return false;
  }

  /**
   * Busca y devuelve una review en concreto
   * @param int Identificador de la review que se desea buscar
   * @return Review review buscada o null si no la encuentra
   */

  public void searchUsersReview() {
		ReviewManager reviewManager = ReviewManager.getInstance();

	    reviewManager.listReviews();
	    System.out.print("Introduzca el identificador del usuario para el que desea buscar críticas: ");
	    int userReviewId = scanner.nextInt();
	    
	    ArrayList<Review> userReviews = new ArrayList<Review>();
	    
		for (int i = 0; i < reviews.size(); i++) {
			if (reviews.get(i).getUserId() == userReviewId) {
					userReviews.add(reviews.get(i));
		        }
		    }
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
   * Devuelve un identificador para las nuevas reviews creadas
   * @param none
   * @return int Identificador de la próxima review que se cree
   */

  public int getReviewId() {
    return reviewId;
  }

  /**
   * Se usa en la carga del sistema para recuperar el indice
   * @param int Identificador de la review que se desea asignar
   * @return none
   */

  public void setReviewId(int reviewId) {
    this.reviewId = reviewId;
  }

  public void listReviews() {
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
}
