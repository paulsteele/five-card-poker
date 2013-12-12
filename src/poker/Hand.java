package poker;
/**
 * Hand Class
 * 
 * Class that handles evaluating score of a hand and dealing with getting info from it
 * 
 * @author Paul Steele
 *
 */
public class Hand{
	private Card[] hand; //an array of cards in the hand
	private int lead; //the leading card when determining winner
	private int secondlead;
	
	/**
	 * Constructor
	 * 
	 * Creates hand instance
	 */
	public Hand(){
		hand = new Card[0]; //empty card array
		lead = -1;
		secondlead = -1;
	}
	
	/**
	 * rescore()
	 * 
	 * looks at the cards in this hand and returns (and assigns) the score of hand
	 * 
	 * @return int
	 */
	public int rescore(){
		
		//super massive conditional
		
		try {
		if (checkRoyalFlush())
			return 10;
		else
			if (checkStraightFlush())
				return 9;
			else
				if (checkFourOfKind())
					return 8;
				else
					if (checkFullHouse())
						return 7;
					else
						if (checkFlush())
							return 6;
						else
							if (checkStraight())
								return 5;
							else
								if (checkThreeOfKind())
									return 4;
								else
									if (checkTwoPair())
										return 3;
									else
										if (checkOnePair())
											return 2;
										else
											return 1;
		}
		catch (ArrayIndexOutOfBoundsException e){
			System.err.println("HAND ARRAY OUT OF BOUNDS");
		}
		return -1;
		
	}
	/**
	 * getCard()
	 * 
	 * returns the card at index array
	 * 
	 * @param array
	 * @return Card
	 */
	public Card getCard(int array){
		if (!(array < 0 || array > hand.length))
			return hand[array];
		else
			return null;
	}
	
	/** 
	 * add()
	 * 
	 * takes parameter card and adds it to the hand at the end
	 * @param card
	 */
	public void add(Card card){
		Card[] temp = new Card[hand.length + 1];
		for (int i = 0; i < hand.length; i ++){
			temp[i] = hand[i];
		}
		temp[hand.length] = card;
		hand = temp;
	}
	
	public int length() {
		return hand.length;
	}
	
	public void sort() {
		for (int j = 0; j < length() -1; j++){
			for(int i = 0; i < length()-1; i++){
				//fixes suit values
				if (getCard(i).getSuit() > getCard(i+1).getSuit()){
					Card swap = getCard(i);
					hand[i] = getCard(i+1);
					hand[i+1] = swap;
				}
				else {
					//fixes number values
					if (getCard(i).getSuit() == getCard(i+1).getSuit()){
						//ace fix
						if (getCard(i+1).getNumber() == 0){
							Card swap = getCard(i);
							hand[i] = getCard(i+1);
							hand[i+1] = swap;
						}
						else {
							if (getCard(i).getNumber() == 0){
								//no change
							}
							else{
								if (getCard(i).getNumber() < getCard(i+1).getNumber()){
									Card swap = getCard(i);
									hand[i] = getCard(i+1);
									hand[i+1] = swap;
								}
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * getLead()
	 * 
	 * returns the leading value in non human readable format
	 * @return leading number
	 */
	public int getLead(){
		return lead;
	}
	
	public int getSecondLead(){
		return secondlead;
	}
	
	public boolean checkRoyalFlush(){
		for (int i = 0; i < hand.length - 4; i++){//only does process for first three cards in collective hand
			if (hand[i].getSuit() == hand[i+1].getSuit() && 
					hand[i].getSuit() == hand[i+2].getSuit() && 
					hand[i].getSuit() == hand[i+3].getSuit() &&
					hand[i].getSuit() == hand[i+4].getSuit()) {
				//if all the suits are the same
				if (hand[i].getNumber() == 0 && 
						hand[i+1].getNumber() == 12 && 
						hand[i+2].getNumber() == 11 && 
						hand[i+3].getNumber() == 10 &&
						hand[i+4].getNumber() == 9) {
					return true;
					}
			}	
		}
		//not a royal flush
		return false;
	}
	
	public boolean checkStraightFlush(){
		for (int i =0; i < hand.length - 4; i++){
			if (hand[i].getSuit() == hand[i+1].getSuit() && 
					hand[i].getSuit() == hand[i+2].getSuit() && 
					hand[i].getSuit() == hand[i+3].getSuit() &&
					hand[i].getSuit() == hand[i+4].getSuit()) {
				//low ace fix
				if (hand[i].getNumber() == 0 && 
						hand[i+1].getNumber() == 4 && 
						hand[i+2].getNumber() == 3 && 
						hand[i+3].getNumber() == 2 &&
						hand[i+4].getNumber() == 1) {
					lead = 4;
					return true;
					}
				//all in same suit
				if (hand[i+1].getNumber() == hand[i].getNumber() - 1 && 
						hand[i+2].getNumber() == hand[i].getNumber() - 2 && 
						hand[i+3].getNumber() == hand[i].getNumber() - 3 &&
						hand[i+4].getNumber() == hand[i].getNumber() - 4) {
					lead = hand[i].getNumber();
					return true;
					}
			}
		}
		return false;
	}
	
	public boolean checkFourOfKind(){
		int[] counter = new int[13];
		for (int i = 0; i < hand.length; i++){
			counter[hand[i].getNumber()] +=1;
		}
		
		for (int i = 0; i < counter.length; i++){
			if (counter[i] == 4){
				lead = i;
				return true;
			}
		}
		return false;
	}
	
	public boolean checkFullHouse(){
		int[] counter = new int[13];
		boolean first = false;
		boolean secound = false;
		
		for (int i = 0; i < hand.length; i++){
			counter[hand[i].getNumber()] +=1;
		}
		
		for (int i = 0; i < counter.length; i++){
			if (counter[i] > 2 && !first){
				lead = i;
				first = true;
			}
			else if (counter[i] > 1){
				secound = true;
				secondlead = i;
			}
		} 
		
		return first && secound;
		
	}
	
	public boolean checkFlush(){
		int[] counter = new int[4];
		
		for (int i = 0; i < hand.length; i++){
			counter[hand[i].getSuit()] +=1;
		}
		
		for (int i = 0; i < counter.length; i++){
			if (counter[i] > 4){
				
				int special = hand[0].getNumber();
				int secondspecial = hand[0].getNumber();
				for (int j = 0; j < hand.length; j++){
					//go through the special hand
					if (hand[j].getNumber() == 0 && special != 0 && hand[j].getNumber() > special){
						secondspecial = special;
						special = hand[j].getNumber();
					}
				}
				lead = special;
				secondlead = secondspecial;
				return true;
			}
		}
		
		return false;
		
	}
	
	public boolean checkStraight(){
		int[] counter = new int[13];
		
		for (int i = 0; i < hand.length; i++){
			counter[hand[i].getNumber()] +=1;
		}
		//check for royal straight
		if (counter[0] > 0 && counter[12] > 0 && counter[11] > 0 && counter[10] > 0 && counter[9] > 0 ){
			lead = 0;
			return true;
		}
		
		//normal check
		for (int i = 0; i < counter.length - 4;i++){
			if (counter[i] > 0 && counter[i+1] > 0 && counter[i+2] > 0 && counter[i+3] > 0 && counter[i+4] > 0 ){
				lead = i+4;
				return true;
			}
		}
		
		return false;
	}
	
	public boolean checkThreeOfKind(){
		int[] counter = new int[13];
		
		for (int i = 0; i < hand.length; i++){
			counter[hand[i].getNumber()] +=1;
		}
		
		for (int i = 0; i < counter.length; i++){
			if (counter[i] >2){
				lead = i;
				return true;
			}
		}
		return false;
		
	}
	
	public boolean checkTwoPair(){
		int[] counter = new int[13];
		int numofpairs = 0;
		for (int i = 0; i < hand.length; i++){
			counter[hand[i].getNumber()] +=1;
		}
		
		for (int i = 0; i < counter.length; i++){
			if (counter[i] >1){
					secondlead = lead;
					lead = i;
				numofpairs+=1;
				
			}
		}
		if (numofpairs >= 2){
			return true;
		}
		return false;
	}
	
	public boolean checkOnePair(){
		int[] counter = new int[13];
		int numofpairs = 0;
		for (int i = 0; i < hand.length; i++){
			counter[hand[i].getNumber()] +=1;
		}
		
		for (int i = 0; i < counter.length; i++){
			if (counter[i] >1){
				lead = i;
				numofpairs+=1;
			}
		}
		if (numofpairs >= 1){
			return true;
		}
		return false;
	}
	
	public static Hand combine(Hand one, Hand two){
		Hand ret = new Hand();
		for (int i = 0; i < one.length(); i++){
			ret.add(one.getCard(i));
		}
		for (int i = 0; i < two.length(); i++){
			ret.add(two.getCard(i));
		}
		ret.sort();
		return ret;
	}
	
}
