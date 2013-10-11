package poker;

public interface Player {
	public String getName();
	public void setName(String name);
	public void setHand(Hand hand);
	public Hand getHand();
	public int getCash();
	public void changeCash(int differnce);
	public int getAnte(int past);
	public int getBid(int past);
	public boolean isFolding();
}
