package poker;

public interface Player {

	public void setHand(Hand hand);
	public Hand getHand();
	public int getCash();
	public void changeCash(int differnce);
}
