package hu.beadando.foxandhounds.entity;

public class CoordConverter {
  public CoordConverter(){
  }

  public static int convertXCoord(String coordXText) {
    if(coordXText.length() > 1) {
      return -2;
    } else {
      return charConvertToNumber(coordXText.substring(0, 1));
    }
  }

  public static int charConvertToNumber(String coordXTextSubbedString) {
    switch(coordXTextSubbedString.toUpperCase()) {
      case "A":
        return 0;
      case "B":
        return 1;
      case "C":
        return 2;
      case "D":
        return 3;
      case "E":
        return 4;
      case "F":
        return 5;
      default:
        return -1;
    }
  }

  public static String numberConvertToChar(int x) {
    switch(x) {
      case 0:
        return "A";
      case 1:
        return "B";
      case 2:
        return "C";
      case 3:
        return "D";
      case 4:
        return "E";
      case 5:
        return "F";
      default:
        return "error";
    }
  }

  public static boolean coordXValidChecker(int x) {
    if(x == -1) {
      System.out.println("Az OSZLOP koordinata nem megengedett karaktert tartalmaz!");
      return true;
    }

    if(x == -2) {
      System.out.println("Az OSZLOP koordinata nem lehet hosszabb 1 karakternel!");
      return true;
    }

    if(x < -2) {
      System.out.println("Az OSZLOP koordinata nem lehet kisebb 0-nal!");
      return true;
    }

    if(x > 5) {
      System.out.println("Az OSZLOP koordinata nem lehet nagyobb 6-nal!");
      return true;
    }


    return false;
  }

  public static boolean coordYValidChecker(int y) {
    --y;

    if(y < 0) {
      System.out.println("A SOR koordinata nem lehet kisebb 0-nal!");
      return true;
    }

    if(y > 5) {
      System.out.println("A SOR koordinata nem lehet nagyobb 6-nal!");
      return true;
    }


    return false;
  }


}
