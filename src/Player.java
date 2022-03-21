import java.util.ArrayList;
import java.util.Scanner;

public class Player {
  private Room currentRoom;
  private String playerName;
  private String playerDecision;
  private String newLoc = "\nYou walked into a new location!";
  private String cantGo = "\nyou can't go that way";
  private String playerAnswer;
  private ArrayList<ItemClass> inventory = new ArrayList<>();
  private Scanner in = new Scanner(System.in);

  void setCurrentRoom(Room currentRoom) {
    this.currentRoom = currentRoom;
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

  String takeAnswer() {
    System.out.print("\nWhat do you want to take: ");
    playerAnswer = in.nextLine();
    playerAnswer = playerAnswer.toLowerCase();
    return playerAnswer;
  }

  String dropAnswer() {
    showInventoryList();
    System.out.print("What do you want to drop: ");
    playerAnswer = in.nextLine();
    playerAnswer = playerAnswer.toLowerCase();
    return playerAnswer;
  }

  public ArrayList<ItemClass> getInventory() {
    return inventory;
  }

  public void take(Player player, String itemName) {
    if (itemName == null) {
      System.out.println("Sorry but there isn´t an item named" + itemName + " in the room");
      return;
    }

    for (ItemClass item : currentRoom.getItemsRoom()) {
      if (item.getName().equalsIgnoreCase(itemName) || item.getDescription().equalsIgnoreCase(itemName)) {
        player.addItemPlayer(item);
        System.out.println("Added " + itemName + " to inventory");
        return;
      }
    }
    System.out.println("Sorry but there isn´t an item named " + itemName + " in the room");
  }

  public void drop(Player player, String itemName) {
    if (itemName == null) {
      System.out.println("You need to specify which Item you want to drop!");
      return;
    }

    for (ItemClass item : player.getInventory()) {
      if (item.getName().equalsIgnoreCase(itemName) || item.getDescription().equalsIgnoreCase(itemName)) {
        player.removeItemPlayer(item);
        System.out.println("Removed " + itemName + " from your inventory");
        return;
      }
    }
    System.out.println("You need to specify which Item you want to drop! ");
  }

  void addItemPlayer(ItemClass item) {
    inventory.add(item);
    currentRoom.removeItems(item);
  }

  void removeItemPlayer(ItemClass item) {
    inventory.remove(item);
    currentRoom.addItems(item);
  }

  void showInventoryList() {
    if (inventory.size() == 0) {
      System.out.println("\nYour inventory is empty");
    } else {
      String s = "";
      for (ItemClass itemClass : inventory) {
        s = s + itemClass.getName() + "\n";
      }
      System.out.println("\nINVENTORY: \n");
      System.out.println(s);
    }
  }
}