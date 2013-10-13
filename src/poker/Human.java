package poker;

import java.util.Scanner;

public class Human implements Player {
	private int cash;
	private Hand hand;
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
		if (cash < 0){
			speak("is out of money!");
			folding = true;
		}
	}
	
	public int getAnte(int past){
		Scanner in = new Scanner(System.in);
		System.out.println("Play this round? (y/n)");
		String input = in.next();
		in.close();
		switch (input.toLowerCase()){
			case "y": {
				changeCash(-5); 
				speak("puts $5 forward as ante.");
				return 5;
			}
			default: {
				folding = true;
				speak("folds");
				return 0;
			}
		}
		
		
			
		
	}
	
	public int getBid(int past){
		Scanner in = new Scanner(System.in);
		int bid = 0;
		while (bid < past){
			System.out.print("Please enter your bid");
			bid = in.nextInt();
			System.out.println("");
		}
		in.close();
		return bid;
	}
	
	public boolean isFolding(){
		return folding;
	}
	
	public void speak(String phrase){
		System.out.println(getName() + " " + phrase);
	}
}
