package poker;

import java.util.Scanner;

public class Human extends Player {
	
	
	public int getBlind(boolean big){
		Scanner in = new Scanner(System.in);
		System.out.println("Play this round? (y/n)");
		String input = in.next();
		in.close();
		int blind;
		if (big)
			blind = Poker.BIG_BLIND;
		else
			blind = Poker.BIG_BLIND / 2;
		switch (input.toLowerCase()){
			case "y": {
				changeCash(-blind); 
				speak("puts $" + blind + " forward as blind.");
				currentBid = blind;
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
	
	public void showHand(){
		System.out.println(getName() + "'s cards are");
		for (int i = 0; i < getHand().length(); i++){
			System.out.print( (i+1) + ": " );
			getHand().getCard(i).display();
		}
	}
	
}
