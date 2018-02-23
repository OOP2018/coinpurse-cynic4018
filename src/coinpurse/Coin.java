package coinpurse;
/**
 * Coin represents coinage (money) with a fixed value and currency.
 * @author Katapon Sinpunyawong
 *
 */
public class Coin extends Money{
	
	/** value currency that call not same main currency*/
	private String callcurrency;

	/**
	 * The value must not be negative.(When value is negative, it value is 0)
	 * (it same like Money because it extends from money class).
	 * @param value of a coin is not negative.
	 * @param currency of coin.
	 */
	public Coin(double value, String currency) {
	
		super(value, getEachcountrycurrency()==null? currency : Money.getEachcountrycurrency());
		this.callcurrency = currency;
		
	}
	
	/**
	 * this method to show the value and currency of coin.
	 * @return value and currency of coin.
	 */
	@Override
	public String toString() {
			return this.getValue()+"-"+this.callcurrency;
		
	}
}
