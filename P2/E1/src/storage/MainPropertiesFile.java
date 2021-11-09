package storage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MainPropertiesFile {

  public static void main(String[] args) {
    Properties prop = new Properties();
    String filename = "config.properties";
    try {
      BufferedReader reader = new BufferedReader(
        new FileReader(new File(filename))
      );
      prop.load(reader);

      String login = prop.getProperty("user");
      System.out.println(login);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
