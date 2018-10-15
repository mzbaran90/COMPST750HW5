package CS251_HW5;

import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) {
		Pokemon[] arrOfPokemons = new Pokemon[4];
		Scanner stdIn = new Scanner(System.in);

		Pokemon pokemon = null;
		int pokeCounter = 0; // index of pokeman in case an invlaid character is added. 

		for (int i = 0; i < arrOfPokemons.length; i++) {

			//TODO
			//Read input from user.
			do {
				
			
			System.out.println("Enter name, health, power, and level of pokemon #" + i + ":");
		    String [] input = stdIn.nextLine().split(" ");
			String name = input[0];
			int health = Integer.parseInt(input[1].trim());
			int power = Integer.parseInt(input[2].trim());
			int level = Integer.parseInt(input[3].trim());
			pokemon = makePokemon(name,health,power,level);
			
			if(health < 0 || power < 0 || level < 0) { // checks for positive values. Sets pokemon to null if so.
				pokemon = null;
				System.out.println("One of the values you have entered is negative"
						+ " please enter a another pokemon");
			}
			else if(Contains(pokemon, arrOfPokemons) == false) { 
				arrOfPokemons[pokeCounter++] = pokemon;
				
			}

			} while(arrOfPokemons[i] == null);
			
		}
		
			
			
			//Create a pokemon and add it to the array if it is not a duplicate.

		


		System.out.println();

		System.out.println("Pokemons before playing");
		print(arrOfPokemons);

		System.out.println();
		for(int i=0; i<3;i++){
			play(arrOfPokemons, stdIn, i);
		}


		System.out.println();
		System.out.println("Pokemons After playing");
		print(arrOfPokemons);

		stdIn.close();
	
		}
	private static void print(Pokemon[] arrOfPokemons){

		//Print the pokemons in the arrOfPokemons array 
		for (int index = 0; index < arrOfPokemons.length && arrOfPokemons[index] != null; index++) {
			System.out.printf("%d: %s\n", index, arrOfPokemons[index].toString());
		
		}

	}

	private static void play(Pokemon[] arrOfPokemons, Scanner stdIn, int numberOfPlay) {
		int firstPokemon=0;
		int secondPokemon=0;
		do{
			System.out.printf("# %d Please enter the pokemons you want to play 0 to 3: ",numberOfPlay);
			firstPokemon = stdIn.nextInt();
			secondPokemon = stdIn.nextInt();

		}while(firstPokemon<0 ||firstPokemon>4 ||secondPokemon<0 ||secondPokemon>4 );

		arrOfPokemons[firstPokemon].specialAttack(arrOfPokemons[secondPokemon]);

		//think of this part as a counterattack
		arrOfPokemons[secondPokemon].physicalAttack(arrOfPokemons[firstPokemon]);

	}

	/**
	 * Creates a pokemon based on name passed to method.
	 * 
	 * @param name
	 * @param health
	 * @param power
	 * @param level
	 * @return Pokemon (Charmander or Pikachu)
	 */
	static Pokemon makePokemon(String name, int health, int power, int level) {
		Pokemon pokemon = null;
		if(name.toLowerCase().equals("charmander")) {
			return pokemon = new Charmander(health, power, level);
		}
		else if(name.toLowerCase().equals("pikachu")) {
			return pokemon = new Pikachu(health, power, level);
		}
		else { 
			
			return pokemon; 
		}

	}
	/*
	 * Tells if array contains a pokemon already. returns true if passed in pokemon 
	 *is contained in pokemon array. 
	 * @param pok
	 * @param arrOfPokemons
	 * @return boolean
	 */

	protected static boolean Contains(Pokemon pok, Pokemon[] arrOfPokemons) {


		if(pok == null) {
			System.out.println("Something isn't right about these values. "
					+ "Please Enter another Pokemon.");
			return true;
			
		}
		for(int p = 0; p < arrOfPokemons.length && arrOfPokemons[p] != null; p++) {
			if (arrOfPokemons[p].equals(pok)) {
				System.out.print("This Pokemon has already been added. Try Again. ");
				return true;

			}

		}
		return false;
	}
}



