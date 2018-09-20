import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class testBlackJackGame {
	
	//static BlackJackGame newGame;
	
	static Hand dealerHand;
	static Hand playerHand;
	
	static Deck newDeck;
	
	static boolean gameOver = false;
	static boolean playerWins = false;
	static boolean dealerWins = false;
	static boolean isPlayerTurn = true;
	static boolean isDealerTurn = true;
	
	@BeforeClass
	public static void testSetup(){
		playerHand = new Hand();
		dealerHand = new Hand();
		newDeck = new Deck();
		
		//newGame = new BlackJackGame();
		
	}
	
	/*
	@Test 
	public void testIntializeGame(){
		BlackJackGame.initializeGame();
		
	}
	*/
}
