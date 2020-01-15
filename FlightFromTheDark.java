import java.util.*;
import java.io.IOException;
class FlightFromTheDark {
  public static int combatSkill = 0, Endurance = 0, choose = 0, chapter = 1, maxEndurance = 0, maxCombatSkill = 0, roll = 0,j = 1;
  public static boolean what = false;
  public static int numDisciplines = 5;
  public static String[] disciplines = new String[numDisciplines];
  public static String[] weapons = new String[2];
  public static String[] backpack = new String[4];
  public static int[][] crDamage = {{0,0,0,0,1,2,3,4,5,6,7,8,9},{0,0,0,1,2,3,4,5,6,7,8,9,10},{0,0,1,2,3,4,5,6,7,8,9,10,11},{0,1,2,3,4,5,6,7,8,9,10,11,12},{1,2,3,4,5,6,7,8,9,10,11,12,14},{2,3,4,5,6,7,8,9,10,11,12,14,16},{3,4,5,6,7,8,9,10,11,12,14,16,18},{4,5,6,7,8,9,10,11,12,14,16,18,100},{5,6,7,8,9,10,11,12,14,16,18,100,100},{6,7,8,9,10,11,12,14,16,18,100,100,100}};
  public static int[][] lwDamage = {{100,100,8,6,6,5,5,5,4,4,4,3,3},{100,8,7,6,5,5,5,4,4,4,3,3,2},{8,7,6,5,5,5,4,4,4,3,3,2,2},{8,7,6,5,5,5,4,4,4,3,3,2,2},{7,6,5,5,5,4,4,4,3,3,2,2,1},{6,6,5,4,3,2,2,2,2,1,1,1,1},{5,5,4,3,2,2,1,1,1,0,0,0,0},{4,4,3,2,1,1,0,0,0,0,0,0,0},{3,3,2,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0}};
  public static int crowns = 0;
  public static Scanner sc = new Scanner (System.in);
  public static ArrayList<String> specialItems = new ArrayList<String>();
  public static void main(String args[]) {
    
    introduction();
    try{ System.in.read();}
	catch (IOException e){ System.out.println("oof");}
    
    characterCreation();
    do {
      game();
	  System.out.println("--------------------------------------------------------------------------------");
    }while (Endurance<=0);
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
  public static boolean getYesNoAnswer() {
	  char answer = sc.next().charAt(0);
	  boolean Error = false;
	  do{
		Error = false;
		if(answer == 'y' || answer == 'Y') return true;
          else if(answer == 'n' || answer == 'N') return false;
          else {
            Error = true;
            System.out.println("Please enter Y or N");
          }
    }while(Error == true);
    return false;
  }
  public static void characterRandom() {
    int Reroll = 2;
    for(boolean i = false; i != true && Reroll > 0 ; i = false) {
      maxCombatSkill = (int)(Math.random() * 9) + 10;
      maxEndurance = (int)(Math.random() * 9) + 20;
      System.out.println("Your COMBAT SKILL is "+maxCombatSkill+" and your ENDURANCE is "+maxEndurance+".");
      if(Reroll > 0) {
        System.out.print("\nWould you like to reroll? Y/N ");
		what = getYesNoAnswer();
        if(what) Reroll--;
      }
    }
  }
  public static void characterDiscipline() {
    System.out.println("Kai Disciplines\n\nOver the centuries, the Kai monks have mastered the skills of the warrior.\nThese skills are known as the Kai Disciplines, and they are taught to all Kai\nLords. You have learnt only five of the skills listed below. The choice of\nwhich five skills these are, is for you to make. As all of the Disciplines may\nbe of use to you at some point on your perilous quest, pick your five with\ncare. The correct use of a Discipline at the right time can save your life.\n\n1)Camouflage\nThis Discipline enables a Kai Lord to blend in with his surroundings. In the\ncountryside, he can hide undetected among trees and rocks and pass close to an\nenemy without being seen. In a town or city, it enables him to look and sound\nlike a native of that area, and can help him to find shelter or a safe hiding\nplace.\n\n2)Hunting\nThis skill ensures that a Kai Lord will never starve in the wild. He will\nalways be able to hunt for food for himself except in areas of wasteland and\ndesert. The skill also enables a Kai Lord to be able to move stealthily when\nstalking his prey.\n\n3)Sixth Sense\nThis skill may warn a Kai Lord of imminent danger. It may also reveal the true\npurpose of a stranger or strange object encountered in your adventure.\n\n4)Tracking\nThis skill enables a Kai Lord to make the correct choice of a path in the wild,\nto discover the location of a person or object in a town or city and to read\nthe secrets of footprints or tracks.\n\n5)Healing\nThis Discipline can be used to restore ENDURANCE points lost in combat. If you\npossess this skill you may restore 1 ENDURANCE point to your total for every\nnumbered section of the book you pass through in which you are not involved in\ncombat. (This is only to be used after your ENDURANCE has fallen below its\noriginal level.) Remember that your ENDURANCE cannot rise above its original\nlevel.\n\n6)Weaponskill\nUpon entering the Kai Monastery, each initiate is taught to master one type of\nweapon. If Weaponskill is to be one of your Kai Disciplines, you will be\nproficient with a random weapon. When you enter combat carrying this weapon,\nyou add 2 points to your COMBAT SKILL.\nThe fact that you are skilled with a weapon does not mean you set out on the\nadventure carrying that particular weapon. However, you will have opportunities\nto acquire weapons in the course of your adventures. If you pick the axe, you\nare lucky enough to be skilled in the one weapon Lone Wolf is carrying from the\nstart of the adventure. (This will be explained fully in the Equipment\nsection.)\n\n7)Mindshield\nThe Darklords and many of the evil creatures in their command have the ability\nto attack you using their Mindforce. The Kai Discipline of Mindshield prevents\nyou from losing any ENDURANCE points when subjected to this form of attack.\n8)Mindblast\nThis enables a Kai Lord to attack an enemy using the force of his mind. It can\nbe used at the same time as normal combat weapons and adds two extra points to\nyour COMBAT SKILL. Not all the creatures encountered on this adventure will be\nharmed by Mindblast. You will be told if a creature is immune.\n\n9)Animal Kinship\nThis skill enables a Kai Lord to communicate with some animals and to be able\nto guess the intentions of others.\n\n10)Mind Over Matter\nMastery of this Discipline enables a Kai Lord to move small objects with his\npowers of concentration.\n");
    for(int i = 4; i > -1; i--) {
      System.out.println("You can choose " + (i+1) + " more disciplines...\n");
      pickNumber(10);
      switch (choose) {
        case 1:
          System.out.println("You have picked the discipline Camouflage.");
          disciplines[i] = "Camouflage";
          break;
        case 2:
          System.out.println("You have picked the discipline Hunting.");
          disciplines[i] = "Hunting";
          break;
        case 3:
          System.out.println("You have picked the discipline Sixth Sense.");
          disciplines[i] = "Sixth Sense";
          break;
        case 4:
          System.out.println("You have picked the discipline Tracking.");
          disciplines[i] = "Tracking";
          break;
        case 5:
          System.out.println("You have picked the discipline Healing.");
          disciplines[i] = "Healing";
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
          disciplines[i] = "Weaponskill "+Weapon;
          break;
        case 7:
          System.out.println("You have picked the discipline Mindshield.");
          disciplines[i] = "Mindshield";
          break;
        case 8:
          System.out.println("You have picked the discipline Mindblast.");
          disciplines[i] = "Mindblast";
          maxCombatSkill = maxCombatSkill+2;
          break;
        case 9:
          System.out.println("You have picked the discipline Animal Kinship.");
          disciplines[i] = "Animal Kinship";
          break;
        case 10:
          System.out.println("You have picked the discipline Mind Over Matter.");
          disciplines[i] = "Mind Over Matter";
          break;
      }
    }
    System.out.println("\n\n\n\n\n");
  }
  public static void equipment() {
    weapons[0] = "Axe";
    backpack[0] = "Meal";
    crowns = (int)(Math.random() * 9) + 0;
    System.out.print("\nYou are dressed in the green tunic and cloak of a Kai initiate. You have little\nwith you to arm yourself for survival.\n\nAll you possess is an Axe and a Backpack containing 1 Meal. Hanging from your\nwaist is a leather pouch containing " + crowns + " Gold Crowns.\nYou also find ");
    int RandomItem = (int)(Math.random() * 9) + 0;
    switch(RandomItem) {
      case 1:
        System.out.print("a Sword.\n\n");
        weapons[1] = "Sword";
        break;
      case 2:
        System.out.print("a Helmet (+2 to ENDURANCE).");
        maxEndurance = maxEndurance + 2;
        break;
      case 3:
        System.out.print("two Meals.\n\n");
        backpack[1] = "Meal";
        backpack[2] = "Meal";
        break;
      case 4:
        System.out.print("Chainmail Waistcoat (+4 to ENDURANCE).\n\n");
        maxEndurance = maxEndurance + 4;
        break;
      case 5:
        System.out.print("a Mace.");
        weapons[1] = "Mace";
        break;
      case 6:
        System.out.print("a Healing Potion.\n\n");
        specialItems.add("Healing Potion");
        break;
      case 7:
        System.out.print("a Quarterstaff.\n\n");
        weapons[1] = "Quarterstaff";
        break;
      case 8:
        System.out.print("a Spear.\n\n");
        weapons[1] = "Spear";
        break;
      case 9:
        System.out.print("12 more gold Crowns.\n\n");
        crowns = crowns + 12;
        break;
      case 0:
        System.out.print("a Broadsword.\n\n");
        weapons[1] = "Broadsword";
        break;
    }
  }
  public static void pickNumber(int Options) {
    do{
      System.out.println("Pick number between 1 and " + Options + ".");
      choose = sc.nextInt();
      
    }while(choose > Options || choose < 1);
  }
  public static void game() {
    switch (chapter) {
      case 1:
        System.out.println("You must make haste for you sense it is not safe to linger by the smoking\nremains of the ruined monastery. The black-winged beasts could return at any\nmoment. You must set out for the Sommlending capital of Holmgard and tell the\nKing the terrible news of the massacre: that the whole ?lite of Kai warriors,\nsave yourself, have been slaughtered. Without the Kai Lords to lead her armies,\nSommerlund will be at the mercy of their ancient enemy, the Darklords.\n\nFighting back tears, you bid farewell to your dead kinsmen. Silently, you\npromise that their deaths will be avenged. You turn away from the ruins and\ncarefully descend the steep track.\n\nAt the foot of the hill, the path splits into two directions, both leading into\na large wood.\n");
        System.out.println("If you wish to take the right path into the wood, type 1.");
        System.out.println("If you wish to follow the left track, type 2.");
        if(checkDiscipline("Sixth Sense"))System.out.println("If you wish to use your Kai Discipline of Sixth Sense, type 3.");
        if(checkDiscipline("Sixth Sense"))pickNumber(3);
        else pickNumber(2);
		System.out.println(choose);
        switch(choose) {
          case 1: chapter = 85; break;
          case 2: chapter = 275;
          case 3: chapter = 141; break;
        }
        break;
      case 2:
        System.out.println("As you dash through the thickening trees, the shouts of the Giaks begin to fade\nbehind you. You have nearly outdistanced them completely, when you crash\nheadlong into a tangle of low branches.\n");
        roll = (int)(Math.random() * 9) + 0;
        if(roll <= 4) chapter = 343;
        else if(roll >= 5) chapter = 276;
        break;
      case 3:
        System.out.println("Staying close to the officer, you follow him through an arched portal and up a\nshort flight of stairs to a long hall. Soldiers run back and forth bearing\norders on ornate scrolls to officers stationed around the city wall.\n\nA haggard and scar-faced man dressed in the white and purple robes of the\nKing's court approaches you and bids you follow him to the citadel.\n");
        System.out.println("If you wish to follow this man, type 1.");
        System.out.println("If you wish to decline his offer and return to the crowded streets, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 196; break;
          case 2: chapter = 144; break;
        }
        break;
      case 4:
        System.out.println("It is a small one-man canoe in very poor condition. The wood has split and\nwarped, and the craft appears to be leaking in several places. You quickly\npatch up the worst of the holes with some clay and bail out the water. This\nseems to stop the leaking for the moment. Stowing your equipment at the bow,\nyou set off downstream, using a piece of driftwood as a paddle.\n\nAfter a short while, you hear the sound of horses galloping towards you along\nthe left bank.\n");
        System.out.println("If you wish to hide in the bottom of the canoe, type 1.");
        System.out.println("If you wish to try to attract their attention, type 2.");
        if(checkDiscipline("Sixth Sense"))System.out.println("If you wish to use your Kai Discipline of Sixth Sense, type 3.");
        if(checkDiscipline("Sixth Sense"))pickNumber(3);
        else pickNumber(2);
        switch(choose) {
          case 1: chapter = 75; break;
          case 2: chapter = 175; break;
          case 3: chapter = 218; break;
        }
        break;
      case 5:
        System.out.println("After about an hour of walking, the track slowly bears round to the east. You\nreach a shallow ford where a fast-flowing brook runs on a steep rocky course\ntowards the south. Just beyond the ford is a junction where the track meets a\nwider path running north to south. Realizing that the north path will take you\naway from the capital, you turn right at the junction and head south.\n");
        chapter = 111; break;
      case 6:
        System.out.println("In the distance you can hear the sound of horses galloping nearer. You crouch\nbehind a tree and wait as the riders come closer. They are the cavalry of the\nKing's Guard wearing the white uniforms of His Majesty's army.\n");
        System.out.println("If you wish to call them, type 1.");
        System.out.println("If you wish to let them pass and then continue on your way through the forest, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 183; break;
          case 2: chapter = 200; break;
        }
        break;
      case 7:
        System.out.println("For what seems an eternity, the rush of the crowd carries you along like a leaf\non a fast-flowing stream. You desperately fight to stay on your feet, but you\nfeel weak and dizzy from your ordeal, and your legs are as heavy as lead.\nSuddenly, you catch a glimpse of a long, narrow stone stairway that leads up to\nthe roof of an inn.\n\nGathering the last reserves of your strength, you dive for the stairs and climb\nslowly up to the top. From here you can see the magnificent view of the\nrooftops and spires of Holmgard, with the high stone walls of the citadel\ngleaming in the sun.\n\nThe houses and buildings of the capital are built very close to each other, and\nit is possible to jump from one roof to the next. In fact many of the citizens\nof Holmgard used to use the 'Roofways' (as they are known) when the heavy\nautumn rains made the unpaved parts of the streets too muddy for walking. But\nafter many accidents, a royal decree forbade their use.\n\nAfter careful thought, you decide to use the 'Roofways', as they are your only\nchance of reaching the King. You have hopped, skipped, and jumped across\nseveral streets and you are only one street away from the citadel when you come\nto the end of a row of rooftops.\n\nThe jump to the next row is much further than anything you have tried before,\nand your stomach begins to feel as if it were full of butterflies. Determined\nto reach the citadel, you turn and take a long run-up to the jump. With blood\npounding in your ears, you sprint to the edge of the roof and leap into space,\nyour eyes fixed on the opposite rooftop.\n");
        roll = (int)(Math.random() * 9) + 0;
        if(roll <= 2) chapter = 108;
        else chapter = 25;
        break;
      case 8:
        System.out.println("Your Kai Sixth Sense warns there is a fierce battle raging in the south. Your\ncommon sense tells you that the south is also the quickest route to the\ncapital.\n");
        chapter = 70; break;
      case 9:
        System.out.println("You cannot move: you are being held rigid by some powerful force. Your eyes are drawn towards the mouth of the skeleton. From deep in the earth you hear a low humming, like the sound of millions of angry bees. A dull red glow appears in the empty eye sockets of the dead King and the humming increases until your ears are filled with the deafening roar. You are in the presence of an ancient evil, far older and stronger than the Darklords themselves.\n"); //From here on out, I will not use \n and will not edit files.
        for(int i = 0; i < specialItems.size(); i++) {
          if(specialItems.get(i) == "Vordak Gem") chapter = 236; break;
        }
        break;
      case 10:
        System.out.println("You are sweating and your legs ache. In the middle distance you can see a group of cottages.\n");
        System.out.println("If you wish to enter a cottage and rest for a while, type 1.");
        System.out.println("If you wish to press on, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 115; break;
          case 2: chapter = 83; break;
        }
        break;
      case 11:
        System.out.println("You quickly dodge into the doorway of a stable and hide your surgeon's cloak in the straw, for it would be better to be seen as a Kai Lord than as a charlatan.\n\nwithout wasting a second, you set off towards the Great Hall on the other side of the courtyard.\n");;
        chapter = 139; break;        
      case 12:
        System.out.println("The bodyguard looks at you with great suspicion and then slams the door shut. You can hear the sound of voices inside the caravan. Suddenly the door swings open and the face of a wealthy merchant appears.\n\nHe demands 10 Gold Crowns as payment for the ride.\n");
        if(crowns >= 10) {
          System.out.println("If you wish to pay him, type 1.");
          System.out.println("If you wish do not wish to pay him, type 2.");
          pickNumber(2);
          switch(choose) {
            case 1: chapter = 262; break;
            case 2: chapter = 247; break;
          }
        }
        else chapter = 247; break;
      case 13:
        System.out.println("The path soon ends at a large clearing. In the centre of the clearing is a tree much taller and wider than any others you have seen in the forest.\n\nLooking up through the massive branches you can see a large treehouse some twenty-five to thirty feet above the ground. There is no ladder, but the gnarled bark of the tree offers many footholds.\n");
        System.out.println("If you wish to climb the tree and search the treehouse, type 1.");
        System.out.println("If you would rather press on, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 307; break;
          case 2: chapter = 213; break;
        }
        break;
      case 14:
        System.out.println("You reach the top of a small wooded hill on which several large boulders form a rough circle. Suddenly you hear a loud growl from behind a rock to your left.\n");
        System.out.println("If you wish to draw your weapon and prepare to fight, type 1.");
        System.out.println("If you would rather take evasive action by running as fast as you can over the hill, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 43; break;
          case 2: chapter = 106; break;
        }
        break;
      case 15:
        System.out.println("You pass through a long, dark tunnel of overhanging branches that eventually opens out into a large clearing. On a stone plinth in the centre of the clearing is a Sword, sheathed in a black leather scabbard. A handwritten note has been tied to the hilt, but it is in a language which is foreign to you.\n");
        if(weapons[0] == null || weapons[1] == null) {
          System.out.println("Do you want to take the sword? Y/N");
          what = getYesNoAnswer();
          if(what) {
            if(weapons[0] == null) weapons[0] = "Sword";
            else weapons[1] = "Sword";
          }
        }
        else System.out.println("You can't wield any more weapons.");
        System.out.println("There are three exits from the clearing.\n");
        System.out.println("If you decide to go east, type 1.");
        System.out.println("If you decide to go west, type 2.");
        System.out.println("If you decide to go south, type 3.");
        pickNumber(3);
        switch(choose) {
          case 1: chapter = 207; break;
          case 2: chapter = 201; break;
          case 3  : chapter = 35; break;
        }
        break;
      case 16:
        System.out.println("You manage to free a horse from the straps securing it to the caravan. It is frightened by the scent of the approaching Doomwolves, and the cries of their evil riders-the Giaks.\n\nPreparing your weapon, you spur your skittish horse towards the oncoming beasts. They are less than fifty yards away and they are lowering their lances at you as they get nearer and nearer.\n");
        chapter = 192; break;
      case 17:
        System.out.println("You raise your weapon to strike at the beast as its razor-fanged mouth snaps shut just inches from your head. Buffeted by the beating of its wings you find it difficult to stand.\n");
        fight("Kraan",16,24,1,0,17);
        System.out.println("You quickly descend the far side of the hill to avoid the Giaks.");
        roll = (int)(Math.random() * 9) + 0;
        if(roll == 0) chapter = 53;
        else if(roll <= 2) chapter = 274;
        else chapter = 316;
        break;
      case 18:
        System.out.println("You are awoken by the sound of troops in the distance. Across the lake you see the black-cloaked figures of Drakkarim and a pack of Doomwolves and their riders. A Kraan appears from above the trees and lands on the roof of the small wooden shack.\n\nIt is ridden by a creature dressed in red. The Kraan takes off and begins to fly across the lake to where you are hidden.\n");
        System.out.println("If you wish to ride deeper in the forest, type 1.");
        System.out.println("If you wish to fight the creature, type 2.");
        if(checkDiscipline("Camouflage"))System.out.println("If you wish to use your Kai Discipline of Camouflage, type 3.");
        if(checkDiscipline("Camouflage"))pickNumber(3);
        else pickNumber(2);
        switch(choose) {
          case 1: chapter = 239; break;
          case 2: chapter = 29; break;
          case 3: chapter = 114; break;
        }
        break;
      case 19:
        System.out.println("\n");
        System.out.println("If you wish to avoid the Sleeptooth by returning to the track, type 1.");
        System.out.println("If you wish to push on through the briars, deeper into the forest, type 2.");
        if(checkDiscipline("Tracking"))System.out.println("If you wish to use your Kai Discipline of Tracking, type 3.");
        if(checkDiscipline("Tracking"))pickNumber(3);
        else pickNumber(2);
        switch(choose) {
          case 1: chapter = 69; break;
          case 2: chapter = 272; break;
          case 3: chapter = 119; break;
        }
        break;
      case 20:
        System.out.println("It seems that whoever lived here left in a great hurry-and they must have left quite recently. A half-eaten meal still remains on the table, and a mug of dark jala is still warm to the touch.\n\nSearching a chest and small wardrobe, you find a Backpack, food (enough for two Meals), and a Dagger.\n");
        if(backpack[0] == null || backpack[1] == null || backpack[2] == null|| backpack[3] == null) {
          System.out.println("Do you want to take the meal? Y/N");
          what = getYesNoAnswer();
          if(what) {
            if(backpack[0] == null) backpack[0] = "Meal";
            else if(backpack[1] == null) backpack[1] = "Meal";
            else if(backpack[2] == null) backpack[2] = "Meal";
            else backpack[3] = "Meal";
          }
        }
        else System.out.println("You can't wield any more items.");
        if(backpack[0] == null || backpack[1] == null || backpack[2] == null|| backpack[3] == null) {
          System.out.println("Do you want to take the meal? Y/N");
          what = getYesNoAnswer();
          if(what) {
            if(backpack[0] == null) backpack[0] = "Meal";
            else if(backpack[1] == null) backpack[1] = "Meal";
            else if(backpack[2] == null) backpack[2] = "Meal";
            else backpack[3] = "Meal";
          }
        }
        else System.out.println("You can't wield any more items.");
        if(weapons[0] == null || weapons[1] == null) {
          System.out.println("Do you want to take the dagger? Y/N");
          what = getYesNoAnswer();
          if(what) {
            if(weapons[0] == null) weapons[0] = "Dagger";
            else weapons[1] = "Dagger";
          }
        }
        else System.out.println("You can't wield any more weapons.");
        chapter = 273; break;

      case 21:
        System.out.println("You have ridden about two miles into the tangle of trees when the ground becomes very marshy.\n");
        roll = (int)(Math.random() * 9) + 0;
        if(roll < 5) {
          System.out.println("Your horse has suddenly plunged into thick mud up to its belly.");
          roll = (int)(Math.random() * 9) + 0;
          if(roll <= 7) {
            System.out.println("The mud engulfs you up to your armpits. Your horse gives one last despairing scream as its muzzle disappears into the bubbling mud.");
            roll = (int)(Math.random() * 9) + 0;
            if(roll != 9){
              System.out.println("The foul-smelling bog sucks you under and claims another victim. Your life and your mission end here.");
              ded();
            }
            else chapter = 312; break;
          }
          else {
            System.out.println("You drag yourself onto firm ground.");
            chapter = 189; break;
          }
        }
        else {
          System.out.println("You manage to steer clear of the morass.");
          chapter = 189; break;
        }
      case 22:
        System.out.println("Knocking aside the leader, you sprint off along the highway. Then behind you the ominous click of a crossbow being cocked sends a shiver down your spine.\n");
        roll = (int)(Math.random() * 9) + 0;
        if(roll <= 4) chapter = 181;
        else chapter = 145;
        break;
      case 23:
        System.out.println("The corridor soon widens into a large hall. At the far end, a stone staircase leads up to a huge door. Two black candles on either side of the stone steps dimly illuminate the chamber. You notice that no wax has melted, and as you get nearer you can feel that they give off no heat. Ancient engravings cover the stone surfaces of the walls.\n\nAnxious to leave this evil tomb, you examine the door for a latch. An ornate pin appears to lock the door, but there is also a keyhole in the lockplate.\n");
        System.out.println("If you wish to remove the pin, type 1.");
        if(checkDiscipline("Mind Over Matter")) System.out.println("If you wish to use your Kai Discipline of Mind Over Matter, type 2.");    
        for(int i = 0; i < specialItems.size(); i++) {
          if(specialItems.get(i) == "Golden Key") System.out.println("If you have a Golden Key and wish to use it, type 3.");
        }
        pickNumber(3);
        switch(choose) {
          case 1: chapter = 337; break;
          case 2: chapter = 326; break;
          case 3: chapter = 337; break;
        }
        break;
      case 24:
        System.out.println("The merchant shouts to the driver of the caravan to jump. 'We're under attack!' he cries, disappearing through a circular window.\n");
        System.out.println("If you decide to jump after him, type 1.");
        System.out.println("If you decide to run through the caravan and grab the reins of the horse team, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 234; break;
          case 2: chapter = 184; break;
        }
        break;
      case 25:
        System.out.println("You land with such a crash on the opposite roof, that the wind is knocked out of you and you lie flat on your back with your head in a spin.\n\nIt takes a minute or so for you to realize that you've made it and are perfectly safe. When you are sure you are all right, you jump up and let out a shout for joy at your skill and daring.\n\nQuickly you find a way across the roof and climb down a long drainpipe to the street below. You see the large iron doors of the citadel open, and a wagon drawn by two large horses tries to leave. The horses are frightened by the noisy crowd and they both rear up, causing the wagon to smash a front wheel against the door. In the confusion, you see a chance to enter and quickly slip inside just as the guards slam the doors shut.\n");
        chapter = 139; break;
      case 26:
        System.out.println("Cautiously, you move along the corridor until you come to a sharp eastward turn. A strange greenish light can be seen in the distance.\n");
        System.out.println("If you wish to continue, type 1.");
        System.out.println("If you wish to go back and try the southern route, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 249; break;
          case 2: chapter = 100; break;
        }
        break;
      case 27:
        System.out.println("You walk along this path for over an hour, carefully watching the sky above you in case the Kraan attack again. Up ahead, a large tree has fallen across the path. As you approach, you can hear voices coming from the other side of the massive trunk.\n");
        System.out.println("If you choose to attack, type 1.");
        System.out.println("If you choose to listen to what the voices say, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 250; break;
          case 2: chapter = 52; break;
        }
        break;
      case 28:
        System.out.println("After a few hundred yards, the path joins another one running north to south.\n");
        System.out.println("If you wish to go northwards, type 1.");
        System.out.println("If you wish to head south, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 130; break;
          case 2: chapter = 147; break;
        }
        break;
      case 29:
        System.out.println("You stride out to the water's edge and prepare yourself for combat. The Kraan and its rider spot you and begin to speed across the lake barely inches above the surface.\n\nThe rider lets out a scream that freezes your blood. He is a Vordak, a fierce lieutenant of the Darklords.\n");
        if(checkDiscipline("Mindshield")) fight("Vordak",17,25,0,0,29);
        else fight("Vordak",17,25,2,0,29);
        chapter = 270; break;
      case 30:
        System.out.println("The people look tired and hungry. They have come many miles from their burning city. Suddenly, you hear the beat of huge wings coming from the north.\n\n'Kraan, Kraan! Hide yourselves!' the cry goes up all along the road.\n\nJust in front of you, a wagon carrying small children breaks down, its right wheel jammed in a furrow. The children scream in panic.\n");
        System.out.println("If you wish to help the children, type 1.");
        System.out.println("If you'd rather run for the cover of the trees, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 194; break;
          case 2: chapter = 261; break;
        }
        break;
      case 31:
        System.out.println("You try to comfort the injured man as best you can, but his wounds are serious and he is soon unconscious again. Covering him with his cape, you turn and press deeper into the forest.\n");
        chapter = 264; break;
      case 32:
        System.out.println("You have ridden about three miles when, in the distance, you spot the unmistakable silhouette of five large Doomwolves. Riding on their backs are Giaks. They seem to be going on ahead to where the path leads down into an open meadow. Suddenly, one of the Giaks leaves the others and begins to ride back along the path towards you.\n");
        System.out.println("If you wish to hide in the undergrowth and let him pass, type 1.");
        System.out.println("If you wish to fight him, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 176; break;
          case 2: chapter = 340; break;
        }
        break;
      case 33:
        System.out.println("The floor of the cave is quite dry and dusty. As you explore deeper in the half-light, you detect the stale odour of rotting flesh. Littering a crevice are the bones, fur, and teeth of several small animals. You notice a small cloth bag among these remains which you open to discover 3 Gold Crowns. Pocketing these coins, you leave what appears to be the lair of a mountain cat and carefully descend the hill.\n");
        chapter = 248; break;
      case 34:
        System.out.println("Without warning, a terrible apparition in red robes swoops down from the sky on the back of a Kraan. Its cry freezes your blood. The beast is a Vordak, a fierce lieutenant of the Darklords.\n\nHe is above you and you must fight him.\n");
        if(checkDiscipline("Mindshield")) fight("Vordak",17,25,0,0,34);
        else fight("Vordak",17,25,2,0,34);
        chapter = 328; break;
      case 35:
        System.out.println("The forest is becoming denser, and the path more tangled with thorny briars. Almost completely hidden by the undergrowth, you notice another path branching off towards the east. Your current route seems to be coming to a prickly end, so you decide to follow the new path eastwards.\n");
        chapter = 207; break;
      case 36:
        System.out.println("The old watchtower ladder is rotten and several rungs break as you climb.\n");
        roll = (int)(Math.random() * 9) + 0;
        if(roll <= 4) System.out.println("You have fallen.");
        else System.out.println("You do not fall.");
        chapter = 323; break;
      case 37:
        System.out.println("You are feeling tired and hungry and you must stop to eat. After your Meal, you retrace your steps back to the citadel and begin to walk around the high, indomitable stone wall.\n\nYou discover another entrance on the eastern side, guarded as before by two armoured soldiers.\n");
        System.out.println("If you wish to approach them and tell your story, type 1.");
        if(checkDiscipline("Mindshield")) {
          System.out.println("If you wish to use the Kai Discipline of Camouflage, type 2.");
          pickNumber(2);
        }
        else pickNumber(1);
        switch(choose) {
          case 1: chapter = 289; break;
          case 2: chapter = 282; break;
        }
        break;
      case 38:
        System.out.println("For half an hour or more you press on through the forest, through the rich vegetation and ferns. You happen upon a small clear stream where you stop for a few minutes to wash your face and drink of the cold, fresh water.\n\nFeeling revitalized, you cross the stream and press on. You soon notice the smell of wood smoke which seems to be drifting towards you from the north.\n");
        System.out.println("If you wish to investigate the smell of wood smoke, type 1.");
        System.out.println("If you would rather avoid the source of this smoke, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 128; break;
          case 2: chapter = 347; break;
        }
        break;
      case 39:
        System.out.println("After a few seconds, two small furry faces nervously appear over the top of the trunk. They say they are Kakarmi and tell you that the Kraan are everywhere. To the west lie the remains of their village but little is left of it now. They are trying to find the rest of their tribe who took to the forest when the 'Black-wings' attacked. They point behind them-east along the path-and tell you that the trail appears to be a dead end, but that if you continue through the undergrowth for a few yards more, you will find a watchtower where the path splits into three directions. Take the east path. This leads to the King's highway between the capital city-Holmgard-and the northern port of Toran.\n\nYou thank the Kakarmi, and bid them farewell.\n");
        chapter = 228; break;
      case 40:
        System.out.println("Keeping a careful watch on the huts for any sign of the enemy, you make your way around the clearing under the cover of the trees and bracken. Rejoining the track, you hurry away from Fogwood.\n");
        chapter = 105; break;
      case 41:
        System.out.println("Three rangers gallop past the river bank, closely followed by the Giaks on their snarling Doomwolves.\n\nThe bank is steep and you are spotted by the Giak leader who orders five of his troops to open fire at you with their bows. Their black arrows rain down on you.\n");
        System.out.println("If you decide to paddle downstream as fast as you can, type 1.");
        System.out.println("If you decide to head for the cover of the trees on the opposite bank, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 174; break;
          case 2: chapter = 116; break;
        }
        break;
      case 42:
        System.out.println("\n");
        System.out.println("If you wish to continue east, type 1.");
        System.out.println("If you would rather head north, type 2.");
        System.out.println("If you decide to venture south, type 3.");
        System.out.println("Or if you prefer to go west, type 4.");
        pickNumber(4);
        switch(choose) {
          case 1: chapter = 86; break;
          case 2: chapter = 238; break;
          case 3: chapter = 157; break;
          case 4: chapter = 147; break;
        }
        break;
      case 43:
        System.out.println("From behind the rock a huge black bear comes into view. It advances slowly towards you, its mouth open and its face lined in anger and pain.\n\nYou notice that it is badly wounded and is bleeding from its neck and back. You must fight it.\n");
        chapter = 195;
        fight("Black Bear",16,10,0,3,106);
        break;
      case 44:
        System.out.println("Without warning, the old track ends abruptly at the edge of a steep slope. The ground here is very loose and unstable. You lose your footing and fall headlong over the edge.\n");
        roll = (int)(Math.random() * 9) + 0;
        if(roll <= 4) chapter = 277;
        else chapter = 338;
        break;
      case 45:
        System.out.println("These men are not what they seem. The tunic of the leader is genuine but it is heavily bloodstained around the collar, as if its true owner had been murdered. Their weapons are not army issue, but expensive and lavishly decorated like the weapons made by the armourers of Durenor.\n\nThe leader has a crossbow slung over his pack. An attempt to run would be suicide. You decide that you must fight them or you will surely be murdered as soon as you drop your weapon.\n");
        chapter = 180; break;
      case 46:
        System.out.println("You have covered about two miles when the trees ahead thin out. You can see a small wooden shack on the edge of a lake. A cloaked man approaches you and offers to row you and your horse across the lake for a fee of 2 Gold \n");
        System.out.println("If you refuse and try to ride around the lake, type 1.");
        if(crowns >= 2){
          System.out.println("If you accept the offer, type 2.");
          crowns = crowns-2; break;
        }
        if(checkDiscipline("Sixth Sense")) System.out.println("If you wish to use your Kai Discipline of Sixth Sense, type 3.");
        pickNumber(3);
        switch(choose) {
          case 1: chapter = 90; break;
          case 2: chapter = 246; break;
        	case 3: chapter = 296; break;
        }
        break;
      case 47:
        System.out.println("Breathless and sweating, you claw your way towards the summit of the hill. Suddenly, a large winged shadow passes across the hillside. You look up to see a Kraan circling the peak above. Behind you the Giaks are gaining ground.\n");
        System.out.println("If you wish to stand and fight the Giaks where you are, using the high ground to your advantage, type 1.");
        System.out.println("If you grit your teeth and press on towards the peak of the hill, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 136; break;
          case 2: chapter = 322; break;
        }
        break;
      case 48:
        System.out.println("Your Sixth Sense warns you that these troops are not all they seem. You can detect an aura of evil about them. They are in the service of the Darklords.\n\nYou must leave here quickly before you are spotted.\n");
        chapter = 243; break;
      case 49:
        System.out.println("As you begin to read the inscription, you notice a shadow moving towards you from behind the screen.\n");
        roll = (int)(Math.random() * 9) + 0;
        if(roll <= 4) chapter = 339;
        else chapter = 60;
        break;
      case 50:
        System.out.println("The sound of fighting can be heard in the distance.\n");
        System.out.println("If you wish to continue towards the sound of battle, type 1.");
        System.out.println("If you wish to avoid the fighting and change direction, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 97; break;
          case 2: chapter = 243; break;
        }
        break;
      case 51:
        System.out.println("You climb the wooded bank of the river and see the log walls of the fieldworks disappearing into the distance.\n\nA battle rages about two miles away and the log wall has collapsed in several places where the Darklords are attacking.\n\nMost of the fieldworks ahead are unmanned, the soldiers having left to supply reinforcements for the raging battle.\n");
        System.out.println("There is a gate in the log wall. If you wish to approach it, type 1.");
        System.out.println("If you would prefer to climb over the wall instead, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 288; break;
          case 2: chapter = 221; break;
        }
        break;
      case 52:
        System.out.println("Now that you are closer, you can make out that the voices are not human. The sound is more like a kind of grunting and squeaking.\n");
        if(checkDiscipline("Animal Kinship")) chapter = 255;
        else {
          System.out.println("You must climb over the tree and face whatever lurks on the other side");
          chapter = 250; break;
        }
        break;
      case 53:
        System.out.println("A searing pain tears through your right leg as it is twisted and crushed by the weight of your body. Down and down you tumble, until you finally land in a ditch at the base of the hill with such force that the wind is knocked out of you and you lose consciousness.\n\nYou are awoken by the sharp pain of something stabbing your chest. It proves to be the tip of a Giak spear. You are greeted by the malicious sneer of its owner as he pins your left arm to the ground. Instinctively you reach for your weapon but it is no longer there.\n\nDefenceless against the cruel Giaks, the last thing that you see before all light fades is the jagged point of a Giak lance hurtling down towards your throat.\n\nYour mission ends here.\n");
        ded();
        break;
      case 54:
        System.out.println("It would seem that the heavens have not heard your prayers. A spear whistles past your head and embeds itself in the neck of your galloping horse. With a shriek of pain, the horse topples forward and you both roll in a tangled heap on the highway.\n\nDazed and pinned down by the weight of the dead body of your horse, the last thing you remember is the sharp penetrating spearheads of the Giak lances.\n\nYou have failed in your mission.\n");
        ded();
        break;
      case 55:
        System.out.println("Just as the Giak makes his leap, you race forward and strike out with your weapon-knocking the creature away from the young wizard's back.\nYou jump onto the struggling Giak and strike again. Due to the surprise of your attack, add 4 points to your COMBAT SKILL for the duration of this fight but remember to deduct it again as soon as the fight is over.\n");
        fight("Giak",9,9,0,0,55);
        chapter = 325; break;
      case 56:
        System.out.println("You hear the scream of a large winged beast above the trees. It is a Kraan, a deadly servant of the Darklords. Quickly you hide beneath the thick fronds of fern until the horrible shrieks have passed away.\n");
        chapter = 222; break;
      case 57:
        System.out.println("The cabin has only one room. In it you see a wooden table and two benches, a large bed made of straw bales lashed together, several bottles of coloured liquids, and an embroidered rug in the centre of the floor.\n");
        System.out.println("If you choose to take a closer look at the bottles, type 1.");
        System.out.println("If you choose to pull back the rug, type 2.");
        System.out.println("If you choose to leave the room and investigate the stable, type 3.");
        pickNumber(3);
        switch(choose) {
          case 1: chapter = 164; break;
          case 2: chapter = 109; break;
          case 3: chapter = 308; break;
        }
        break;
      case 58:
        System.out.println("Bracing yourself for the run, you head off down the ridge at a steady pace. To the west, the army of the Darklords looks like a giant pot of black ink that has been spilled between the mountains and is spreading into the land below.\n\nYou have been running for twenty minutes when you catch sight of a pack of Doomwolves lining a shallow ridge to your right.\n");
        System.out.println("If you decide to flatten yourself against the rocks along the side of the road and wait until they pass, type 1.");
        System.out.println("If you decide to carry on running, but draw your weapon just in case they attack, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 251; break;
          case 2: chapter = 160; break;
        }
        break;
      case 59:
        System.out.println("Peering into the darkness, you notice that rough stairs have been cut into the earth and that the mouth of the cave is in fact the entrance to a tunnel.\n\nCarefully descending the slippery stairway, you notice a small silver box on a shelf at the bottom of the staircase.\n");
        System.out.println("If you want to open the silver box, type 1.");
        System.out.println("If you wish to return to the surface and press on, type 2.");
        System.out.println("If you wish to investigate the tunnel further, type 3.");
        pickNumber(3);
        switch(choose) {
          case 1: chapter = 124; break;
          case 2: chapter = 106; break;
          case 3: chapter = 211; break;
        }
        break;
      case 60:
        System.out.println("The last thing you remember before darkness engulfs you is the flash of a long curved steel knife. You have become yet another victim of the Sage and his robber son-the very one who has just slit your throat!\n\nYour quest ends here.\n");
        ded();
        break;
      case 61:
        System.out.println("At last you can reach the wooden fieldworks surrounding the outer city. As you race towards a sentry post, you can hear the excited shouts of the guards cheering you on. Thank the gods that they recognize you, for you must appear a ragged and suspicious figure. Your cloak is torn and hangs in tatters, your face is scratched and blood-smeared, and the dust of the Graveyard covers you from head to toe.\n\nSplashing through a shallow stream, you stagger towards the gate. The full horror of the Graveyard encounter begins to catch up with you. The last thing you recall before exhaustion robs you of consciousness, is falling into the outstretched arms of two soldiers who have run from the fieldworks to help you.\n");
        chapter = 268; break;
      case 62:
        System.out.println("The 'soldiers' lie dead at your feet. They were bandits who were stealing from the refugees of Toran, and from the abandoned houses and farms in the area.\n\nSearching their bodies you find 28 Gold Crowns and two Backpacks containing enough food for 3 Meals. They had been armed with a crossbow and three Swords. The crossbow has been damaged in the fight, but the Swords are untouched and you may keep one if you wish.\n\nYou adjust your equipment, give a cautious glance towards the west, and continue your run towards the outer defences of the capital.\n");
        chapter = 288; break;
      case 63:
        System.out.println("The wild old man is screaming at you. He blames you for the war and curses the Kai Lords as agents of the Darklords. He will not listen to reason and you must fight him.\n");
        fight("Madman",11,10,0,0,63);
        chapter = 269; break;
      case 64:
        System.out.println("You are awoken by the cries of a Kraan circling above the caravan. It is early morning and the sky is clear and bright. You can see a pack of Doomwolves less than a quarter of a mile away along the highway ahead. They are preparing to attack. You must act quickly.\n");
        System.out.println("If you decide to gather your equipment and run for the cover of the trees, type 1.");
        System.out.println("If you decide to cut free one of the horses and try to break through the attacking Doomwolves to the clear road beyond, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 188; break;
          case 2: chapter = 16; break;
        }
        break;
      case 65:
        System.out.println("Your senses scream at you that this place is very evil. Leave as quickly as you can.\n");
        chapter = 104; break;
      case 66:
        System.out.println("Startled, you turn around to see a burly sergeant and two soldiers running towards you, their swords drawn as if to strike.\n\nYou prepare to defend yourself for it looks as if they are about to attack first and ask questions later; but suddenly the sergeant calls his men to a halt. He has recognized your cloak. They put away their weapons and apologize many times for their mistake. The sergeant orders one of the men to fetch the captain of the Guard as he leads you to the doors of the Great Hall.\n\nYou are greeted by a tall and handsome warrior who listens intently to your story. When you have finished the account of your perilous journey to the capital, you notice a tear in the brave man's eye as he bids you to follow him. You walk through the splendid halls and corridors of the inner Palace. The richness and grandeur are a wonder to behold. You eventually arrive at a large carved door, guarded by two soldiers wearing silver armour.\n\nYou are about to meet the King.\n");
        chapter = 350; break;
      case 67:
        System.out.println("Your Kai Discipline of Tracking reveals to you fresh paw prints leading off along the south path.\n\nThey are the prints of a black bear, an animal renowned for its ferocity. You decide the east path would be a much safer route.\n");
        chapter = 252; break;
      case 68:
        System.out.println("After a short walk, you reach a junction where a path crosses your present route heading from west to east.\n");
        System.out.println("If you wish to turn west, type 1.");
        System.out.println("If you wish to head east, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 130; break;
          case 2: chapter = 15; break;
        }
        break;
      case 69:
        System.out.println("You are very near a friendly village.\n\nAvoid the gallowbrush.\n");
        chapter = 272; break;
      case 70:
        System.out.println("You have reached a small bridge. A track follows the stream towards the east. A much narrower path disappears into thick forest towards the south.\n");
        System.out.println("If you wish to go east, type 1.");
        System.out.println("If you wish to go south, type 2.");
    		if(checkDiscipline("Sixth Sense")) {
          System.out.println("If you wish to use your Kai Discipline of Sixth Sense, type 3.");
          pickNumber(3);
        }
    		else pickNumber(2);
        switch(choose) {
          case 1: chapter = 28; break;
          case 2: chapter = 157; break;
          case 3: chapter = 8; break;
        }
        break;
      case 71:
        System.out.println("You are winded but not hurt. You have fallen fifteen feet or so through the roof of an underground tomb. The walls are sheer and you cannot climb them. An arched tunnel leads out of the tomb towards the east, in front of which lies the sarcophagus of some ancient noble.\n");
        System.out.println("If you wish to open the sarcophagus to see if it contains any treasure, type 1.");
        System.out.println("If you wish to leave via the tunnel, type 2.");
    		if(checkDiscipline("Sixth Sense")) {
          System.out.println("If you wish to use your Kai Discipline of Sixth Sense, type 3.");
          pickNumber(3);
        }
    		else pickNumber(2);
        switch(choose) {
          case 1: chapter = 242; break;
          case 2: chapter = 104; break;
          case 3: chapter = 65; break;
        }
        break;
      case 72:
				System.out.println("You turn to face a sneering Giak and the razor-fanged jaws of its mount. You must fight them as one enemy.");
        fight("Giak + Doomwolf",15,24,0,0,72);
    		chapter = 265; break;
      case 73:
        System.out.println("Pulling your green cloak about you, you blend into the foliage and rocks. Peering carefully up at the track, you are shocked to see that they are not the King's men at all.\n\nThey are Drakkarim, some of the Darklords' cruellest troops. They must have disguised themselves as soldiers of the King in order to get this far into the forest. Thanking your Kai training for saving your life, you silently slip away from the stream and push on into the forest.\n");
        chapter = 243; break;
      case 74:
        System.out.println("The Kraan and its riders land on the track barely ten feet from where you are hidden.\n\nThe Giaks leap from the scaly backs of the Kraan and move towards you, their spears raised to strike. You have been seen.\n");
        System.out.println("If you decide to fight them, type 1.");
        System.out.println("If you decide to run deeper into the forest without delay, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 138; break;
          case 2: chapter = 281; break;
        }
        break;
      case 75:
        System.out.println("Peering out carefully, you can see three green-clad men on horses racing along the bank. You recognize them as Border Rangers, the regiment of the King's Army that police the western borders. One of them is wounded and is slumped over the neck of his horse.\n\nClose behind follow a pack of twenty Doomwolves. Their Giak riders are firing arrows at the rangers which fall all around them. One ranger drops from his horse and rolls down the river bank, a black arrow deeply embedded in his right leg.\n");
        System.out.println("If you wish to help the ranger, type 1.");
        System.out.println("If you wish to stay hidden and drift downstream, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 260; break;
          case 2: chapter = 163; break;
        }
        break;
    case 76:
        System.out.println("The Gem feels very hot and burns your hand. You quickly grab it with the edge of your cloak and slip this Vordak Gem into your Backpack. A Gem that size must be worth hundreds of Crowns! You smile at your good fortune, mount your horse, and ride off along the south track.\n");
        Endurance = Endurance - 2;
    		chapter = 118; break;
    case 77:
        System.out.println("The Mountain Giaks are unaccustomed to pursuing their prey through forests and you soon outdistance them, until finally the sound of their grunts and curses disappears completely.	\n\nWhen you are satisfied that they have given up the chase, you stop for a few minutes to catch your breath and check your equipment. With the memory of your ruined monastery still blazing in your mind, you gather up your meagre belongings and push on.\n");
        chapter = 19; break;
    case 78:
        System.out.println("As the caravan careers past, you leap for the tailboard and manage to hold fast. Pulling yourself upright, you find that you are standing on the bottom rung of a ladder leading to the rear door of the wagon. Suddenly the top half of the door flies open and you are confronted by the angry face of a bodyguard.\n");
        System.out.println("If you decide to inform him that you are a Kai Lord with an urgent message for the King, type 1.");
        System.out.println("If you decide to offer him Gold Crowns for safe passage to the capital, type 2.");
    		System.out.println("If you decide to attack the guard with your weapon, type 3.");
        pickNumber(3);
        switch(choose) {
          case 1: chapter = 132; break;
          case 2: chapter = 12; break;
          case 3: chapter = 220; break;
        }
        break;
    case 79:
        System.out.println("You come to a small footbridge across a fast-flowing stream. On the other side of the bridge the path turns south. You cross the bridge and follow the path.\n");
        chapter = 204; break;
    case 80:
        System.out.println("You stumble backwards through the front door, clutching your burnt chest with both hands. Smoke is billowing from the shop and you must run-before the Sage or his robber son catch you.\n\nYou make it back to the main street and lose yourself in the rush of the crowds.\n");
        chapter = 7; break;
    case 81:
        System.out.println("After nearly an hour, the Kraan and their cruel riders vanish towards the west. As the shocked refugees start to emerge from the woods, you can hear the sound of horses in the distance galloping nearer. You stay hidden and wait as the riders come closer. They are the cavalry of the King's Guard wearing the white uniforms of His Majesty's army.\n");
        System.out.println("If you wish to call to them, type 1.");
        System.out.println("If you would rather continue along the forest edge towards the south, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 183; break;
          case 2: chapter = 200; break;
        }
        break;
    case 82:
        System.out.println("The giant Gourgaz lies dead at your feet. His evil followers hiss at you and then fall back from the bridge. The Prince's soldiers form a protective wall around you and their dying leader with their shields. Black arrows whistle past your head.\n\nThe dying Prince looks up into your eyes and says, 'Kai Lord, you must take a message to my father. The enemy is too strong, we cannot hold him. The King must seek that which is in Durenor or all is lost. Take my horse and ride for the capital. May the luck of the gods ride with you.'\n\nYou bid a sad farewell to the Prince, mount his white steed, and head south along the forest path. The battle still rages behind you as the Prince's men fight off another assault on the bridge.\n");
        chapter = 235; break;
    case 83:
        System.out.println("You have run about a mile when three soldiers appear from beneath a small footbridge. They demand that you halt and drop your weapons and equipment.\n\nThey are bloodstained and unshaven. Their leader is wearing the tunic of a soldier of the Toran garrison.\n");
        System.out.println("If you wish to do as they say, type 1.");
        System.out.println("If you wish to prepare to fight them, type 2.");
   			System.out.println("If you demand to know what they want, type 3.");
    		if(checkDiscipline("Sixth Sense")) {
          System.out.println("If you wish to use your Kai Discipline of Sixth Sense, type 4.");
          pickNumber(4);
        }
    		else pickNumber(3);
        switch(choose) {
          case 1: chapter = 205; break;
          case 2: chapter = 180; break;
          case 3: chapter = 232; break;
          case 4: chapter = 45; break;
        }
        break;
    case 84:
        System.out.println("Just as you feel the air beating on your back, you slip free of your horse and roll over-landing with a splash in a muddy ditch by the side of the highway.\n\nYou are uninjured, and you quickly scramble to your feet and make a dash for the cover of the trees-but with thirty yards left to run, you see the Kraan circling above for another dive.\n");
        chapter = 188; break;
    case 85:
        System.out.println("The path is wide and leads straight into thick undergrowth. The trees are tall here and unusually quiet. You walk for over a mile when suddenly you hear the beating of large wings directly above you. Looking up, you are shocked to see the sinister black outline of a Kraan diving to attack you.\n");
        System.out.println("If you draw your weapon and prepare to fight, type 1.");
        System.out.println("If you evade the attack by running south, deeper into the forest, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 229; break;
          case 2: chapter = 99; break;
        }
        break;
    case 86:
        System.out.println("You soon reach another crossroads.\n");
        System.out.println("If you wish to journey east, type 1.");
        System.out.println("If you wish to head north, type 2.");
    		System.out.println("If you prefer to go south, type 3.");
   			System.out.println("Or if you wish to turn west, type 4.");
        pickNumber(4);
        switch(choose) {
          case 1: chapter = 6; break;
          case 2: chapter = 35; break;
          case 3: chapter = 167; break;
          case 4: chapter = 42; break;
        }
        break;
    case 87:
        System.out.println("Focusing your powers on the lock, you try to visualize the inner mechanism. Gradually its image appears in your mind's eye. It is old and corroded but it still functions. You are in danger of losing your concentration when a subtle click confirms that your effort has not been in vain.\n\nThe pin is an easier task. Slowly it rises out of the lock and falls to the floor. The granite door swings towards you on hidden hinges and the grey half-light of the Graveyard floods into the tomb. The exit is overgrown with graveweed and you suffer many small cuts to your face and hands as you fight your way through to the surface. You are startled by a sudden noise. You turn to see the disembodied head of a corpse laughing at you.\n\nIn blind panic, you race through the eerie necropolis towards the southern gate.\n");
        chapter = 61; break;
    case 88:
        System.out.println("You cautiously peer around the rock to see a soldier lying on his back. By his side is a Spear and shield. On the shield is the painting of a white pegasus-the Prince of Sommerlund's emblem. He is one of the Prince's soldiers, and he is only just conscious. His uniform is badly torn, and you can see that he has a deep wound in his left arm. As you move nearer, his eyes flicker open. 'Heal me, my lord,' he begs. 'I can barely feel my arm.'\n");
    		if(checkDiscipline("Healing")){
          System.out.println("If you wish to use the Kai Discipline of Healing on this man, type 1.");
          System.out.println("If you do not want to use it, type 2.");
          pickNumber(2);
          switch(choose) {
            case 1: chapter = 216; break;
            case 2: chapter = 31; break;
        	}
        }    
    		else chapter = 31; break;
    case 89:
        System.out.println("In a cloud of dust and loose rocks you career down the steep hillside. The Kraan is still circling above as if waiting to direct the Giaks after you.\n");
        roll = (int)(Math.random() * 9) + 0;
        if(roll <= 1) chapter = 53;
        else if(roll <= 4) chapter = 274;
    		else chapter = 316;
        break;
    case 90:
        System.out.println("Night falls and you are soon engulfed in total darkness. To press on would be useless, for you would be sure to lose your way. Tethering your horse to a tree, you pull your green Kai cloak about you and fall into a restless sleep.\n");
        chapter = 18; break;
    case 91:
        System.out.println("The small shop is dark and musty. Books and bottles of every size and colour fill the many shelves. As you close the door, a small black dog begins to yap at you. A bald man appears from behind a large screen and bids you welcome. He politely enquires as to the nature of your visit and offers you a choice of his wares from the glass counter.\n");
        System.out.println("If you wish to look at his wares, type 1.");
        System.out.println("If you would rather decline his offer and return to the street, type 2.");
    		if(checkDiscipline("Sixth Sense")){
          System.out.println("If you wish to use your Kai Discipline of Sixth Sense, type 3.");
          pickNumber(3);
        }
        else pickNumber(2);
        switch(choose) {
          case 1: chapter = 152; break;
          case 2: chapter = 7; break;
          case 3: chapter = 198; break;
        }
        break;
    case 92:
        System.out.println("You dive for cover not a moment too soon, for a hail of black arrows scream out of the woods and bombard the area where you were standing seconds before. Pulling your cloak around you to blend into the dense bracken, you dash through the forest and away from the hidden ambushers as fast as possible. This entire area is infested by Giaks and you must escape as quickly as you can. You run without rest for over an hour until you happen to fall upon a straight forest path heading towards the east. You follow the path, taking care to keep watch for signs of the enemy.\n");
        chapter = 13; break;
    case 93:
        System.out.println("You turn and run for the stairs just as a large block falls with a crash behind you. The room you were in has been completely sealed off. As you escape into the daylight, you glimpse behind you the crooked figure of an old druid as he raises his staff. A second later, a bolt of lightning explodes at your feet. You do not stop but run headlong down the hill, cursing the delay but thankful for your Sixth Sense.\n");
        chapter = 106; break;
    case 94:
        System.out.println("The Sage, seeing that you have killed his son, turns and runs from the shop by a back door.\n\nYou find 12 Gold Crowns in the robber's purse and another 4 Gold Crowns in a wooden box under the counter. Carefully examining the potions and the wand you soon realize that they are all cheap counterfeits. In fact the entire shop is full of imitations. You shake your head and return to the main street.\n");
        crowns = crowns + 16;
    		chapter = 7; break;
    case 95:
        System.out.println("You soon stumble upon a narrow forest track running from north to south.\n");
        System.out.println("If you wish to set off along the track towards the north, type 1.");
        System.out.println("If you wish to go south instead, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 240; break;
          case 2: chapter = 5; break;
        }
        break;
    case 96:
        System.out.println("Holding your breath, you tighten your grip on your weapon and prepare to strike. The tension is unbearable-the Giaks are so close that the foul stench of their unwashed bodies fills your nostrils. You hear them curse in their strange alien tongue and then leave the ledge and start to scramble towards the peak. When you are sure they have gone, you finally exhale and wipe the sweat from your eyes.\n");
        System.out.println("If you wish to explore the cave further, type 1.");
        System.out.println("If you wish to leave the cave and descend the hill in case the Giaks return, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 33; break;
          case 2: chapter = 248; break;
        }
        break;
    case 97:
        System.out.println("Ahead of you, you can see a fierce battle raging across a stone bridge. The clash of steel and the cries of men and beasts echo through the forest. In the midst of the fighting, you see Prince Pelathar, the King's son. He is in combat with a large grey Gourgaz who is wielding a black axe above his scaly head. Suddenly, the Prince falls wounded-a black arrow in his side.\n");
        System.out.println("If you wish to defend the fallen Prince, type 1.");
        System.out.println("If you wish to run into the forest, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 255; break;
          case 2: chapter = 306; break;
        }
        break;
    case 98:
        System.out.println("The guards seem to believe your story and bow with respect to your rank of Kai Lord. One of them pulls a concealed bell-rope and the huge doors start to swing open. They usher you inside and you hear the doors close behind you.\n");
        chapter = 139; break;
    case 99:
        System.out.println("You dive into the undergrowth just as the beast screams past your head. You quickly look back to see the Kraan turning in the air in preparation for another dive. You scramble to your feet and run deeper into the safety of the forest.\n");
        chapter = 222; break;
    case 100:
        System.out.println("The cold corridor suddenly makes an abrupt turning towards the east. You notice a greenish glow that lights the tunnel in the far distance. As you creep nearer you can see that the corridor opens out into a larger chamber.\n\nThe strange light seems to emanate from a large bowl resting upon the top of a granite throne. On a plinth in front of the throne stands a statue. It looks like a winged serpent curved in the shape of an 'S'.\n");
        System.out.println("If you wish to sit on the throne, type 1.");
        System.out.println("If you wish to examine the statue, type 2.");
    		System.out.println("If you wish to look for an exit from this chamber, type 3.");
        pickNumber(3);
        switch(choose) {
          case 1: chapter = 161; break;
          case 2: chapter = 133; break;
          case 3: chapter = 257; break;
        }
        break;
        
        
        
  	case 101:
        System.out.println("The noise of battle soon fades behind you but the ensuing silence is broken by a voice in your head that accuses you of being a coward, and deserting a fellow human in danger. You try to rid yourself of your nagging conscience by telling yourself that your mission is far more important, and that not only is the life of the young magician in peril but the lives of all your countrymen depend on you reaching the capital alive.\n\nSuddenly, the sight of a Giak war party in the distance makes you quickly take cover and hide. But it is too late-they have spotted you and you must run as fast as you can.\n");
        chapter = 281; break;
	case 102:
        System.out.println("As you descend the rocky slope towards the Graveyard of the Ancients, you are aware of a strange mist and cloud that swirls all around this grey and forbidding place, blocking the sun and covering the Graveyard in a perpetual gloom. A chill creeps forward to greet your approach.\n\nWith a feeling of deep dread, you enter the eerie necropolis.\n");
        chapter = 284; break;
	case 103:
        System.out.println("The overgrown path leads to a junction where another track branches off towards the east.\n");
        System.out.println("If you wish to take this path, type 1.");
        System.out.println("If you would rather continue towards the northeast, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 13; break;
          case 2: chapter = 287; break;
        }
        break;
	case 104:
        System.out.println("The walls are dank and slimy. The stale air chokes you and cobwebs brush across your face. You can feel panic grip your stomach, as the tunnel gets darker and darker.\n\nYou reach a junction where the tunnel meets a corridor leading from north to south.\n");
        System.out.println("If you wish to turn north, type 1.");
        System.out.println("If you wish to go south, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 26; break;
          case 2: chapter = 100; break;
        }
        break;
	case 105:
        System.out.println("In the distance, perched on the branch of an old oak tree is a jet-black raven.\n");
        if(checkDiscipline("Animal Kinship")) {
			System.out.println("If you wish to use your Kai Discipline of Animal Kinship to call to this bird, type 1.");
			System.out.println("If you do not wish to use it, type 2.");
			pickNumber(2);
			switch(choose) {
			  case 1: chapter = 298; break;
			  case 2: chapter = 335; break;
			}
		}
		else chapter = 335;
        break;
	case 106:
        System.out.println("Eventually you come to the edge of a fast-flowing icy stream. The white water cascades over the mossy rocks and disappears towards the east.\n");
        System.out.println("If you wish to follow the stream to the east, type 1.");
        System.out.println("If you would rather explore upstream, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 263; break;
          case 2: chapter = 334; break;
        }
        break;
	case 107:
        System.out.println("Running across the room, you lash out at the skulls, smashing them to fragments. You notice that inside each skull is a bubbling grey jelly that seems to writhe and change its shape, sprouting bat-like wings and suckers from its glistening form. In horror and loathing, you race for the exit corridor and escape just as a heavy portcullis falls with a crash, completely sealing off the chamber.\n");
        chapter = 23; break;
	case 108:
        System.out.println("You fly in an arc through the air towards the opposite roof. Everything seems to be happening in slow motion. You see the teeming crowds below in the street, and a nest of callysparrows in the eaves of a roof to your right. You hear their startled cries as you land with a crash on the other side. But it is the last sound that you will ever hear. The tiles splinter and collapse and you fall through the four floors of the 'Green Slipper Inn' breaking your back in several places.\n\nYour mission and your life end here.\n");
        ded();
        break;
	case 109:
        System.out.println("The only thing under the carpet is dirt!\n");
        System.out.println("If you wish to take a closer look at the bottles, type 1.");
        System.out.println("Or if you wish to leave the room and investigate the stable, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 164; break;
          case 2: chapter = 308; break;
        }
        break;
    case 110:
        System.out.println("You quickly take aim and hurl the rock at the Giak's head as hard as you can, but to your horror the creature ducks and the rock arcs harmlessly over its back. You must act immediately to save the wizard.\n");
        chapter = 55; break;
    case 112:
        System.out.println("Suddenly, the large rock you are hiding behind is rolled aside and you are faced by two snarling Giaks intent on your death. The cave mouth is a narrow entrance and you can only fight the Giaks one at a time.\n");
        fight("Giak",13,10,0,0,112);
   			fight("Giak",12,10,0,0,112);
   			System.out.println("If you wish to explore the cave further, type 1.");
        System.out.println("Or if you wish leave and descend the hill, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 33; break;
          case 2: chapter = 248; break;
        }
        break;
    case 119:
        System.out.println("The gallowbrush tears your cloak and scratches deep into your arms and legs as you slowly force your way through. Fifteen minutes later you emerge from the briars and stagger onwards between the trees.\n\nYou feel a little dizzy as you push on, and your eyelids seem very heavy. You suddenly find yourself at the edge of a steep wooded slope.\n");
        System.out.println("If you wish to slide down the slope as carefully as you can, type 1.");
        System.out.println("If you do not feel that you are up to the risk of this tricky descent in your present sleepy state, walk around the edge of the ridge, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 226; break;
          case 2: chapter = 38; break;
        }
        break;
    case 124:
        System.out.println("Inside the box you find 15 Gold Crowns and a Silver Key.\n");
    		crowns = crowns+15;
    		specialItems.add("Silver Key");
        System.out.println("If you wish to continue to investigate the tunnel, type 1.");
        System.out.println("If you wish to leave and descend the hill, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 211; break;
          case 2: chapter = 106; break;
        }
        break;
    case 125:
        System.out.println("The path opens out into a large clearing. You notice strange claw prints in the earth. Kraan have landed here. By the number of prints and by the size of the area disturbed, you judge that at least five of the foul creatures landed here in the last twelve hours.\n\nYou see two exits on the far side of the clearing. One leads west, the other south.\n");
        System.out.println("If you wish to take the south path, type 1.");
        System.out.println("If you wish to take the west path, type 2.");
    		if(checkDiscipline("Tracking")) {
          System.out.println("If you wish to use your Kai Discipline of Tracking, type 3.");
          pickNumber(3);
        }
        else pickNumber(2);
        switch(choose) {
          case 1: chapter = 27; break;
          case 2: chapter = 214; break;
          case 3: chapter = 301; break;
        }
        break;
    case 131:
        System.out.println("You have covered about a quarter of a mile when you hear shouting and a noise like thunderclaps ahead. Edging nearer, you soon make out a clearing that you recognize to be the site of the ruins of Raumas, an ancient forest temple.\n\nA war party of Giaks, some twenty-five to thirty strong, are attacking the ruins from all sides. Many more of the Giaks are dead or dying among the broken pillars of marble, but still they assault whatever is hidden inside. Suddenly, a bolt of blue lightning rips through the front rank of Giaks sending the armour-clad creatures tumbling in all directions. A Giak, taller than the others and dressed from head to foot in black chainmail, curses at his troops as he whips them forward with a barbed flail.\n\nWith weapon ready, you move to the edge of the clearing, under cover of the thick foliage, and try to catch a glimpse of the defenders. To your amazement, the ruins are being defended by a young man no older than yourself. You recognize his sky-blue robes, embroidered with stars. He is a young theurgist of the Magicians' Guild of Toran: an apprentice in magic.Five Giaks charge forward, their spears raised to stab the apprentice as he hurriedly retreats deeper into the ruins. You see him turn and raise his left hand just before a bolt of blue flame shoots from his fingertips into the snarling Giak soldiers. Close to where you are hidden, you see a Giak scuttle past and climb one of the pillars of the temple. He has a long curved dagger in his mouth and he is about to jump on the young wizard standing below.\n");
        System.out.println("If you wish to shout a warning to the wizard, type 1.");
        System.out.println("If you wish to run forward and attack the Giak when he jumps, type 2.");
    		System.out.println("If you wish to pick up a chunk of temple marble and throw it at the Giak's head, type 3.");
    		System.out.println("Or if you would rather turn and leave the battle area and run back into the woods, type 4.");
        pickNumber(4);
        switch(choose) {
          case 1: chapter = 241; break;
          case 2: chapter = 55; break;
          case 3: chapter = 302; break;
          case 4: chapter = 101; break;
        }
        break;
    case 134:
        System.out.println("Using your skills, you detect Giak tracks around the perimeter of the clearing. The prints are fresh and you can tell that these cruel minions of the Darklords were in this area less than two hours ago.\n");
        System.out.println("Forewarned by this knowledge, if you decide to investigate the huts, type 1.");
        System.out.println("If you would rather avoid the clearing, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 305; break;
          case 2: chapter = 40; break;
        }
        break;
    case 136:
        System.out.println("The Giaks get nearer and then crouch down as if preparing themselves to pounce. You can see the sharp serrated points of their spears and hear their low guttural speech. The larger of the two creatures screams, 'Orgadak taag! Nogjat aga ok!' and attacks you.\n\nYou must fight each of the Giaks in turn. Add 1 point to your COMBAT SKILL during this fight, as you have the advantage of the higher ground in your favour.\n");
        fight("Giak",13,10,0,0,136);
   			fight("Giak",12,10,0,0,136);
        chapter = 313; break;
    case 138:
        System.out.println("You prepare your weapon and advance to meet the enemy. There are two Mountain Giaks and you must fight them one at a time.\n");
        fight("Giak",13,10,0,0,138);
    		fight("Giak",12,10,0,0,138);
    		chapter = 291; break;
    case 140:
        System.out.println("You are in a clearing where several trees have been cut down to make a rickety watchtower. Below the tower are three paths leading off in different directions.\n");
        System.out.println("If you take the south path, type 1.");
        System.out.println("If you take the east path, type 2.");
    		System.out.println("If you take the southwest path, type 3.");
    		System.out.println("If you decide to climb the watchtower, type 4.");
        pickNumber(4);
        switch(choose) {
          case 1: chapter = 14; break;
          case 2: chapter = 252; break;
          case 3: chapter = 215; break;
          case 4: chapter = 36; break;
        }
        break;
    case 141:
        System.out.println("Your Sixth Sense has warned you that some of the creatures that attacked the monastery are searching the two paths for any survivors of their raid, but you can avoid both tracks by making your way through the undergrowth of the woods.\n");
        System.out.println("If you wish to head south, type 1.");
        System.out.println("Or if you wish to cut through the heavier foliage towards the northeas, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 56; break;
          case 2: chapter = 333; break;
        }
        break;
    case 155:
        System.out.println("As you approach, the group of people stop talking. You can see by their expressions that they recognize your green Kai cloak. Slowly, one of the men extends his hand in friendship and says, 'My Lord, we had heard a rumour that the Kai were destroyed. Heaven be praised that it is not so. We feared all was lost.'\n\nYou do not tell them of the destruction of the monastery, for they are refugees from Toran and have lost everything they owned. Their only hope now is that the Kai Lords will lead an army to victory. You learn that the northern port was attacked from both air and sea, and that the forces of the Darklords far outnumbered the King's brave garrison. You reassure them that Sommerlund will not fall and wish them luck on their journey ahead.\n");
        chapter = 70; break;
    case 176:
        System.out.println("You hide behind some thick bushes so that the Doomwolf and its rider will not see your white horse. Luckily it works-the beast lopes past and vanishes down the track that you have just come along.\n");
        System.out.println("If you wish to attack the remaining Doomwolves and their riders, type 1.");
        System.out.println("If you wish to press on deeper into the forest, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 253; break;
          case 2: chapter = 126; break;
        }
        break;
    case 186:
        System.out.println("The Kakarmi disappear into the dense undergrowth and you soon find yourself lost. After nearly two hours of walking you hear the sound of running water. You decide to investigate a little closer.\n");
        chapter = 106; break;
    case 187:
        System.out.println("Two furry faces appear over the top of the trunk. Both pairs of eyes stare at your weapon and the two creatures let out a shriek of fright. Leaping from the trunk, they disappear into the forest.\n");
        System.out.println("If you wish to follow them, type 1.");
        System.out.println("If you wish to let them go and continue, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 186; break;
          case 2: chapter = 228; break;
        }
        break;
    case 195:
        System.out.println("Wiping the bear's blood from your weapon, you notice the mouth of a cave hidden behind the rock from which the bear attacked.\n");
        System.out.println("If you wish to investigate this cave further, type 1.");
        System.out.println("If you wish to press on, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 59; break;
          case 2: chapter = 106; break;
        }
        break;
    case 214:
        System.out.println("The path gradually narrows until it disappears completely into a mass of dense vegetation. You cannot go any further on this route and therefore you must return to the clearing.\n\nYou should take the south path.\n");
        chapter = 125; break;
    case 215:
        System.out.println("You emerge into a small clearing. In the centre you see the skeletal remains of a large animal. To the south a narrow track leads off into the distance.\n");
        System.out.println("If you wish to examine the skeleton, type 1.");
        System.out.println("If you would rather press on, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 346; break;
          case 2: chapter = 14; break;
        }
        break;
    case 222:
        System.out.println("As you go on you discover a forest path that divides at the point you join it.\n");
        System.out.println("If you wish to take the south fork, type 1.");
        System.out.println("If you wish to take the east fork, type 2.");
    		if(checkDiscipline("Tracking")) {
          System.out.println("If you wish to use your Kai Discipline of Tracking, type 3.");
          pickNumber(3);
        }
        else pickNumber(2);
        switch(choose) {
          case 1: chapter = 252; break;
          case 2: chapter = 140; break;
          case 3: chapter = 67; break;
        }
        break;
    case 225:
        System.out.println("You recognize the language to be that of the Kakarmi, an intelligent race of forest animals that live in, and care for the forests of Sommerlund. You have nothing to fear from these creatures as they are very timid and gentle in their behaviour. Using your skill of Animal Kinship, you call to them in their strange native tongue.\n");
        System.out.println("If you say 'Do not be afraid, I am a friend,', type 1.");
        System.out.println("If you say 'I am a Kai Lord. I wish you no harm. I must talk with you,', type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 187; break;
          case 2: chapter = 39; break;
        }
        break;
    case 228:
        System.out.println("The path continues eastwards but soon disappears into thick undergrowth.\n");
        System.out.println("If you continue east, cutting through the vegetation with your weapon, type 1.");
        System.out.println("If you head south to where the bushes are less dense and then press on through the forest, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 140; break;
          case 2: chapter = 215; break;
        }
        break;
    case 229:
        System.out.println("The Kraan hovers above you, raising dust with the beat of its huge black wings. The dust gets into your eyes and nose, and you start to cough. Now the beast attacks.\n\nYou must fight it to the death.\n");
        fight("Kraan",16,25,1,0,229);
    		System.out.println("If you search the body, type 1.");
        System.out.println("Or if you continue along the east path, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 267; break;
          case 2: chapter = 125; break;
        }
        break;
    case 241:
        System.out.println("The wizard heeds your cry and spins around just in time to loose a searing bolt of energy at the Giak. The creature's head disintegrates in flames and its twitching body falls in a heap at the foot of the pillar. The Giak officer sees you and shouts, 'Ogot.Ogot!' to his cowering troops, who quickly run away from the ruins to the safety of the forest beyond.\n\nThe young wizard wipes his brow, and walks towards you, his hand extended in gratitude and friendship.\n");
        chapter = 349; break;

    case 250:
        System.out.println("Leaping from the top of the trunk, you land in front of two small furry creatures. You recognize that they are Kakarmi, an intelligent race of animals that inhabit and tend the forests of Sommerlund. Before you can apologize for your dramatic entrance, the frightened little creatures scurry off into the forest.\n");
        System.out.println("If you wish to follow them, type 1.");
        System.out.println("If you wish to continue, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 186; break;
          case 2: chapter = 228; break;
        }
        break;
    case 252:
        System.out.println("In the centre of a small clearing you see a group of humans talking excitedly and gesturing wildly with their hands. There are two children, three men, and a woman. Their belongings are wrapped in bundles which they carry slung over their shoulders. Their clothes look well made and expensive but they are dirty and torn.\n");
        System.out.println("If you wish to approach them and ask who they are, type 1.");
        System.out.println("If you wish to avoid them and continue onwards on your mission, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 155; break;
          case 2: chapter = 70; break;
        }
        break;
    case 267:
        System.out.println("Covering your nose with your cloak, you cautiously approach the dead beast. The sharp smell of its fetid black blood makes your stomach churn, but you are determined to press on. Then you notice a large saddlebag strapped to its chest. Opening the bag, you find a Message written on an animal skin.Deeper in the bag is a Dagger. You may keep both the Message and the Dagger if you wish.\n\nYou leave the body and continue eastwards along the path.\n");
        chapter = 125; break;
    case 272:
        System.out.println("Keeping a watchful eye on the sky above, you move quickly along the track. You recall that this route leads to Fogwood, a small cluster of huts that have been used by a family of charcoal burners for nearly fifty years. After twenty minutes you reach the edge of a clearing where the huts are grouped in a small circle. There is no sign of the usual mist of wood smoke which gives Fogwood its apt name, and the huts are unusually quiet.\n");
        System.out.println("To prepare your weapon and stealthily approach the huts, type 1.");
        if(checkDiscipline("Tracking")) {
          System.out.println("If you wish to use your Kai Discipline of Tracking, type 2.");
          pickNumber(2);  
        }
				else pickNumber(1);
        switch(choose) {
          case 1: chapter = 305; break;
          case 2: chapter = 134; break;
        }
        break;
    case 275:
        System.out.println("You have followed this twisting track for about twenty minutes when you hear the beating of wings high above the trees. Looking up you see a large Kraan approaching from the north, its huge black wings casting a gigantic shadow on the trees below.\n\nOn its back are two creatures armed with long spears. They are Mountain Giaks-small ugly creatures full of hatred and malice. Many centuries ago, their ancestors were used by the Darklords to build the infernal city of Helgedad, which lies in the volcanic wastelands beyond the Durncrag mountain range. The construction of the city was long and torturous, and only the strongest of the creatures survived the heat and poisonous atmosphere of Helgedad.\n\nQuickly you dive for the shelter of a large fern tree as the Kraan passes overhead. With heart pounding, you pray that your quick reactions have saved you from being spotted.\n");
        roll = (int)(Math.random() * 9) + 0;
        if(roll <= 4) chapter = 345;
        else chapter = 74;
        break;
    case 279:
        System.out.println("You clamber over the loose rocks and into the mouth of the cave, and then quickly turn to push a large rock over the entrance.\n\nAfter a few minutes you see the Giaks on the rocky ledge outside, their evil yellow eyes furtively searching every crevice of the hillside. They are so close that you feel sure that they must spot you any second now.\n");
        roll = (int)(Math.random() * 9) + 0;
        if(roll <= 6) chapter = 112;
        else chapter = 96;
        break;
    case 281:
        System.out.println("As you race through the trees you can hear the horrible cackle of the Giaks close behind you. Soon the trees start to thin out and directly ahead you can see a rocky hillside.\n");
        System.out.println("If you break cover and climb up the hill, type 1.");
        System.out.println("If you change direction and continue your run through the forest, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 311; break;
          case 2: chapter = 77; break;
        }
        break;
    case 285:
        System.out.println("With a sickening thud, the chunk of marble cracks open the back of the Giak's head. The creature drops to its knees and slowly falls forward, down to the ruins below. Elated by your skill, you race forward to aid the young wizard.\n");
        chapter = 325; break;
		case 290:
        System.out.println("Inside the long box is a Quarterstaff wrapped in leather. You may take this Weapon if you wish. You close the box and descend the ladder to the clearing below, taking care to use only the sound rungs.\n");
        if(weapons[0] == null || weapons[1] == null) {
          System.out.println("Do you want to take the quarterstaff? Y/N");
          what = getYesNoAnswer();
          if(what) {
            if(weapons[0] == null) weapons[0] = "Quarterstaff";
            else weapons[1] = "Quarterstaff";
          }
        }
    		else System.out.println("You can't wield any more weapons.");
    		chapter = 140; break;
    case 291:
        System.out.println("The two Giaks lie at your feet, their bodies twisted and lifeless. A quick search reveals 6 Gold Crowns, 2 Spears, and a Dagger.\n\nYou may keep the Gold and take either the Dagger or a Spear.\n\nThe Kraan flew off during your battle, and the track is now deserted. You adjust your Backpack and continue your mission.\n");
        crowns = crowns + 6;
    		if(weapons[0] == null || weapons[1] == null) {
          System.out.println("Do you want to take the dagger? Y/N");
          what = getYesNoAnswer();
          if(what) {
            if(weapons[0] == null) weapons[0] = "Dagger";
            else weapons[1] = "Dagger";
          }
        }
    		else System.out.println("You can't wield any more weapons.");
    		if(weapons[0] == null || weapons[1] == null) {
          System.out.println("Do you want to take the spear? Y/N");
          what = getYesNoAnswer();
          if(what) {
            if(weapons[0] == null) weapons[0] = "Spear";
            else weapons[1] = "Spear";
          }
        }
    		else System.out.println("You can't wield any more weapons.");
   		  if(weapons[0] == null || weapons[1] == null) {
          System.out.println("Do you want to take the spear? Y/N");
          what = getYesNoAnswer();
          if(what) {
            if(weapons[0] == null) weapons[0] = "Spear";
            else weapons[1] = "Spear";
          }
        }
    		else System.out.println("You can't wield any more weapons.");
        chapter = 272; break; 
    case 293:
        System.out.println("With a wave of his hand, Banedon leaves the ruins and you continue your mission, pushing on through the thick woods ahead. You have not gone far when you realize several pairs of yellow eyes are watching you from the undergrowth to your left. Suddenly, a black arrow skims the top of your head. It is a Giak ambush and you must run as fast as you can to escape it.\n");
        chapter = 281; break;
    case 301:
        System.out.println("Your Kai Discipline reveals that the west path is a dead end.\n");
        chapter = 27; break;
    case 302:
        roll = (int)(Math.random() * 9) + 0;
        if(roll <= 2) chapter = 110;
        else chapter = 285; break;
    case 311:
        System.out.println("The hillside is steep and the earth is loose and slippery. You chance a swift glance over your shoulder and see the two Giaks emerge from the woods. They start to climb after you. About halfway from the peak of the hill, you spot a cave to your right, almost totally hidden by a landslide.\n");
        System.out.println("If you wish to hide in the cave, type 1.");
        System.out.println("If you wish to avoid the cave and continue your climb to the peak, type 2.");
    		if(checkDiscipline("Camouflage")) {
          System.out.println("If you wish to use your Kai Discipline of Camouflage, type 3.");
          pickNumber(3);
        }
        else pickNumber(2);
        switch(choose) {
          case 1: chapter = 279; break;
          case 2: chapter = 47; break;
          case 3: chapter = 324; break;
        }
        break;
    case 313:
        System.out.println("Wiping the foul Giak blood from your weapon, you quickly descend the hillside before the Kraan spots its dead riders. Many times you lose your footing on the loose rocks, falling several feet.\n\nDeduct 1 ENDURANCE point for cuts and bruises to your legs.\n");
        Endurance--;
    		chapter = 248; break;
    case 323:
        System.out.println("From the top of the tower you can see above the trees in all directions. Far to the north, a column of jet-black smoke rises high into the sky. Small orange tongues of flame flicker at its base. Your heart sinks as you realize that the port of Toran is ablaze. From the southwest, the wind carries the noise of battle. It is close; no more than five miles at most.On the floor of the watchtower is a large oblong box.\n");
        System.out.println("If you wish to open this box, type 1.");
        System.out.println("If you would prefer to descend the ladder and leave the tower, taking care to use only the good rungs, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 290; break;
          case 2: chapter = 140; break;
        }
        break;
    case 324:
        System.out.println("You pull up your hood and drop down behind the rocks that litter the mouth of the cave. Holding your breath, you curl up into a tight ball, and completely cover yourself with your green cloak. Only a few minutes later the Giaks clamber over the rocky ledge outside, their evil yellow eyes furtively searching every crevice of the hillside.Then cursing in their strange tongue, they leave the ledge and start to climb towards the peak. You silently thank your old Masters for teaching you the Kai Discipline of Camouflage-it has probably saved your life on this occasion.\n");
        System.out.println("If you wish to explore the cave, type 1.");
        System.out.println("If you wish to leave and descend the hill in case the Giaks return, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 33; break;
          case 2: chapter = 248; break;
        }
        break;
    case 325:
        System.out.println("Upon seeing you emerge from the woods, the Giak officer shouts 'Ogot! Ogot!' to his cowering troops, who flee the ruins and run to the safety of the forest.\n\nShaking his mailed fist at you, the black-clad Giak screams, 'RANEG ROGAG OK-ORGADAKA OKAK ROGAG GAJ!' before leaving. Surveying the scene of battle, you count over fifteen Giak dead lying among the broken pillars of Raumas.\n\nThe young wizard wipes his brow and walks towards you, his hand extended in friendship.\n");
        chapter = 349; break;
    case 333:
        System.out.println("You have cut your way through the thick undergrowth for nearly half an hour when you hear the beat of wings high above the trees. Looking up you can just make out the shape of a Kraan approaching from the north. It is one of the monsters that attacked the monastery and on its back are two grey-skinned creatures armed with long spears.\n\nThese are Mountain Giaks-evil servants of the Darklords, full of hatred and malice. Many centuries ago, their ancestors were used by the Darklords to build the infernal city of Helgedad, which lies in the volcanic wastelands beyond the Durncrag range of mountains. The construction of the city was long and torturous and only the strongest of the Giaks survived the heat and poisonous atmosphere of Helgedad.\n\nHidden by the trees, you freeze, keeping absolutely still as the Kraan passes overhead and disappears towards the south. When you are sure that it has gone, you move off once again into the forest.\n");
        chapter = 131; break;
    case 345:
        System.out.println("You pull up the hood of your green Kai cloak and hold your breath as the Kraan circles above. After a few minutes, you hear the frantic curses of the Giaks. The beating of Kraan wings fades, as they disappear towards the west. Your quick reactions have saved you from capture and likely death.\n");
        System.out.println("You can now return to the track, type 1.");
        System.out.println("Or push on under cover of the trees, type 2.");
        pickNumber(2);
        switch(choose) {
          case 1: chapter = 272; break;
          case 2: chapter = 19; break;
        }
        break;
    case 346:
        System.out.println("Lodged deep in the rib cage of the skeleton is a Spear. It is in good condition and you may take it if you wish and are able to.\n");
        chapter = 14; break;
    case 349:
        System.out.println("He is a young blond-haired youth with deep brooding eyes. His face is lined with exhaustion and the grime of battle, and his long sky-blue robes bear evidence of living rough in the wilds. He shakes your hand and bows. 'My eternal thanks, Kai Lord. My powers are nearly drained. Had you not come to my aid, I fear I would have ended my days atop a Giak lance.'\n\nHe is weak and unsteady on his feet. You take his arm and sit him down upon a fallen pillar where you listen intently to what he has to say.\n\n'My name is Banedon. I am journeyman to the Brotherhood of the Crystal Star, which is the Magicians' Guild of Toran. My Guildmaster has sent me to your monastery with this urgent message.' He removes a vellum envelope from inside his robes and hands it to you.\n\n'As you see, I have opened the letter and read its contents. When the war started, I was on the highway with two travelling companions. The Kraan attacked us and we lost each other in the forest during our escape.'\n\nThe letter is a warning to the Kai Lords that the Darklords have mustered a vast army beyond the Durncrag Range. The Guildmaster urges the Kai to cancel the celebrations of Fehmarn and prepare for war.\n\n'I fear we were betrayed,' says Banedon, his head bowed in sorrow.\n\n'One of my order, a brother called Vonotar, had explored the forbidden mysteries of the Black Art. Ten days ago he denounced the Brotherhood and killed one of our Elders. He has since disappeared. It is rumoured that he now aids the Darklords.'\n\nYou tell Banedon what has happened at the monastery, and of your mission to warn the King. Silently, he removes a gold chain from around his neck and hands it to you. On the chain is a small Crystal Star Pendant. 'It is the symbol of my Brotherhood, and we are both truly brothers in this hour of darkness. It is a talisman of good fortune-may it protect you on your road ahead.'\n\nYou thank him, place the chain around your neck, and slip the Crystal Star4 inside your shirt.\n\nBanedon bids you farewell. 'We must leave this place lest the Giaks return with more of their loathsome kind to put an end to us. I must return to my Guild. I bid you farewell, my brother. May the luck of the gods go with you.'\n");
        specialItems.add("Crystal Star");
		chapter = 293;
        break;
	default:
		System.out.println("Part mising");
    }
        
  }
  public static boolean checkDiscipline(String search) {
    String disSearch = search;
    boolean found = false;
    for(int i = 0; i < numDisciplines; i++) {
      if(disciplines[i] == disSearch) found = true;
    }
    return found;
  }
  public static void fight(String creatureName, int creatureCombatSkill, int creatureEndurance, int creatureDeducts, int evadeRounds, int evadeChapter) {
    String crName = creatureName;
    int crCombatSkill = creatureCombatSkill;
    int crEndurance = creatureEndurance;
    int crScary = creatureDeducts;
    int evadePossible = evadeRounds;
    int nextChapter = evadeChapter;
    int j = 1;
    System.out.println("You are fighting against "+crName+".");
    System.out.println("What weapon will you use to fight?");
    if(weapons[0] != null) System.out.println("If you want to use " + weapons[0] + ", type "+j+".");
    else if(weapons[1] != null) System.out.println("If you want to use " + weapons[1] + ", type "+j+".");
    else {
      System.out.println("You don't have a weapon to fight with. You lose.");
      ded();
    }
    int x = 0;
    combatSkill = combatSkill - crScary;
    int CombatRatio = combatSkill - crCombatSkill;
    for(int round = 1; Endurance > 0 || crEndurance > 0; round++){
      if(round >= evadePossible && evadePossible != 0) {
        System.out.println("Do you want to run away? Y/N");
        what = getYesNoAnswer();
        if(what) {
        	chapter = evadeChapter;
        }
      }
      else {
        if(CombatRatio<-11) x = 0;
        else if(CombatRatio <= -9) x = 1;
        else if(CombatRatio <= -7) x = 2;
        else if(CombatRatio <= -5) x = 3;
        else if(CombatRatio <= -3) x = 4;
        else if(CombatRatio <= -1) x = 5;
        else if(CombatRatio == 0) x = 6;
        else if(CombatRatio <= 1) x = 7;
        else if(CombatRatio <= 3) x = 8;
        else if(CombatRatio <= 5) x = 9;
        else if(CombatRatio <= 7) x = 10;
        else if(CombatRatio <= 9) x = 11;
        else x = 12;
        
        roll = (int)(Math.random() * 9) + 0;
        crEndurance = crEndurance - crDamage[roll][x];
		System.out.println("You dealt "+crDamage[roll][x]+" to "+crName+".");
        Endurance = Endurance - lwDamage[roll][x];
		System.out.println("You were dealt "+lwDamage[roll][x]+" to "+crName+".");
		if(Endurance <= 0) ded();
		if(crEndurance <= 0) System.out.println("You have defeated "+crName+".");
      }
      
  	}
  }
    
  public static void ded() {
    System.out.println("You have died.");
    try{ System.in.read();}
	catch (IOException e){ System.out.println("oof");}
    System.exit(0);
  }
}