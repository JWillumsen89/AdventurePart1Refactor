import java.io.IOException;
import java.util.Scanner;

public class Game {
  private Room currentRoom;
  private String playerName;
  Scanner in = new Scanner(System.in);
  private boolean gameRunning = true;
  //Environment environment = new Environment();
  UserInterface ui = new UserInterface();
  Map map = new Map();

  void go() throws IOException {
    map.createRooms();
    currentRoom = map.getStartRoom();
    ui.gameStartUp();
    mainMenu();
    while (gameRunning) {
      userInterface();
    }
  }

  void mainMenu() {
    System.out.println("Main menu: \n");
    System.out.println("Start game [start]");
    System.out.println("Exit game [exit]");
    System.out.print("\nEnter decision: ");
    String decision = in.nextLine();
    decision = decision.toLowerCase();

    switch (decision) {
      case "start", "s" -> {
        playerName();
        System.out.println("\nGrab your sword and lets go!!");
        userInterface();
      }
      case "exit", "e" -> ui.exit();
      default -> {
        ui.invalidAnswer();
        mainMenu();
      }
    }
  }

  void playerName() {
    System.out.print("Warrior! Whats your name: ");
    playerName = in.nextLine();
    playerName = playerName.toUpperCase();
  }

  void userInterface() {
    String newLoc = "\n" + playerName + ", You walked into a new location!";
    String cantGo = "you can't go that way";

    System.out.print("\n" + playerName + ", what do you want to do: ");
    String playerDecision = in.nextLine();
    playerDecision = playerDecision.toLowerCase();
    switch (playerDecision) {
      case "look", "l" -> System.out.println("\n" + currentRoom);
      case "go north", "north", "go n", "n" -> {
        if (currentRoom.getNorth() != null) {
          System.out.println(newLoc);
          currentRoom = currentRoom.getNorth();
        } else {
          System.out.println(cantGo);
        }
      }
      case "go south", "south", "go s", "s" -> {
        if (currentRoom.getSouth() != null) {
          System.out.println(newLoc);
          currentRoom = currentRoom.getSouth();
        } else {
          System.out.println(cantGo);
        }
      }
      case "go west", "west", "go w", "w" -> {
        if (currentRoom.getWest() != null) {
          System.out.println(newLoc);
          currentRoom = currentRoom.getWest();
        } else {
          System.out.println(cantGo);
        }
      }
      case "go east", "east", "go e", "e" -> {
        if (currentRoom.getEast() != null) {
          System.out.println(newLoc);
          currentRoom = currentRoom.getEast();
        } else {
          System.out.println(cantGo);
        }
      }
      case "help", "h" -> ui.helpMenu();
      case "exit" -> ui.exit();
      default -> ui.invalidAnswer();
    }
  }
}

