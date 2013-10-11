package poker;

import java.util.Scanner;

public class Human implements Player{
	private int cash;
	private Hand hand;
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
		Scanner in = new Scanner(System.in);
		int ante = 0;
		while (ante < past){
			System.out.print("Please enter your ante");
			ante = in.nextInt();
			System.out.println("");
		}
		in.close();
		return ante;
			
		
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
}
