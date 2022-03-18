//GRASP Creator principle - Map is creator of rooms.
public class Map {

  private Room startRoom;

  Room getStartRoom() {
    return startRoom;
  }

  void createRooms() {
    String name;
    String description;

    //Room1
    name = "CAVE ENTRANCE";
    description = """
        You have entered a dark cage with water dripping from the ceiling, shiny eyes in the distance from, what seems like hundreds of small animals, bats maybe!
        There is also some noise, a distant growling and something that sounds like footsteps, but hard to tell what this is and where its coming from.""";
    Room room1 = new Room(name, description);
    Item axe = new Item("Axe","\nThere is an axe here.");
    room1.addItems(axe);

    //Room 2
    name = "SMALL PATH";
    description = """
        Spiderwebs everywhere and you cant barely see anything in the dark.
        You are also stepping in something that seems to be sticking to you boots. Mud, blood or something else disgusting.
        Goosebumps suddenly wanders all over your buddy, a scream from something erupts from something or someone in the distance!""";
    Room room2 = new Room(name, description);
    Item sword = new Item("Sword","\nThere is a sword here");
    room2.addItems(sword);

    //Room 3
    name = "DUGOUT AREA";
    description = """
        A small torch, hanging from the wall, brings a little bit of light to this weird, dugout room.
        Rats screaming and running away from almost every small corner or hidden place and leave you with brief silence.
        Theres a small oddly looking table, containing the rest of what seems to have been someones lunch and very small leather bag, someone left in a hurry!.
        After looking a round, the silence gets interrupted by the same distant growling you have been hearing earlier""";
    Room room3 = new Room(name, description);
    Item shield = new Item("Shield","\nThere is a shield here");
    room3.addItems(shield);

    //Room 4
    name = "SLOPE INTO THE DARK";
    description = """
        A steep slope where lots of bats are staring at you from the ceiling!
        Small ticking noise are coming from the scorpions crawling on the walls.
        There is a weird smell here, rot, death and something you cant describe""";
    Room room4 = new Room(name, description);
    Item spear = new Item("Spear","\nThere is a spear here");
    room4.addItems(spear);

    //Room 5
    name = "CEREMONIAL ROOM";
    description = """
        You entered a ceremonial room!
        Suddenly a loud smash and roar surprises you!!! A crazy looking beast, with shiny yellow eyes, just threw a bust of some sort after you and roared!
        It runs towards you and throws across the room.
        Back on your feet, you grab your weapon and prepare for a hard fight""";
    Room room5 = new Room(name, description);
    Item hammer = new Item("hammer","\nThere is a hammer here");
    room5.addItems(hammer);

    //Room 6
    name = "WATERFALL";
    description = """
        Water erupting from a small crack in the ceiling creates a small pond that seems to be continuing into a small stream that disappears through the crack in the cave floor.
        By the water there a very oddly skeleton, that thankfully is not alive. Because those pointer teeth and sharp claws, must have injured somebody badly.
        Thorn fabric and a dagger is beside it. Someone barely escaped this still alive.""";
    Room room6 = new Room(name, description);
    Item morningstar = new Item("Morningstar","\nThere is an morningstar here");
    room6.addItems(morningstar);

    //Room 7
    name = "SKELETON ROOM";
    description = """
        DEATH! Lots of kills have been committed here! Skeletons all around, centipedes crawling in and out of nearby skull and the disgusting smell is making it hard to breath!
        Bones are breaking because you cant take a step without stepping on them.
        Then!! Goosebumps hits you when you suddenly hear a roar from deeper within the cave.""";
    Room room7 = new Room(name, description);
    Item dagger = new Item("dagger","\nThere is a dagger here");
    room7.addItems(dagger);

    //Room 8
    name = "CAVE AND CAGES";
    description = """
        Everything suddenly changes.
        This area is nicely dugout, there is monuments, torches that light up the room and cages.
        But something is off, some of the monuments are smashed, claws marks, old blood marks and a weird quite atmosphere.
        In the corner is a big cage, broken, smashed actually! Something big was here!""";
    Room room8 = new Room(name, description);
    Item armor = new Item("Armor","\nThere is a suit of armor here");
    room8.addItems(armor);

    //Room 9
    name = "STAIRWAY";
    description = """
        Man made creepy stairs!
        Very slippery and small.""";
    Room room9 = new Room(name, description);
    Item excalibur = new Item("Excalibur","\nHere lies the legendary Excalibur");
    room9.addItems(excalibur);


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

    startRoom = room1;
  }
}
