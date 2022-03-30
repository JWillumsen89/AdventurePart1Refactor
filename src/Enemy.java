import java.util.ArrayList;

public class Enemy {

  private String name;
  private String description;
  private int healthPointsEnemy;
  private boolean enemyAlive = true;
  private int enemyAttackDamage = 10;

  Enemy() {}

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

  public  void decreseHealth(int healthPoints){
    healthPointsEnemy -= healthPoints;



  }

  public void isDead (){
    enemyAlive = false;
    }

  public boolean isEnemyAlive() {
    return enemyAlive;
  }

  public void setEnemyAlive(boolean enemyAlive) {
    this.enemyAlive = enemyAlive;
  }
}


