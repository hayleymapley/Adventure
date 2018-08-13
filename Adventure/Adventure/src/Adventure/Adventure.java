package Adventure;

import java.util.Scanner;

public class Adventure {
	Scanner in = new Scanner(System.in);

	int playerHP = 10;
	int playerGP = 0;
	String playerName;
	String playerWeapon = "crooked dagger";
	int playerChoice = 0;
	int possibleChoices = 0;
	boolean validChoice = false;

	boolean cartReceivedGold = false;
	boolean cartWomanMad = false;
	boolean cartWomanAttacked = false;
	boolean townGuardMad = false;

	public void pressEnterKeyToContinue() {
		System.out.println("");
		System.out.println("Press the [Enter] Key to continue...");
		System.out.println("");
		try {
			System.in.read();
		} catch (Exception e)
		{}
	}

	public int isValidChoice(int playerChoice, int possibleChoices) {
		if (playerChoice < 1 || playerChoice > possibleChoices) {
			validChoice = false;
		} else {
			validChoice = true;
		}
		while (!validChoice) {
			System.out.println("Please enter a valid choice: ");
			playerChoice = in.nextInt();
			if (playerChoice < 1 || playerChoice > possibleChoices) {
				validChoice = false;
			} else {
				validChoice = true;
			}
		}
		return playerChoice;
	}

	public void playerSetup() {
		//introduction
		System.out.println("Welcome.");
		System.out.println("What is your name, adventurer?");
		playerName = in.nextLine();
		System.out.println("");
		System.out.println("Hello, " + playerName + ". Welcome to the land of Arundia.");
		System.out.println("");
		System.out.println("* You have a " + playerWeapon + " to defend yourself with.");
		System.out.println("* Your current HP is " + playerHP + ". You're feeling very healthy.");
		System.out.println("");
		System.out.println("You were born into a poverty stricken village in the south of Arundia. You don't remember its name.");
		System.out.println("Shortly after your birth, your mother became very ill. With no means to seek treatment, she sadly passed away when you were three months old.");
		System.out.println("Your father, now a newly widowed solo parent, took to exploring the mines at the perimeter of the village.");
		System.out.println("He found many trinkets which he was able to clean up and sell on in order to keep the family afloat for a number of years.");
		System.out.println("");
		System.out.println("When you were seven, your father brought a trinket back home. A locket, inside holding a ruby red crystal that shone like fire in the light."); 
		System.out.println("Your father knew that this trinket was more special and more valuable than any others he had scavenged in the past.");
		System.out.println("Overjoyed, your father came to you and showed you the rare find. \"This treasure, " + playerName + ", will be the end of our poverty\" he said.");
		System.out.println("The next day, you woke up to the rising of the sun and walked into the main room, only to find the front door wide open.");
		System.out.println("Everything was turned upside down, papers strewn everywhere and blankets torn to shreds on the hard wood floor.");
		System.out.println("Your father had disappeared, and he never returned.");
		System.out.println("");
		System.out.println("At this very young age you learned that in order to stay alive, you had to fend for yourself.");
		System.out.println("The people in your village were kind, but also very poor and had no means of supporting a newly orphaned child.");
		System.out.println("Few were willing to help you, and so the rest of your childhood consisted of wandering, begging, hiding, and stealing.");
		System.out.println("You have spent your adolescent years roaming and fighting, with the aim of finding out what really happened to your father.");
		this.pressEnterKeyToContinue();
	}

	public void startingArea() {
		if (cartWomanAttacked) {
			System.out.println("* You walk away from the town back along the road, expecting to once again see the woman and her cart");
			System.out.println("* The woman, however, is gone, and so is her cart. But where?");
			System.out.println("* You turn around and head back to the town.");
			System.out.println("");
			this.pressEnterKeyToContinue();
			this.townGate();
		} else {
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("");
			System.out.println("* You are walking along a dirt road that seems to lead to a township in the distance.");
			System.out.println("* As you're strolling, you see a large cart sitting idle to the side of the road, which appears to be in a state of disrepair.");
			System.out.println("* You can see that the cart seems to be full of wares, including food, materials, and some rather nice looking weapons...");
			System.out.println("* Beside the cart is a short, plump woman with a purse tied to her waist trying to lift a heavy wheel back onto position on the axel.");
			System.out.println("* She appears to be struggling with the weight. The woman looks up to see you watching her and waves you over.");
			System.out.println("");
			System.out.println("What do you want to do?");
			System.out.println("");
			System.out.println("1: Help the woman; she looks like she needs some assistance");
			System.out.println("2: Ignore the woman and head to the town; she might be one of those scam artists");
			System.out.println("3: Try to pickpocket the woman; we might as well try to make the most of the situation");
			System.out.println("4: Attack the woman; that wagon probably has something that's a bit better than a " + playerWeapon);
			System.out.println("");
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------");

			playerChoice = in.nextInt();
			possibleChoices = 4;
			
			playerChoice = this.isValidChoice(playerChoice, possibleChoices);
			
			if (playerChoice==1) {
				if (!cartReceivedGold && !cartWomanMad) {
					System.out.println("Woman: Oh, thank you very much! This weight is far too much for me.");
					System.out.println("Woman: Please take this small token of my gratitude, adventurer.");
					System.out.println("");
					System.out.println("* The woman reaches into the pouch at her side and gives you 5 gold pieces.");
					playerGP = playerGP + 5;
					cartReceivedGold = true;
					System.out.println("* You now have " + playerGP + "GP.");
					this.pressEnterKeyToContinue();
					this.startingArea();
				} else if (cartReceivedGold && !cartWomanMad) {
					System.out.println("Woman: I truly am grateful for your help, but I have nothing else left to give you!");
					this.pressEnterKeyToContinue();
					this.startingArea();
				} else if (cartWomanMad) {
					System.out.println("Woman: You think I want YOUR help after that stunt you just tried to pull?");
					System.out.println("Woman: You better get out of here before I do you some more damage.");
					this.pressEnterKeyToContinue();
					this.startingArea();
				}
			} else if (playerChoice==2) {
				System.out.println("* You decide that it's probably best to keep on moving...");
				System.out.println("* You carry on along the road and see a large stone wall nearby.");
				this.pressEnterKeyToContinue();
				this.townGate();
			} else if (playerChoice==3) {
				System.out.println("* You make small talk with the woman as you approach, edging closer to the bag hanging at her side.");
				System.out.println("* You make a move for the bag, and..");
				System.out.println("");
				System.out.println("Woman: Hey! What the hell do you think you're doing?");
				System.out.println("");
				System.out.println("* The woman slaps you and you take 1HP damage.");
				cartWomanMad = true;
				playerHP = playerHP - 1;
				System.out.println("* You now have " + playerHP + "HP.");
				this.pressEnterKeyToContinue();
				this.startingArea();
			} else if (playerChoice ==4) {
				System.out.println("* You quickly take out your " + playerWeapon + " and take a swing at the woman.");
				System.out.println("* The woman gets hit and falls to the ground, beginning to scream. She stops making noise as you loudly threaten to finish the job.");
				System.out.println("* Taking advantage of the situation, you grab a nice-looking one-handed sword from the wagon and discard your " + playerWeapon + ".");
				System.out.println("");
				System.out.println("Woman: Please.. have mercy...");
				System.out.println("");
				System.out.println("* Without another word, you sheath your new sword, turn around and continue walking north along the path.");
				playerWeapon = "one-handed sword";
				cartWomanAttacked = true;
				this.pressEnterKeyToContinue();
				this.townGate();
			}
		}

	}

	public void townGate() {
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("");
		System.out.println("* You find yourself at the entrance gate of the town.");
		System.out.println("* A large stone wall with crenellations runs about 30ft on either side of the wrought-iron gate.");
		System.out.println("* In front of the gate stands a kind-looking, but weary guard armed with a sword. You approach the gate.");
		System.out.println("");
		System.out.println("What do you want to do?");
		System.out.println("");
		System.out.println("1: Talk to the guard");
		System.out.println("2: Attack the guard");
		System.out.println("3: Enter the town");
		System.out.println("4: Head back the way you came");
		System.out.println("5: Head West along the city wall");
		System.out.println("");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------");

		playerChoice = in.nextInt();
		possibleChoices = 5;
		this.isValidChoice(playerChoice, possibleChoices);
		if (playerChoice==1) {
			System.out.println("Guard: Hello there, stranger.");
			System.out.println("Guard: If you're looking for entry, I'm afraid you're out of luck.");
			System.out.println("Guard: The powers that be have declared a quarantine, and I'm certainly not going to risk my job for you.");
			this.pressEnterKeyToContinue();
			this.townGate();
		} else if (playerChoice==2) {
			System.out.println("* You pull out your " + playerWeapon + " and lunge at the guard.");
			System.out.println("");
			System.out.println("Guard: Hey!");
			System.out.println("");
			System.out.println("* The guard quickly draws his sword and with two quick slashes disarms you, leaving you with a bleeding gash on your hand.");
			playerWeapon = "bleeding hand";
			playerHP = playerHP - 2;
			townGuardMad = true;
			System.out.println("* You lose your weapon, and take 2HP damage.");
			this.pressEnterKeyToContinue();
			this.townGate();
		} else if (playerChoice==3) {
			if (cartWomanAttacked) {
				System.out.println("* You nod at the guard and move towards the entrance. The guard holds up his sword and stops you in your tracks.");
				System.out.println("");
				System.out.println("Guard: No strangers allowed, I'm afraid. Especially not strangers who attack our merchants.");
				this.pressEnterKeyToContinue();
				this.townGate();
			} else if (cartWomanMad) {
				System.out.println("* You nod at the guard and move towards the entrance. The guard holds up his sword and stops you in your tracks.");
				System.out.println("Guard: No strangers allowed, I'm afraid. Especially not strangers who rob our merchants.");
				this.pressEnterKeyToContinue();
				this.townGate();
			} else if (townGuardMad) {
				System.out.println("* You move towards the entrance. The guard holds up his sword and stops you in your tracks.");
				System.out.println("");
				System.out.println("Guard: Are you serious? Not gonna happen. Try not attacking people next time you wanna go somewhere.");
				this.pressEnterKeyToContinue();
				this.townGate();
			 } else {
				System.out.println("* You nod at the guard and move towards the entrance. The guard holds up his sword and stops you in your tracks.");
				System.out.println("Guard: No strangers allowed, I'm afraid.");
				this.pressEnterKeyToContinue();
				this.townGate();
			}
		} else if (playerChoice==4) {
			this.startingArea();
		} else if (playerChoice==5) {
			this.westWall();
		}
	}

	public void westWall() {
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("");
		System.out.println("* You head west along the stone walls of the city. The wall curves and you're heading north again, through a wooded area.");
		System.out.println("* Walking carefully through the trees, you run your hand along the cold stone bricks to your right and notice a brick out of place.");
		System.out.println("* Upon closer inspection, it appears that the rest of the bricks in the wall are in tact. You notice something out of place beneath you.");
		System.out.println("* Below your feet are leaves and twigs, but the ground beneath sounds hollow when you step on it. You lean down and brush the debris away.");
		System.out.println("");
		System.out.println("* Below you is a trapdoor!");
		System.out.println("* On the one hand, this offers an entry to the city. On the other hand, you have no idea where it will lead.");
		System.out.println("");
		System.out.println("What do you want to do?");
		System.out.println("");
		System.out.println("1: Open the trapdoor");
		System.out.println("2: Continue along the perimeter");
		System.out.println("3: Head back to the guard");
		System.out.println("");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
		
		playerChoice = in.nextInt();
		possibleChoices = 3;
		
		this.isValidChoice(playerChoice, possibleChoices);
		
		if (playerChoice==1) {
			this.trapdoor();
		} else if (playerChoice==2) {
			//this.westWallContinue();
		} else if (playerChoice==3) {
			this.townGate();		}
	}

	public void trapdoor() {
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("");
		System.out.println("* The door is stiff at first, but you manage to pry it open. You climb down the ladder, closing the door behind you.");
		System.out.println("* After clambering down for about thirty seconds, you reach the bottom of the ladder and find yourself in a dimly lit tunnel.");
		System.out.println("* T");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
	
		playerChoice = in.nextInt();
		possibleChoices = 3;
	}
	
	public static void main(String[] args) {
		Adventure game = new Adventure();
		game.playerSetup();
		game.startingArea();
	}
}
