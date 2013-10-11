package poker;


/**
 * AI class for five card poker
 * 
 * @author Paul Steele
 *
 */
public class AI implements Player{
	private int cash;
	private Hand hand;
	
	public void setHand(Hand hand){
		this.hand = hand;
	}
	
	public int getCash(){
		return cash;
	}
	
	public Hand getHand(){
		return hand;
	}
	
	public void changeCash(int difference){
		cash += difference;
	}
}
