import java.util.ArrayList;

public class Room {
  private String roomName;
  private String roomDescription;
  private Room north;
  private Room south;
  private Room east;
  private Room west;
  private Item item;
  private ArrayList<Item> items = new ArrayList<>();

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
    items.add(item);
  }

  String getItems() { //TODO skal have et andet navn
    String s = "";
    for (int i = 0; i < items.size(); i++) {
      s = s + items.get(i).getDescription() + "\n";
    }
    return s;
  }

  String removeItems() { //TODO skal have et andet navn
    String s = "";
    for (int i = 0; i < items.size(); i++) {
      s = s + items.remove(i).getDescription() + "\n";
    }
    return s;
  }

  String removeItem(String item) {
    return item;
  }

  @Override
  public String toString() {
    return roomName + "\n\n" + roomDescription;
  }

}
