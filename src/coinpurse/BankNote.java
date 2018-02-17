package coinpurse;
/**
 * BankNote represents banknote (money) with a fixed value and currency.
 * @author Katapon Sinpunyawong
 *
 */
public class BankNote extends Money{
	
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
		
		super(value,currency);
		serialNumber = nextSerialNumber++;
	}
	
	
	/**
	 * Get the banknote serialnumber.
	 * @return banknote serialnumber.
	 */
	public long getSerial() {
		return this.serialNumber;
	}
	
	/**
     * Set the serial number unique for each factory.
     * @param nextSerialNumber for start to run serialNumber.
     */
    public static void setNextSerialNumber(long nextSerialNumber) {
        BankNote.nextSerialNumber = nextSerialNumber;
    }
	
	/**
	 * this method to show the value, currency and serialnumber of banknote.
	 * @return value, currency and serialnumber of banknote.
	 */
	@Override
	public String toString() {
		return this.getValue()+"-"+this.getCurrency()+" note ["+this.getSerial()+"]";
	}
}
