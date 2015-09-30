package ideone; //do not include on Ideone.com

import java.util.Scanner; //allows me to take in input
import java.util.Random;

/**
 * Console League of Legends
 * A game that demonstrates aggregate, instantiated objects and encapsulation
 * @author adilettad
 */
public class Ideone {
	public static void main(String[] args) 
        {
            //REQUIRED: Create at least one instance of a custom class
            Champion player = new Champion();
            Champion npc = new Champion(true);
            boolean player1 = true;
		
            //REQUIRED: Some type of game loop.. this one repeats...
            //...so long as both players' health is above 0
            while((player.getHealth() > 0) && (npc.getHealth() > 0)){
                attack(player1, player, npc);
                player1 = whoseTurn(player1, player, npc);
            }
            announceWinner(player1);
	}

        /**
         * Attacks are calculated and damage is registered.
         * @param player1
         * @param player
         * @param npc 
         */
        public static void attack(boolean player1, Champion player, Champion npc)
        {
            System.out.println("Attack!");
        }
        
        /**
         * Next player's attack turn is determined
         * @param player1
         * @param player
         * @param npc
         * @return
         */
        public static boolean whoseTurn(boolean player1, Champion player, Champion npc)
        {
            System.out.println("Who's turn is it?");
            return !player1;
        }
        
        /**
         * Winner is announced depending on the boolean's status
         * @param player1 
         */
        public static void announceWinner(boolean player1)
        {
            if (player1)
            {
                System.out.println("You won, congratulations");
            }else{
                System.out.println("You lost. Try harder next time.");
            }
        }
} //closes the Ideone class

/**
 * REQUIRED: A custom class with all private attributes. One of those...
 * ..attributes must be a second custom class. 
 * @author adilettad
 */
class Champion 
{
        //REQUIRED: Your custom class has all private attributes
	private int health = 0;
	private String name;
	private Weapon arm;
        private double attackspeed;

        /**
         * First of my two overloaded constructors of the Champion class
         */
	public Champion()   //set the parameters of this constructor
        {
            //Give options and take input on champion selection
            System.out.println("Pick your champion!");
            System.out.println("Press 1 for Braum, press 2 for Morgana");
            System.out.println("press 3 for Jinx, or 4 for Zilian");
            Scanner usersays = new Scanner(System.in);
            int opt = usersays.nextInt();
            this.pickHero(opt);
            this.arm = new Weapon();
        }
        
        /**
         * Second of my overloaded constructors, auto-runs for the npc
         * @param isacomputer 
         */
	public Champion(boolean isacomputer) 
        {
            System.out.println("Computer player entering the game");
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(4);
            this.pickHero(randomInt);
            this.arm = new Weapon(true);
	}
        
        /**
         * This is the character selection option, using a switch instead
         * of a long series of IF statements
         * @param opt 
         */
        private void pickHero(int opt){
            switch (opt){
                case 1: name = "Braum";
                        health = 120;
                        this.attackspeed = 0;
                        break;
                case 2: this.name = "Morgana";
                        this.health = 100;
                        attackspeed = 0.1;
                        break;
                case 3: this.name = "Jinx";
                        this.health = 90;
                        attackspeed = 0.2;
                        break;
                case 4: this.name = "Zilian";
                        this.health = 80;
                        this.attackspeed = 0.1;
            }
        }
        
        //REQUIRED: Helper assets. These are used to provide access to the...
        //...private data
	public int getHealth() {
            return health;
	}

	public void takeDamage(int num1) {
            health -= num1;
	}

	public String getName() {
            return name;
	}
        
        public double getAS(){
            return attackspeed;
        }

} // closes Champion

/**
 * REQUIRED: A second class that is used by the first custom class.
 * @author adilettad
 */
class Weapon {

        //REQUIRED: This second class has all private attributes too
	private int dmg;
        private double speed;
	private String name;

	public Weapon() // this is constructor #1
	{
            System.out.println("Choose 1 for saber; 2 for battleaxe.");
            Scanner usersays = new Scanner(System.in);
            int opt = usersays.nextInt();
            if (opt == 1)
            {
                dmg = 10; 
                speed = 0.2;
                name = "saber";
            }else{
                dmg = 20; 
                speed = 0.1;
                name = "battleaxe";               
            }
	}
        public Weapon(boolean isacomputer)
        {
            dmg = 10; 
            speed = 0.2;
            name = "saber";
            
        }

        /**
         * REQUIRED: Helper asset on the custom class that is used by our
         * primary class
         * @return The damage the weapon deals
         */
	public int getDmg() { 
            return dmg;
	}

	public String getName() { 
            return name;
	}
        
        public double getSpeed() {
            return speed;
        }

} //closes the weapon class