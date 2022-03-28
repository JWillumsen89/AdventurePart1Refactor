public class Game {

  private boolean gameRunning = true;

  UserInterface ui = new UserInterface();
  Map map = new Map();
  Player player = new Player();

  void run() {
    map.createRooms();
    player.setCurrentRoom(map.getStartRoom());
    ui.gameStartUp();
    ui.printMain();
    mainMenu();
    while (gameRunning && player.isPlayerAlive()) {
      playerDecisionsSwitch();
    }
    if (!player.isPlayerAlive()) {
      ui.gameOver();
      ui.exit();
    } else if (gameRunning) {
      ui.winner();
      ui.exit();
    } else
      ui.exit();
  }

  void mainMenu() {
    ui.getCommand();
    switch (ui.getDecision()) {
      case "start", "s" -> player.playerNameInput();
      case "exit", "e" -> {
        ui.exit();
        gameRunning = false;
      }
      default -> {
        ui.invalidAnswer();
        System.out.println("");
        ui.printMain();
        mainMenu();
      }
    }
  }

  void playerDecisionsSwitch() {
    player.playerDecisions();
    switch (player.getPlayerDecision()) {
      case "go north", "north", "go n", "n" -> player.movement(Direction.NORTH);
      case "go south", "south", "go s", "s" -> player.movement(Direction.SOUTH);
      case "go west", "west", "go w", "w" -> player.movement(Direction.WEST);
      case "go east", "east", "go e", "e" -> player.movement(Direction.EAST);
      case "looking", "look", "l" -> player.look();
      case "searching", "search" -> player.search();
      case "eat" -> player.eat(player, player.answer("What do want to eat: "));
      case "drink" -> player.drink(player, player.answer("What do you want to drink: "));
      case "health" -> player.health();
      case "take item", "take", "t" -> player.take(player, player.takeAnswer("What do you want to take: "));
      case "drop item", "drop", "d" -> player.drop(player, player.answer("What do you want to drop: "));
      case "inventory", "i" -> player.showInventoryList();
      case "help me", "help", "h" -> ui.helpText();
      case "exit" -> {
        ui.exit();
        gameRunning = false;
      }
      default -> ui.invalidAnswer();
    }
  }
}