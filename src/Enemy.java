public class Enemy {

    private String name;
    private String description;
    private int healthPoints;

    Enemy (String name, String description, int healthPoints) {
        this.name = name;
        this.description = description;
        this.healthPoints = healthPoints;
    }

    public String getName (){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public int getHealthPoints (){
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints){
        this.healthPoints = healthPoints;
    }

}
