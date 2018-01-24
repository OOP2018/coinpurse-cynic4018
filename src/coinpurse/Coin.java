package coinpurse;
/**
 * Coin represents coinage (money) with a fixed value and currency.
 * @author Katapon Sinpunyawong.
 *
 */
public class Coin implements Comparable<Coin>{

	/** value of coin */
	private double value;
	/** currency of coin that to arrange value type of coin such as 1 Baht = 3.47 Yen (Now)*/
	private String currency;

	/**
	 * The value must not be negative.(When value is negative, it value is 0)
	 * @param value of a coin is not negative.
	 * @param currency of coin.
	 */
	public Coin(double value, String currency) {
		
		if(value < 0) 
		{
			this.value = 0 ;
		}
		else 
		{
			this.value = value;
		}
		
		this.currency = currency;
	}
	
	/**
	 * Get the coin value.
	 * @return coin value.
	 */
	public double getValue() {
		return value;
	}
	
	/**
	 * Get the coin currency.
	 * @return coin currency.
	 */
	public String getCurrency() {
		return currency;
	}
	
	/**
	 * This method compare this object to specified object. 
	 * The result is true if and only if the argument is not null 
	 * and is a String object that represents the same sequence of characters as this object.
	 * @param Object arg for compare with this object (value and currency in this class).
	 * @param True when both value and currency of arg and this class is equal.
	 */
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

	/**
	 * This method compare this object to specified object to arrange to order.
	 * @param Coin coin for compare with this value to order.
	 * @return -1 if this value is less than coin value.
	 * 			1 if this value is more than coin value.
	 * 		    0 if this value is equal to coin value.	 
	 */
	@Override
	public int compareTo(Coin coin) {
		
		if(this.getValue()<coin.getValue()) 
		{
			return -1;
		}
		else if(this.getValue()>coin.getValue())
		{
			return 1;
		}
		else
		return 0;
	}
	
	/**
	 * this method to show the value and currency of coin.
	 * @return value and currency of coin.
	 */
	@Override
	public String toString() {
		return String.format("%.2f-%s",value ,currency);
	}
}
