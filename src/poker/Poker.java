package poker;

import java.io.IOException;
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
	
	private int currentPlayer; //contains who the current player is
	private int playerOneCash; //cash that player One has
	private int playerTwoCash; //cash that player Two has
	private Hand playerOneHand; //hand of player One
	private Hand playerTwoHand; //hand of player Two
	private int bet; //the current bet 
	private int ante; //the bet that has to be overcome
	public final int STARTING_CASH = 500;
	private Deck deck; //the deck of the game
	private static final int CLEARSCREEN_AMOUNT = 100; //number of lines to clear screen with 
	private static final String TEXTLINE = "------------------"; //dashes that appended to menus
	/**
	 * main()
	 * 
	 * calls menu and run game
	 * @param args
	 */
	public static void main(String[] args) {//Actual game runtime
		Scanner in = new Scanner(System.in);
		Poker.callMenu(in);
		in.close();
	}
	/**
	 * Constructor
	 */
	public Poker() {
		playerOneCash = STARTING_CASH;
		playerTwoCash = STARTING_CASH;
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
		if (currentPlayer == 1)
			currentPlayer = 2;
		else
			currentPlayer = 1;
	}
	/**
	 * getBet()
	 * 
	 * returns the bet
	 * 
	 * @return int
	 */
	public int getBet(){
		return bet;
	}
	
	/**
	 * setBet()
	 * 
	 * sets the bet to the parameter bet
	 * 
	 * @param int
	 */
	public void setBet(int bet){
		this.bet = bet;
	}
	
	/**
	 * getAnte()
	 * 
	 * gets the ante the better has to overcome
	 * 
	 * @return int
	 */
	
	public int getAnte(){
		return ante;
	}
	
	/**
	 * setAnte()
	 * 
	 * sets the ante the better has to overcome
	 * 
	 * @param int
	 */
	
	public void setAnte(int ante){
		this.ante = ante;
	}
	
	/**
	 * changeCash()
	 * 
	 * Modify the cash of the player sent in parameter by amount
	 * 
	 * @param player
	 * @param amount
	 */
	public void changeCash(int player, int amount){
		if (player == 1){
			playerOneCash += amount;
		}
		if (player == 2){
			playerTwoCash += amount;
		}
	}
	
	/**
	 * getCash()
	 * 
	 * returns the cash of the player
	 * 
	 * @param player
	 * @return int
	 */
	public int getCash(int player){
		if (player ==1 )
			return playerOneCash;
		if (player ==2 )
			return playerTwoCash;
		
		return -1;
	}
	
	/**
	 * run()
	 * 
	 * does the actual running of the game
	 * 
	 */
	public void run(){
		
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
			return callMenu(in); //recurses and calls the menu again
		}
		case "3":{
			System.out.println("This project was coded in Java using the Eclipse IDE");
			System.out.println("Coded by Paul Steele as a Semester Project");
			System.out.println("Work began the 8th week of class");
			System.out.println("");
			System.out.println("Press return to go back to menu");
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
}