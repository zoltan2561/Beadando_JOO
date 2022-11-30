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

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
