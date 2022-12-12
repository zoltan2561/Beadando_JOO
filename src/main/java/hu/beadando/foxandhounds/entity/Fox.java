package hu.beadando.foxandhounds.entity;

public class Fox {

  private int coordX;
  private int coordY;
  private String name;

  public Fox(int coordX, int coordY, String name) {
    this.coordX = coordX;
    this.coordY = coordY;
    this.name = name;
  }

    public Fox() {

    }

  public Fox(int i, int i1) {

  }


  public int getCoordX() {
    return coordX;
  }

  public void setCoordX(int coordX) {
    this.coordX = coordX;
  }

  public int getCoordY() {
    return coordY;
  }

  public void setCoordY(int coordY) {
    this.coordY = coordY;
  }



  public String getName() {
    return name;
  }

}
