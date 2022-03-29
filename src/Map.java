//GRASP Creator principle - Map is creator of rooms.
public class Map {

  private Room startRoom;
  private String name;
  private String description;

  Room getStartRoom() {
    return startRoom;
  }

  void createRooms() {
    //Room1
    name = "CAVE ENTRANCE";
    description = """
        You have entered a dark cage with water dripping from the ceiling, shiny eyes in the distance from, what seems like hundreds of small animals, bats maybe!
        There is also some noise, a distant growling and something that sounds like footsteps, but hard to tell what this is and where its coming from.
        """;
    Room room1 = new Room(name, description);
    Item axe = new MeleeWeapon("Axe", "\nThere is an axe here.", 20, 10);
    Item gold = new Gold("Gold", "\nSome small shiny pieces of gold are laying in the corner.", 0, 55);
    Item apple = new Food("Apple", "\nThere is a half eaten, brown apple on the ground.", 2
        , 4, "Not that bad anyway! Added 4 health points");
    Item rabbitSkin = new MiscItems("Rabbit Skin", "\nThe skin of a rabbit, thorn from its body is laying on the ground", 3);
    Enemy orc = new Enemy("Orc", "A big smelly orc is standing and looking right at you", 20);
    room1.addItems(axe);
    room1.addItems(gold);
    room1.addItems(apple);
    room1.addItems(rabbitSkin);
    room1.addEnemy(orc);

    //Room 2
    name = "SMALL PATH";
    description = """
        Spiderwebs everywhere and you cant barely see anything in the dark.
        You are also stepping in something that seems to be sticking to you boots. Mud, blood or something else disgusting.
        Goosebumps suddenly wanders all over your buddy, a scream erupts from something or someone in the far distance!
        """;
    Room room2 = new Room(name, description);
    Item sword = new MeleeWeapon("Sword", "\nThere is a sword here", 18, 9);
    Item poison = new Liquid("Blue Potion", "\nThere is a little flask, containing some blue liquid", 1, -50
        , "POISON!! Your stomach starts to cramp and you pass out for a few seconds. Your health points decreased by 50 points");
    room2.addItems(sword);
    room2.addItems(poison);

    //Room 3
    name = "DUGOUT AREA";
    description = """
        A small torch, hanging from the wall, brings a little bit of light to this weird, dugout room.
        Rats screaming and running away from almost every small corner or hidden place and leave you with brief silence.
        Theres a small oddly looking table, containing the rest of what seems to have been someones lunch and very small leather bag, someone left in a hurry!.
        After looking a round, the silence gets interrupted by the same distant growling you have been hearing earlier
        """;
    Room room3 = new Room(name, description);
    Item shield = new Armor("Shield", "\nThere is a shield here", 17, 10);
    Item leatherPouch = new Gold("Leather pouch", "\nThere is brown little leather, looks like it is containing something"
        , 4, 100);
    room3.addItems(shield);
    room3.addItems(leatherPouch);

    //Room 4
    name = "SLOPE INTO THE DARK";
    description = """
        A steep slope where lots of bats are staring at you from the ceiling!
        Small ticking noise are coming from the scorpions crawling on the walls.
        There is a weird smell here, rot, death and something you cant describe
        """;
    Room room4 = new Room(name, description);
    Item spear = new MeleeWeapon("Spear", "\nThere is a spear here", 21, 13);
    Item stones = new RangedWeapon("Stones", "\nA small pile of stones are on the ground, they might be good for throwing", 7
        , 3, 6);
    room4.addItems(spear);
    room4.addItems(stones);

    //Room 5
    name = "CEREMONIAL ROOM";
    description = """
        You entered a ceremonial room!
        Suddenly a loud smash and roar surprises you!!! A crazy looking beast, with shiny yellow eyes, just threw a bust of some sort after you and roared!
        It runs towards you and throws across the room.
        Back on your feet, you grab your weapon and prepare for a hard fight
        """;
    Room room5 = new Room(name, description);
    Item excalibur = new MeleeWeapon("Excalibur", "\nHere lies the legendary Excalibur", 30
        , 25);
    room5.addItems(excalibur);

    //Room 6
    name = "WATERFALL";
    description = """
        Water erupting from a small crack in the ceiling creates a small pond that seems to be continuing into a small stream that disappears through the crack in the cave floor.
        By the water there a very oddly skeleton, that thankfully is not alive. Because those pointer teeth and sharp claws, must have injured somebody badly.
        Thorn fabric and a dagger is beside it. Someone barely escaped this still alive.
        """;
    Room room6 = new Room(name, description);
    Item morningstar = new MeleeWeapon("Morningstar", "\nThere is a morningstar here", 25, 12);
    room6.addItems(morningstar);

    //Room 7
    name = "SKELETON ROOM";
    description = """
        DEATH! Lots of kills have been committed here! Skeletons all around, centipedes crawling in and out of nearby skull and the disgusting smell is making it hard to breath!
        Bones are breaking because you cant take a step without stepping on them.
        Then!! Goosebumps hits you when you suddenly hear a roar from deeper within the cave.
        """;
    Room room7 = new Room(name, description);
    Item dagger = new MeleeWeapon("Dagger", "\nThere is a dagger here", 10, 7);
    room7.addItems(dagger);

    //Room 8
    name = "CAVE AND CAGES";
    description = """
        Everything suddenly changes.
        This area is nicely dugout, there is monuments, torches that light up the room and cages.
        But something is off, some of the monuments are smashed, claws marks, old blood marks and a weird quite atmosphere.
        In the corner is a big cage, broken, smashed actually! Something big was here!
        """;
    Room room8 = new Room(name, description);
    Item armor = new Armor("Armor", "\nThere is a suit of armor here", 12, 10);
    Item goldPotion = new Liquid("Gold Potion", "\nA small shine form the corner of the room catches your eyes," +
        " its a small bottle with shiny, golden liquid in it", 1, 60
        , "A sudden heat goes through your body, you feel stronger and ready for battle! 60 health points are added! ");
    room8.addItems(armor);
    room8.addItems(goldPotion);

    //Room 9
    name = "STAIRWAY";
    description = """
        Man made creepy stairs!
        Very slippery and small.
        """;
    Room room9 = new Room(name, description);
    Item hammer = new MeleeWeapon("Hammer", "\nThere is a hammer here", 20, 12);
    room9.addItems(hammer);

    //room 1
    room1.setEast(room2);
    room1.setSouth(room4);

    //room 2
    room2.setWest(room1);
    room2.setEast(room3);

    //room 3
    room3.setWest(room2);
    room3.setSouth(room6);

    //room 4
    room4.setNorth(room1);
    room4.setSouth(room7);

    //room 5
    room5.setSouth(room8);

    //room 6
    room6.setNorth(room3);
    room6.setSouth(room9);

    //room 7
    room7.setNorth(room4);
    room7.setEast(room8);

    //room 8
    room8.setWest(room7);
    room8.setNorth(room5);
    room8.setEast(room9);

    //room 9
    room9.setWest(room8);
    room9.setNorth(room6);

    startRoom = room1;
  }
}