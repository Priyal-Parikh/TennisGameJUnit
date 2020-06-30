import junit.framework.TestCase;

public class TennisGameTest extends TestCase {

	TennisGame tennisGame = new TennisGame(0, 0, "Player A", "Player B");

	//game start test case
	public void testNewGameReturnLoveAll() {
		String score = tennisGame.findScore();

		assertEquals("Love,Love", score);
	}

	
	//continuing further in game test cases
	public void testPlayerOneScoresFirstBall() {
		tennisGame.scoreByFirstPlayer();

		String score = tennisGame.findScore();
		assertEquals("Fifteen,Love", score);
	}

	public void testPlayerTwoScoresFirstBall() {
		tennisGame.scoreBySecondPlayer();

		String score = tennisGame.findScore();
		assertEquals("Love,Fifteen", score);
	}

	public void testFifteenScoreByBoth() {
		tennisGame.scoreByFirstPlayer();
		tennisGame.scoreBySecondPlayer();

		String score = tennisGame.findScore();
		assertEquals("Fifteen,Fifteen", score);
	}

	public void testPlayerTwoScoresFirstTwoBalls() {
		createCustomizedScore(0, 2);

		String score = tennisGame.findScore();
		assertEquals("Love,Thirty", score);
	}

	public void testPlayerOneScoresFirstThreeBalls() {
		createCustomizedScore(3, 0);
		String score = tennisGame.findScore();
		assertEquals("Forty,Love", score);
	}
	
	

	// Deuce Test cases
	public void testForDeuce() {
		createCustomizedScore(3, 3);

		String score = tennisGame.findScore();
		assertEquals("Deuce", score);
	}

	public void testForEqualButNotDuece() {
		createCustomizedScore(2, 2);

		String score = tennisGame.findScore();
		assertEquals("Thirty,Thirty", score);
	}

	public void testPlayersAreAtDuceAtScore4() {
		createCustomizedScore(4, 4);
		String score = tennisGame.findScore();
		assertEquals("Deuce", score);
	}
	
	

	// Advantage test cases
	public void testPlayerBAdvantage() {
		createCustomizedScore(4, 5);

		String score = tennisGame.findScore();
		assertEquals("Advantage Player B", score);
	}

	public void testPlayerAAdvantage() {
		createCustomizedScore(5, 4);

		String score = tennisGame.findScore();
		assertEquals("Advantage Player A", score);
	}
	
	

	// Winning Condition Test cases
	public void testPlayerTwoWins() {
		createCustomizedScore(2, 4);
		String score = tennisGame.findScore();
		assertEquals("Player B is winner", score);
	}

	public void testPlayerTwoWinsAfterAdvantage() {
		createCustomizedScore(6, 8);
		String score = tennisGame.findScore();
		assertEquals("Player B is winner", score);
	}

	public void testPlayerOneWinsAfterAdvantage() {
		createCustomizedScore(8, 6);
		String score = tennisGame.findScore();
		assertEquals("Player A is winner", score);
	}

	// This method will be called when there is a need to create a customized input
	// for the scores
	public void createCustomizedScore(int playerOneWinningShots, int playerTwoWinningShots) {
		for (int i = 0; i < playerOneWinningShots; i++) {
			tennisGame.scoreByFirstPlayer();
		}
		for (int i = 0; i < playerTwoWinningShots; i++) {
			tennisGame.scoreBySecondPlayer();
		}
	}
}
