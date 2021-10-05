package storage;

import factories.UserFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import managers.UserManager;
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

    Scanner myReader = new Scanner(userStorage);

    UserManager userManager = UserManager.getInstance();

    if (myReader.hasNextLine()) {
      String data = myReader.nextLine();

      userManager.setUserId(Integer.parseInt(data));

      while (myReader.hasNextLine()) {
        data = myReader.nextLine();
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
    myReader.close();
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
        users.get(i).getUserPassword() +
        "\n"
      );
    }
    userStorage.close();

    return true;
  }
}
