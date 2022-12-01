package hu.beadando.foxandhounds.entity;

public class Board {

  private final int[][] coords = new int[6][6];
  private static final String COLOR_ROKA = "\033[1;31m";
  private static final String COLOR_KUTYA_1 = "\033[1;32m";
  private static final String COLOR_KUTYA_2 = "\033[1;33m";
  private static final String COLOR_KUTYA_3 = "\033[1;34m";
  private static final String COLOR_MARGIN = "\033[1;35m";
  private static final String COLOR_ZERO = "\033[1;37m";
  private static final String COLOR_RESET = "\033[0m";

  private boolean game;

  public Board() {
    setDefaultCoords();
    game = true;
  }

  public void printer() {
    System.out.print(COLOR_MARGIN);
    System.out.print("A   ");
    System.out.print("B   ");
    System.out.print("C   ");
    System.out.print("D   ");
    System.out.print("E   ");
    System.out.print("F   ");
    System.out.println(COLOR_RESET);

    for(int i=0; i<21; i++) {
      System.out.print("_");
    }

    System.out.println("\n\n");

    for (int i=0; i<6; i++) {
      for (int j=0; j<6; j++) {
        //itt azért van megcserélve, hogy a kirajzolás igazodjon az elnevezésekhez;
        //a gép nem úgy rajzolja a koordináta rendszert mint ahogy a valóságban van;
        textColorSettedPrinter(coords[j][i]);
      }
      System.out.println("  |" + COLOR_MARGIN + (i+1) + COLOR_RESET);
    }

    System.out.println("\n\n");
  }

  public int getCoordsValue(int x, int y) {
    return coords[x][y];
  }

  public void setCoordsValue(int x, int y, int value) {
    coords[x][y] = value;
  }

  private void setDefaultCoords() {
    //kutya
    coords[0][5] = 1;

    //Roka_1
    coords[1][0] = 2;

    //Roka_2
    coords[3][0] = 3;

    //Roka_3
    coords[5][0] = 4;
  }

  private void textColorSettedPrinter(int value) {
    System.out.print(COLOR_ZERO);

    if(value == 1) {
      System.out.print(COLOR_ROKA + value + COLOR_RESET + "   ");
    } else if(value == 2) {
      System.out.print(COLOR_KUTYA_1 + value + COLOR_RESET + "   ");
    } else if(value == 3) {
      System.out.print(COLOR_KUTYA_2 + value + COLOR_RESET + "   ");
    } else if(value == 4) {
      System.out.print(COLOR_KUTYA_3 + value + COLOR_RESET + "   ");
    } else {
      System.out.print(value + "   ");
    }

    System.out.print(COLOR_RESET);
  }

  public boolean getGame() {
    return game;
  }

  public void setGame(boolean game) {
    this.game = game;
  }
}
