import java.util.*;
class FlightFromTheDark {
	public static int Section = 0;
	public static int CombatSkill = 0;
	public static int Endurance = 0;
	public static int Choose = 0;
	public static boolean Dead = false;
	public static int NumDisciplines = 5;
	public static String[] Disciplines = new String[NumDisciplines];
	public static void main(String args[]) {
		Scanner enter = new Scanner (System.in);
		
		introduction();
		enter.nextLine();
		
		characterCreation();
		
	}
	public static void introduction() {
		System.out.println("The Story So Far...\nIn the northern land of Sommerlund, it has been the custom for many centuries\nto send the children of the Warrior Lords to the monastery of Kai. There they\nare taught the skills and disciplines of their noble fathers.\n\nThe Kai monks are masters of their art, and the children in their charge love\nand respect them in spite of the hardships of their training. For one day when\nthey have finally learnt the secret skills of the Kai, they will return to\ntheir homes equipped in mind and body to defend themselves against the constant\nthreat of war from the Darklords of the west.\n\nIn olden times, during the Age of the Black Moon, the Darklords waged war on\nSommerlund. The conflict was a long and bitter trial of strength that ended in\nvictory for the Sommlending at the great battle of Maakengorge. King Ulnar and\nthe allies of Durenor broke the Darkland armies at the pass of Moytura and\nforced them back into the bottomless abyss of Maakengorge. Vashna, mightiest of\nthe Darklords, was slain upon the sword of King Ulnar, called 'Sommerswerd',\nthe sword of the sun. Since that age, the Darklords have vowed vengeance upon\nSommerlund and the House of Ulnar.\n\nNow it is in the morning of the feast of Fehmarn, when all of the Kai Lords are\npresent at the monastery for the celebrations. Suddenly a great black cloud\ncomes from out of the western skies. So many are the numbers of the\nblack-winged beasts that fill the sky, that the sun is completely hidden. The\nDarklords, ancient enemy of the Sommlending, are attacking. War has begun.\n\nOn this fateful morning, you, Silent Wolf (the name given to you by the Kai)\nhave been sent to collect firewood in the forest as a punishment for your\ninattention in class. As you are preparing to return, you see to your horror a\nvast cloud of black leathery creatures swoop down and engulf the monastery.\nDropping the wood, you race to the battle that has already begun. But in the\nunnatural dark, you stumble and strike your head on a low tree branch. As you\nlose consciousness, the last thing that you see in the poor light is the walls\nof the monastery crashing to the ground.\n\nMany hours pass before you awake. With tears in your eyes you now survey the\nscene of destruction. Raising your face to the clear sky, you swear vengeance\non the Darklords for the massacre of the Kai warriors, and with a sudden flash\nof realization you know what you must do. You must set off on a perilous\njourney to the capital city to warn the King of the terrible threat that now\nfaces his people. For you are now the last of the Kai-you are now the Lone\nWolf.");
	}
	public static void characterCreation() {
		characterRandom();
		characterDiscipline();
		game();
	}
	public static void characterRandom() {
		int Reroll = 2;
		boolean Error = false;
		for(boolean i = false; i != true && Reroll > 0 ; ) {
			Error = false;
			i = false;
			CombatSkill = (int)(Math.random() * 9) + 10;
			Endurance = (int)(Math.random() * 9) + 20;
			System.out.println("Your COMBAT SKILL is "+CombatSkill+" and your ENDURANCE is "+Endurance+".");
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
		for(int i = 5; i > 0; i--) {
			System.out.println("You can choose " + i + " more disciplines...\n");
			pickNumber(10);
			int dis = 0;
			switch (Choose) {
				case 1:
					System.out.println("You have picked the discipline Camouflage.");
					Disciplines[dis] = "Camouflage";
					break;
				case 2:
					System.out.println("You have picked the discipline Hunting.");
					Disciplines[dis] = "Hunting";
					break;
				case 3:
					System.out.println("You have picked the discipline Sixth Sense.");
					Disciplines[dis] = "Sixth Sense";
					break;
				case 4:
					System.out.println("You have picked the discipline Tracking.");
					Disciplines[dis] = "Tracking";
					break;
				case 5:
					System.out.println("You have picked the discipline Healing.");
					Disciplines[dis] = "Healing";
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
					Disciplines[dis] = "Weaponskill "+Weapon;
					break;
				case 7:
					System.out.println("You have picked the discipline Mindshield.");
					Disciplines[dis] = "Mindshield";
					break;
				case 8:
					System.out.println("You have picked the discipline Mindblast.");
					Disciplines[dis] = "Mindblast";
					break;
				case 9:
					System.out.println("You have picked the discipline Animal Kinship.");
					Disciplines[dis] = "Animal Kinship";
					break;
				case 10:
					System.out.println("You have picked the discipline Mind Over Matter.");
					Disciplines[dis] = "Mind Over Matter";
					break;
			}
		}
		System.out.println("\n\n\n\n\n");
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
		int chapter = 1;
		switch (chapter) {
			case 1:
				System.out.println("You must make haste for you sense it is not safe to linger by the smoking\nremains of the ruined monastery. The black-winged beasts could return at any\nmoment. You must set out for the Sommlending capital of Holmgard and tell the\nKing the terrible news of the massacre: that the whole élite of Kai warriors,\nsave yourself, have been slaughtered. Without the Kai Lords to lead her armies,\nSommerlund will be at the mercy of their ancient enemy, the Darklords.\n\nFighting back tears, you bid farewell to your dead kinsmen. Silently, you\npromise that their deaths will be avenged. You turn away from the ruins and\ncarefully descend the steep track.\n\nAt the foot of the hill, the path splits into two directions, both leading into\na large wood.");
				System.out.println("If you wish to take the right path into the wood, type 1.");
				System.out.println("If you wish to follow the left track, type 2");
				if(checkDiscipline("Sixth Sense"))System.out.println("If you wish to use your Kai Discipline of Sixth Sense, type 3");
		}
	}
	public static boolean checkDiscipline(String search) {
		String disSearch = search;
		boolean found = false;
		for(int i = 0; i < NumDisciplines; i++) {
			System.out.println(Disciplines[i]);
			if(Disciplines[i] == disSearch) found = true;
		}
		return found;
	}
}