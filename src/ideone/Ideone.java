package ideone; //do not include on Ideone.com

import java.util.Scanner; //allows me to take in input

/**
 * Console League of Legends
 * A game that demonstrates aggregate, instantiated objects and encapsulation
 * @author adilettad
 */
public class Ideone {
	public static void main(String[] args) {

            //REQUIRED: Create at least one instance of a custom class
            Champion player = new Champion();
            Champion npc = new Champion(true);
            boolean player1 = true;
		
            //REQUIRED: Some type of game loop.. this one repeats...
            //...so long as both players' health is above 0
            while((player.getHealth() > 0) && (npc.getHealth() > 0)){
                // attack(playerTurn, player, npc)
                // whoseTurn(playerTurn)
            }
            //announce winner... this only runs when the loop is broken b/c...
            //...a player was defeated
	}
} //closes the Ideone class

/**
 * REQUIRED: A custom class with all private attributes. One of those...
 * attributes must be a second custom class. 
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
                        this.arm = new Weapon(this.name);
			}
        
        /**
         * Second of my overloaded constructors, auto-runs for the npc
         * @param isacomputer 
         */
	public Champion(boolean isacomputer) {
		System.out.println("Computer player entering the game");

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
                case 2: this.name = "Morgana";
                        this.health = 100;
                        attackspeed = 0.1;
                case 3: this.name = "Jinx";
                        this.health = 90;
                        attackspeed = 0.2;
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
	private String name;

	public Weapon(String playername) // this is constructor #1
	{
		dmg = 20;
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

} //closes the weapon class