public class Enemy {

  private String name;
  private String description;
  private int healthPointsEnemy;

  Enemy(String name, String description, int healthPointsEnemy) {
    this.name = name;
    this.description = description;
    this.healthPointsEnemy = healthPointsEnemy;
  }
  public String getName(){
    return name;
  }
  public String getDescription(){
    return description;
  }
  public int getHealthPointsEnemy(){
    return healthPointsEnemy;
  }
  public void setHealthPointsEnemy(int healthPointsEnemy){
    this.healthPointsEnemy = healthPointsEnemy;
  }
}
