import java.util.*;

public class Hand extends Vector<Card>{
	
	
	public Hand(){
		super();
	}
	
	// clear hand of cards
	public void clear(){
		super.clear();
	}
	
	// return total of hand
	public int getTotal(){
		int total = 0;
		
		for(Card card : this){
			total = total + card.getValue();
		}
		return total;
	}
	
	// check if hand is bust ie. all card values > 21
	public boolean isBust(){
		if (this.getTotal() > 21){
			return true;
		}else{
			return false;
		}	
	}
	
	// check if initial hand is BlackJack
	public boolean isBlackJack(){
		if(this.getTotal() == 21 && this.size() == 2){
			return true;
		}else{
			return false;
		}
	}
	
	// add card to hand. Changes value of Ace to 1 if addition of new card creates a BUST
	public boolean addCard(Card newCard){
		
		boolean cardAdded = false;
		
		if(!isBust() && !isBlackJack()){
			cardAdded = super.add(newCard);
			
			if(isBust()){
				for(Card card : this){
					if(card.getName()== "Ace"){
						card.setValue(1);
						if(!isBust()){
							break;
						}
					}
				}
			}
		}
		return cardAdded;
	}
	
	public boolean containsAce(){
		for(Card card: this){
			if(card.getName()=="Ace" && card.getValue() == 11){
				return true;
			}
		}
		return false;
	}
	
	public String toString(){
		String fullHand = new String();
		Iterator i = this.iterator();
		while(i.hasNext()){
			fullHand += i.next().toString() + " ";
		}
		return fullHand + "for a total of: " + this.getTotal();
	}
	
}
