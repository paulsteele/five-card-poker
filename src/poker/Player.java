package poker;

public class Player {
	protected String name;
	protected boolean folding;
	protected int cash;
	protected Hand hand;
	protected int currentBid;
	protected Window window;
	
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
	
	
	
	public int getBlind(boolean big){
		return -500;
		//NEEDS TO BE OVERWRITTEN
	}
	public int getBid(int past){
		return -500;
		//NEEDS TO BE OVERWRITTEN
	}
	public void showHand(){
		//NEEDS TO BE OVERWRITTEN
	}
	
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
