package storage;

import factories.SpectacleFactory;
import factories.UserFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import managers.ReviewManager;
import managers.SesionManager;
import managers.SpectacleManager;
import managers.UserManager;
import reviews.Review;
import sesions.Sesion;
import spectacles.Spectacle;
import users.User;
import utilities.SystemFunctions;

/**
 * Implementación de la interfaz repository para trabajar con ficheros
 * @author Antonio Moruno Gracia
 * @author David Pérez Dueñas
 * @author Marcos Rivera Gavilán
 * @version 1.0
 */

public class FileStorage implements IRepository {

  /**
   * Función encargada de cargar el sistema
   * @param none
   * @return none
 * @throws IOException 
 * @throws ParseException 
   */
  @Override
  public boolean loadSystem() throws IOException, ParseException {
    File userStorage = new File("users.txt");
    File reviewStorage = new File("reviews.txt");
    File spectacleStorage = new File("spectacles.txt");
    File sesionStorage = new File("sesions.txt");
    
    if(!userStorage.exists()) { 
        FileWriter newUserStorage = new FileWriter("users.txt");
        newUserStorage.close();
    }
    
    Scanner userReader = new Scanner(userStorage);

    UserManager userManager = UserManager.getInstance();

    if (userReader.hasNextInt()) {
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

    if(!reviewStorage.exists()) { 
        FileWriter newReviewsStorage = new FileWriter("reviews.txt");
        newReviewsStorage.close();
    }
    
    Scanner reviewReader = new Scanner(reviewStorage);

    ReviewManager reviewManager = ReviewManager.getInstance();

    if (reviewReader.hasNextInt()) {
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
        for (int i = 8; i < parts.length; i++) {
          review.addUserIdWhoVoted(Integer.parseInt(parts[i]));
        }
        reviewManager.addReview(review);
      }
    }
    reviewReader.close();
    
    if(!spectacleStorage.exists()) { 
        FileWriter newSpectacleStorage = new FileWriter("spectacles.txt");
        newSpectacleStorage.close();
    }
    
    Scanner spectacleReader = new Scanner(spectacleStorage);

    SpectacleManager spectacleManager = SpectacleManager.getInstance();

    if (spectacleReader.hasNextInt()) {
      String data = spectacleReader.nextLine();

      spectacleManager.setSpectacleId(Integer.parseInt(data));

      while (spectacleReader.hasNextLine()) {
        data = spectacleReader.nextLine();
        String[] parts = data.split(",");

        Spectacle spectacle = SpectacleFactory.getSpectacle(parts[2]);
        spectacle.setSpectacleId(Integer.parseInt(parts[0]));
        spectacle.setTitle(parts[1]);
        spectacle.setDescription(parts[3]);
        spectacle.setCategory(SystemFunctions.convertStringToCategory(parts[4]));
        spectacle.setPlaces(Integer.parseInt(parts[5]));
        spectacleManager.addSpectacle(spectacle);
      }
    }
    spectacleReader.close();
    
    if(!sesionStorage.exists()) { 
        FileWriter newSesionStorage = new FileWriter("sesions.txt");
        newSesionStorage.close();
    }
    Scanner sesionReader = new Scanner(sesionStorage);
    
    if (sesionReader.hasNextInt()) {
        String data = sesionReader.nextLine();

        SesionManager sesionManager = SesionManager.getInstance();
    sesionManager.setSesionId(Integer.parseInt(data));

    

    SimpleDateFormat formatter6=new SimpleDateFormat("dd-MM-yyyy HH:mm");
      while (sesionReader.hasNextLine()) {
        data = sesionReader.nextLine();
        String[] parts = data.split(",");

        Sesion sesion = new Sesion();
        sesion.setSpectacleId(Integer.parseInt(parts[0]));
	    sesion.setSesionId(Integer.parseInt(parts[1]));
        sesion.setPlacesLeft(Integer.parseInt(parts[2]));
        sesion.setDate(formatter6.parse(parts[3]));
        sesionManager.addSesion(sesion);
      }
    }
    sesionReader.close();
    
    return true;
  }

  /**
   * Función encargada de guardar el estado del sistema en el alamacenamiento
   * @param none
   * @return none
   * @throws IOException
   */
  @Override
  public boolean saveSystem() throws IOException {
    FileWriter userStorage = new FileWriter("users.txt");
    FileWriter reviewStorage = new FileWriter("reviews.txt");
    FileWriter spectacleStorage = new FileWriter("spectacles.txt");
    FileWriter sesionStorage = new FileWriter("sesions.txt");

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
      ArrayList<Integer> usersIdWhoVoted = reviews.get(i).getUsersIdWhoVoted();
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
        reviews.get(i).getDislike()
      );
      for (int j = 0; j < usersIdWhoVoted.size(); j++) {
        reviewStorage.write("," + usersIdWhoVoted.get(j));
      }
      reviewStorage.write("\n");
    }
    reviewStorage.close();
    
    SpectacleManager spectacleManager = SpectacleManager.getInstance();
    ArrayList<Spectacle> spectacles = spectacleManager.getSpectacles();

    spectacleStorage.write(spectacleManager.getSpectacleId() + "\n");
    for (int i = 0; i < spectacles.size(); i++) {
      spectacleStorage.write(
        spectacles.get(i).getSpectacleId() +
        "," +
        spectacles.get(i).getTitle() +
        "," +
        spectacles.get(i).getType() +
        "," +
        spectacles.get(i).getDescription() +
        "," +
        spectacles.get(i).getCategory() +
        "," +
        spectacles.get(i).getPlaces() +
        "\n"
      );
    }  
    spectacleStorage.close();
    
    SesionManager sesionManager = SesionManager.getInstance();
    ArrayList<Sesion> sesions = sesionManager.getSesions();
    SimpleDateFormat formatter6=new SimpleDateFormat("dd-MM-yyyy HH:mm");

    sesionStorage.write(sesionManager.getSesionId() + "\n");
    for (int i = 0; i < sesions.size(); i++) {
      sesionStorage.write(
        sesions.get(i).getSpectacleId() +
        "," +
        sesions.get(i).getSesionId() +
        "," +
        sesions.get(i).getPlacesLeft() +
        "," +
        formatter6.format(sesions.get(i).getDate()) +
        "\n"
      );
    }    
    sesionStorage.close();
    
    return true;
  }
}
