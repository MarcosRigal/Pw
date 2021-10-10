package managers;

import java.util.ArrayList;
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

  /**
   * Elimina una review en concreto
   * @param int Identificador de la review que se desea eliminar
   * @return Boolean True si se ha podido borrar false si no
   */

  public Boolean deleteReview(int deleteReviewId) {
    UserManager userManager = UserManager.getInstance();

    return reviews.removeIf(
      n ->
        (
          (n.getReviewId() == deleteReviewId) &&
          (
            (n.getUserId() == userManager.getActiveUser().getUserId()) ||
            (userManager.getActiveUser().getType().equals("Admin"))
          )
        )
    );
  }

  /**
   * Asigna una valoración a una review
   * @param int reviewId Identificador de la review
   * @param Boolean Valoración del usuario true positiva false negativa
   * @return Boolean True si se ha podido asignar false si no
   */

  /**
   * Busca y devuelve una review en concreto
   * @param int Identificador de la review que se desea buscar
   * @return
   * @return Review review buscada o null si no la encuentra
   */

  public ArrayList<Review> searchUsersReview(int userReviewId) {
    ArrayList<Review> userReviews = new ArrayList<Review>();

    for (int i = 0; i < reviews.size(); i++) {
      if (reviews.get(i).getUserId() == userReviewId) {
        userReviews.add(reviews.get(i));
      }
    }
    return userReviews;
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

  public void addReview(Review review) {
    this.reviews.add(review);
  }

  public void registerReview(Review review) {
    UserManager userManager = UserManager.getInstance();
    review.addUserIdWhoVoted(userManager.getActiveUser().getUserId());
    this.reviews.add(review);
    reviewId += 1;
  }

  public boolean voteReview(int choice, int voteReviewId) {
    UserManager userManager = UserManager.getInstance();

    for (int i = 0; i < reviews.size(); i++) {
      if (
        (reviews.get(i).getReviewId() == voteReviewId) &&
        (
          !reviews
            .get(i)
            .getUsersIdWhoVoted()
            .contains(userManager.getActiveUser().getUserId())
        )
      ) {
        if (choice == 1) {
          reviews.get(i).like();
          reviews
            .get(i)
            .addUserIdWhoVoted(userManager.getActiveUser().getUserId());
          return true;
        }
        if (choice == 2) {
          reviews.get(i).dislike();
          reviews
            .get(i)
            .addUserIdWhoVoted(userManager.getActiveUser().getUserId());
          return true;
        }
      }
    }
    return false;
  }

  public ArrayList<Review> searchSpectaclesReview(int spectacleId) {
    ArrayList<Review> spectaclesReviews = new ArrayList<Review>();

    for (int i = 0; i < reviews.size(); i++) {
      if (reviews.get(i).getSpectacleId() == spectacleId) {
        spectaclesReviews.add(reviews.get(i));
      }
    }
    return spectaclesReviews;
  }
}
