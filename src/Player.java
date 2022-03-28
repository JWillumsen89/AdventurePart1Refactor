import java.util.ArrayList;
import java.util.Scanner;

public class Player {
  private Room currentRoom;
  private String playerName;
  private String playerDecision;
  private String newLoc;
  private String cantGo;
  private String playerAnswer;
  private int takeAnswer;
  private ArrayList<ItemClass> inventory = new ArrayList<>();
  private Scanner in = new Scanner(System.in);

  void setCurrentRoom(Room currentRoom) {
    this.currentRoom = currentRoom;
  }

  void setTakeAnswer(int takeAnswer) {
    this.takeAnswer = takeAnswer;
  }

  int getTakeAnswer() {
    return takeAnswer;
  }

  String getPlayerDecision() {
    return playerDecision;
  }

  void playerDecisions() {
    System.out.print("\n" + playerName + ", what do you want to do: ");
    playerDecision = in.nextLine();
    playerDecision = playerDecision.toLowerCase();
  }

  void playerNameInput() {
    System.out.print("Warrior! Whats your name: ");
    playerName = in.nextLine();
    playerName = playerName.toUpperCase();
    System.out.println("\nGrab your sword and lets go!!");
    newLoc = "\n" + playerName + ", You walked into a new location!";
    cantGo = "\nyou can't go that way";
  }

  void movementNorth() {
    if (currentRoom.getNorth() != null) {
      System.out.println(newLoc);
      currentRoom = currentRoom.getNorth();
    } else {
      System.out.println(cantGo);
    }
  }

  void movementSouth() {
    if (currentRoom.getSouth() != null) {
      System.out.println(newLoc);
      currentRoom = currentRoom.getSouth();
    } else {
      System.out.println(cantGo);
    }
  }

  void movementWest() {
    if (currentRoom.getWest() != null) {
      System.out.println(newLoc);
      currentRoom = currentRoom.getWest();
    } else {
      System.out.println(cantGo);
    }
  }

  void movementEast() {
    if (currentRoom.getEast() != null) {
      System.out.println(newLoc);
      currentRoom = currentRoom.getEast();
    } else {
      System.out.println(cantGo);
    }
  }

  void look() {
    System.out.println("\n" + currentRoom + currentRoom.getItemsDescription());
  }

  void answer() {
    playerAnswer = in.nextLine();
    playerAnswer = playerAnswer.toLowerCase();
  }

  void takeItem(ItemClass item) {
    //TODO Make this a list where you can write number or name of item instead!! But now we can pick up items and store them in inventory.
    System.out.print("Do you want to take: " + item.getName() + "\nYes or No?: ");
    answer();
    switch (playerAnswer) {
      case "yes", "y" -> {
        addItemPlayer(item);
        System.out.println("You took: " + item.getName());
        take();
      }
      case "no", "n" -> System.out.println("You left the " + item.getName() + " here.");
    }
  }

  void take() {
    if (currentRoom.itemsRoom.size() == 0) {
      System.out.println("\nThere are no items here!");
    } else {
      System.out.println("Those are the items here: \n" + currentRoom.showItemsListRoom());

      for (int i = 0; i < currentRoom.itemsRoom.size(); i++) {
        takeItem(currentRoom.itemsRoom.get(i));
      }
    }
  }

  void dropItem(ItemClass item) {
    //TODO Make this a list where you can write number or name of item instead!! But now we can drop items.
    System.out.print("\nShould this item be dropped: " + item.getName() + " \nYes or No?: ");
    answer();
    switch (playerAnswer) {
      case "yes", "y" -> {
        removeItemPlayer(item);
        System.out.println("You dropped: " + item.getName());
        drop();
      }
      case "no", "n" -> System.out.println("");
    }

  }

  void drop() {
    if (inventory.size() == 0) {
      System.out.println("\nYour inventory is empty!");
    } else {
      for (ItemClass itemClass : inventory) {
        showInventoryList();
        System.out.println("Do you want to drop this item: " + itemClass.getName());
        dropItem(itemClass);
      }
    }
  }

  void showInventoryList() {
    int count = 1;

    if (inventory.size() == 0) {
      System.out.println("\nYour inventory is empty");
    } else {
      String s = "";
      for (ItemClass itemClass : inventory) {
        s = s + "[" + count + "] " + itemClass.getName() + "\n";
        count++;
      }
      System.out.println("\nINVENTORY: \n");
      System.out.println(s);
    }
  }

  void addItemPlayer(ItemClass item) {
    inventory.add(item);
    currentRoom.itemsRoom.remove(item);
  }

  void removeItemPlayer(ItemClass item) {
    inventory.remove(item);
    currentRoom.itemsRoom.add(item);
  }
}