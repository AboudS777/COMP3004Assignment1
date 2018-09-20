
import java.util.*;

public class BlackJackGame {

	private static Hand dealerHand = new Hand();
	private static Hand playerHand = new Hand();
	
	private static Deck deck = new Deck();
	private static Scanner scan = new Scanner(System.in);
	
	
	private static boolean gameOver = false;
	private static boolean playerWins = false;
	private static boolean dealerWins = false;
	private static boolean isPlayerTurn = true;
	private static boolean isDealerTurn = true;
	
	public static void main(String[] args) {
			
		promptUser();
		checkHandsForBlackJack();
		playerPlay();
		dealerPlay();	
		checkHandsForBust();
		checkForHighestHand();
	}
	
	public BlackJackGame(){
		
	}
	
	// check which player has the highest hand without being bust
	private static void checkForHighestHand() {
		if(dealerHand.getTotal() >= playerHand.getTotal() && !dealerHand.isBust()){
			printPlayerHand();
			printDealerFinalHand();
			System.out.println("Dealer has the higher hand. Dealer wins.");
			dealerWins = true;
			gameOver = true;
		}else if(playerHand.getTotal() > dealerHand.getTotal() && !playerHand.isBust()){
			printPlayerHand();
			printDealerFinalHand();
			System.out.println("Player has the higher hand. Player wins.");
			playerWins = true;
			gameOver = true;
		}
	}

	// checks hands for BlackJack
	private static void checkHandsForBlackJack() {
		if(dealerHand.isBlackJack()){
			printDealerFinalHand();
			System.out.println("Dealer has BlackJack. Dealer wins.");
			dealerWins = true;
			gameOver = true;
		}else if(playerHand.isBlackJack() && !dealerHand.isBlackJack()){
			printPlayerHand();
			printDealerFinalHand();
			System.out.println("Player has BlackJack and dealer does not. Player wins.");
			playerWins = true;
			gameOver = true;
		}
	}

	// checks hands for bust
	private static void checkHandsForBust() {
		if(playerHand.isBust()){
			printPlayerHand();
			System.out.println("Player's hand is bust. Dealer wins.");
			dealerWins = true;
			gameOver = true;
		}else if(!playerHand.isBust() && dealerHand.isBust()){
			printPlayerHand();
			printDealerFinalHand();
			System.out.println("Dealer's hand is bust. Player wins.");
			playerWins = true;
			gameOver = true;
		}
	}

	// dealer "plays"
	private static void dealerPlay() {
		while(isDealerTurn){
			if(dealerHand.getTotal() < 16){
				dealerHand.addCard(deck.dealCard());
			}else if(dealerHand.getTotal() > 17){
				isDealerTurn = false;				
			}else if(dealerHand.getTotal() == 17 && dealerHand.containsAce()){
				dealerHand.addCard(deck.dealCard());
				isDealerTurn = false;
			}
		}
	}

	// perform hit or stand depending on player choice
	public static boolean playTurn(Hand hand, String action){
		if(action.equalsIgnoreCase("H")){
			hand.addCard(deck.pop());
			printPlayerHand();
			return true;
		}else if (action.equalsIgnoreCase("S")){
			return false;
		}else{
			return false;
		}
	}
	
	// prompt user for console or file input
	public static void promptUser(){
		System.out.println("Hello, select Console(c) or File input(f)");
		String s = scan.next();
		if (s.equalsIgnoreCase("C")){
			initializeGame();
		}else if(s.equalsIgnoreCase("F")){
			return;
		}
	}
	
	// initialize card game
	public static void initializeGame(){
		deck.shuffleDeck();
		playerHand.addCard(deck.dealCard());
		playerHand.addCard(deck.dealCard());
		dealerHand.addCard(deck.dealCard());
		dealerHand.addCard(deck.dealCard());
		printInitialHands();
	}
	
	public static void playerPlay(){
		while (isPlayerTurn){
			System.out.println("Select: Hit(h) or Stand(s)");
			String decision = scan.next();
			isPlayerTurn = playTurn(playerHand, decision);
		}
	}
	
	//display initial hands
	public static void printInitialHands(){
		System.out.println("Initial hand: You have " + playerHand.toString());
		System.out.println("Dealer's initial hand: " + dealerHand.get(1).toString() + " and another card face down.");
	}
	
	//display player hand
	public static void printPlayerHand(){
		System.out.println("You have " + playerHand.toString());
	}
	
	//display dealer's final hand
	public static void printDealerFinalHand(){
		System.out.println("Dealer has " + dealerHand.toString());
	}
}
