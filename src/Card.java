/**
 * Card Class
 * 
 * Class contains a card value and suit value
 * Also contains a terminal display method
 * 
 * @author Paul Steele
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
			case 1: return "Two";
			case 2: return "Three";
			case 3: return "Four";
			case 4: return "Five";
			case 5: return "Six";
			case 6: return "Seven";
			case 7: return "Eight";
			case 8: return "Nine";
			case 9: return "Ten";
			case 10: return "Jack";
			case 11: return "Queen";
			case 12: return "King";
		
			default: return "NA";
		}
		
	}
	
	/**
	 * getSuitChar()
	 * 
	 * returns a char value of the suit e.g. a spade would return ♠ 
	 * ♠ ♣ ♦ ♥
	 * @return char
	 */
	public char getSuitChar(){
		switch(suit){
			case 0: return '♥';
			case 1: return '♦';
			case 2: return '♣';
			case 3: return '♠';
			
			default: return 'N';
		}
	}
}