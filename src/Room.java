import java.util.ArrayList;

public class Room {
  private String roomName;
  private String roomDescription;
  private Room north;
  private Room south;
  private Room east;
  private Room west;
  private ItemClass item;
  ArrayList<ItemClass> itemsRoom = new ArrayList<>();
  Player player = new Player();

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

  void addItems(ItemClass item) {
    itemsRoom.add(item);
  }

  String getItemsDescription() {
    String s = "";
    for (int i = 0; i < itemsRoom.size(); i++) {
      s = s + itemsRoom.get(i).getDescription();
    }
    return s;
  }

  String showItemsListRoom() {
    int count = 1;

    String s = "";
    for (int i = 0; i < itemsRoom.size(); i++) {
      s = s + "[" + count + "] " + itemsRoom.get(i).getName() + "\n";
      count++;

    }
    return s;
  }

  @Override
  public String toString() {
    return roomName + "\n\n" + roomDescription;
  }
}