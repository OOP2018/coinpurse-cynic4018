package coinpurse;
/**
 * BankNote represents banknote (money) with a fixed value and currency.
 * @author Katapon Sinpunyawong
 *
 */
public class BankNote implements Valuable{

	/** value of banknote */
	private double value;
	/** currency of banknote that to arrange value type of banknote such as 1 Baht = 3.47 Yen (Now)*/
	private String currency;
	/** banknote have unique a serialnumber that starting from 1000000*/
	private static long nextSerialNumber = 1000000;
	/** banknote have unique a serialnumber*/
	private long serialNumber;
	
	/**
	 * The value must not be negative.(When value is negative, it value is 0)
	 * @param value of a banknote is not negative.
	 * @param currency of banknote.
	 * @param each banknote have a unique serialnumber that starting from 1000000(nextSerialNumber). 
	 */
	public BankNote(double value, String currency) {
	
		if(value < 0) 
		{
			this.value = 0 ;
		}
		else 
		{
			this.value = value;
		}
		
		this.currency = currency;
		
		serialNumber = nextSerialNumber;
	}
	
	/**
	 * Get the banknote value.
	 * @return banknote value.
	 */
	public double getValue() {
		return this.value;
	}
	
	/**
	 * Get the banknote currency.
	 * @return banknote currency.
	 */
	public String getCurrency() {
		return this.currency;
	}
	
	/**
	 * Get the banknote serialnumber.
	 * @return banknote serialnumber.
	 */
	public double getSerial() {
		return this.serialNumber;
	}
	
	/**
	 * This method compare this object to specified object. 
	 * The result is true if and only if the argument is not null 
	 * and is a String object that represents the same sequence of characters as this object.
	 * @param Object obj for compare with this object (value and currency in this class).
	 * @param True when both value and currency of obj and this class is equal.
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
			
		BankNote banknote = (BankNote) obj;
	
		return this.getValue() == banknote.getValue() && this.getCurrency().equals(banknote.getCurrency());
	}
	
	/**
	 * this method to show the value, currency and serialnumber of banknote.
	 * @return value, currency and serialnumber of banknote.
	 */
	@Override
	public String toString() {
		return String.format("%.2f-%s note [%d]",value ,currency, serialNumber);
	}
}
