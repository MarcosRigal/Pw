package es.uco.pw.business.managers;

import es.uco.pw.data.daos.ReviewDAO;
import es.uco.pw.data.dtos.ReviewDTO;

import java.util.ArrayList;

import es.uco.pw.business.reviews.Review;

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

  private int reviewId;

  /**
   * Constructor del review manager
   * @param none
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
   * @param none
   * @return ArrayList<ReviewDTO> Vector con las criticas
   */

  public ArrayList<ReviewDTO> getReviews() {
    ReviewDAO reviews = new ReviewDAO();
    return reviews.getReviews();
  }

  /**
   * Elimina una review en concreto
   * @param int Identificador de la review que se desea eliminar
   * @return Boolean True si se ha podido borrar false si no
   */

  public Boolean deleteReview(int deleteReviewId, String email, String type) {

    if(existsReview(deleteReviewId)){
    	ReviewDTO review = findReview(deleteReviewId);
    	if((review.getEmail().equals(email)) || (type.equals("Admin"))){
    	    ReviewDAO reviewDAO = new ReviewDAO();
    	    return reviewDAO.deleteReview(deleteReviewId);
    	}
    }
    return false;
  }

  /**
   * Asigna una valoración a una review
   * @param int elección del usuario
   * @param int reviewId Identificador de la review
   * @return Boolean True si se ha podido asignar false si no
   */

  public boolean voteReview(int choice, int voteReviewId, String email) {
    ReviewDAO reviewDAO = new ReviewDAO();
    if(existsReview(voteReviewId)){
        if(reviewDAO.canUserVote(email, voteReviewId)){
        	ReviewDTO review =  findReview(voteReviewId);
        	if (choice == 1) {
                reviewDAO.like(email, review);
                return true;
        	}
              if (choice == 2) {
                reviewDAO.dislike(email, review);
                return true;
              }
        }
        return false;
    }
    return false;
  }

  /**
   * Busca y las reviews creadas por un usuario
   * @param int Identificador del usuario que creo las reviews que se desean buscar
   * @return ReviewDTO review buscada o null si no la encuentra
   */

  public ArrayList<ReviewDTO> searchUsersReview(String email) {
    ReviewDAO reviews = new ReviewDAO();
    return reviews.getUserReviews(email);
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
   * @param int Identificador de la próxima review que se va a crear
   * @return none
   */

  public void setReviewId(int reviewId) {
    this.reviewId = reviewId;
  }

  /**
   * Registra en el sistema una nueva review
   * @param ReviewDTO review que se acaba de crear
   * @return none
   */

  public boolean registerReview(Review review) {
	SpectacleManager spectacleManager = SpectacleManager.getInstance();
	if ((spectacleManager.existsSpectacle(review.getSpectacleId())==false) || (review.getScore() < 0 || review.getScore() > 5)) {
		return false;
	}
    ReviewDAO reviewDAO = new ReviewDAO();
    return reviewDAO.registerReview(review);
  }

  /**
   * Devuelve las reviews asociadas a un spectacleId
   * @param int Identificador del espectáculo del que se desean obtener las reviews
   * @return ArrayList<ReviewDTO> Array con todas las reviews que pertenecen a ese espectáculo
   */

  public ArrayList<ReviewDTO> searchSpectaclesReview(int spectacleId) {
    ArrayList<ReviewDTO> spectaclesReviews = new ArrayList<ReviewDTO>();
    ArrayList<ReviewDTO> reviews = getReviews();
    for (int i = 0; i < reviews.size(); i++) {
      if (reviews.get(i).getSpectacleId() == spectacleId) {
        spectaclesReviews.add(reviews.get(i));
      }
    }
    return spectaclesReviews;
  }

  /**
   * Devuelve todas las críticas de los espectáculos dado un título
   * @param String Title
   * @return ArrayList<ReviewDTO> Vector con las criticas
   */

  public ArrayList<ReviewDTO> getReviewsBySpectacleTitle(String title) {
    ReviewDAO reviews = new ReviewDAO();
    return reviews.getReviewsBySpectacleTitle(title);
  }
  
  /**
   * Comprueba que exista una review
   * @param int Identificador de la review
   * @return boolean True si la ha encontrado false si no
   */

  public boolean existsReview(int reviewId) {
	ArrayList<ReviewDTO> allReviews = getReviews();
    for (int i = 0; i < allReviews.size(); i++) {
      if (allReviews.get(i).getReviewId() == reviewId) {
        return true;
      }
    }
    return false;
  }

  /**
   * Busca una review en concreto
   * @param int Identificador de la review
   * @return ReviewDTO Review buscada
   * @return null Si o encuentra la review
   */

  public ReviewDTO findReview(int reviewId) {
	ArrayList<ReviewDTO> allReviews = getReviews();
    for (int i = 0; i < allReviews.size(); i++) {
      if (allReviews.get(i).getReviewId() == reviewId) {
        return allReviews.get(i);
      }
    }
    return null;
  }
}
