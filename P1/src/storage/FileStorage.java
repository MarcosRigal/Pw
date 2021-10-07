package storage;

import factories.UserFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import managers.ReviewManager;
import managers.UserManager;
import reviews.Review;
import users.User;

/**
 * Implementación de la interfaz repository para trabajar con ficheros
 * @author Antonio Moruno Gracia
 * @author David Pérez Dueñas
 * @author Marcos Rivera Gavilán
 * @version 1.0
 */

public class FileStorage implements IRepository {

  /**
   * Función encargada de guardar el estado del sistema en el alamacenamiento
   * @param none
   * @return none
   * @throws FileNotFoundException
   */
  @Override
  public boolean loadSystem() throws FileNotFoundException {
    File userStorage = new File("users.txt");
    File reviewStorage = new File("reviews.txt");
    File spectacleStorage = new File("spectacles.txt");

    Scanner userReader = new Scanner(userStorage);

    UserManager userManager = UserManager.getInstance();

    if (userReader.hasNextLine()) {
      String data = userReader.nextLine();

      userManager.setUserId(Integer.parseInt(data));

      while (userReader.hasNextLine()) {
        data = userReader.nextLine();
        String[] parts = data.split(",");

        User user = UserFactory.getUser(parts[2]);
        user.setUserId(Integer.parseInt(parts[0]));
        user.setName(parts[1]);
        user.setSurname(parts[3]);
        user.setNick(parts[4]);
        user.setEmail(parts[5]);
        user.setPassword(parts[6]);
        userManager.addUser(user);
      }
    }
    userReader.close();

    Scanner reviewReader = new Scanner(reviewStorage);

    ReviewManager reviewManager = ReviewManager.getInstance();

    if (reviewReader.hasNextLine()) {
      String data = reviewReader.nextLine();

      reviewManager.setReviewId(Integer.parseInt(data));

      while (reviewReader.hasNextLine()) {
        data = reviewReader.nextLine();
        String[] parts = data.split(",");

        Review review = new Review();
        review.setReviewId(Integer.parseInt(parts[0]));
        review.setUserId(Integer.parseInt(parts[1]));
        review.setSpectacleId(Integer.parseInt(parts[2]));
        review.setTitle(parts[3]);
        review.setScore(Integer.parseInt(parts[4]));
        review.setReview(parts[5]);
        review.setLike(Integer.parseInt(parts[6]));
        review.setDislike(Integer.parseInt(parts[7]));
        reviewManager.addReview(review);
      }
    }
    reviewReader.close();

    return false;
  }

  /**
   * Función encargada de cargar el sistema
   * @param none
   * @return none
   * @throws IOException
   */
  @Override
  public boolean saveSystem() throws IOException {
    FileWriter userStorage = new FileWriter("users.txt");
    FileWriter reviewStorage = new FileWriter("reviews.txt");
    FileWriter spectacleStorage = new FileWriter("spectacles.txt");

    UserManager userManager = UserManager.getInstance();
    ArrayList<User> users = userManager.getUsers();
    userStorage.write(userManager.getUserId() + "\n");
    for (int i = 0; i < users.size(); i++) {
      userStorage.write(
        users.get(i).getUserId() +
        "," +
        users.get(i).getName() +
        "," +
        users.get(i).getType() +
        "," +
        users.get(i).getSurname() +
        "," +
        users.get(i).getNick() +
        "," +
        users.get(i).getEmail() +
        "," +
        users.get(i).getPassword() +
        "\n"
      );
    }
    userStorage.close();

    ReviewManager reviewManager = ReviewManager.getInstance();
    ArrayList<Review> reviews = reviewManager.getReviews();

    reviewStorage.write(reviewManager.getReviewId() + "\n");
    for (int i = 0; i < reviews.size(); i++) {
      reviewStorage.write(
        reviews.get(i).getReviewId() +
        "," +
        reviews.get(i).getUserId() +
        "," +
        reviews.get(i).getSpectacleId() +
        "," +
        reviews.get(i).getTitle() +
        "," +
        reviews.get(i).getScore() +
        "," +
        reviews.get(i).getReview() +
        "," +
        reviews.get(i).getLike() +
        "," +
        reviews.get(i).getDislike() +
        "\n"
      );
    }
    reviewStorage.close();
    spectacleStorage.close();
    return true;
  }
}
