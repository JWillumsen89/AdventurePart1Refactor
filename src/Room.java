import java.util.ArrayList;

public class Room {

  private String roomName;
  private String roomDescription;
  private Room north;
  private Room south;
  private Room east;
  private Room west;
  private ArrayList<Item> itemsRoom = new ArrayList<>();
  private ArrayList<Enemy> enemiesRoom = new ArrayList<>();

  ArrayList<Enemy> getEnemiesRoom(){
    return enemiesRoom;
  }

  ArrayList<Item> getItemsRoom() {
    return itemsRoom;
  }

  Room(String name, String roomDescription) {
    setRoomName(name);
    setRoomDescription(roomDescription);

  }

  void setRoomName(String roomName) {
    this.roomName = roomName;
  }

  void setRoomDescription(String roomDescription) {
    this.roomDescription = roomDescription;
  }

  void setNorth(Room north) {
    this.north = north;
  }

  Room getNorth() {
    return north;
  }

  void setSouth(Room south) {
    this.south = south;
  }

  Room getSouth() {
    return south;
  }

  void setEast(Room east) {
    this.east = east;
  }

  Room getEast() {
    return east;
  }

  void setWest(Room west) {
    this.west = west;
  }

  Room getWest() {
    return west;
  }

  void addItems(Item item) {
    itemsRoom.add(item);
  }

  void addEnemy(Enemy enemy) {
    enemiesRoom.add(enemy);
  }

  void removeItems(Item item) {
    itemsRoom.remove(item);
  }

  String getItemsDescription() {
    String s = "";
      for (int i = 0; i < itemsRoom.size(); i++) {
        s = s + itemsRoom.get(i).getDescription() + " [" + itemsRoom.get(i).getName() + "]";
      }
      return s;
    }

  String getEnemyDescription() {
    String s = "";
    for (int i = 0; i < enemiesRoom.size(); i++) {
      s = s + enemiesRoom.get(i).getDescription() + " [" + enemiesRoom.get(i).getName() + " HEALTH: " + enemiesRoom.get(i).getHealthPointsEnemy() + "]\n";
    }
    return s;
  }

  @Override
  public String toString() {
    return roomName + "\n\n" + roomDescription;
  }
}
