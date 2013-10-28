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
		
		Poker.sleep(1500);
		return ret;
	}
	
	public int getBid(int past){
		Poker.sleep(500);
		//int bid = 0;
		//while (bid < past)
		//	bid = rand.nextInt(getCash() / 3); //bids up to maximum of 1/10 of current cash
		
		//speak("bids " + bid);
		Poker.sleep(750);
		speak("calls the bid");
		int howmuch = past - currentBid;
		changeCash(-howmuch);
		currentBid += howmuch;
		Poker.sleep(750);
		return howmuch;
		
	}
	
	
	

}
