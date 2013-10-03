/**
 * Card Class
 * 
 * Class contains a card value and suit value
 * Also contains a terminal display method
 * 
 * @author paul
 *
 */
public class Card {
	private int number; //the value of the card
	private int suit; //the suit of the card
	
	
	/**
	 * Card Constructor
	 * 
	 * takes in a card value and suit value and stores them in this card
	 * @param number
	 * @param suit
	 */
	public Card(int number, int suit) {
		this.number = number;
		this.suit = suit;
	}
	
	/**
	 * getNumber()
	 * 
	 * returns the value number, not the human readable value
	 * @return int
	 */
	public int getNumber(){
		return number;
	}
	
	/**
	 * getSuit()
	 * 
	 * returns the suit value, not the human readable value
	 * @return int
	 */
	public int getSuit(){
		return suit;
	}
	
	/**
	 * getValue()
	 * 
	 * returns the human readable string of the card value e.g. "King", "One"
	 * @return String
	 */
	public String getValue(){
		switch (number){
		
		case 0: return "Ace";
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
		case 10:
		case 11:
		case 12:
		case 13:
		default: return "NA";
		}
		
	}
}