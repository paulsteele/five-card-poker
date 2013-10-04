package poker;
/**
 * Deck 
 * 
 * Class is a collection of 52 cards, all of which make up the playable deck
 * Has shuffle methods and draw methods and renew
 * 
 * @author Paul Steele
 *
 */

import java.util.Random; //used for shuffling



public class Deck{
	private Card[] deck; //the deck of cards
	private int remainingCards; //number of remaining cards
	
	/**
	 * Deck Constructor
	 */
	public Deck(){
		deck = new Card[52];//declares deck
		remainingCards = deck.length; //initializes the remaingCards value
		int suit; //the suit value
		int number; //the card number value
		
		for(int i = 0; i < remainingCards; i++){ //loops through all cards and assigns a suit and number
			suit = i / 13; //will ultimately hit 0, 1, 2, and 3 each 14 times
			number = i % 13; //fills each card number with one value per set
			deck[i] = new Card(number, suit); //does the actual assigning of cards
			
		}
	}
	
	/**
	 * shuffle()
	 * 
	 * Shuffles the deck
	 */
	public void shuffle(){
		Random random = new Random(); //gets new random
		int firstNumber; //obtains a random spot between 0 and 52
		int secondNumber; //obtains a random spot between 0 and 52
		for (int i = 0; i < remainingCards; i++){
			firstNumber = random.nextInt(remainingCards); 
			secondNumber = random.nextInt(remainingCards);
			Card temp = deck[firstNumber];
			deck[firstNumber] = deck[secondNumber]; //puts 2nd card into first
			deck[secondNumber] = temp;//puts 1st card into 2nd
		}
		
		
	}
	/**
	 * getRemaningCards()
	 * 
	 * returns the number of remaining cards in deck
	 * @return int
	 */
	public int getRemainingCards(){
		return remainingCards;
		
	}
	
	/**
	 * getCard(int)
	 * 
	 * returns the card at the array location of deck
	 * @param array
	 * 
	 * @return Card
	 */
	public Card getCard(int array){
		return deck[array];
	}
	
	/**
	 * draw()
	 * 
	 * takes the first card out of the deck and resizes the array
	 * 
	 * @return Card
	 */
	public Card draw() {
		
		Card[] temp = new Card[remainingCards - 1]; //makes a new card array one size smaller than previous deck
		
		Card ret = deck[0]; //gets the card that will be returned
		
		for (int i = 1; i < remainingCards -1 ; i++) {
			temp[i - 1] = deck [i];//goes through and puts 1 through top into 0 through new top in the new deck
		}
		deck = temp; //makes the deck = the new deck
		remainingCards -= 1; //lowers card count
		
		return ret; //returns the actual card after all that work
		
	}
}