package poker;
/**
 * Hand Class
 * 
 * Class that handles evaluating score of a hand and dealing with getting info from it
 * 
 * @author Paul Steele
 *
 */
public class Hand{
	private Card[] hand; //an array of cards in the hand
	private int score; //score of the hand
	
	/**
	 * Constructor
	 * 
	 * Creates hand instance
	 */
	public Hand(){
		hand = new Card[0]; //empty card array
		rescore(); //checks the score of this hand
	}
	
	/**
	 * rescore()
	 * 
	 * looks at the cards in this hand and returns (and assigns) the score of hand
	 * 
	 * @return int
	 */
	public int rescore(){
		//right now simply return 0
		score = 0;
		return score;
		
	}
	/**
	 * getCard()
	 * 
	 * returns the card at index array
	 * 
	 * @param array
	 * @return Card
	 */
	public Card getCard(int array){
		if (!(array < 0 || array > hand.length))
			return hand[array];
		else
			return null;
	}
	
	/** 
	 * add()
	 * 
	 * takes parameter card and adds it to the hand at the end
	 * @param card
	 */
	public void add(Card card){
		Card[] temp = new Card[hand.length + 1];
		for (int i = 0; i < hand.length; i ++){
			temp[i] = hand[i];
		}
		temp[hand.length] = card;
		hand = temp;
	}
	
	public int length() {
		return hand.length;
	}
	
	public void sort() {
		//this method will make scoring easy cards of same suit placed next to each other in order
	}
}