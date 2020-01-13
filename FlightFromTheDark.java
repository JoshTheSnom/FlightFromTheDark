import java.util.*;
import java.lang.*;
import java.io.IOException;
class FlightFromTheDark {
  public static int Section = 0, CombatSkill = 0, Endurance = 0, Choose = 0, chapter = 1, maxEndurance = 0, maxCombatSkill = 0, Roll = 0;;
  public static boolean Dead = false;
  public static int NumDisciplines = 5;
  public static String[] Disciplines = new String[NumDisciplines];
  public static String[] Weapons = new String[2];
  public static String[] Backpack = new String[4];
  public static int Crowns = 0;
  public static ArrayList<String> SpecialItems = new ArrayList<String>();
  public static void main(String args[]) {
    
    introduction();
    try{ System.in.read();}
	catch (IOException e){ System.out.println("oof");}
    
    characterCreation();
    do {
      game();
    }while (Endurance > 0);
  }
  public static void introduction() {
    System.out.println("The Story So Far...\nIn the northern land of Sommerlund, it has been the custom for many centuries\nto send the children of the Warrior Lords to the monastery of Kai. There they\nare taught the skills and disciplines of their noble fathers.\n\nThe Kai monks are masters of their art, and the children in their charge love\nand respect them in spite of the hardships of their training. For one day when\nthey have finally learnt the secret skills of the Kai, they will return to\ntheir homes equipped in mind and body to defend themselves against the constant\nthreat of war from the Darklords of the west.\n\nIn olden times, during the Age of the Black Moon, the Darklords waged war on\nSommerlund. The conflict was a long and bitter trial of strength that ended in\nvictory for the Sommlending at the great battle of Maakengorge. King Ulnar and\nthe allies of Durenor broke the Darkland armies at the pass of Moytura and\nforced them back into the bottomless abyss of Maakengorge. Vashna, mightiest of\nthe Darklords, was slain upon the sword of King Ulnar, called 'Sommerswerd',\nthe sword of the sun. Since that age, the Darklords have vowed vengeance upon\nSommerlund and the House of Ulnar.\n\nNow it is in the morning of the feast of Fehmarn, when all of the Kai Lords are\npresent at the monastery for the celebrations. Suddenly a great black cloud\ncomes from out of the western skies. So many are the numbers of the\nblack-winged beasts that fill the sky, that the sun is completely hidden. The\nDarklords, ancient enemy of the Sommlending, are attacking. War has begun.\n\nOn this fateful morning, you, Silent Wolf (the name given to you by the Kai)\nhave been sent to collect firewood in the forest as a punishment for your\ninattention in class. As you are preparing to return, you see to your horror a\nvast cloud of black leathery creatures swoop down and engulf the monastery.\nDropping the wood, you race to the battle that has already begun. But in the\nunnatural dark, you stumble and strike your head on a low tree branch. As you\nlose consciousness, the last thing that you see in the poor light is the walls\nof the monastery crashing to the ground.\n\nMany hours pass before you awake. With tears in your eyes you now survey the\nscene of destruction. Raising your face to the clear sky, you swear vengeance\non the Darklords for the massacre of the Kai warriors, and with a sudden flash\nof realization you know what you must do. You must set off on a perilous\njourney to the capital city to warn the King of the terrible threat that now\nfaces his people. For you are now the last of the Kai-you are now the Lone\nWolf.");
  }
  public static void characterCreation() {
    characterRandom();
    characterDiscipline();
    equipment();
    try{ System.in.read();}
	catch (IOException e){ System.out.println("oof");}
    
  }
  public static void characterRandom() {
    int Reroll = 2;
    boolean Error = false;
    for(boolean i = false; i != true && Reroll > 0 ; ) {
      Error = false;
      i = false;
      maxCombatSkill = (int)(Math.random() * 9) + 10;
      maxEndurance = (int)(Math.random() * 9) + 20;
      System.out.println("Your COMBAT SKILL is "+maxCombatSkill+" and your ENDURANCE is "+maxEndurance+".");
      if(Reroll > 0) {
        do{
          System.out.print("\nWould you like to reroll? Y/N ");
          Scanner sc = new Scanner (System.in);
          char Answer = sc.next().charAt(0);
          if(Answer == 'y' || Answer == 'Y') {
            Reroll--;
          }
          else if(Answer == 'n' || Answer == 'N') i = true;
          else {
            Error = true;
            System.out.println("Please enter Y or N");
          }
        }while(Error == true);
      }
    }
  }
  public static void characterDiscipline() {
    System.out.println("Kai Disciplines\n\nOver the centuries, the Kai monks have mastered the skills of the warrior.\nThese skills are known as the Kai Disciplines, and they are taught to all Kai\nLords. You have learnt only five of the skills listed below. The choice of\nwhich five skills these are, is for you to make. As all of the Disciplines may\nbe of use to you at some point on your perilous quest, pick your five with\ncare. The correct use of a Discipline at the right time can save your life.\n\n1)Camouflage\nThis Discipline enables a Kai Lord to blend in with his surroundings. In the\ncountryside, he can hide undetected among trees and rocks and pass close to an\nenemy without being seen. In a town or city, it enables him to look and sound\nlike a native of that area, and can help him to find shelter or a safe hiding\nplace.\n\n2)Hunting\nThis skill ensures that a Kai Lord will never starve in the wild. He will\nalways be able to hunt for food for himself except in areas of wasteland and\ndesert. The skill also enables a Kai Lord to be able to move stealthily when\nstalking his prey.\n\n3)Sixth Sense\nThis skill may warn a Kai Lord of imminent danger. It may also reveal the true\npurpose of a stranger or strange object encountered in your adventure.\n\n4)Tracking\nThis skill enables a Kai Lord to make the correct choice of a path in the wild,\nto discover the location of a person or object in a town or city and to read\nthe secrets of footprints or tracks.\n\n5)Healing\nThis Discipline can be used to restore ENDURANCE points lost in combat. If you\npossess this skill you may restore 1 ENDURANCE point to your total for every\nnumbered section of the book you pass through in which you are not involved in\ncombat. (This is only to be used after your ENDURANCE has fallen below its\noriginal level.) Remember that your ENDURANCE cannot rise above its original\nlevel.\n\n6)Weaponskill\nUpon entering the Kai Monastery, each initiate is taught to master one type of\nweapon. If Weaponskill is to be one of your Kai Disciplines, you will be\nproficient with a random weapon. When you enter combat carrying this weapon,\nyou add 2 points to your COMBAT SKILL.\nThe fact that you are skilled with a weapon does not mean you set out on the\nadventure carrying that particular weapon. However, you will have opportunities\nto acquire weapons in the course of your adventures. If you pick the axe, you\nare lucky enough to be skilled in the one weapon Lone Wolf is carrying from the\nstart of the adventure. (This will be explained fully in the Equipment\nsection.)\n\n7)Mindshield\nThe Darklords and many of the evil creatures in their command have the ability\nto attack you using their Mindforce. The Kai Discipline of Mindshield prevents\nyou from losing any ENDURANCE points when subjected to this form of attack.\n8)Mindblast\nThis enables a Kai Lord to attack an enemy using the force of his mind. It can\nbe used at the same time as normal combat weapons and adds two extra points to\nyour COMBAT SKILL. Not all the creatures encountered on this adventure will be\nharmed by Mindblast. You will be told if a creature is immune.\n\n9)Animal Kinship\nThis skill enables a Kai Lord to communicate with some animals and to be able\nto guess the intentions of others.\n\n10)Mind Over Matter\nMastery of this Discipline enables a Kai Lord to move small objects with his\npowers of concentration.\n");
    for(int i = 4; i > -1; i--) {
      System.out.println("You can choose " + (i+1) + " more disciplines...\n");
      pickNumber(10);
      switch (Choose) {
        case 1:
          System.out.println("You have picked the discipline Camouflage.");
          Disciplines[i] = "Camouflage";
          break;
        case 2:
          System.out.println("You have picked the discipline Hunting.");
          Disciplines[i] = "Hunting";
          break;
        case 3:
          System.out.println("You have picked the discipline Sixth Sense.");
          Disciplines[i] = "Sixth Sense";
          break;
        case 4:
          System.out.println("You have picked the discipline Tracking.");
          Disciplines[i] = "Tracking";
          break;
        case 5:
          System.out.println("You have picked the discipline Healing.");
          Disciplines[i] = "Healing";
          break;
        case 6:
          int Weaponskill = 0;
          String Weapon = ".";
          Weaponskill = (int)(Math.random() * 9) + 0;
          switch (Weaponskill) {
            case 0:
              Weapon = "Dagger";
              break;
            case 1:
              Weapon = "Spear";
              break;
            case 2:
              Weapon = "Mace";
              break;
            case 3:
              Weapon = "Short Sword";
              break;
            case 4:
              Weapon = "Warhammer";
              break;
            case 5:
              Weapon = "Sword";
              break;
            case 6:
              Weapon = "Axe";
              break;
            case 7:
              Weapon = "Sword";
              break;
            case 8:
              Weapon = "Quarterstaff";
              break;
            case 9:
              Weapon = "Broadsword";
              break;
          }
          System.out.println("You have picked the discipline Weaponskill. You are now proficicent with " + Weapon +".");
          Disciplines[i] = "Weaponskill "+Weapon;
          break;
        case 7:
          System.out.println("You have picked the discipline Mindshield.");
          Disciplines[i] = "Mindshield";
          break;
        case 8:
          System.out.println("You have picked the discipline Mindblast.");
          Disciplines[i] = "Mindblast";
          maxCombatSkill = maxCombatSkill+2;
          break;
        case 9:
          System.out.println("You have picked the discipline Animal Kinship.");
          Disciplines[i] = "Animal Kinship";
          break;
        case 10:
          System.out.println("You have picked the discipline Mind Over Matter.");
          Disciplines[i] = "Mind Over Matter";
          break;
      }
    }
    System.out.println("\n\n\n\n\n");
  }
  public static void equipment() {
    Weapons[0] = "Axe";
    Backpack[0] = "Meal";
    Crowns = (int)(Math.random() * 9) + 0;
    System.out.print("\nYou are dressed in the green tunic and cloak of a Kai initiate. You have little\nwith you to arm yourself for survival.\n\nAll you possess is an Axe and a Backpack containing 1 Meal. Hanging from your\nwaist is a leather pouch containing " + Crowns + " Gold Crowns.\nYou also find ");
    int RandomItem = (int)(Math.random() * 9) + 0;
    switch(RandomItem) {
      case 1:
        System.out.print("a Sword.\n\n");
        Weapons [1] = "Sword";
        break;
      case 2:
        System.out.print("a Helmet (+2 to ENDURANCE).");
        maxEndurance = maxEndurance + 2;
        break;
      case 3:
        System.out.print("two Meals.\n\n");
        Backpack [1] = "Meal";
        Backpack [2] = "Meal";
        break;
      case 4:
        System.out.print("Chainmail Waistcoat (+4 to ENDURANCE).\n\n");
        maxEndurance = maxEndurance + 4;
        break;
      case 5:
        System.out.print("a Mace.");
        Weapons[1] = "Mace";
        break;
      case 6:
        System.out.print("a Healing Potion.\n\n");
        SpecialItems.add("Healing Potion");
        break;
      case 7:
        System.out.print("a Quarterstaff.\n\n");
        Weapons [1] = "Quarterstaff";
        break;
      case 8:
        System.out.print("a Spear.\n\n");
        Weapons [1] = "Spear";
        break;
      case 9:
        System.out.print("12 more gold crowns.\n\n");
        Crowns = Crowns + 12;
        break;
      case 0:
        System.out.print("a Broadsword.\n\n");
        Weapons [1] = "Broadsword";
        break;
    }
  }
  public static void pickNumber(int Options) {
    int Numbers = Options;
    do{
      System.out.println("Pick number between 1 and " + Numbers + ".");
      Scanner sc = new Scanner (System.in);
      Choose = sc.nextInt();
      
    }while(Choose > Options || Choose < 1);
  }
  public static void game() {
    switch (chapter) {
      case 1:
        System.out.println("You must make haste for you sense it is not safe to linger by the smoking\nremains of the ruined monastery. The black-winged beasts could return at any\nmoment. You must set out for the Sommlending capital of Holmgard and tell the\nKing the terrible news of the massacre: that the whole élite of Kai warriors,\nsave yourself, have been slaughtered. Without the Kai Lords to lead her armies,\nSommerlund will be at the mercy of their ancient enemy, the Darklords.\n\nFighting back tears, you bid farewell to your dead kinsmen. Silently, you\npromise that their deaths will be avenged. You turn away from the ruins and\ncarefully descend the steep track.\n\nAt the foot of the hill, the path splits into two directions, both leading into\na large wood.\n");
        System.out.println("If you wish to take the right path into the wood, type 1.");
        System.out.println("If you wish to follow the left track, type 2.");
        if(checkDiscipline("Sixth Sense"))System.out.println("If you wish to use your Kai Discipline of Sixth Sense, type 3.");
        if(checkDiscipline("Sixth Sense"))pickNumber(3);
        else pickNumber(2);
        switch(Choose) {
          case 1: chapter = 85;
          case 2: chapter = 275;
          case 3: chapter = 141;
        }
        break;
      case 2:
        System.out.println("As you dash through the thickening trees, the shouts of the Giaks begin to fade\nbehind you. You have nearly outdistanced them completely, when you crash\nheadlong into a tangle of low branches.\n");
        Roll = (int)(Math.random() * 9) + 0;
        if(Roll <= 4) chapter = 343;
        else if(Roll >= 5) chapter = 276;
        break;
      case 3:
        System.out.println("Staying close to the officer, you follow him through an arched portal and up a\nshort flight of stairs to a long hall. Soldiers run back and forth bearing\norders on ornate scrolls to officers stationed around the city wall.\n\nA haggard and scar-faced man dressed in the white and purple robes of the\nKing's court approaches you and bids you follow him to the citadel.\n");
        System.out.println("If you wish to follow this man, type 1.");
        System.out.println("If you wish to decline his offer and return to the crowded streets, type 2.");
        pickNumber(2);
        switch(Choose) {
          case 1: chapter = 196;
          case 2: chapter = 144;
        }
        break;
      case 4:
        System.out.println("It is a small one-man canoe in very poor condition. The wood has split and\nwarped, and the craft appears to be leaking in several places. You quickly\npatch up the worst of the holes with some clay and bail out the water. This\nseems to stop the leaking for the moment. Stowing your equipment at the bow,\nyou set off downstream, using a piece of driftwood as a paddle.\n\nAfter a short while, you hear the sound of horses galloping towards you along\nthe left bank.\n");
        System.out.println("If you wish to hide in the bottom of the canoe, type 1.");
        System.out.println("If you wish to try to attract their attention, type 2.");
        if(checkDiscipline("Sixth Sense"))System.out.println("If you wish to use your Kai Discipline of Sixth Sense, type 3.");
        if(checkDiscipline("Sixth Sense"))pickNumber(3);
        else pickNumber(2);
        switch(Choose) {
          case 1: chapter = 75;
          case 2: chapter = 175;
          case 3: chapter = 218;
        }
        break;
      case 5:
        System.out.println("After about an hour of walking, the track slowly bears round to the east. You\nreach a shallow ford where a fast-flowing brook runs on a steep rocky course\ntowards the south. Just beyond the ford is a junction where the track meets a\nwider path running north to south. Realizing that the north path will take you\naway from the capital, you turn right at the junction and head south.\n");
        chapter = 111;
        break;
      case 6:
        System.out.println("In the distance you can hear the sound of horses galloping nearer. You crouch\nbehind a tree and wait as the riders come closer. They are the cavalry of the\nKing's Guard wearing the white uniforms of His Majesty's army.\n");
        System.out.println("If you wish to call them, type 1.");
        System.out.println("If you wish to let them pass and then continue on your way through the forest, type 2.");
        pickNumber(2);
        switch(Choose) {
          case 1: chapter = 183;
          case 2: chapter = 200;
        }
        break;
      case 7:
        System.out.println("For what seems an eternity, the rush of the crowd carries you along like a leaf\non a fast-flowing stream. You desperately fight to stay on your feet, but you\nfeel weak and dizzy from your ordeal, and your legs are as heavy as lead.\nSuddenly, you catch a glimpse of a long, narrow stone stairway that leads up to\nthe roof of an inn.\n\nGathering the last reserves of your strength, you dive for the stairs and climb\nslowly up to the top. From here you can see the magnificent view of the\nrooftops and spires of Holmgard, with the high stone walls of the citadel\ngleaming in the sun.\n\nThe houses and buildings of the capital are built very close to each other, and\nit is possible to jump from one roof to the next. In fact many of the citizens\nof Holmgard used to use the 'Roofways' (as they are known) when the heavy\nautumn rains made the unpaved parts of the streets too muddy for walking. But\nafter many accidents, a royal decree forbade their use.\n\nAfter careful thought, you decide to use the 'Roofways', as they are your only\nchance of reaching the King. You have hopped, skipped, and jumped across\nseveral streets and you are only one street away from the citadel when you come\nto the end of a row of rooftops.\n\nThe jump to the next row is much further than anything you have tried before,\nand your stomach begins to feel as if it were full of butterflies. Determined\nto reach the citadel, you turn and take a long run-up to the jump. With blood\npounding in your ears, you sprint to the edge of the roof and leap into space,\nyour eyes fixed on the opposite rooftop.\n");
        Roll = (int)(Math.random() * 9) + 0;
        if(Roll <= 2) chapter = 108;
        else if(Roll >= 3) chapter = 25;
        break;
      case 8:
        System.out.println("Your Kai Sixth Sense warns there is a fierce battle raging in the south. Your\ncommon sense tells you that the south is also the quickest route to the\ncapital.\n");
        chapter = 70;
        break;
      case 9:
        System.out.println("You cannot move: you are being held rigid by some powerful force. Your eyes are drawn towards the mouth of the skeleton. From deep in the earth you hear a low humming, like the sound of millions of angry bees. A dull red glow appears in the empty eye sockets of the dead King and the humming increases until your ears are filled with the deafening roar. You are in the presence of an ancient evil, far older and stronger than the Darklords themselves.\n"); //From here on out, I will not use \n and will not edit files.
        for(int i = 0; i < SpecialItems.size(); i++) {
          if(SpecialItems.get(i) == "Vordak Gem") chapter = 236;
        }
        break;
      case 10:
        System.out.println("You are sweating and your legs ache. In the middle distance you can see a group of cottages.\n");
        System.out.println("If you wish to enter a cottage and rest for a while, type 1.");
        System.out.println("If you wish to press on, type 2.");
        pickNumber(2);
        switch(Choose) {
          case 1: chapter = 115;
          case 2: chapter = 83;
        }
        break;
      case 11:
        System.out.println("You quickly dodge into the doorway of a stable and hide your surgeon's cloak in the straw, for it would be better to be seen as a Kai Lord than as a charlatan.\n\nwithout wasting a second, you set off towards the Great Hall on the other side of the courtyard.\n");;
        chapter = 139;
        break;
      case 12:
        System.out.println("The bodyguard looks at you with great suspicion and then slams the door shut. You can hear the sound of voices inside the caravan. Suddenly the door swings open and the face of a wealthy merchant appears.\n\nHe demands 10 Gold Crowns as payment for the ride.\n");
        if(Crowns >= 10) {
          System.out.println("If you wish to pay him, type 1.");
          System.out.println("If you wish do not wish to pay him, type 2.");
          pickNumber(2);
          switch(Choose) {
            case 1: chapter = 262;
            case 2: chapter = 247;
          }
        }
        else chapter = 247;
        break;
      case 13:
        System.out.println("The path soon ends at a large clearing. In the centre of the clearing is a tree much taller and wider than any others you have seen in the forest.\n\nLooking up through the massive branches you can see a large treehouse some twenty-five to thirty feet above the ground. There is no ladder, but the gnarled bark of the tree offers many footholds.\n");
        System.out.println("If you wish to climb the tree and search the treehouse, type 1.");
        System.out.println("If you would rather press on, type 2.");
        pickNumber(2);
        switch(Choose) {
          case 1: chapter = 307;
          case 2: chapter = 213;
        }
        break;
      case 14:
        System.out.println("You reach the top of a small wooded hill on which several large boulders form a rough circle. Suddenly you hear a loud growl from behind a rock to your left.\n");
        System.out.println("If you wish to draw your weapon and prepare to fight, type 1.");
        System.out.println("If you would rather take evasive action by running as fast as you can over the hill, type 2.");
        pickNumber(2);
        switch(Choose) {
          case 1: chapter = 43;
          case 2: chapter = 106;
        }
        break;
      case 15:
        System.out.println("You pass through a long, dark tunnel of overhanging branches that eventually opens out into a large clearing. On a stone plinth in the centre of the clearing is a Sword, sheathed in a black leather scabbard. A handwritten note has been tied to the hilt, but it is in a language which is foreign to you.\n");
        if(Weapons[0] == null || Weapons[1] == null) {
          System.out.println("Do you want to take the sword? Y/N");
          Scanner sc = new Scanner (System.in);
          String YesNo = sc.next();
          if(YesNo == "Y") {
            if(Weapons[0] == null) Weapons[0] = "Sword";
            else Weapons[1] = "Sword";
          }
        }
        else System.out.println("You can't wield any more weapons.");
        System.out.println("There are three exits from the clearing.\n");
        System.out.println("If you decide to go east, type 1.");
        System.out.println("If you decide to go west, type 2.");
        System.out.println("If you decide to go south, type 3.");
        pickNumber(3);
        switch(Choose) {
          case 1: chapter = 207;
          case 2: chapter = 201;
          case 3  : chapter = 35;
        }
        break;
      case 16:
        System.out.println("You manage to free a horse from the straps securing it to the caravan. It is frightened by the scent of the approaching Doomwolves, and the cries of their evil riders-the Giaks.\n\nPreparing your weapon, you spur your skittish horse towards the oncoming beasts. They are less than fifty yards away and they are lowering their lances at you as they get nearer and nearer.\n");
        chapter = 192;
        break;
      case 17:
        System.out.println("You raise your weapon to strike at the beast as its razor-fanged mouth snaps shut just inches from your head. Buffeted by the beating of its wings you find it difficult to stand.\n");
        fight("Kraan",16,24,1);
        System.out.println("You quickly descend the far side of the hill to avoid the Giaks.");
        Roll = (int)(Math.random() * 9) + 0;
        if(Roll == 0) chapter = 53;
        else if(Roll >= 2) chapter = 274;
        else chapter = 316;
        break;
      case 18:
        System.out.println("You are awoken by the sound of troops in the distance. Across the lake you see the black-cloaked figures of Drakkarim and a pack of Doomwolves and their riders. A Kraan appears from above the trees and lands on the roof of the small wooden shack.\n\nIt is ridden by a creature dressed in red. The Kraan takes off and begins to fly across the lake to where you are hidden.\n");
        System.out.println("If you wish to ride deeper in the forest, type 1.");
        System.out.println("If you wish to fight the creature, type 2.");
        if(checkDiscipline("Camouflage"))System.out.println("If you wish to use your Kai Discipline of Camouflage, type 3.");
        if(checkDiscipline("Camouflage"))pickNumber(3);
        else pickNumber(2);
        switch(Choose) {
          case 1: chapter = 239;
          case 2: chapter = 29;
          case 3: chapter = 114;
        }
        break;
      case 19:
        System.out.println("\n");
        System.out.println("If you wish to avoid the Sleeptooth by returning to the track, type 1.");
        System.out.println("If you wish to push on through the briars, deeper into the forest, type 2.");
        if(checkDiscipline("Tracking"))System.out.println("If you wish to use your Kai Discipline of Tracking, type 3.");
        if(checkDiscipline("Tracking"))pickNumber(3);
        else pickNumber(2);
        switch(Choose) {
          case 1: chapter = 69;
          case 2: chapter = 272;
          case 3: chapter = 119;
        }
        break;
      case 20:
        System.out.println("It seems that whoever lived here left in a great hurry-and they must have left quite recently. A half-eaten meal still remains on the table, and a mug of dark jala is still warm to the touch.\n\nSearching a chest and small wardrobe, you find a Backpack, food (enough for two Meals), and a Dagger.\n");
        if(Backpack[0] == null || Backpack[1] == null || Backpack[2] == null|| Backpack[3] == null) {
          System.out.println("Do you want to take the meal? Y/N");
          Scanner sc = new Scanner (System.in);
          String YesNo = sc.next();
          if(YesNo == "Y") {
            if(Backpack[0] == null) Backpack[0] = "Meal";
            else if(Backpack[1] == null) Backpack[1] = "Meal";
            else if(Backpack[2] == null) Backpack[2] = "Meal";
            else Backpack[3] = "Meal";
          }
        }
        else System.out.println("You can't wield any more items.");
        if(Backpack[0] == null || Backpack[1] == null || Backpack[2] == null|| Backpack[3] == null) {
          System.out.println("Do you want to take the meal? Y/N");
          Scanner sc = new Scanner (System.in);
          String YesNo = sc.next();
          if(YesNo == "Y") {
            if(Backpack[0] == null) Backpack[0] = "Meal";
            else if(Backpack[1] == null) Backpack[1] = "Meal";
            else if(Backpack[2] == null) Backpack[2] = "Meal";
            else Backpack[3] = "Meal";
          }
        }
        else System.out.println("You can't wield any more items.");
        if(Weapons[0] == null || Weapons[1] == null) {
          System.out.println("Do you want to take the dagger? Y/N");
          Scanner sc = new Scanner (System.in);
          String YesNo = sc.next();
          if(YesNo == "Y") {
            if(Weapons[0] == null) Weapons[0] = "Dagger";
            else Weapons[1] = "Dagger";
          }
        }
        else System.out.println("You can't wield any more weapons.");
        chapter = 273;
        break;
      case 21:
        System.out.println("You have ridden about two miles into the tangle of trees when the ground becomes very marshy.\n");
        Roll = (int)(Math.random() * 9) + 0;
        if(Roll > 5) {
          System.out.println("Your horse has suddenly plunged into thick mud up to its belly.");
          Roll = (int)(Math.random() * 9) + 0;
          if(Roll >= 7) {
            System.out.println("The mud engulfs you up to your armpits. Your horse gives one last despairing scream as its muzzle disappears into the bubbling mud.");
            Roll = (int)(Math.random() * 9) + 0;
            if(Roll != 9){
              System.out.println("The foul-smelling bog sucks you under and claims another victim. Your life and your mission end here.");
              ded();
            }
            else chapter = 312;
          }
          else {
            System.out.println("You drag yourself onto firm ground.");
            chapter = 189;
          }
        }
        else {
          System.out.println("You manage to steer clear of the morass.");
          chapter = 189;
        }
        break;
      case 22:
        System.out.println("Knocking aside the leader, you sprint off along the highway. Then behind you the ominous click of a crossbow being cocked sends a shiver down your spine.\n");
        Roll = (int)(Math.random() * 9) + 0;
        if(Roll <= 4) chapter = 181;
        else chapter = 145;
        break;
      case 23:
        System.out.println("The corridor soon widens into a large hall. At the far end, a stone staircase leads up to a huge door. Two black candles on either side of the stone steps dimly illuminate the chamber. You notice that no wax has melted, and as you get nearer you can feel that they give off no heat. Ancient engravings cover the stone surfaces of the walls.\n\nAnxious to leave this evil tomb, you examine the door for a latch. An ornate pin appears to lock the door, but there is also a keyhole in the lockplate.\n");
        int j = 1;
        System.out.println("If you wish to remove the pin, type 1.");
        if(checkDiscipline("Mind Over Matter")) {
          j++;
          System.out.println("If you wish to use your Kai Discipline of Mind Over Matter, type "+j+".");    
        }
        System.out.println(", type 2.");
        for(int i = 0; i < SpecialItems.size(); i++) {
          if(SpecialItems.get(i) == "Golden Key") {
            j++;
            System.out.println("If you have a Golden Key and wish to use it, type "+j+".");
          }
        }
        pickNumber(j);
        switch(Choose) {
          case 1: chapter = 337;
          case 2: chapter = 326;
          case 3: chapter = 337;
        }
        break;
      case 24:
        System.out.println("The merchant shouts to the driver of the caravan to jump. 'We're under attack!' he cries, disappearing through a circular window.\n");
        System.out.println("If you decide to jump after him, type 1.");
        System.out.println("If you decide to run through the caravan and grab the reins of the horse team, type 2.");
        pickNumber(2);
        switch(Choose) {
          case 1: chapter = 234;
          case 2: chapter = 184;
        }
        break;
      case 25:
        System.out.println("You land with such a crash on the opposite roof, that the wind is knocked out of you and you lie flat on your back with your head in a spin.\n\nIt takes a minute or so for you to realize that you've made it and are perfectly safe. When you are sure you are all right, you jump up and let out a shout for joy at your skill and daring.\n\nQuickly you find a way across the roof and climb down a long drainpipe to the street below. You see the large iron doors of the citadel open, and a wagon drawn by two large horses tries to leave. The horses are frightened by the noisy crowd and they both rear up, causing the wagon to smash a front wheel against the door. In the confusion, you see a chance to enter and quickly slip inside just as the guards slam the doors shut.\n");
        chapter = 139;
        break;
      case 26:
        System.out.println("Cautiously, you move along the corridor until you come to a sharp eastward turn. A strange greenish light can be seen in the distance.\n");
        System.out.println("If you wish to continue, type 1.");
        System.out.println("If you wish to go back and try the southern route, type 2.");
        pickNumber(2);
        switch(Choose) {
          case 1: chapter = 249;
          case 2: chapter = 100;
        }
        break;
      case 27:
        System.out.println("You walk along this path for over an hour, carefully watching the sky above you in case the Kraan attack again. Up ahead, a large tree has fallen across the path. As you approach, you can hear voices coming from the other side of the massive trunk.\n");
        System.out.println("If you choose to attack, type 1.");
        System.out.println("If you choose to listen to what the voices say, type 2.");
        pickNumber(2);
        switch(Choose) {
          case 1: chapter = 250;
          case 2: chapter = 52;
        }
        break;
      case 28:
        System.out.println("After a few hundred yards, the path joins another one running north to south.\n");
        System.out.println("If you wish to go northwards, type 1.");
        System.out.println("If you wish to head south, type 2.");
        pickNumber(2);
        switch(Choose) {
          case 1: chapter = 130;
          case 2: chapter = 147;
        }
        break;
      case 29:
        System.out.println("You stride out to the water's edge and prepare yourself for combat. The Kraan and its rider spot you and begin to speed across the lake barely inches above the surface.\n\nThe rider lets out a scream that freezes your blood. He is a Vordak, a fierce lieutenant of the Darklords.\n");
        if(checkDiscipline("Mindshield")) fight("Vordak",17,25,0);
        else fight("Vordak",17,25,2);
        chapter = 270;
        break;
      case 30:
        System.out.println("The people look tired and hungry. They have come many miles from their burning city. Suddenly, you hear the beat of huge wings coming from the north.\n\n'Kraan, Kraan! Hide yourselves!' the cry goes up all along the road.\n\nJust in front of you, a wagon carrying small children breaks down, its right wheel jammed in a furrow. The children scream in panic.\n");
        System.out.println("If you wish to help the children, type 1.");
        System.out.println("If you'd rather run for the cover of the trees, type 2.");
        pickNumber(2);
        switch(Choose) {
          case 1: chapter = 194;
          case 2: chapter = 261;
        }
        break;
      case 31:
        System.out.println("You try to comfort the injured man as best you can, but his wounds are serious and he is soon unconscious again. Covering him with his cape, you turn and press deeper into the forest.\n");
        chapter = 264;
        break;
      case 32:
        System.out.println("You have ridden about three miles when, in the distance, you spot the unmistakable silhouette of five large Doomwolves. Riding on their backs are Giaks. They seem to be going on ahead to where the path leads down into an open meadow. Suddenly, one of the Giaks leaves the others and begins to ride back along the path towards you.\n");
        System.out.println("If you wish to hide in the undergrowth and let him pass, type 1.");
        System.out.println("If you wish to fight him, type 2.");
        pickNumber(2);
        switch(Choose) {
          case 1: chapter = 176;
          case 2: chapter = 340;
        }
        break;
      case 33:
        System.out.println("The floor of the cave is quite dry and dusty. As you explore deeper in the half-light, you detect the stale odour of rotting flesh. Littering a crevice are the bones, fur, and teeth of several small animals. You notice a small cloth bag among these remains which you open to discover 3 Gold Crowns. Pocketing these coins, you leave what appears to be the lair of a mountain cat and carefully descend the hill.\n");
        chapter = 248;
        break;
      case 34:
        System.out.println("Without warning, a terrible apparition in red robes swoops down from the sky on the back of a Kraan. Its cry freezes your blood. The beast is a Vordak, a fierce lieutenant of the Darklords.\n\nHe is above you and you must fight him.\n");
        if(checkDiscipline("Mindshield")) fight("Vordak",17,25,0);
        else fight("Vordak",17,25,2);
        chapter = 328;
        break;
      case 35:
        System.out.println("The forest is becoming denser, and the path more tangled with thorny briars. Almost completely hidden by the undergrowth, you notice another path branching off towards the east. Your current route seems to be coming to a prickly end, so you decide to follow the new path eastwards.\n");
        chapter = 207;
        break;
      case 36:
        System.out.println("The old watchtower ladder is rotten and several rungs break as you climb.\n");
        Roll = (int)(Math.random() * 9) + 0;
        if(Roll <= 4) System.out.println("You have fallen.");
        else System.out.println("You do not fall.");
        chapter = 323;
        break;
      case 37:
        System.out.println("You are feeling tired and hungry and you must stop to eat. After your Meal, you retrace your steps back to the citadel and begin to walk around the high, indomitable stone wall.\n\nYou discover another entrance on the eastern side, guarded as before by two armoured soldiers.\n");
        System.out.println("If you wish to approach them and tell your story, type 1.");
        if(checkDiscipline("Mindshield")) {
          System.out.println("If you wish to use the Kai Discipline of Camouflage, type 2.");
          pickNumber(2);
        }
        else pickNumber(1);
        switch(Choose) {
          case 1: chapter = 289;
          case 2: chapter = 282;
        }
        break;
      case 38:
        System.out.println("For half an hour or more you press on through the forest, through the rich vegetation and ferns. You happen upon a small clear stream where you stop for a few minutes to wash your face and drink of the cold, fresh water.\n\nFeeling revitalized, you cross the stream and press on. You soon notice the smell of wood smoke which seems to be drifting towards you from the north.\n");
        System.out.println("If you wish to investigate the smell of wood smoke, type 1.");
        System.out.println("If you would rather avoid the source of this smoke, type 2.");
        pickNumber(2);
        switch(Choose) {
          case 1: chapter = 128;
          case 2: chapter = 347;
        }
        break;
      case 39:
        System.out.println("After a few seconds, two small furry faces nervously appear over the top of the trunk. They say they are Kakarmi and tell you that the Kraan are everywhere. To the west lie the remains of their village but little is left of it now. They are trying to find the rest of their tribe who took to the forest when the 'Black-wings' attacked. They point behind them-east along the path-and tell you that the trail appears to be a dead end, but that if you continue through the undergrowth for a few yards more, you will find a watchtower where the path splits into three directions. Take the east path. This leads to the King's highway between the capital city-Holmgard-and the northern port of Toran.\n\nYou thank the Kakarmi, and bid them farewell.\n");
        chapter = 228;
        break;
      case 40:
        System.out.println("Keeping a careful watch on the huts for any sign of the enemy, you make your way around the clearing under the cover of the trees and bracken. Rejoining the track, you hurry away from Fogwood.\n");
        chapter = 105;
        break;
      case 41:
        System.out.println("Three rangers gallop past the river bank, closely followed by the Giaks on their snarling Doomwolves.\n\nThe bank is steep and you are spotted by the Giak leader who orders five of his troops to open fire at you with their bows. Their black arrows rain down on you.\n");
        System.out.println("If you decide to paddle downstream as fast as you can, type 1.");
        System.out.println("If you decide to head for the cover of the trees on the opposite bank, type 2.");
        pickNumber(2);
        switch(Choose) {
          case 1: chapter = 174;
          case 2: chapter = 116;
        }
        break;
      case 42:
        System.out.println("\n");
        System.out.println("If you wish to continue east, type 1.");
        System.out.println("If you would rather head north, type 2.");
        System.out.println("If you decide to venture south, type 3.");
        System.out.println("Or if you prefer to go west, type 4.");
        pickNumber(4);
        switch(Choose) {
          case 1: chapter = 86;
          case 2: chapter = 238;
          case 3: chapter = 157;
          case 4: chapter = 147;
        }
        break;
      /*case 43:
        System.out.println("\n");
        System.out.println(", type 1.");
        System.out.println(", type 2.");
        pickNumber();
        switch(Choose) {
          case 1: chapter = ;
          case 2: chapter = ;
        }
        break;
      case 44:
        System.out.println("\n");
        System.out.println(", type 1.");
        System.out.println(", type 2.");
        pickNumber();
        switch(Choose) {
          case 1: chapter = ;
          case 2: chapter = ;
        }
        break;
      case 45:
        System.out.println("\n");
        System.out.println(", type 1.");
        System.out.println(", type 2.");
        pickNumber();
        switch(Choose) {
          case 1: chapter = ;
          case 2: chapter = ;
        }
        break;
      case 46:
        System.out.println("\n");
        System.out.println(", type 1.");
        System.out.println(", type 2.");
        pickNumber();
        switch(Choose) {
          case 1: chapter = ;
          case 2: chapter = ;
        }
        break;
      case 47:
        System.out.println("\n");
        System.out.println(", type 1.");
        System.out.println(", type 2.");
        pickNumber();
        switch(Choose) {
          case 1: chapter = ;
          case 2: chapter = ;
        }
        break;
      case 48:
        System.out.println("\n");
        System.out.println(", type 1.");
        System.out.println(", type 2.");
        pickNumber();
        switch(Choose) {
          case 1: chapter = ;
          case 2: chapter = ;
        }
        break;
      case 49:
        System.out.println("\n");
        System.out.println(", type 1.");
        System.out.println(", type 2.");
        pickNumber();
        switch(Choose) {
          case 1: chapter = ;
          case 2: chapter = ;
        }
        break;
      case 50:
        System.out.println("\n");
        System.out.println(", type 1.");
        System.out.println(", type 2.");
        pickNumber();
        switch(Choose) {
          case 1: chapter = ;
          case 2: chapter = ;
        }
        break;
      case 51:
        System.out.println("\n");
        System.out.println(", type 1.");
        System.out.println(", type 2.");
        pickNumber();
        switch(Choose) {
          case 1: chapter = ;
          case 2: chapter = ;
        }
        break;
      case 52:
        System.out.println("\n");
        System.out.println(", type 1.");
        System.out.println(", type 2.");
        pickNumber();
        switch(Choose) {
          case 1: chapter = ;
          case 2: chapter = ;
        }
        break;
      case 53:
        System.out.println("\n");
        System.out.println(", type 1.");
        System.out.println(", type 2.");
        pickNumber();
        switch(Choose) {
          case 1: chapter = ;
          case 2: chapter = ;
        }
        break;
      case 54:
        System.out.println("\n");
        System.out.println(", type 1.");
        System.out.println(", type 2.");
        pickNumber();
        switch(Choose) {
          case 1: chapter = ;
          case 2: chapter = ;
        }
        break;
      case 55:
        System.out.println("\n");
        System.out.println(", type 1.");
        System.out.println(", type 2.");
        pickNumber();
        switch(Choose) {
          case 1: chapter = ;
          case 2: chapter = ;
        }
        break;
      case 56:
        System.out.println("\n");
        System.out.println(", type 1.");
        System.out.println(", type 2.");
        pickNumber();
        switch(Choose) {
          case 1: chapter = ;
          case 2: chapter = ;
        }
        break;
      case 57:
        System.out.println("\n");
        System.out.println(", type 1.");
        System.out.println(", type 2.");
        pickNumber();
        switch(Choose) {
          case 1: chapter = ;
          case 2: chapter = ;
        }
        break;
      case 58:
        System.out.println("\n");
        System.out.println(", type 1.");
        System.out.println(", type 2.");
        pickNumber();
        switch(Choose) {
          case 1: chapter = ;
          case 2: chapter = ;
        }
        break;
      case 59:
        System.out.println("\n");
        System.out.println(", type 1.");
        System.out.println(", type 2.");
        pickNumber();
        switch(Choose) {
          case 1: chapter = ;
          case 2: chapter = ;
        }
        break;
      case 60:
        System.out.println("\n");
        System.out.println(", type 1.");
        System.out.println(", type 2.");
        pickNumber();
        switch(Choose) {
          case 1: chapter = ;
          case 2: chapter = ;
        }
        break;
      case 61:
        System.out.println("\n");
        System.out.println(", type 1.");
        System.out.println(", type 2.");
        pickNumber();
        switch(Choose) {
          case 1: chapter = ;
          case 2: chapter = ;
        }
        break;
      case 62:
        System.out.println("\n");
        System.out.println(", type 1.");
        System.out.println(", type 2.");
        pickNumber();
        switch(Choose) {
          case 1: chapter = ;
          case 2: chapter = ;
        }
        break;
      case 63:
        System.out.println("\n");
        System.out.println(", type 1.");
        System.out.println(", type 2.");
        pickNumber();
        switch(Choose) {
          case 1: chapter = ;
          case 2: chapter = ;
        }
        break;
      case 64:
        System.out.println("\n");
        System.out.println(", type 1.");
        System.out.println(", type 2.");
        pickNumber();
        switch(Choose) {
          case 1: chapter = ;
          case 2: chapter = ;
        }
        break;
      case 65:
        System.out.println("\n");
        System.out.println(", type 1.");
        System.out.println(", type 2.");
        pickNumber();
        switch(Choose) {
          case 1: chapter = ;
          case 2: chapter = ;
        }
        break;
      case 66:
        System.out.println("\n");
        System.out.println(", type 1.");
        System.out.println(", type 2.");
        pickNumber();
        switch(Choose) {
          case 1: chapter = ;
          case 2: chapter = ;
        }
        break;
      case 67:
        System.out.println("\n");
        System.out.println(", type 1.");
        System.out.println(", type 2.");
        pickNumber();
        switch(Choose) {
          case 1: chapter = ;
          case 2: chapter = ;
        }
        break;
      case 68:
        System.out.println("\n");
        System.out.println(", type 1.");
        System.out.println(", type 2.");
        pickNumber();
        switch(Choose) {
          case 1: chapter = ;
          case 2: chapter = ;
        }
        break;
      case 69:
        System.out.println("\n");
        System.out.println(", type 1.");
        System.out.println(", type 2.");
        pickNumber();
        switch(Choose) {
          case 1: chapter = ;
          case 2: chapter = ;
        }
        break;
      case 70:
        System.out.println("\n");
        System.out.println(", type 1.");
        System.out.println(", type 2.");
        pickNumber();
        switch(Choose) {
          case 1: chapter = ;
          case 2: chapter = ;
        }
        break;
      case 72:
        System.out.println("\n");
        System.out.println(", type 1.");
        System.out.println(", type 2.");
        pickNumber();
        switch(Choose) {
          case 1: chapter = ;
          case 2: chapter = ;
        }
        break;
      case 72:
        System.out.println("\n");
        System.out.println(", type 1.");
        System.out.println(", type 2.");
        pickNumber();
        switch(Choose) {
          case 1: chapter = ;
          case 2: chapter = ;
        }
        break;
      case 73:
        System.out.println("\n");
        System.out.println(", type 1.");
        System.out.println(", type 2.");
        pickNumber();
        switch(Choose) {
          case 1: chapter = ;
          case 2: chapter = ;
        }
        break;
      case 74:
        System.out.println("\n");
        System.out.println(", type 1.");
        System.out.println(", type 2.");
        pickNumber();
        switch(Choose) {
          case 1: chapter = ;
          case 2: chapter = ;
        }
        break;
      case 75:
        System.out.println("\n");
        System.out.println(", type 1.");
        System.out.println(", type 2.");
        pickNumber();
        switch(Choose) {
          case 1: chapter = ;
          case 2: chapter = ;
        }
        break;*/
    }
  }
  public static boolean checkDiscipline(String search) {
    String disSearch = search;
    boolean found = false;
    for(int i = 0; i < NumDisciplines; i++) {
      if(Disciplines[i] == disSearch) found = true;
    }
    return found;
  }
  public static boolean fight(String creatureName, int creatureCombatSkill, int creatureEndurance, int creatureDeducts) {
    boolean didWin = true;
    String crName = creatureName;
    int crCombatSkill = creatureCombatSkill;
    int crEndurance = creatureEndurance;
    int crScary = creatureDeducts;
    int j = 1;
    System.out.println("What weapon will you use to fight?");
    if(Weapons[0] != null) System.out.println("If you want to use " + Weapons[0] + ", type "+j+".");
    else if(Weapons[1] != null) System.out.println("If you want to use " + Weapons[1] + ", type "+j+".");
    else {
      System.out.println("You don't have a weapon to fight with. You lose.");
      ded();
	  return false;
    }
    System.out.println("For now, you will win all combats");
    /*if(didWin != false) {
      CombatSkill = maxCombatSkill - crScary;
      int CombatRatio = CombatSkill - crCombatSkill;
      RandomNum = (int)(Math.random() * 9) + 0;
      if(CombatRatio <= 0) {
        crEndurance = crEndurance - (CombatRatio+2+RandomNum)
        Endurance = Endurance - (  
      }*/
      return true;
    }
    
  public static void ded() {
    System.out.println("You have died.");
    try{ System.in.read();}
	catch (IOException e){ System.out.println("oof");}
    System.exit(0);
  }
}