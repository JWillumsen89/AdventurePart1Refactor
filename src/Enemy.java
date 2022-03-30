import java.util.ArrayList;

public class Enemy {

  private String name;
  private String description;
  private int healthPointsEnemy;
  private int enemyAttack;

  Enemy() {}

  Enemy(String name, String description, int healthPointsEnemy, int enemyAttack) {
    this.name = name;
    this.description = description;
    this.healthPointsEnemy = healthPointsEnemy;
    this.enemyAttack = enemyAttack;
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