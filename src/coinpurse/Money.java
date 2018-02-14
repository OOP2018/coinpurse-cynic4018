package coinpurse;

public class Money implements Valuable{

	/** value of money */
	double value;
	/** currency of money that to arrange value type of money such as 1 Baht = 3.47 Yen (Now)*/
	 String currency;
	
	/**
	 * The value must not be negative.(When value is negative, it value is 0)
	 * @param value of a money is not negative.
	 * @param currency of money.
	 */
	public Money(double value, String currency) {
		
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
	 * This method compare this object to specified object to arrange to order.
	 * @param Valuable m for compare with this value to order.
	 * @return -1 if this value is less than money value.
	 * 			1 if this value is more than money value.
	 * 		    0 if this value is equal to money value.	 
	 */
	public int compareTo(Valuable m) {
		return Double.compare(this.getValue(), m.getValue());
	}

	
	/**
	 * This method compare this object to specified object. 
	 * The result is true if and only if the argument is not null 
	 * and is a String object that represents the same sequence of characters as this object.
	 * @param Object arg for compare with this object (value and currency in this class).
	 * @param True when both value and currency of arg and this class is equal.
	 */
	@Override
	public boolean equals(Object obj) {
		
		if(obj == null) 
		{
			return false;
		}
		if(obj.getClass() != this.getClass()) 
		{
			return false;
		}
			
		Money m = (Money) obj;
		return this.getValue() == m.getValue() && this.getCurrency().equals(m.getCurrency());
	}

	/**
	 * Get the money value.
	 * @return money value.
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Get the money currency.
	 * @return money currency.
	 */
	public String getCurrency() {
		return this.currency;
	}

	
}
