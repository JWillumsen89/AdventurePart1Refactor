//GRASP Creator principle - Map is creator of rooms.
public class Map {

  private Room startRoom;
  private Room r1, r2, r3, r4, r5, r6, r7, r8, r9;
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
    r1 = new Room(name, description);

    //Room 2
    name = "SMALL PATH";
    description = """
        Spiderwebs everywhere and you cant barely see anything in the dark.
        You are also stepping in something that seems to be sticking to you boots. Mud, blood or something else disgusting.
        Goosebumps suddenly wanders all over your buddy, a scream erupts from something or someone in the far distance!
        """;
    r2 = new Room(name, description);

    //Room 3
    name = "DUGOUT AREA";
    description = """
        A small torch, hanging from the wall, brings a little bit of light to this weird, dugout room.
        Rats screaming and running away from almost every small corner or hidden place and leave you with brief silence.
        Theres a small oddly looking table, containing the rest of what seems to have been someones lunch and very small leather bag, someone left in a hurry!.
        After looking a round, the silence gets interrupted by the same distant growling you have been hearing earlier
        """;
    r3 = new Room(name, description);

    //Room 4
    name = "SLOPE INTO THE DARK";
    description = """
        A steep slope where lots of bats are staring at you from the ceiling!
        Small ticking noise are coming from the scorpions crawling on the walls.
        There is a weird smell here, rot, death and something you cant describe
        """;
    r4 = new Room(name, description);

    //Room 5
    name = "CEREMONIAL ROOM";
    description = """
        You entered a ceremonial room!
        Nicely decorated, torches burning and some beautiful statues are in the corners of the room.
        One of them is smashed into half and some beast is laying on the floor.
        """;
    r5 = new Room(name, description);

    //Room 6
    name = "WATERFALL";
    description = """
        Water erupting from a small crack in the ceiling creates a small pond that seems to be continuing into a small stream that disappears through the crack in the cave floor.
        By the water there a very oddly skeleton, that thankfully is not alive. Because those pointer teeth and sharp claws, must have injured somebody badly.
        Thorn fabric and a dagger is beside it. Someone barely escaped this still alive.
        """;
    r6 = new Room(name, description);

    //Room 7
    name = "SKELETON ROOM";
    description = """
        DEATH! Lots of kills have been committed here! Skeletons all around, centipedes crawling in and out of nearby skull and the disgusting smell is making it hard to breath!
        Bones are breaking because you cant take a step without stepping on them.
        Then!! Goosebumps hits you when you suddenly hear a roar from deeper within the cave.
        """;
    r7 = new Room(name, description);

    //Room 8
    name = "CAVE AND CAGES";
    description = """
        Everything suddenly changes.
        This area is nicely dugout, there is monuments, torches that light up the room and cages.
        But something is off, some of the monuments are smashed, claws marks, old blood marks and a weird quite atmosphere.
        In the corner is a big cage, broken, smashed actually! Something big was here!
        """;
    r8 = new Room(name, description);

    //Room 9
    name = "STAIRWAY";
    description = """
        Man made creepy stairs!
        Very slippery and small.
        """;
    r9 = new Room(name, description);

    //room 1
    r1.setEast(r2);
    r1.setSouth(r4);

    //room 2
    r2.setWest(r1);
    r2.setEast(r3);

    //room 3
    r3.setWest(r2);
    r3.setSouth(r6);

    //room 4
    r4.setNorth(r1);
    r4.setSouth(r7);

    //room 5
    r5.setSouth(r8);

    //room 6
    r6.setNorth(r3);
    r6.setSouth(r9);

    //room 7
    r7.setNorth(r4);
    r7.setEast(r8);

    //room 8
    r8.setWest(r7);
    r8.setNorth(r5);
    r8.setEast(r9);

    //room 9
    r9.setWest(r8);
    r9.setNorth(r6);

    startRoom = r1;

    addItems();
  }

    //r1
    Item axe = new MeleeWeapon("Axe", "\nThere is an axe here.", 20, 10);
    Item gold = new Gold("Gold", "\nSome small shiny pieces of gold are laying in the corner.", 0, 55);
    Item apple = new Food("Apple", "\nThere is a half eaten, brown apple on the ground.", 2
        , 4, "Not that bad anyway! Added 4 health points");
    Item rabbitSkin = new MiscItems("Rabbit Skin", "\nThe skin of a rabbit, thorn from its body is laying on the ground", 3);
    Enemy orc = new Enemy("Orc", "A big smelly orc is standing and looking right at you", 40,10);
    //r2
    Item sword = new MeleeWeapon("Sword", "\nThere is a sword here", 18, 9);
    Item poison = new Liquid("Blue Potion", "\nThere is a little flask, containing some blue liquid", 1, -50
        , "POISON!! Your stomach starts to cramp and you pass out for a few seconds. Your health points decreased by 50 points");
    Enemy rat = new Enemy("Rat", "A nasty rabies infected rat is crawling around.", 20,3);
    //r3
    Item shield = new Armor("Shield", "\nThere is a shield here", 17, 10);
    Item leatherPouch = new Gold("Leather pouch", "\nThere is brown little leather, looks like it is containing something"
        , 4, 100);
    Enemy goblin = new Enemy("Goblin", "A small, evil goblin, with pointy teeth and yellow eyes are standing in your path.", 25,8);
    //r4
    Item spear = new MeleeWeapon("Spear", "\nThere is a spear here", 21, 13);
    Item stones = new RangedWeapon("Stones", "\nA small pile of stones are on the ground, they might be good for throwing", 7
        , 3, 6);
    Enemy wolf = new Enemy("Wolf", "Howling, showing teeth and raising its neck hair! An evil looking wolf, with blood dripping from its mouth is right in front of you."
        , 30,9);
    //r5
    Item excalibur = new MeleeWeapon("Excalibur", "\nHere lies the legendary Excalibur", 30
        , 25);
    Enemy dragon = new Enemy("Dragon", "A huge dragon is sleeping on the floor, guarding something!", 60,15);
    //r6
    Item morningstar = new MeleeWeapon("Morningstar", "\nThere is a morningstar here", 25, 12);
    Enemy slime = new Enemy("Slime", "A slimy creature is dragging itself around on the ground, steam rises from it as well!", 70,5);
    //r7
    Item dagger = new MeleeWeapon("Dagger", "\nThere is a dagger here", 10, 7);
    Enemy spider = new Enemy("Spider", "Hanging from the ceiling, is a giant spider! All of its, small, creepy, eyes are watching you intensely and the sound of its fangs clapping is making the hair on your neck standing up! ", 20,10);
    //r8
    Item armor = new Armor("Armor", "\nThere is a suit of armor here", 12, 10);
    Item goldPotion = new Liquid("Gold Potion", "\nA small shine form the corner of the room catches your eyes," +
        " its a small bottle with shiny, golden liquid in it", 1, 60
        , "A sudden heat goes through your body, you feel stronger and ready for battle! 60 health points are added! ");
    Enemy drake = new Enemy("Drake", "A giant, lizard looking beast, is crawling towards you, flicking its tongue and drooling!", 55,12);
    //r9
    Item hammer = new MeleeWeapon("Hammer", "\nThere is a hammer here", 20, 12);
    Enemy lion = new Enemy("Lion", "A majestic lion is eating the rest of something you can identify!", 40,12);

  public void addItems() {
    //r1
    r1.addItems(axe);
    r1.addItems(gold);
    r1.addItems(apple);
    r1.addItems(rabbitSkin);
    r1.addEnemy(orc);
    //r2
    r2.addItems(sword);
    r2.addItems(poison);
    r2.addEnemy(rat);
    //r3
    r3.addItems(shield);
    r3.addItems(leatherPouch);
    r3.addEnemy(goblin);
    //r4
    r4.addItems(spear);
    r4.addItems(stones);
    r4.addEnemy(wolf);
    //r5
    r5.addItems(excalibur);
    r5.addEnemy(dragon);
    //r6
    r6.addItems(morningstar);
    r6.addEnemy(slime);
    //r7
    r7.addItems(dagger);
    r7.addEnemy(spider);
    //r8
    r8.addItems(armor);
    r8.addItems(goldPotion);
    r8.addEnemy(drake);
    //r9
    r9.addItems(hammer);
    r9.addEnemy(lion);
  }
}