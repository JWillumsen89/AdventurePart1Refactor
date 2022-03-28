public class Armor extends Item {

  private int armorPoints;

  Armor(String name, String description, int weight, int armorPoints) {
    super(name, description, weight);
    this.armorPoints = armorPoints;
  }
}
