package poker;

import java.util.Random;


/**
 * AI class for five card poker
 * 
 * @author Paul Steele
 *
 */
public class AI extends Player{
	
	private Random rand = new Random();
	
	public int getBlind(boolean big){
		Poker.sleep(500);
		Poker.sleep(1500);
		int ret;
		int blind;
		if (big)
			blind = Poker.BIG_BLIND;
		else
			blind = Poker.BIG_BLIND / 2;
		if (getCash() > blind){
			speak("puts $" + blind + " forward as blind.");
			changeCash(-blind);
			currentBid = blind;
			ret = blind;
		}
		else {
			folding = true;
			speak("folds");
			ret = 0;
		}
		
		return ret;
	}
	
	public int getBid(int past){
		Poker.sleep(500);
		Poker.sleep(750);
		
		int howmuch = past - currentBid;
		speak("calls the bid by putting in "+ howmuch);
		changeCash(-howmuch);
		currentBid += howmuch;
		return howmuch;
		
	}

	public void showHand() {

	}
	
	
	

}
