
public class TennisGame {

	private int player1_scrore = 0;
	private int player2_scrore = 0;
	private String player1_name = null;
	private String player2_name = null;

	public TennisGame(int player1_scrore, int player2_scrore, String player1_name, String player2_name) {
		this.player1_scrore = player1_scrore;
		this.player2_scrore = player2_scrore;
		this.player1_name = player1_name;
		this.player2_name = player2_name;
	}

	// Method added to find the score at any given time
	public String findScore() {

		if (checkIfDuece()) {
			return "Deuce";
		}

		if (checkIfPlayerHasAdvantage()) {
			return "Advantage " + playerWithHigherScore();
		}

		if (checkIfAnyPlayerisWinner()) {
			return playerWithHigherScore() + " is winner";
		}
		
		if(player1_scrore == player2_scrore) {
			return convertToReadableScore(player2_scrore) + " all";
		}

		return convertToReadableScore(player1_scrore) + "," + convertToReadableScore(player2_scrore);
	}

	// Method added to covert Score into readable format
	public String convertToReadableScore(int score) {

		String scoreInWord = "";

		switch (score) {
		case 0:
			scoreInWord = "Love";
			break;
		case 1:
			scoreInWord = "Fifteen";
			break;
		case 2:
			scoreInWord = "Thirty";
			break;
		case 3:
			scoreInWord = "Forty";
			break;

		default:
			scoreInWord = "Invalid Input of Score";
		}

		return scoreInWord;
	}

	// In case of a winning shot, need to add a point in the score
	public void scoreByFirstPlayer() {
		player1_scrore++;
	}

	public void scoreBySecondPlayer() {
		player2_scrore++;
	}

	// The method added to check the duece
	public boolean checkIfDuece() {
		boolean ifDuece = false;

		if (player1_scrore >= 3 && player1_scrore == player2_scrore) {
			ifDuece = true;
		}
		return ifDuece;
	}

	// Method will check if player has an advantage
	public boolean checkIfPlayerHasAdvantage() {
		if (player1_scrore >= 4 && player1_scrore == player2_scrore + 1) {
			// player 1 has an advantage
			return true;
		} else if (player2_scrore >= 4 && player2_scrore == player1_scrore + 1) {
			// player 2 has an advantage
			return true;
		} else {
			return false;
		}

	}

	// Method will return the player with higher score at any given time
	public String playerWithHigherScore() {
		if (player1_scrore > player2_scrore) {
			return player1_name;
		} else {
			return player2_name;
		}
	}

	// Method will decide if any layer is winner or not
	public boolean checkIfAnyPlayerisWinner() {

		if (player1_scrore >= 4 && player1_scrore >= player2_scrore + 2) {
			return true;
		} else if (player2_scrore >= 4 && player2_scrore >= player1_scrore + 2) {
			return true;
		} else {
			return false;
		}
	}
}
