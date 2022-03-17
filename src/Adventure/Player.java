package Adventure;

import Adventure.Game;

import java.util.Scanner;

public class Player {
    private Room currentRoom;
    private String playerName;
    Scanner in = new Scanner(System.in);

    String newLoc = "\n" + playerName + ", You walked into a new location!";
    String cantGo = "you can't go that way";



    void playerName() {
        System.out.print("Warrior! Whats your name: ");
        playerName = in.nextLine();
        playerName = playerName.toUpperCase();
      }

    void north() {

        if (currentRoom.getNorth() != null) {
            System.out.println(newLoc);
            currentRoom = currentRoom.getNorth();
        } else {
            System.out.println(cantGo);
        }
    }

    void south() {

            if (currentRoom.getSouth() != null) {
                System.out.println(newLoc);
                currentRoom = currentRoom.getSouth();
            } else {
                System.out.println(cantGo);
            }
        }


    void west() {

            if (currentRoom.getWest() != null) {
                System.out.println(newLoc);
                currentRoom = currentRoom.getWest();
            } else {
                     System.out.println(cantGo);
                     }
    }


    void east() {

            if (currentRoom.getEast() != null) {
                System.out.println(newLoc);
                currentRoom = currentRoom.getEast();

            } else {
                     System.out.println(cantGo);
            }
    }


}

