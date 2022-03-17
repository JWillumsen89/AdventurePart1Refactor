package Adventure;

import java.util.Scanner;

public class UserInterface {
  final Scanner in = new Scanner(System.in);


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

  boolean helpMenu() {
    boolean helpMenuBoolean = true;
    System.out.println("\nHelp menu:");
    helpText();
    while (helpMenuBoolean) {
      System.out.println("""
          Return to Game [game]
          Return to Main menu [main]
          Exit Game [exit]""");
      System.out.print("\nEnter decision: ");
      String helpMenuDecision = in.nextLine();
      helpMenuDecision = helpMenuDecision.toLowerCase();
      switch (helpMenuDecision) {
        case "game", "g" -> helpMenuBoolean = false;
        case "main", "m" -> {
          //helpMenu = false;
          return false;
        }
        case "exit", "e" -> exit();
        default -> invalidAnswer();
      }
    }
    return true; //True if "m" is not picked.
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


    System.exit(0);
  }

  void invalidAnswer() {
    System.out.println("\nYOU ENTERED AN INVALID ANSWER!! TRY AGAIN");

  }
}
