package coinpurse;
/**
 * ThaiMoneyFactory is class that do about manage thai money.
 * @author Katapon Sinpunyawong.
 * 
 */
public class ThaiMoneyFactory extends MoneyFactory {
	
	/** Thai money currency */
	private final String currency = "Baht";
	
	/**
	 * This constructor use to set serial number for ThaiMoneyFactory.
	 */
	public ThaiMoneyFactory() {
		BankNote.setNextSerialNumber(1000000);
	}
	
	/**
	 * Create money according Thailand Coin and Banknote.
	 * @param get value for arrange to Coin or Banknote.
	 * @return new Coin if value that according 1, 2, 5, 10.
	 * 		   new Banknote if value that according 20, 50, 100, 500, 1000.
	 * 		   else throw because thailand haven't that value in Coin/Banknote.
	 */
	@Override
	public Valuable createMoney(double value) {
		
		if(value == 1 | value == 2 | value == 5 | value == 10) 
		{
			return new Coin(value, currency);
		}
		else if(value == 20 | value == 50 | value == 100 | value == 500 | value == 1000) 
		{
			return new BankNote(value, currency);
		}
		else
		{
			throw new IllegalArgumentException("This value haven't in thailand Coin/Banknote.");
		}
	}

}
