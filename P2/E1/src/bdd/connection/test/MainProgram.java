package bdd.connection.test;

import dtos.Manager;

/**
 * Main program to illustrate JDBC usage
 * @author Aurora Ramirez
 * @author Jose Raul Romero
 * */

public class MainProgram {

  public static void main(String[] args) {
    Manager manager = new Manager();
    String usersInfo = manager.findUsers();
    String spectaclesInfo = manager.findSpectacles();
    String sesionsInfo = manager.findSesions();
    String reviewsInfo = manager.findReviews();
    System.out.println(usersInfo);
    System.out.println(spectaclesInfo);
    System.out.println(sesionsInfo);
    System.out.println(reviewsInfo);
  }
}