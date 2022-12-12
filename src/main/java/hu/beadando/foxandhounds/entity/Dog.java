package hu.beadando.foxandhounds.entity;

public class Dog {

  private int coordX;
  private int coordY;
  private String name;

  public Dog(int coordX, int coordY, String name) {
    this.coordX = coordX;
    this.coordY = coordY;
    this.name = name;
  }

  public Dog() {

  }

  public Dog(int i, int i1) {

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

  public Object getX() {
    return null;
  }

  public Object getY() {
    return null;
  }

    public void setX(int i) {
    }

  public void setY(int i) {
  }
}
