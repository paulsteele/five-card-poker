package poker;

import java.util.Scanner;

public class Human extends Player {
	
	
	public int getBlind(boolean big){
		int blind;
		if (big)
			blind = Poker.BIG_BLIND;
		else
			blind = Poker.BIG_BLIND / 2;
				changeCash(-blind); 
				speak("puts $" + blind + " forward as blind.");
				currentBid = blind;
				return blind;
	}
	
	
	public int getBid(int past){
		Scanner in = new Scanner(System.in);
		int bid = 0;
		while (bid < past){
			System.out.print("Please enter your bid");
			System.out.print("You need to bid " + (past - currentBid) + " in order to call");
			bid = in.nextInt();
			System.out.println("");
		}
		in.close();
		changeCash(-bid);
		currentBid += bid;
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
