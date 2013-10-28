package poker;

import java.util.Scanner;

/**
 * Poker
 * 
 * The full poker game. Includes menu and AI and the whole lot
 * 
 * @author Paul Steele
 *
 */
public class Poker {
	private final int PLAYERS;
	private int currentPlayer; //contains who the current player is
	private Player[] players;
	private final int STARTING_CASH = 500;
	private Deck deck; //the deck of the game
	private Hand community; //the community cards
	private static final int CLEARSCREEN_AMOUNT = 100; //number of lines to clear screen with 
	private static final String TEXTLINE = "------------------"; //dashes that appended to menus
	private int bid; //the highest bid
	private int pot; //what's in the pot
	private int dealer;
	public static final int BIG_BLIND = 10; //the big blind
	/**
	 * main()
	 * 
	 * calls menu and run game
	 * @param args
	 */
	public static void main(String[] args) {//Actual game runtime
		Scanner in = new Scanner(System.in);
		boolean play = Poker.callMenu(in);
		in.close();
		Poker game = new Poker(5);
		if (play)
			game.run();
			
	}
	/**
	 * Constructor
	 */
	public Poker(int playersd) {
		this.PLAYERS = playersd;
		players = new Player[PLAYERS+1];
		players[1] = new Human();
		//create players
		for (int i = 2; i < PLAYERS + 1; i++){
			players[i] = new AI();
		}
		//initialization
		for (int i = 1; i < PLAYERS+1;i++){
			players[i].changeCash(STARTING_CASH);
			if (i !=1)
				players[i].setName("AI " + (i -1));
			else
				players[i].setName("Human " + i);
		}
		currentPlayer = 1;
		community = new Hand();
		dealer = 1;
	}
	
	/**
	 * getCurrentPlayer()
	 * 
	 * returns an integer of whose turn it is
	 * @return int
	 */
	
	public int getCurrentPlayer(){
		return currentPlayer;
	}
	
	/**
	 * changePlayer()
	 * 
	 * changes from player 1 to player 2 and vice versa
	 * depending on who the current player is
	 */
	public void changePlayer(){
		if (currentPlayer == PLAYERS)
			currentPlayer = 1;
		else
			currentPlayer +=1;
	}
	
	
	/**
	 * run()
	 * 
	 * does the actual running of the game
	 * 
	 */
	public void run(){
		int temp; //this number is used when temporary values need to be sent to two different functions
		Poker.clearScreen();
		deck = new Deck();
		for (int i = 0; i < 20; i++){
			deck.shuffle();
		}
		
		pot = 0;
		bid = 0;
		deck.shuffle();//start off by shuffling
		//give each player a brand new hand
		for (int i = 1; i < PLAYERS + 1; i++){
			players[i].setHand(new Hand());
		}
		
		//deal each player 2 cards
		for (int i = 1; i < PLAYERS +1; i++){
			players[i].getHand().add(deck.draw());
			players[i].getHand().add(deck.draw());
		}
		//Say that the dealer deals
		players[dealer].speak("deals two cards to each player");
		//Clear each players current bid
		for (int i = 1; i < PLAYERS + 1;i++){
			players[i].setCurrentBid(0);
		}
		//big blind left of dealer
		temp = players[getBlinders()[0]].getBlind(true);
		pot += temp;
		bid = temp;
		//small blind right of dealer
		temp = players[getBlinders()[1]].getBlind(false);
		pot += temp;
		
		
		
		
		
	}
	/**
	 * callMenu()
	 * 
	 * calls up a menu
	 * 
	 * @return true if a game is to be played
	 *
	 */
	public static boolean callMenu(Scanner in){
		clearScreen();//clears screen for use
		System.out.println(TEXTLINE + "Welcome to Five Card Poker" + TEXTLINE);
		System.out.println("\nPlease Select an option");
		System.out.println("");
		System.out.println("1). Play a game");
		System.out.println("2). How to play");
		System.out.println("3). About");
		System.out.println("4). Exit");
		String holder = in.next();
		switch (holder){
		case "1":{
			return true;
		}
		case "2":{
			System.out.println("Poker is a really fun game, try it sometime");
			System.out.println("Dont't worry I'll add more to this later");
			System.out.println("");
			System.out.println("Press return to go back to menu");
			in.nextLine();
			in.nextLine();
			return callMenu(in); //recurses and calls the menu again
		}
		case "3":{
			System.out.println("This project was coded in Java using the Eclipse IDE");
			System.out.println("Coded by Paul Steele as a Semester Project");
			System.out.println("Work began the 8th week of class");
			System.out.println("");
			System.out.println("Press return to go back to menu");
			in.nextLine();
			in.nextLine();
			return callMenu(in);
		}
		case "4":{
			//immediate Exit
			return false;
		}
		default:{
			System.out.println("That is not a valid option");
			System.out.println("");
			System.out.println("Press return to go back to menu");
			in.nextLine();
			in.nextLine();
			return callMenu(in);
		}
			
		}
	}
	
	/**
	 * clearScreen()
	 * 
	 * utility class to clear the screen
	 */
	private static void clearScreen(){
		for (int i = 0 ; i < CLEARSCREEN_AMOUNT; i++){
			System.out.println("");
		}
	}
	
	public Player getPlayer(int play){
		return players[play];
	}
	
	public static void sleep(int i){
	
			try {
				Thread.sleep(i);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		
	}
	
	private int[] getBlinders(){
		int[] ret = new int[2];
		int big = dealer - 1;
		if (big == 0)
			big = PLAYERS;
		int small = dealer +1;
		if (dealer == PLAYERS)
			small = 1;
		ret[0] = big;
		ret[1] = small;
		return ret;
	}
	
	private void beginBid(){
		boolean done = false;
				
		while (!done){
			done = true;
			//checks to see if all players have called
			for (int i = 1; i < PLAYERS + 1; i++){
				if (players[i].meetingBid(bid) != true)
					done = false;
			}
			
			
		}
	}
	
}