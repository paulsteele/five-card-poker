package poker;

public abstract class Player {
	protected String name;
	protected boolean folding;
	protected int cash;
	protected Hand hand;
	protected int currentBid;
	protected Window window;
	protected Poker game;
	
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
	}
	
	public Hand getHand(){
		return hand;
	}
	
	public int getCash(){
		return cash;
	}
	
	public void changeCash(int difference){
		cash += difference;
		if (cash < 0){
			speak("is out of money!");
			folding = true;
		}
	}
	public abstract int getBlind(boolean big) throws InterruptedException;
	public abstract int getBid(int past) throws InterruptedException;
	
	public boolean isFolding(){
		return folding;
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
		return (bid == currentBid);
	}
	
	public void setWindow(Window window){
		this.window = window;
	}
}
