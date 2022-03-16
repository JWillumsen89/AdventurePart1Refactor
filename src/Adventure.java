import java.io.IOException;
import java.util.Scanner;

public class Adventure {
  private Room currentRoom;
  private String playerName;
  Scanner in = new Scanner(System.in);
  private boolean gameRunning = true;
  //Environment environment = new Environment();


  public static void main(String[] args) throws IOException {
    new Adventure().go();
  }

  void go() throws IOException {
    createRooms();
    gameStartUp();
    mainMenu();
    while (gameRunning) {
      userInterface();
    }
  }

  void createRooms() throws IOException {
    String name;
    String description;
    //gameStartUp();

    //Room1
    name = "CAVE ENTRANCE";
    description = """
        You have entered a dark cage with water dripping from the ceiling, shiny eyes in the distance from, what seems like hundreds of small animals, bats maybe!
        There is also some noise, a distant growling and something that sounds like footsteps, but hard to tell what this is and where its coming from.""";
    //description = environment.descripRoom1();
    Room room1 = new Room(name, description);

    //Room 2
    name = "SMALL PATH";
    description = """
        Spiderwebs everywhere and you cant barely see anything in the dark.
        You are also stepping in something that seems to be sticking to you boots. Mud, blood or something else disgusting.
        Goosebumps suddenly wanders all over your buddy, a scream from something erupts from something or someone in the distance!""";
    //description = environment.descripRoom2();
    Room room2 = new Room(name, description);

    //Room 3
    name = "DUGOUT AREA";
    description = """
        A small torch, hanging from the wall, brings a little bit of light to this weird, dugout room.
        Rats screaming and running away from almost every small corner or hidden place and leave you with brief silence.
        Theres a small oddly looking table, containing the rest of what seems to have been someones lunch and very small leather bag, someone left in hurry!.
        After looking a round, the silence gets interrupted by the same distant growling you have been hearing earlier""";
    //description = environment.descripRoom3();
    Room room3 = new Room(name, description);

    //Room 4
    name = "SLOPE INTO THE DARK";
    description = """
        A steep slope where lots of bats are staring at you from the ceiling!
        Small ticking noise are coming from the scorpions crawling on the walls.
        There is a weird smell here, rot, death and something you cant describe""";
    //description = environment.descripRoom4();
    Room room4 = new Room(name, description);

    //Room 5
    name = "CEREMONIAL ROOM";
    description = """
        You entered a ceremonial room!
        Suddenly a loud smash and roar surprises you!!! A crazy looking beast, with shiny yellow eyes, just threw a bust of some sort after you and roared!
        It runs towards you and throws across the room.
        Back on your feet, you grab your weapon and prepare for a hard fight""";
    //description = environment.descripRoom5();
    Room room5 = new Room(name, description);

    //Room 6
    name = "WATERFALL";
    description = """
        Water erupting from a small crack in the ceiling creates a small pond that seems to be continuing into a small stream that disappears through the crack in the cave floor.
        By the water there a very oddly skeleton, that thankfully is not alive. Because those pointer teeth and sharp claws, must have injured somebody badly.
        Thorn fabric and a dagger is beside it. Someone barely escaped this still alive.""";
    //description = environment.descripRoom6();
    Room room6 = new Room(name, description);

    //Room 7
    name = "SKELETON ROOM";
    description = """
        DEATH! Lots of kills have been committed here! Skeletons all around, centipedes crawling in and out of nearby skull and the disgusting smell is making it hard to breath!
        Bones are breaking because you cant take a step without stepping on them.
        Then!! Goosebumps hits you when you suddenly hear a roar from deeper within the cave.""";
    //description = environment.descripRoom7();
    Room room7 = new Room(name, description);

    //Room 8
    name = "CAVE AND CAGES";
    description = """
        Everything suddenly changes.
        This area is nicely dugout, there is monuments, torches that light up the room and cages.
        But something is off, some of the monuments are smashed, claws marks, old blood marks and a weird quite atmosphere.
        In the corner is a big cage, broken, smashed actually! Something big was here!""";
    //description = environment.descripRoom8();
    Room room8 = new Room(name, description);

    //Room 9
    name = "STAIRWAY";
    description = """
        Man made creepy stairs!
        Very slippery and small.""";
    //description = environment.descripRoom9();
    Room room9 = new Room(name, description);


    //room 1
    room1.setNorth(null);
    room1.setEast(room2);
    room1.setSouth(room4);
    room1.setWest(null);

    //room 2
    room2.setNorth(null);
    room2.setSouth(null);
    room2.setWest(room1);
    room2.setEast(room3);

    //room 3
    room3.setNorth(null);
    room3.setEast(null);
    room3.setWest(room2);
    room3.setSouth(room6);

    //room 4
    room4.setEast(null);
    room4.setWest(null);
    room4.setNorth(room1);
    room4.setSouth(room7);

    //room 5
    room5.setNorth(null);
    room5.setWest(null);
    room5.setEast(null);
    room5.setSouth(room8);

    //room 6
    room6.setEast(null);
    room6.setWest(null);
    room6.setNorth(room3);
    room6.setSouth(room9);

    //room 7
    room7.setWest(null);
    room7.setSouth(null);
    room7.setNorth(room4);
    room7.setEast(room8);

    //room 8
    room8.setSouth(null);
    room8.setWest(room7);
    room8.setNorth(room5);
    room8.setEast(room9);

    //room 9
    room9.setEast(null);
    room9.setSouth(null);
    room9.setWest(room8);
    room9.setNorth(room6);

    currentRoom = room1;
  }

  void gameStartUp() {
    System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tWELCOME TO: ");
    System.out.println("""
         _______  _______ _________ _______  _______        _______  ______            _______  _       _________          _______  _______\s
        (  ____ )(  ____ \\\\__   __/(  ____ )(  ___  )      (  ___  )(  __  \\ |\\     /|(  ____ \\( (    /|\\__   __/|\\     /|(  ____ )(  ____ \\
        | (    )|| (    \\/   ) (   | (    )|| (   ) |      | (   ) || (  \\  )| )   ( || (    \\/|  \\  ( |   ) (   | )   ( || (    )|| (    \\/
        | (____)|| (__       | |   | (____)|| |   | |      | (___) || |   ) || |   | || (__    |   \\ | |   | |   | |   | || (____)|| (__   \s
        |     __)|  __)      | |   |     __)| |   | |      |  ___  || |   | |( (   ) )|  __)   | (\\ \\) |   | |   | |   | ||     __)|  __)  \s
        | (\\ (   | (         | |   | (\\ (   | |   | |      | (   ) || |   ) | \\ \\_/ / | (      | | \\   |   | |   | |   | || (\\ (   | (     \s
        | ) \\ \\__| (____/\\   | |   | ) \\ \\__| (___) |      | )   ( || (__/  )  \\   /  | (____/\\| )  \\  |   | |   | (___) || ) \\ \\__| (____/\\
        |/   \\__/(_______/   )_(   |/   \\__/(_______)      |/     \\|(______/    \\_/   (_______/|/    )_)   )_(   (_______)|/   \\__/(_______/""");

    helpText();
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
      case "exit", "e" -> exit();
      default -> {
        invalidAnswer();
        mainMenu();
      }
    }
  }

  void playerName() {
    System.out.print("Warrior! Whats your name: ");
    playerName = in.nextLine();
    playerName = playerName.toUpperCase();
  }

  void helpText() {
    System.out.println("""
                
        Throughout the game you can write the following commands:
                
        look      = Looking around at the current location
        go east   = Moves player towards east
        go west   = Moves player towards west
        go north  = Moves player towards north
        go south  = Moves player towards south
        help      = Opens help menu
        exit      = Game terminates
                
        """);

  }

  void helpMenu() {
    System.out.println("\nHelp menu:");
    helpText();
    System.out.println("""
        Return to Game [game]
        Return to Main menu [main]
        Exit Game [exit]""");
    System.out.print("\nEnter decision:");
    String helpMenuDecision = in.nextLine();
    helpMenuDecision = helpMenuDecision.toLowerCase();
    switch (helpMenuDecision) {
      case "game", "g" -> userInterface();
      case "main", "m" -> mainMenu();
      case "exit", "e" -> exit();
      default -> invalidAnswer();
    }
  }

  void exit() {

    System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tTHANK YOU FOR PLAYING: ");
    System.out.println("""
         _______  _______ _________ _______  _______        _______  ______            _______  _       _________          _______  _______\s
        (  ____ )(  ____ \\\\__   __/(  ____ )(  ___  )      (  ___  )(  __  \\ |\\     /|(  ____ \\( (    /|\\__   __/|\\     /|(  ____ )(  ____ \\
        | (    )|| (    \\/   ) (   | (    )|| (   ) |      | (   ) || (  \\  )| )   ( || (    \\/|  \\  ( |   ) (   | )   ( || (    )|| (    \\/
        | (____)|| (__       | |   | (____)|| |   | |      | (___) || |   ) || |   | || (__    |   \\ | |   | |   | |   | || (____)|| (__   \s
        |     __)|  __)      | |   |     __)| |   | |      |  ___  || |   | |( (   ) )|  __)   | (\\ \\) |   | |   | |   | ||     __)|  __)  \s
        | (\\ (   | (         | |   | (\\ (   | |   | |      | (   ) || |   ) | \\ \\_/ / | (      | | \\   |   | |   | |   | || (\\ (   | (     \s
        | ) \\ \\__| (____/\\   | |   | ) \\ \\__| (___) |      | )   ( || (__/  )  \\   /  | (____/\\| )  \\  |   | |   | (___) || ) \\ \\__| (____/\\
        |/   \\__/(_______/   )_(   |/   \\__/(_______)      |/     \\|(______/    \\_/   (_______/|/    )_)   )_(   (_______)|/   \\__/(_______/""");

    gameRunning = false;
  }

  void invalidAnswer() {
    System.out.println("\nYOU ENTERED AN INVALID ANSWER!! TRY AGAIN");

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
      case "help", "h" -> helpMenu();
      case "exit" -> exit();
      default -> invalidAnswer();
    }
  }
}
