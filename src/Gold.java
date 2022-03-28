public class Gold extends Item {

  private int goldPoints;

  public Gold(String name, String description, int weight, int goldPoints) {
    super(name, description, weight);
    this.setGoldPoints(goldPoints);
  }

  public void setGoldPoints(int goldPoints) {
    this.goldPoints = goldPoints;
  }

  public int getGoldPoints() {
    return goldPoints;
  }

}

