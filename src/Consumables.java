public class Consumables extends Item {

  private String goodOrBad;
  private int healthPoints;

  public Consumables(String name, String description, int weight, int healthPoints, String goodOrBad) {
    super(name, description, weight);
    this.setHealthPoints(healthPoints);
    this.goodOrBad = goodOrBad;
  }

  public void setHealthPoints(int healthPoints) {
    this.healthPoints = healthPoints;
  }

  public int getHealthPoints() {
    return healthPoints;
  }

  public String getGoodOrBad() {
    return goodOrBad;
  }

}
