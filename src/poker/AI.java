package poker;

import java.util.Random;


/**
 * AI class for five card poker
 * 
 * @author Paul Steele
 *
 */
public class AI implements Player{
	private int cash;
	private Hand hand;
	private Random rand = new Random();
	private String name;
	private boolean folding;
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setHand(Hand hand){
		this.hand = hand;
		folding = false;
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
	
	public int getAnte(int past){
		Poker.sleep(500);
		int ret;
		if (getCash() > 5){
			System.out.println(getName() + " puts $5 forward as ante.");
			changeCash(-5);
			ret = 5;
		}
		else {
			folding = true;
			System.out.println(getName() + " folds");
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
		
		System.out.println(getName() + " bids " + bid);
		Poker.sleep(1500);
		return bid;
	}
	
	public boolean isFolding(){
		return folding;
	}
}
