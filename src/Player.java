import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Player {

  private Room currentRoom;
  private String playerName;
  private String playerDecision;
  private String newLoc = "\nYou walked into a new location!";
  private String cantGo = "\nyou can't go that way";
  private String playerAnswer;
  private int goldAmount = 0;
  private int healthAmount = 100;
  private int playerAttackDamage = 0;
  private boolean playerAlive = true;
  private Weapon equippedWeapon = null;
  private ArrayList<Item> inventory = new ArrayList<>();
  private Scanner in = new Scanner(System.in);

  public boolean isPlayerAlive() {
    return this.playerAlive;
  }

  public ArrayList<Item> getInventory() {
    return inventory;
  }

  public void setCurrentRoom(Room currentRoom) {
    this.currentRoom = currentRoom;
  }

  public String getPlayerDecision() {
    return playerDecision;
  }

  public void playerDecisions() {
    System.out.print("\n" + playerName + ", what do you want to do: ");
    playerDecision = in.nextLine();
    playerDecision = playerDecision.toLowerCase();
  }

  public void playerNameInput() {
    System.out.print("Warrior! Whats your name: ");
    playerName = in.nextLine();
    playerName = playerName.toUpperCase();
    System.out.println("\nGrab your sword and lets go!!");
  }

  public void movement(Direction direction) {
    Room weWantToGo = null;

    if (direction == Direction.NORTH)
      weWantToGo = currentRoom.getNorth();
    else if (direction == Direction.EAST)
      weWantToGo = currentRoom.getEast();
    else if (direction == Direction.WEST)
      weWantToGo = currentRoom.getWest();
    else if (direction == Direction.SOUTH)
      weWantToGo = currentRoom.getSouth();

    if (weWantToGo != null) {
      currentRoom = weWantToGo;
      System.out.println(newLoc);
    } else {
      System.out.println(cantGo);
    }
  }

  public void attack(Player player, String attackWhichEnemy) {
    System.out.println("Test");

    if (attackWhichEnemy == null) {
      System.out.println("You didnt type anything that's possible to attack.");
      return;
    }

    for (Enemy enemy : currentRoom.getEnemiesRoom()) {
      if (enemy.getName().equalsIgnoreCase(attackWhichEnemy)) {
        if (attackWhichEnemy instanceof Enemy) {
          System.out.println("you did damage");
          return;
        }
      }
      System.out.println("Sorry but there isn´t an enemy named" + attackWhichEnemy + " in this room");
    }
  }

  public void look() {
    System.out.println("\n" + currentRoom);
    //System.out.println("\n" + currentRoom + currentRoom.getItemsDescription());
  }

  public void search() {
    System.out.println(currentRoom.getItemsDescription());
  }

  public String inventoryAnswer(String message) {
    showInventoryList();
    if (inventory.size() != 0) {
      System.out.println("\n" + message);
      playerAnswer = in.nextLine().toLowerCase(Locale.ROOT);
    } else {
      System.out.println("");
    }
    return playerAnswer;
  }

  public String answer(String message) {
    System.out.print("\n" + message);
    playerAnswer = in.nextLine().toLowerCase(Locale.ROOT);
    return playerAnswer;
  }

  public void deadOrAlive() {
    if (healthAmount <= 0)
      playerAlive = false;
  }

  public void eat(Player player, String itemName) {

    if (itemName == null) {
      System.out.println("Lets move on");
      return;
    }

    for (Item item : player.inventory) {
      if (item instanceof Food) {
        if (item.getName().equalsIgnoreCase(itemName)) {
          player.consumeItemPlayer((Consumables) item);
          System.out.println("You ate it. [" + itemName + "]");
          System.out.println(((Consumables) item).getGoodOrBad());
          health();
          deadOrAlive();
          return;
        }
      }
    }
    System.out.println("You can't eat that [" + itemName + "]");
  }

  public void drink(Player player, String itemName) {

    if (itemName == null) {
      System.out.println("Lets move on");
      return;
    }

    for (Item item : player.inventory) {
      if (item instanceof Liquid) {
        if (item.getName().equalsIgnoreCase(itemName)) {
          player.consumeItemPlayer((Consumables) item);
          System.out.println("You drank it. [" + itemName + "]");
          System.out.println(((Consumables) item).getGoodOrBad());
          health();
          deadOrAlive();
          return;
        }
      }
    }
    System.out.println("You can't drink that [" + itemName + "]");
  }

  public void take(Player player, String itemName) {

    if (itemName == null) {
      System.out.println("You didnt pick anything");
      return;
    }

    for (Item item : currentRoom.getItemsRoom()) {
      if (item.getName().equalsIgnoreCase(itemName)) {
        if (item instanceof Gold) {
          stashGoldPlayer((Gold) item);
          System.out.println("Added gold to your stash");
          System.out.println("You have: " + goldAmount + " pieces");
          return;
        } else {
          player.addItemPlayer(item);
          System.out.println("Added " + itemName + " to inventory");
          return;
        }
      }
    }
    System.out.println("Sorry but there isn´t an item named" + itemName + " in the room");
  }

  public void drop(Player player, String itemName) {
    if (inventory == null) {
      System.out.println("Lets move on!");
      return;
    }
    for (Item item : player.getInventory()) {
      if (item.getName().equalsIgnoreCase(itemName)) {
        player.removeItemPlayer(item);
        System.out.println("Removed " + itemName + " from your inventory");
        if (item.equals(equippedWeapon))
          playerAttackDamage = playerAttackDamage - equippedWeapon.getAttackPoints();
        System.out.println("You have also un-equip your: " + itemName);
        equippedWeapon = null;
        return;
      }
    }
    System.out.println("That's not something you can drop");
  }

  public void equipWeapon(Player player, String itemName) {
    if (itemName == null) {
      System.out.println("Lets move on");
      return;
    }

    for (Item item : player.inventory) {
      if (item.getName().equalsIgnoreCase(itemName)) {
        if (!(item instanceof Weapon)) {
          System.out.println("You can't equip that.");
        } else if (item instanceof Weapon && equippedWeapon == null) {
          {
            player.equipItemPlayer((Weapon) item);
            System.out.println("You equipped [" + itemName + "]");
          }
        } else if (item instanceof Weapon && equippedWeapon != null) {
          playerAttackDamage = playerAttackDamage - equippedWeapon.getAttackPoints();
          player.equipItemPlayer((Weapon) item);
          System.out.println("You have now equipped: " + itemName + " instead");
          equippedWeapon = (Weapon) item;
        }
      }
    }
    System.out.println("You now deal: " + playerAttackDamage + " damage.");
  }

  public void stashGoldPlayer(Gold item) {
    goldAmount = item.getGoldPoints() + goldAmount;
    currentRoom.removeItems(item);
  }

  public void addItemPlayer(Item item) {
    inventory.add(item);
    currentRoom.removeItems(item);
  }

  public void removeItemPlayer(Item item) {
    inventory.remove(item);
    currentRoom.addItems(item);
  }

  public void consumeItemPlayer(Consumables item) {
    inventory.remove(item);
    healthAmount = item.getHealthPoints() + healthAmount;
    if (healthAmount >= 100)
      healthAmount = 100;
    else if (healthAmount <= 0)
      healthAmount = 0;
  }

  public void equipItemPlayer(Weapon item) {

    equippedWeapon = item;
    playerAttackDamage = playerAttackDamage + item.getAttackPoints();
    //inventory.remove(item);
    //equippedWeapon1.add(item);
  }

  public void health() {
    System.out.println("\nYour health level(0-100): " + healthAmount);

    if (healthAmount > 80)
      System.out.println("You are in good condition right now! Lets kill some beasts");
    else if (healthAmount > 60)
      System.out.println("Starting to feel a bit hungry, start thinking about finding some food");
    else if (healthAmount > 40)
      System.out.println("You need to find food and not fight!");
    else if (healthAmount > 0)
      System.out.println("DANGER DANGER!! GET FOOD NOW!!");
    else
      System.out.println("YOU DIED!!");
  }

  public void showInventoryList() {
    if (inventory.size() == 0) {
      System.out.println("\nYour inventory is empty");
      System.out.println("\nGOLD STASH: " + goldAmount);
    } else {
      String s = "";
      String equipS = "";
      for (Item item : inventory) {
        if (item == equippedWeapon)
          equipS = equipS + item.getName() + "\n";
        else
          s = s + item.getName() + "\n";
      }
      System.out.println("\nINVENTORY:");
      System.out.println(s);
      System.out.println("\nEQUIPPED ITEMS:");
      System.out.println(equipS);
      System.out.println("\nGOLD STASH: " + goldAmount);
    }
  }
}
