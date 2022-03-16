public class Room {
  private String roomName;
  private String roomDescription;
  private Room north;
  private Room south;
  private Room east;
  private Room west;

  Room(String name, String roomDescription) {
    setRoomName(name);
    setRoomDescription(roomDescription);

  }

  void setRoomName(String roomName) {
    this.roomName = roomName;
  }

  String getRoomName() {
    return roomName;
  }

  void setRoomDescription(String roomDescription) {
    this.roomDescription = roomDescription;
  }

  String getRoomDescription() {
    return roomDescription;
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

  @Override
  public String toString() {
    return roomName + "\n\n" + roomDescription;
  }
}
