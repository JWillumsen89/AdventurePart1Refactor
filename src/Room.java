import java.util.ArrayList;

public class Room {
  private String roomName;
  private String roomDescription;
  private Room north;
  private Room south;
  private Room east;
  private Room west;
  private ItemClass item;
  private ArrayList<ItemClass> items = new ArrayList<>();
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
    items.add(item);
  }

  String getItemsDescription() {
    String s = "";
    for (int i = 0; i < items.size(); i++) {
      s = s + items.get(i).getDescription() + "\n";
    }
    return s;
  }

  String showItemsList() {
    int count = 1;

    String s = "";
    for (int i = 0; i < items.size(); i++) {
      s = s + "[" + count + "] " + items.get(i).getName() + "\n";
      count++;

    }
    return s;
  }

  String removeItems() {
    String s = "";
    int i = 0;//TODO needs to be "takeAnswer" from Player class, from take method.
    //TODO add item to inventory before removing it from currentRoom.
    s = "You took: " + s + items.remove(i).getName() + "\n";

    return s;
  }

  @Override
  public String toString() {
    return roomName + "\n\n" + roomDescription;
  }

}
