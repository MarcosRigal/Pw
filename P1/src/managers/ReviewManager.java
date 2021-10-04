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

  /**
   * Busca y devuelve una review en concreto
   * @param int Identificador de la review que se desea buscar
   * @return Review review buscada o null si no la encuentra
   */

  private ReviewManager() {}

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

  public boolean registerReview(Review review) {
    return true;
  }

  /**
   * Elimina una review en concreto
   * @param int Identificador de la review que se desea eliminar
   * @return Boolean True si se ha podido borrar false si no
   */

  public boolean deleteReview(int reviewId) {
    return true;
  }

  /**
   * Asigna una valoración a una review
   * @param int reviewId Identificador de la review
   * @param Boolean Valoración del usuario true positiva false negativa
   * @return Boolean True si se ha podido asignar false si no
   */

  public boolean voteReview(int userId, Boolean vote) {
    return true;
  }

  /**
   * Busca y devuelve una review en concreto
   * @param int Identificador de la review que se desea buscar
   * @return Review review buscada o null si no la encuentra
   */

  public Review searchReview(int review) {
    return null;
  }
}
