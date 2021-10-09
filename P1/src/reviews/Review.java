package reviews;

import java.util.ArrayList;

/**
 * Clase que representa a una reseña
 * generada por un usuario del sitema.
 * @author Antonio Moruno Gracia
 * @author David Pérez Dueñas
 * @author Marcos Rivera Gavilán
 * @version 1.0
 */

public class Review {

  private int reviewId;
  private int userId;
  private int spectacleId;
  private String title;
  private int score;
  private String review;
  private int like;
  private int dislike;
  private ArrayList<Integer> usersIdWhoVoted = new ArrayList<Integer>();

  /**
   * Constructor de la clase review
   * @param none
   */

  public Review() {
    setLike(0);
    setDislike(0);
  }

  /**
   * Devuelve el identificador de la crítica
   * @param none
   * @return int Identificador de la crítica
   */

  public int getReviewId() {
    return reviewId;
  }

  /**
   * Devuelve el identificador del usuario que ha realizado la crítica
   * @param none
   * @return int Identificador del usuario que ha realizado la crítica
   */

  public int getUserId() {
    return userId;
  }

  /**
   * Devuelve el identificador del espectáculo al que se refiere la crítica
   * @param none
   * @return int Identificador del espectáculo al que se refiere la crítica
   */

  public int getSpectacleId() {
    return spectacleId;
  }

  /**
   * Devuelve el titulo de la crítica
   * @param none
   * @return string Título de la crítica
   */

  public String getTitle() {
    return title;
  }

  /**
   * Devuelve la puntuación de la crítica
   * @param none
   * @return int Puntuación de la crítica
   */

  public int getScore() {
    return score;
  }

  /**
   * Devuelve la review de la crítica
   * @param none
   * @return string Review de la crítica
   */

  public String getReview() {
    return review;
  }

  /**
   * Devuelve las valoraciones realizadas por otros usuarios a esa crítica
   * @param none
   * @return ArrayList<Boolean> Vector con las valoraciones realizadas por otros usuarios a esa crítica
   */

  /**
   * Cambia el identificador de la review
   * @param int Nuevo identificador de la review
   * @return none
   */

  public void setReviewId(int reviewId) {
    this.reviewId = reviewId;
  }

  /**
   * Cambia el identificador del autor de la review
   * @param int Nuevo identificador del autor de la review
   * @return none
   */

  public void setUserId(int userId) {
    this.userId = userId;
  }

  /**
   * Cambia el identificador del espectáculo asociado a la review
   * @param int Nuevo identificador del espectáculo asociado a la review
   * @return none
   */

  public void setSpectacleId(int spectacleId) {
    this.spectacleId = spectacleId;
  }

  /**
   * Cambia el titulo de la review
   * @param String Nuevo titulo de la review
   * @return none
   */

  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Cambia la puntuación de la review
   * @param int Nueva puntuación de la review
   * @return none
   */

  public void setScore(int score) {
    this.score = score;
  }

  /**
   * Cambia la descripición de la review
   * @param String Nueva descripción de la review
   * @return none
   */

  public void setReview(String review) {
    this.review = review;
  }

  /**
   * Cambia el vector con las valoraciones de los usuarios de la review
   * @param ArrayList<Boolean> Nuevo vector con las valoraciones de los usuarios de la review
   * @return none
   */

  public int getLike() {
    return like;
  }

  public void setLike(int like) {
    this.like = like;
  }

  public int getDislike() {
    return dislike;
  }

  public void setDislike(int dislike) {
    this.dislike = dislike;
  }

  public void like() {
    this.like = this.like + 1;
  }

  public void dislike() {
    this.dislike = this.dislike + 1;
  }

  public ArrayList<Integer> getUsersIdWhoVoted() {
    return usersIdWhoVoted;
  }

  public void setUsersIdWhoVoted(ArrayList<Integer> usersIdWhoVoted) {
    this.usersIdWhoVoted = usersIdWhoVoted;
  }

  public void addUserIdWhoVoted(int userIdWhoVoted) {
    this.usersIdWhoVoted.add(userIdWhoVoted);
  }
}
