public class Game {

  UserInterface ui = new UserInterface();
  Map map = new Map();
  Player player = new Player();

  void run() {
    boolean gameRunning = true;

    map.createRooms();
    player.setCurrentRoom(map.getStartRoom());
    ui.gameStartUp();
    ui.printMain();
    mainMenu();
    while (gameRunning) {
      playerDecisionsSwitch();
    }
    ui.exit();
  }

  void mainMenu() {
    ui.getCommand();
    switch (ui.getDecision()) {
      case "start", "s" -> player.playerNameInput();
      case "exit", "e" -> ui.exit();
      default -> ui.invalidAnswer();
    }
  }

  void playerDecisionsSwitch() {
    player.playerDecisions();
    switch (player.getPlayerDecision()) {
      case "look", "l" -> player.look();
      case "go north", "north", "go n", "n" -> player.movementNorth();
      case "go south", "south", "go s", "s" -> player.movementSouth();
      case "go west", "west", "go w", "w" -> player.movementWest();
      case "go east", "east", "go e", "e" -> player.movementEast();
      case "take", "t" -> player.take();
      case "drop", "d" -> player.drop();
      case "inventory", "i" -> player.showInventoryList();
      case "help", "h" -> ui.helpText();
      case "exit" -> ui.exit();
      default -> ui.invalidAnswer();
    }
  }
}