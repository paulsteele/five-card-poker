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
	private int lastRound =-1; //the last round bet on
	public AI(Poker game){
		super(game);
	}
	private double aggressivess = 22.5;
	
	public int getBlind(boolean big) throws InterruptedException{
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
	
	public int getBid(int past) throws InterruptedException{
		Poker.sleep(500);
		Poker.sleep(750);
		boolean oneround = false;
		int howmuch=0;
		double reccurance = 1.0;
		while (!oneround || (howmuch < past - currentBid)){ //short circuit to always request at least once
			if (lastRound == game.getRound()){
				reccurance -= .1;
			}
			else {
				lastRound = game.getRound();
			}
			
			double probability = (currentScore()-1.0);
			probability *= reccurance;
			probability *= aggressivess;
			if (rand.nextDouble() < probability){
				//increase bid
				howmuch = past - currentBid + 10;
			}
			else {
				//call
				howmuch = past - currentBid;
			}
			oneround = true;
		}
		speak("bids "+ howmuch);
		changeCash(-howmuch);
		currentBid += howmuch;
		return howmuch;
		
	}
	
	public int currentScore() {
		Hand combined = Hand.combine(getHand(), game.getCommunity());
		combined.sort();
		return combined.rescore();
	}
}
