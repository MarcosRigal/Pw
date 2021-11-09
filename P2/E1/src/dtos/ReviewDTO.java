package dtos;

/**
 * Clase que representa a una reseña
 * generada por un usuario del sitema.
 * @author Antonio Moruno Gracia
 * @author David Pérez Dueñas
 * @author Marcos Rivera Gavilán
 * @version 1.0
 */

public class ReviewDTO {

  private int reviewId;
  private String email;
  private int spectacleId;
  private String title;
  private int score;
  private String review;
  private int like;
  private int dislike;

  /**
   * Constructor de la clase review
   * @param none
   */

  public ReviewDTO(
    int reviewId,
    String email,
    int spectacleId,
    String title,
    int score,
    String review
  ) {
    this.reviewId = reviewId;
    this.email = email;
    this.spectacleId = spectacleId;
    this.title = title;
    this.score = score;
    this.review = review;
    setLike(0);
    setDislike(0);
  }

  public ReviewDTO(
    int reviewId,
    String email,
    int spectacleId,
    String title,
    int score,
    String review,
    int like,
    int dislike
  ) {
    this.reviewId = reviewId;
    this.email = email;
    this.spectacleId = spectacleId;
    this.title = title;
    this.score = score;
    this.review = review;
    this.like = like;
    this.dislike = dislike;
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

  public String getEmail() {
    return email;
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
   * Devuelve el número de likes de la crítica
   * @param none
   * @return int Número de likes
   */

  public int getLike() {
    return like;
  }

  /**
   * Devuelve el número de dislikes de la crítica
   * @param none
   * @return int Número de dislikes
   */

  public int getDislike() {
    return dislike;
  }

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

  public void setEmail(String email) {
    this.email = email;
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
   * Cambia el número de likes
   * @param int Nueva numero de likes
   * @return none
   */

  public void setLike(int like) {
    this.like = like;
  }

  /**
   * Cambia el número de dislikes
   * @param int Nueva numero de dislikes
   * @return none
   */

  public void setDislike(int dislike) {
    this.dislike = dislike;
  }

  /**
   * Da un like a la review
   * @param none
   * @return none
   */

  public void like() {
    this.like = this.like + 1;
  }

  /**
   * Da un dislike a la review
   * @param none
   * @return none
   */

  public void dislike() {
    this.dislike = this.dislike + 1;
  }

  public String toString() {
    String reviewInfo =
      "ReviewId: " +
      this.reviewId +
      " Email: " +
      this.email +
      " SpectacleId: " +
      this.spectacleId +
      " Title: " +
      title +
      " Score: " +
      this.score +
      " Review: " +
      this.review +
      " Like: " +
      this.like +
      " Dislike: " +
      this.dislike;
    return reviewInfo;
  }
}
