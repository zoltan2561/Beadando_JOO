package hu.beadando.foxandhounds.service;

import hu.beadando.foxandhounds.entity.Board;
import hu.beadando.foxandhounds.entity.CoordConverter;
import hu.beadando.foxandhounds.entity.Dog;
import hu.beadando.foxandhounds.entity.Fox;
import hu.beadando.foxandhounds.entity.Player;
import org.springframework.stereotype.Service;
import org.h2.Driver;

import java.sql.*;
import java.util.Scanner;

@Service
public class GameServiceImpl implements GameService {

  private static final String ERVENYTELEN_KOORDINATA = "Ervenytelen koordinata!";
  private static final String ADD_UJRA = "Add ujra!";
  private static final String MEZO_FOGLALT = "A mezo mar foglalt '";
  private static final String ALTAL = "' altal. ";
  public Scanner input;

  @Override
  public void play() {
    Player player = new Player(getPlayerName(), 5);
    Dog dog = new Dog(0, 5, "Kutya");
    Fox fox1 = new Fox(1, 0, "Roka_1");
    Fox fox2 = new Fox(3, 0, "Roka_2");
    Fox fox3 = new Fox(5, 0, "Roka_3");

    defaultPrinter(dog, fox1, fox2, fox3);

    Board board = new Board();
    board.printer();

    defaultPrinter2(dog);

    start(player, board, dog, fox1, fox2, fox3);
  }



  public String getPlayerName() {
    System.out.println("Add meg a jatekos nevet: ");
    Scanner input = new Scanner(System.in);
    return input.nextLine();
  }

  public void defaultPrinter(Dog dog, Fox fox1, Fox fox2, Fox fox3) {
    System.out.println("START GAME!" + "\n");
    System.out.println("Jelolesek: ");
    System.out.println(
        " '" + dog.getName() + "' = 1;\n '" + fox1.getName() + "' = 2;\n '" + fox2.getName() + "' = 3;\n '"
            + fox3.getName() + "' = 4;" + "\n");
  }

  public void defaultPrinter2(Dog dog) {
    System.out.println("A koordinatakat 'betu+szam' kombinacioban varjuk!");
    System.out.println("'" + dog.getName() + "' kezd!\n");
  }

  public int coordDogYReader() {
    Scanner input = new Scanner(System.in);
    boolean check;
    int coordY;

    do {
      System.out.println("Add meg a SOR koordinatat: ");
      coordY = input.nextInt();
      check = CoordConverter.coordYValidChecker(coordY);
      if (check) {
        System.out.println("Hibas SOR koordinata, add ujra!");
      }
    } while (check);

    return --coordY;
  }

  public int coordDogXReader() {
    Scanner input = new Scanner(System.in);
    boolean check;
    int coordX;

    do {
      System.out.println("Add meg az OSZLOP koordinatat: ");
      String coordIn = input.nextLine();
      coordX = CoordConverter.convertXCoord(coordIn);
      check = CoordConverter.coordXValidChecker(coordX);
      if (check) {
        System.out.println("Hibas OSZLOP koordinata!");
      }
    } while (check);

    return coordX;
  }

  public int coordFoxXGenerator(Fox fox) {
    int min = fox.getCoordX() - 1;
    int max = fox.getCoordX() + 1;
    int x;

    if (min < 0) {
      min = 0;
    }

    if (max > 5) {
      max = 5;
    }

    do {
      x = (int) (Math.random() * (max - min + 1) + min);
    } while (fox.getCoordX() == x);

    return x;
  }

  public int coordFoxYGenerator(Fox fox) {
    int min = fox.getCoordY() - 1;
    int max = fox.getCoordY() + 1;
    int y;

    if (min < 0) {
      min = 0;
    }

    if (max > 5) {
      max = 5;
    }

    do {
      y = (int) (Math.random() * (max - min + 1) + min);
    } while (fox.getCoordY() == y);

    return y;
  }

  public boolean coordDogPositionChecker(Dog dog, int x, int y, Fox fox1, Fox fox2, Fox fox3) {
    boolean exiter = false;

    if(coordDiagonalPositionCheckerToDog(dog, x, y)) {
      exiter = true;
      System.out.println(ERVENYTELEN_KOORDINATA);
      System.out.print("Csak atlosan lephetsz. ");
      System.out.println(ADD_UJRA);
    } else if(coordOccupiedPositionCheckerToFox(fox1, x, y)) {
      exiter = true;
      System.out.println(ERVENYTELEN_KOORDINATA);
      System.out.print(MEZO_FOGLALT + fox1.getName() + ALTAL);
      System.out.println(ADD_UJRA);
    } else if(coordOccupiedPositionCheckerToFox(fox2, x, y)) {
      exiter = true;
      System.out.println(ERVENYTELEN_KOORDINATA);
      System.out.print(MEZO_FOGLALT + fox2.getName() + ALTAL);
      System.out.println(ADD_UJRA);
    } else if(coordOccupiedPositionCheckerToFox(fox3, x, y)) {
      exiter = true;
      System.out.println(ERVENYTELEN_KOORDINATA);
      System.out.print(MEZO_FOGLALT + fox3.getName() + ALTAL);
      System.out.println(ADD_UJRA);
    }

    return exiter;
  }

  private boolean coordFox1PositionChecker(Dog dog, int x, int y, Fox fox1, Fox fox2, Fox fox3) {
    return coordDiagonalPositionCheckerToFox(fox1, x, y) || coordOccupiedPositionCheckerToFox(fox2, x, y)
        || coordOccupiedPositionCheckerToFox(fox3, x, y) || coordOccupiedPositionCheckerToDog(dog, x, y);
  }

  private boolean coordFox2PositionChecker(Dog dog, int x, int y, Fox fox1, Fox fox2, Fox fox3) {
    return coordDiagonalPositionCheckerToFox(fox2, x, y) || coordOccupiedPositionCheckerToFox(fox1, x, y)
        || coordOccupiedPositionCheckerToFox(fox3, x, y) || coordOccupiedPositionCheckerToDog(dog, x, y);
  }

  private boolean coordFox3PositionChecker(Dog dog, int x, int y, Fox fox1, Fox fox2, Fox fox3) {
    return coordDiagonalPositionCheckerToFox(fox3, x, y) || coordOccupiedPositionCheckerToFox(fox2, x, y)
        || coordOccupiedPositionCheckerToFox(fox1, x, y) || coordOccupiedPositionCheckerToDog(dog, x, y);
  }

  private boolean coordDiagonalPositionCheckerToFox(Fox fox, int x, int y) {
    return !((fox.getCoordX() + 1 == x || fox.getCoordX() - 1 == x) && (fox.getCoordY() + 1 == y
        || fox.getCoordY() - 1 == y));
  }

  private boolean coordDiagonalPositionCheckerToDog(Dog dog, int x, int y) {
    return !((dog.getCoordX() + 1 == x || dog.getCoordX() - 1 == x) && (dog.getCoordY() + 1 == y
        || dog.getCoordY() - 1 == y));
  }

  private boolean coordOccupiedPositionCheckerToFox(Fox fox, int x, int y) {
    return fox.getCoordX() == x && fox.getCoordY() == y;
  }

  private boolean coordOccupiedPositionCheckerToDog(Dog dog, int x, int y) {
    return dog.getCoordX() == x && dog.getCoordY() == y;
  }

  private boolean endChecker(Dog dog, Fox fox1, Fox fox2, Fox fox3) {
    int x = dog.getCoordX() - 1;
    int y = dog.getCoordY() - 1;

    int x1 = dog.getCoordX() - 1;
    int y1 = dog.getCoordY() + 1;

    int x2 = dog.getCoordX() + 1;
    int y2 = dog.getCoordY() + 1;

    int x3 = dog.getCoordX() + 1;
    int y3 = dog.getCoordY() - 1;

    return occupiedAllFieldCheckerToDog(x, y, fox1, fox2, fox3) && occupiedAllFieldCheckerToDog(x1, y1, fox1, fox2, fox3) &&
        occupiedAllFieldCheckerToDog(x2, y2, fox1, fox2, fox3) && occupiedAllFieldCheckerToDog(x3, y3, fox1, fox2, fox3);
  }

  private boolean endChecker2(Dog dog) {
    return dog.getCoordY() == 0;
  }

  private boolean occupiedAllFieldCheckerToDog(int x, int y, Fox fox1, Fox fox2, Fox fox3) {
    return (x < 0 || x > 5 || y < 0 || y > 5)
        || (fox1.getCoordX() == x && fox1.getCoordY() == y)
        || (fox2.getCoordX() == x && fox2.getCoordY() == y)
        || (fox3.getCoordX() == x && fox3.getCoordY() == y);
  }

  private int randomFoxGenerator() {
    int min = 1;
    int max = 3;
    return (int) (Math.random() * (max - min + 1) + min);
  }

  /*
  private static boolean endlessChecker() {
  */

  private void start(Player player, Board board, Dog dog, Fox fox1, Fox fox2, Fox fox3) {
    String winner = "";

    do {
      int x;
      int y;
      int x1;
      int y1;
      int x2;
      int y2;
      int x3;
      int y3;

      do {
        x = coordDogXReader();
        y = coordDogYReader();
      } while (coordDogPositionChecker(dog, x, y, fox1, fox2, fox3));

      board.setCoordsValue(dog.getCoordX(), dog.getCoordY(), 0);
      dog.setCoordX(x);
      dog.setCoordY(y);
      board.setCoordsValue(dog.getCoordX(), dog.getCoordY(), 1);
      player.setScore(player.getScore() + 1);

      int randomFoxNumber = randomFoxGenerator();
      int counter=0;
      int threshold=10;

      if (randomFoxNumber == 1) {
        do {
          x1 = coordFoxXGenerator(fox1);
          y1 = coordFoxYGenerator(fox1);

          // Check if the counter exceeds the threshold
          if (counter > threshold) {
            // Handle the situation here, for example by exiting the loop
            System.out.println("!hiba!");
            break;
          }

          counter++;

        } while (coordFox1PositionChecker(dog, x1, y1, fox1, fox2, fox3));

        board.setCoordsValue(fox1.getCoordX(), fox1.getCoordY(), 0);

        fox1.setCoordX(x1);
        fox1.setCoordY(y1);
        board.setCoordsValue(fox1.getCoordX(), fox1.getCoordY(), 2);

      }

      if (randomFoxNumber == 2) {
        do {
          x2 = coordFoxXGenerator(fox2);
          y2 = coordFoxYGenerator(fox2);
          // endlessChecker;
          //
          if (counter > threshold) {
            // Handle the situation here, for example by exiting the loop
            System.out.println("!hiba!");
            break;
          }

          counter++;
        } while (coordFox2PositionChecker(dog, x2, y2, fox1, fox2, fox3));

        board.setCoordsValue(fox2.getCoordX(), fox2.getCoordY(), 0);

        fox2.setCoordX(x2);
        fox2.setCoordY(y2);
        board.setCoordsValue(fox2.getCoordX(), fox2.getCoordY(), 3);

      }

      if (randomFoxNumber == 3) {
        do {
          x3 = coordFoxXGenerator(fox3);
          y3 = coordFoxYGenerator(fox3);
          // endlessChecker;
          if (counter > threshold) {
            // Handle the situation here, for example by exiting the loop
            System.out.println("!hiba!");
            break;
          }
          counter++;
        } while (coordFox3PositionChecker(dog, x3, y3, fox1, fox2, fox3));

        board.setCoordsValue(fox3.getCoordX(), fox3.getCoordY(), 0);

        fox3.setCoordX(x3);
        fox3.setCoordY(y3);
        board.setCoordsValue(fox3.getCoordX(), fox3.getCoordY(), 4);
      }

      board.printer();

      if (endChecker(dog, fox1, fox2, fox3)) {
        board.setGame(false);
        winner = "Rokak";
      }

      if (endChecker2(dog)) {
        board.setGame(false);
        winner = player.getName() + ", pontok: " + player.getScore();
        player.setNumWins(player.getNumWins() + 1);

      }

    } while (board.getGame());

    System.out.println("VEGE A JATEKNAK! A GYOZTES: " + winner );

   /////////////////adatbázisba írás
    try {
      Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/./user2", "sa", "1234");

      // Check if the player already exists
      String sqlCheck = "SELECT * FROM players WHERE name = ?";
      PreparedStatement stmtCheck = conn.prepareStatement(sqlCheck);
      stmtCheck.setString(1, player.getName());
      ResultSet rs = stmtCheck.executeQuery();
      if (rs.next()) {
        // Player already exists, so update their wins
        int wins = rs.getInt("wins") + player.getNumWins();
        String sqlUpdate = "UPDATE players SET wins = ? WHERE name = ?";
        PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdate);
        stmtUpdate.setInt(1, wins);
        stmtUpdate.setString(2, player.getName());
        stmtUpdate.executeUpdate();
      } else {
        // Player does not exist, so insert a new record
        String sqlInsert = "INSERT INTO players (name, wins) VALUES (?, ?)";
        PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert);
        stmtInsert.setString(1, player.getName());
        stmtInsert.setInt(2, player.getNumWins());
        stmtInsert.executeUpdate();
      }

      // Close the connection to the database
      conn.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    /////////////////highscores
    try {
      Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/./user2", "sa", "1234");

      // Retrieve the data from the table
      String sql = "SELECT * FROM players ORDER BY wins DESC";
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);

      // Print the data to the terminal
      System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆HIGHSCORES☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
      System.out.println("   ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
      while (rs.next()) {
        String name = rs.getString("name");
        int wins = rs.getInt("wins");

        System.out.println(name + " has won " + wins + " games");

      }
      System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆HIGHSCORES☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
      System.out.println("     ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
      System.out.println("      ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
      System.out.println("         ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
      // Close the connection to the database
      conn.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }



  }


}
