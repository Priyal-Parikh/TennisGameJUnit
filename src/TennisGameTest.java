import junit.framework.TestCase;

public class TennisGameTest extends TestCase {

	TennisGame tennisGame = new TennisGame(0, 0, "Player A", "Player B");

	public void testNewGameReturnLoveAll() {
		String score = tennisGame.findScore();

		assertEquals("Love,Love", score);
	}

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
	
	
	public void testPlayerOneScoresFirstThreeBalls(){
		createCustomizedScore(3, 0);
		String score = tennisGame.findScore();
		assertEquals("Forty,Love", score);
	}
	
	
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
	
	
	
	//This method will be called when there is a need to create a customized input for the scores
	public void createCustomizedScore(int playerOneWinningShots, int playerTwoWinningShots ) {
		for (int i = 0; i < playerOneWinningShots; i++) {
			tennisGame.scoreByFirstPlayer();
		}
		for (int i = 0; i < playerTwoWinningShots; i++) {
			tennisGame.scoreBySecondPlayer();
		}
	}
}
