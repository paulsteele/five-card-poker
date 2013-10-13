package poker;

import java.util.Scanner;

public class Human extends Player {
	
	
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
	
}
