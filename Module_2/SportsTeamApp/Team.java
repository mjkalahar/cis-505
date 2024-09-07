/*
 * Kalahar, M. (2024). CIS 505 Intermediate Java Programming. Bellevue University.
 */
package SportsTeamApp;

/*
 * Represents a sports team with a team name, the names of players on the team, and the total player count
 */
public class Team {
	// Name of the team
	private String teamName = "";
	// Names of players on the team
	private String[] players = new String[20];
	// Total number of players on the team
	private int playerCount = 0;
	
	/*
	 * Constructor for a team object, team name is a requirement to create a team
	 * @param teamName String Name of the team
	 */
	public Team(String teamName) {
		this.teamName = teamName;
	}
	
	/*
	 * Adds a player to the existing team by adding name to players name array and increment player count
	 * @param player String Name of the player
	 */
	public void addPlayer(String player) {
		players[playerCount] = player;
		playerCount++;
	}
	
	/*
	 * Returns an array of the player names
	 * @return String Array Containing the names of the players on the team
	 */
	public String[] getPlayers() {
		return players;
	}

	/*
	 * Returns the number of players on the team
	 * @return int Player count - number of players on the team
	 */
	public int getPlayerCount() {
		return playerCount;
	}


	/*
	 * Returns the team name
	 * @return String The name of the team
	 */
	public String getTeamName() {
		return teamName;
	}
	
	/*
	 * Override toString to provide team details string
	 * @return String Containing a team summary of number of players and players names list delimited by commas
	 */
	@Override
	public String toString() {
		String playersString = "";
		for(int playerLoopCount = 0; playerLoopCount < getPlayerCount(); playerLoopCount++) {
			playersString += getPlayers()[playerLoopCount] + ",";
		}
		return String.format("  --Team Summary--\n  Number of players in team: %d\n  Players on team: %s", getPlayerCount(), playersString);
	}
}