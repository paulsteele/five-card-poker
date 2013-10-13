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
	
	public int getAnte(int past){
		Poker.sleep(500);
		int ret;
		if (getCash() > 5){
			speak("puts $5 forward as ante.");
			changeCash(-5);
			ret = 5;
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
		int bid = 0;
		while (bid < past)
			bid = rand.nextInt(getCash() / 3); //bids up to maximum of 1/10 of current cash
		
		speak("bids " + bid);
		Poker.sleep(1500);
		return bid;
	}
	
	
	

}
