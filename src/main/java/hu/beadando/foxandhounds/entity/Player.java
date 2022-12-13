package hu.beadando.foxandhounds.entity;

public class Player {

  private String name;
  private int score;
  private int numWins;

  public Player(String name, int i) {
    this.name = name;
    score = 0;
  }
    public Player() {
    }

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getScore() {
    return score;
  }
  public void setNumWins(int numWins) {
    this.numWins = numWins;
  }

  public int getNumWins() {
    return numWins;
  }
  public void setScore(int score) {
    this.score = score;
  }

}
