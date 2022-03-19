import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
  private Room currentRoom;
  private String playerName;
  private String newLoc;
  private String cantGo;
  ArrayList<ItemClass> inventory = new ArrayList<>(List.of());
  Map map = new Map();

  void setCurrentRoom(Room currentRoom) {
    this.currentRoom = currentRoom;
  }

  Room getCurrentRoom() {
    return currentRoom;
  }

  /*void setTakeAnswer(int takeAnswer) {
    this.takeAnswer = takeAnswer;
  }

   */

  /*int getTakeAnswer() {
    return takeAnswer;
  }

   */

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

  int take(char command) {
    Scanner in = new Scanner(System.in);


    System.out.println("What item do want to take?: ");
    System.out.println(currentRoom.showItemsList());
    System.out.print("Enter the number of the item: ");
    int takeAnswer = in.nextInt();
    System.out.println(currentRoom.removeItems());

    return takeAnswer - 1;
  }

  String showInventoryList() {
    int count = 1;

    String s = "";
    for (int i = 0; i < inventory.size(); i++) {
      s = s + "[" + count + "] " + inventory.get(i).getName() + "\n";
      count++;

    }
    System.out.println("Axe"); //TODO Remove this and make sure it prints inventory list instead when add item to inventory works.
    return s;
  }

  String addItem() {
    String s = "";
    for (int i = 0; i < inventory.size(); i++) {
      s = "You took: " + s + inventory + "\n";
      //System.out.println(player.inventory);
    }
    return s;
  }
}