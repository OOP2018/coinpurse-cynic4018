package coinpurse;
/**
 * MoneyFactory is an abstract class that do about create money.
 * @author Katapon Sinpunyawong.
 * 
 */
public abstract class MoneyFactory {
	/** singleton instance of MoneyFactory. */
	private static MoneyFactory factory = null;
	
	/**
	 * this method show to get an instance of MoneyFactory.
	 * @return MoneyFactory  
 	 *  
 	 */
	public static MoneyFactory getInstance() {
	
		return factory;
		
	}
	
	/**
	 * this method is an abstact method that doing about 
	 * create new money object in the local currency.
	 * @param get value to create new money.
	 * @return value of amount to create new money.
	 */
	public abstract Valuable createMoney(double value) ;
	
	/**
	 * this method is doing about parse from String to double 
	 * for use in createMoney(double value) method. 	 
	 * @param parse from String to double.
	 * @return createMoney(valuedouble) if valuedouble is number(String to double).
	 * 		   throw IllegalArgumentException if is not number.
	 */
	public Valuable createMoney(String value) {
		
		double valuedouble = 0;
		try {
			valuedouble = Double.parseDouble(value);
		} catch(NumberFormatException e) {
			throw new IllegalArgumentException("String value is not a number");
		}
		return createMoney(valuedouble);
		
	}
	
	/**
	 * Static method to a "set" the MoneyFactory object that is used.
	 * @param MoneyFactory mf to set.
	 */
	public static void setFactory(MoneyFactory mf) {
		factory = mf;
	}

}
