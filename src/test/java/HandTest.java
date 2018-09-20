import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class HandTest {
	
	static Hand testHand1;
	static Hand testHand2;
	static Hand testHand3;
	static Hand testHand4;
	static Hand testHand5;
	static Hand testHand6;
	
	static Card card1;
	static Card card2;
	static Card card3;
	static Card card4;
	static Card card5;
	static Card card6;
	static Card card7;
	static Card card8;
	static Card card9;
	static Card card10;
	
	static Deck deck1;
	static Deck deck2;
	
	@BeforeClass
	public static void setSetup(){
		testHand1 = new Hand();
		testHand2 = new Hand();
		testHand3 = new Hand();
		testHand4 = new Hand();
		testHand5 = new Hand();
		testHand6 = new Hand();

		card1 = new Card(11, "Spades", "Ace");
		card2 = new Card(5, "Spades", "Five");
		card3 = new Card(11, "Hearts", "Ace");
		
		card4 = new Card(11, "Hearts", "Ace"); 
		card5 = new Card(11, "Spades", "Ace");
		card6 = new Card(11, "Hearts", "Queen");
		card7 = new Card(3, "Hearts", "Three");
		
		card8 = new Card(10, "Spades", "Jack");
		card9 = new Card(10, "Hearts", "Queen");
		card10 = new Card(10, "Hearts", "King");
		
		deck1 = new Deck();
		deck2 = new Deck();
		testHand1.addCard(deck1.dealCard());
		testHand1.addCard(deck1.dealCard());
		testHand2.addCard(new Card(10, "Diamonds", "Jack"));
		testHand2.addCard(new Card(10, "Spades", "Ten"));
		testHand3.addCard(new Card(10, "Diamonds", "Jack"));
		testHand3.addCard(new Card(10, "Spades", "Ten"));
		testHand3.addCard(new Card(10, "Spades", "Queen"));
		testHand4.addCard(new Card(11, "Spades", "Ace"));
		testHand4.addCard(new Card(10, "Spades", "King"));
		
	}
	
	@Test
	public void testClearHand(){
		testHand1.clear();
		assertEquals(0, testHand1.size());
	}
	
	@Test
	public void testGetTotal(){
		assertEquals(20, testHand2.getTotal());
	}
	
	@Test
	public void testIsBust(){
		boolean isBust = false;
		if(testHand3.getTotal() > 21){
			isBust = true;
		}
		assertEquals(true, isBust);
	}
	
	@Test
	public void testIsBlackJack(){
		assertEquals(21, testHand4.getTotal());
		assertEquals(2, testHand4.size());
	}
	
	@Test
	public void testAddCard(){
		assertEquals(true, testHand5.addCard(card1));
		assertEquals(true, testHand5.addCard(card2));
		assertEquals(true, testHand5.addCard(card3));
		assertEquals(true, testHand5.contains(card1));
		assertEquals(true, testHand5.contains(card2));
		assertEquals(true, testHand5.contains(card3));
		assertEquals(1, card1.getValue());
		assertEquals(11, card3.getValue());
		
		assertEquals(true, testHand6.addCard(card4));
		assertEquals(true, testHand6.addCard(card5));
		assertEquals(true, testHand6.addCard(card6));
		assertEquals(true, testHand6.addCard(card7));
		assertEquals(1, card4.getValue());
		assertEquals(1, card5.getValue());
		
	}
	
	@Test
	public void testJQKValue(){
		assertEquals(10, card8.getValue());
		assertEquals(10, card9.getValue());
		assertEquals(10, card10.getValue());
	}
	
	
}
