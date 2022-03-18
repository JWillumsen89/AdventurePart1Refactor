import java.io.IOException;
import java.util.Scanner;

public class Game {

  final Scanner in = new Scanner(System.in);
  final UserInterface ui = new UserInterface();
  final Map map = new Map();
  Player player = new Player();
  private char command;

  void run() {
    boolean gameRunning = true;

    map.createRooms();
    player.setCurrentRoom(map.getStartRoom());
    ui.gameStartUp();
    ui.printMain();
    mainMenu();
    while (gameRunning) {
      playerDecisions();
    }
    ui.exit();

  }

  void mainMenu() {
    String decision = ui.getCommand();
    switch (decision) {
      case "start", "s" -> {
        player.playerNameInput();
        System.out.println("\nGrab your sword and lets go!!");
      }
      case "exit", "e" -> ui.exit();
      default -> ui.invalidAnswer();
    }
  }

  void playerDecisions() {
    System.out.print("\n" + player.getPlayerName() + ", what do you want to do: ");
    String playerDecision = in.nextLine();
    playerDecision = playerDecision.toLowerCase();
    switch (playerDecision) {
      case "look", "l" -> System.out.println("\n" + player.getCurrentRoom()); //TODO Print currentRoom
      case "go north", "north", "go n", "n" -> {
        command = 'n';
        player.movement(command);
      }
      case "go south", "south", "go s", "s" -> {
        command = 's';
        player.movement(command);
      }
      case "go west", "west", "go w", "w" -> {
        command = 'w';
        player.movement(command);
      }
      case "go east", "east", "go e", "e" -> {
        command = 'e';
        player.movement(command);
      }
      case "help", "h" -> ui.helpText();
      case "exit" -> ui.exit();
      default -> ui.invalidAnswer();
    }
  }
}

