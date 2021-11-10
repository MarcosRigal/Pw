package bdd.connection.test;

import java.sql.Date;
import java.text.SimpleDateFormat;
import managers.DataBaseManager;
import dtos.Manager;

/**
 * Main program to illustrate JDBC usage
 * @author Aurora Ramirez
 * @author Jose Raul Romero
 * */

public class MainProgram {

  public static void main(String[] args) {
    DataBaseManager dataBaseManager = DataBaseManager.getInstance();
    dataBaseManager.getConnected();
    Manager manager = new Manager();
    String usersInfo = manager.findUsers();
    String spectaclesInfo = manager.findSpectacles();
    String sesionsInfo = manager.findSesions();
    String reviewsInfo = manager.findReviews();
    System.out.println(usersInfo);
    System.out.println(spectaclesInfo);
    System.out.println(sesionsInfo);
    System.out.println(reviewsInfo);
    SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    Date date = new Date(System.currentTimeMillis());
    System.out.println(formatter.format(date)); 
    dataBaseManager.getDisconnected();
  }
}
