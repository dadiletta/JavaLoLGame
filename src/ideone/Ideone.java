package ideone;

import java.util.Scanner; //allows me to take in input

public class Ideone {
	public static void main(String[] args) {

		player = new Champion()
		npc = new Champion(true)
		// playerturn boolean
		// attack(playerTurn, player, npc)
		
		System.out.println("Still works!");
            while((player.getHealth() > 0) && (nps.getHealth() > 0)){
                //attack
                // whoseTurn(playerTurn)
            }
            //announce winner
	}
}

class Champion // if this class was in a separate file it would need to be called public
{

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

class Weapon {

	private int dmg; // let's learn to manage private functions
	private String name;

	public Weapon(String playername) // this is constructor #1
	{
		dmg = 20;
	}

	public Weapon(String playername, boolean isacomputer) // this is an overloaded constructor. This gets called if I pass 2 params
	{

	}

	public int getDmg() { // THIS IS CALLED A HELPER ASSET because they help you
							// access private variables
		return dmg;
	}

	public String getName() { // another helper asset helping a different
								// private variable
		return name;
	}

}