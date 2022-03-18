import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
  private Room currentRoom;

  private String playerName;
  private String newLoc;
  private String cantGo;
  ArrayList<String> inventory = new ArrayList<>(List.of());

  void setCurrentRoom(Room currentRoom) {
    this.currentRoom = currentRoom;
  }

  Room getCurrentRoom() {
    return currentRoom;
  }

  String getPlayerName() {
    return playerName;
  }

  void playerNameInput() {
    Scanner in = new Scanner(System.in);
    System.out.print("Warrior! Whats your name: ");
    playerName = in.nextLine();
    playerName = playerName.toUpperCase();
    newLoc = "\n" + playerName + ", You walked into a new location!";
    cantGo = "\nyou can't go that way";
  }

  void movement(char command) {
    if (command == 'n') {
      if (currentRoom.getNorth() != null) {
        System.out.println(newLoc);
        currentRoom = currentRoom.getNorth();
      } else {
        System.out.println(cantGo);
      }
    } else if (command == 's') {
      if (currentRoom.getSouth() != null) {
        System.out.println(newLoc);
        currentRoom = currentRoom.getSouth();
      } else {
        System.out.println(cantGo);
      }
    } else if (command == 'e') {
      if (currentRoom.getEast() != null) {
        System.out.println(newLoc);
        currentRoom = currentRoom.getEast();
      } else {
        System.out.println(cantGo);
      }
    } else if (command == 'w') {
      if (currentRoom.getWest() != null) {
        System.out.println(newLoc);
        currentRoom = currentRoom.getWest();
      } else {
        System.out.println(cantGo);
      }
    }
  }
}