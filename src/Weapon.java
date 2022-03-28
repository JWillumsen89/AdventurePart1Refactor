public abstract class Weapon  extends Item {

  private int attackPoints;

  Weapon(String name, String description, int weight, int attackPoints) {
    super(name, description, weight);
    this.attackPoints = attackPoints;
  }
}
