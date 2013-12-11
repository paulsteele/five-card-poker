package poker;

public abstract class Player {
	protected String name;
	protected boolean folding;
	protected int cash;
	protected Hand hand;
	protected int currentBid;
	protected Window window;
	protected Poker game;
	protected boolean allIn;
	protected boolean inGame = true;
	protected int lead;
	protected int secondlead;
	protected int timesBid;
	protected int lastScore;
	
	public Player(Poker game){
		this.game = game;
	}
	
	public Poker getGame(){
		return game;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public void setHand(Hand hand){
		this.hand = hand;
		folding = false;
		allIn = false;
		timesBid = 0;
		lastScore = 0;
		
	}
	
	public Hand getHand(){
		return hand;
	}
	
	public int getCash(){
		return cash;
	}
	
	public void changeCash(int difference){
		cash += difference;
	}
	public abstract int getBlind(boolean big) throws InterruptedException;
	public abstract int getBid(int past) throws InterruptedException;
	
	public boolean isFolding(){
		return !inGame || folding;
	}
	
	public void speak(String phrase){
		window.print(getName() + " " + phrase);
	}
	
	public int getCurrentBid(){
		return currentBid;
	}
	
	public void setCurrentBid(int bid){
		currentBid = bid;
	}
	
	public boolean meetingBid(int bid){
		return (allIn || (bid == currentBid));
	}
	
	public void setWindow(Window window){
		this.window = window;
	}
	public int currentScore() {
		Hand combined = Hand.combine(getHand(), game.getCommunity());
		combined.sort();
		int score = combined.rescore();
		lead = combined.getLead();
		secondlead = combined.getSecondLead();
		return score;
	}
	
	public String getScoreName() {
		switch (currentScore()){
			case 10: return "Royal Flush";
			case 9: return "Straight Flush";
			case 8: return "Four of a Kind";
			case 7: return "Full House";
			case 6: return "Flush";
			case 5: return "Straight";
			case 4: return "Three of a Kind";
			case 3: return "Two Pairs";
			case 2: return "One Pair";
			case 1: return "Junk";
			default: return "Purple";
		}
	}
	
	public int getLead(){
		if (lead == 0)
			return 13;
		
		return lead;
	}
	
	public int getSecondLead(){
		if (secondlead == 0)
			return 13;
		return secondlead;
	}
}
