import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class DeckTest {
	
	static Deck testDeck1;
	static Deck testDeck2;
	
	@BeforeClass
	public static void testSetup(){
		testDeck1 = new Deck();
		testDeck2 = new Deck();
	}
	
	@Test
	public void testDeckSize(){
		assertEquals(52, testDeck1.size());
	}
	
	@Test
	public void testDeckShuffle(){
		Card card = testDeck1.get(0);
		testDeck1.shuffleDeck();
		/*
		boolean sameCard = true;
		if(!card.equals(testDeck.get(0))){
			sameCard = false;
		}
		assertEquals(false, sameCard);
		*/
		assertNotEquals(card, testDeck1.get(0));
	}
	
	@Test
	public void testDealCard(){
		Card card = testDeck2.dealCard();
		assertEquals(51, testDeck2.size());
		
	}
}
