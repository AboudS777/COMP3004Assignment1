import java.util.*;

public class Deck extends Stack<Card>{
	
	public static final int DECK_SIZE = 52;
	
	
	public Deck(){
		
		super();
		
		final String[] suits = {"Spades", "Diamonds", "Clubs", "Hearts"};
		final String[] cardName = {"Ace", "Two", "Three", "Four", "Five","Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		
		for (String suit : suits)
		{
			for(int i = 0; i < 13; i++){
				if(cardName[i] == "Jack" || cardName[i] == "Queen" || cardName[i] == "King"){
					this.push(new Card(10, suit, cardName[i]));
				}else if(cardName[i] == "Ace"){
					this.push(new Card(11, suit, cardName[i]));
				}else{
					this.push(new Card(i+1, suit, cardName[i]));
				}
			}
		}
	}
	
	// shuffles the deck
	public void shuffleDeck(){
		Collections.shuffle(this);
	}
	
	// deals a card
	public Card dealCard(){
		
		if (this.empty()){
			System.out.println("No cards left in deck");
			return null;
		}else{
			return this.pop();
		}
	}
}
