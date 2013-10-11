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
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
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
	
	public int getAnte(int past){
		Poker.sleep(500);
		int ante = 0;
		while (ante < past)
			ante = rand.nextInt(getCash() / 10); //bids up to maximum of 1/10 of current cash
		
		System.out.println(getName() + " puts " + ante + " forward as ante.");
		Poker.sleep(1500);
		return ante;
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
}
