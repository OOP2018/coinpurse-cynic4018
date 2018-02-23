package coinpurse;
/**
 * BankNote represents banknote (money) with a fixed value and currency.
 * @author Katapon Sinpunyawong
 *
 */
public class BankNote extends Money{
	
	/** banknote have unique a serialnumber*/
	private long serialNumber;
	/** value currency that call not same main currency*/
	private String callcurrency;
	
	/**
	 * The value must not be negative.(When value is negative, it value is 0)
	 * @param value of a banknote is not negative.
	 * @param currency of banknote.
	 * @param each banknote have a unique serialnumber that starting from 1000000(nextSerialNumber). 
	 */
	public BankNote(double value, String currency, long nextSerialNumber) {
		
		super(value,getEachcountrycurrency() == null? currency : Money.getEachcountrycurrency());
		this.callcurrency = currency;	
		this.serialNumber = nextSerialNumber;
		nextSerialNumber++;
	}
	
	
	/**
	 * Get the banknote serialnumber.
	 * @return banknote serialnumber.
	 */
	public long getSerial() {
		return this.serialNumber;
	}
	
	
	/**
	 * this method to show the value, currency and serialnumber of banknote.
	 * @return value, currency and serialnumber of banknote.
	 */
	@Override
	public String toString() {

			return this.getValue()+"-"+this.callcurrency+" note ["+this.getSerial()+"]";
	}
}

