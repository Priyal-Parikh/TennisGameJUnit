import junit.framework.TestCase;

public class TennisGameTest extends TestCase{
	
	TennisGame tennisGame = new TennisGame(0,0,"Player A" , "Player B");
	
	public void testNewGameReturnLoveAll()
	{
		String score = tennisGame.calculateScore();
		
		assertEquals("Love,Love", score);
	}

}
