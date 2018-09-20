
public class Card {
	
	private int value;
	private String suit;
	private String name;
	
	public Card(){
		
	}
	
	public Card(int val, String suit, String name){
		this.value = val;
		this.suit = suit;
		this.name = name;
	}
	
	public int getValue(){
		return value;
	}
	
	public String getSuit(){
		return suit;
	}
	
	public String getName(){
		return name;
	}
	
	public void setValue(int newVal){
		this.value = newVal;
	}
	
	public void setSuit(String newSuit){
		this.suit = newSuit;
	}
	
	public void setName(String newName){
		this.name = newName;
	}
	
	public String toString(){
		return getName() + " of " + getSuit();
	}
}
