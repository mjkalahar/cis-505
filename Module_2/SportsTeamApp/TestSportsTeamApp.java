/*
 * Kalahar, M. (2024). CIS 505 Intermediate Java Programming. Bellevue University.
 */
package SportsTeamApp;

import java.util.Scanner;


/*
 * Main driver class to test Team.class Sports Team App. Prompts the user team name and players on the team. 
 * Creates the team and displays a team summary for that team, loops back to ask to create another team or exits.
 */
public class TestSportsTeamApp {

	/*
	 * Main method for Sports Team App
	 */
	public static void main(String[] args) {

		//Print welcome message
		System.out.println("  Welcome to the Sports Team App");
		//Initialize exit boolean to control while loop
		boolean exit = false;

		//Continue to create teams until exit boolean is true
		while(!exit) {
			//Prompt user for team name
			System.out.print("\n  Enter a team name: ");
			//Create scanner for reading input
			Scanner scanner = new Scanner(System.in);
			//Read input for team name
			String teamName = scanner.nextLine();
			
			//Create the team object using the team name
			Team team = new Team(teamName);

			//Prompt user for players names for this team
			System.out.println("\n  Enter the player names: ");
			System.out.print("    hint: use commas for multiple players; no spaces>: ");
			//Read player name input from user
			String playerNames = scanner.nextLine();

			//Split players names delimited by comma, loop through the names adding the players to the team
			for(String playerName: playerNames.split(","))  {
				team.addPlayer(playerName);
			}
			//Display the team summary
			System.out.println();
			System.out.println(team);
			//Prompt user to continue to create another team or exit
			System.out.print("\n  Continue? (y/n): ");
			//Read user response to continuing
			String answer = scanner.nextLine();
			//If user does not enter "Y" or "y", set exit boolean to true
			if(!"Y".equalsIgnoreCase(answer)) {
				exit = true;
			}
		}

		//Display end of program message
		System.out.print("\n\n  End of line...");
		
	}
}