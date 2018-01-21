package coinpurse;
/**
 * Coin represents coinage (money) with a fixed value and currency.
 * @author Katapon Sinpunyawong.
 *
 */
public class Coin implements Comparable<Coin>{

private double value;
private String currency;

	public Coin(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}
	
	public double getValue() {
		return value;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	@Override
	public boolean equals(Object arg) {
		
		if(arg == null) 
		{
			return false;
		}
		if(arg.getClass() != this.getClass()) 
		{
			return false;
		}
			
		Coin coin = (Coin) arg;
		return this.getValue() == coin.getValue() && this.getCurrency().equals(coin.getCurrency());
	}

	@Override
	public int compareTo(Coin coin) {
		double compare = this.getValue() - coin.getValue();
		
		if(compare==0) 
		{
			return -1;
		}
		else if(compare>0)
		{
			return 1;
		}
		else 
		return 0;
	}
	
	@Override
	public String toString() {
		return String.format("");
	}
}
