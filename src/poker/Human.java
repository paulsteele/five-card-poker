package poker;

public class Human extends Player {
	
	
	public Human(Poker game){
		super(game);
	}
	
	public int getBlind(boolean big) throws InterruptedException{
		Poker.sleep(500);
		int blind;
		if (big)
			blind = Poker.BIG_BLIND;
		else
			blind = Poker.BIG_BLIND / 2;
				changeCash(-blind); 
				speak("puts $" + blind + " forward as blind.");
				currentBid = blind;
				window.redrawScore();
				return blind;
	}
	
	
	public int getBid(int past) throws InterruptedException{
		int bid = 0;
		Poker.sleep(500);
		boolean oneround = false;
		while (!oneround || (bid < past)){
			window.print("Please enter your bid");
			window.print("You need to bid " + (past - currentBid) + " in order to call");
			Poker.setLock(this);
			synchronized (Poker.getLock()){
					window.buttonsEnabled(true);
					wait();	
			}
			window.buttonsEnabled(false);
			if ("folding".equals(Poker.dropbox)){
				speak("folds");
				folding = true;
				return 0;
			}
			
			if ("call".equals(Poker.dropbox)){
				bid = past - currentBid;
				speak("calls the bid by putting in "+ bid);
				changeCash(-bid);
				currentBid += bid;
				return bid;
			}
			
			bid = (int) Poker.dropbox;
			oneround = true;
		}
		changeCash(-bid);
		currentBid += bid;
		return bid;
	}
}
