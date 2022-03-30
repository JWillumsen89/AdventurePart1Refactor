import java.util.Scanner;

public class UserInterface {

  private String decision;
  private Scanner in = new Scanner(System.in);

  String getDecision() {
    return decision;
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

  String getCommand() {
    decision = in.nextLine();
    decision = decision.toLowerCase();

    return decision;
  }

  void printMain() {
    System.out.print("""
        Main menu:
        Start game [start]
        Exit game [exit]
        """);

    System.out.print("\nEnter decision: ");
  }

  void helpText() {
    System.out.println("""
        
        Throughout the game you can write the following commands:
                
        go east, east, go e, e    = Moves player towards east
        go west, west, go w, w    = Moves player towards west
        go north, north, go n, n  = Moves player towards north
        go south, south, go s, s  = Moves player towards south
        attack, a                 = Attack enemy/enemies
        looking, look, l          = Looking around at the current location
        searching, search, se     = Searching for items.
        eat                       = Eat food items.
        drink, d                  = Drink liquid items.
        health, hh                = Shows your health status.
        equip, ep                 = Equip weapon from inventory
        take item, take, t        = Take items in the room
        drop item, drop, di       = Drop items you have collected
        inventory, i              = Shows your inventory
        help me, help, h          = Opens help menu
        exit                      = Exit game
                
        """);
  }

  void exit() {
    System.out.println("""
                                                             THANK YOU FOR PLAYING:
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

  void gameOver() {
    System.out.println("\nGAME OVER");
  }

  void winner() {
    System.out.println("YOU SURVIVED THIS ADVENTURE!");
  }
}