public class RangedWeapon extends Weapon {

  private int ammunition;

  public RangedWeapon(String name, String description, int weight, int attackPoints, int ammunition) {
    super(name, description, weight, attackPoints);
    this.ammunition = ammunition;

  }

  public int attack() {
    if (ammunition > 0) {
      ammunition = ammunition - 1;
      return getAttackPoints();
    } else {
      System.out.println("you don't have any ammunition");
      return 0;
    }
  }



  public int getAmmunition(){
    return ammunition;
  }



  public void setAmmunition(Ammo ammo){
    this.ammunition += ammo.getAmmo();
  }
}




