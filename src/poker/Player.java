package poker;

public class Player {
	protected String name;
	protected boolean folding;
	protected int cash;
	protected Hand hand;
	
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
	
	public int getAnte(int past){
		return -500;
		//NEEDS TO BE OVERWRITTEN
	}
	public int getBid(int past){
		return -500;
		//NEEDS TO BE OVERWRITTEN
	}
	public boolean isFolding(){
		return folding;
	}
	public void speak(String phrase){
		System.out.println(getName() + " " + phrase);
	}
}
