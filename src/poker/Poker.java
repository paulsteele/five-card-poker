package poker;
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
	private int bet; //the current bet 
	private int ante; //the bet that has to be overcome
	public final int STARTING_CASH = 500;
	private Deck deck; //the deck of the game
	
	/**
	 * main()
	 * 
	 * runs the game
	 * @param args
	 */
	public static void main(String[] args) {//Actual game runtime
		
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
}