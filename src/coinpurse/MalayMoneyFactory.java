package coinpurse;
/**
 * MalayMoneyFactory is class that do about manage malay money.
 * @author Katapon Sinpunyawong.
 * 
 */
public class MalayMoneyFactory extends MoneyFactory{

	/** Malay money currency */
	private final String currency = "Ringgit";
	
	/**
	 * This constructor use to set serial number for MalayMoneyFactory.
	 */
	public MalayMoneyFactory() {
		BankNote.setNextSerialNumber(1000000);
		Money.setCurrency(currency);
	}
	
	/**
	 * Create money according Malaysia Coin and Banknote.
	 * @param get value for arrange to Coin or Banknote.
	 * @return new Coin if value that according 1, 2, 5, 10.
	 * 		   new Banknote if value that according 20, 50, 100, 500, 1000.
	 * 		   else throw because Malaysia haven't that value in Coin/Banknote.
	 */
	@Override
	public Valuable createMoney(double value) {
		
		if(value == 0.05 | value == 0.10 | value == 0.20 | value == 0.50) 
		{
			return new Coin(value*100, "Sen");
		}
		else if(value == 1 | value == 2 | value == 5 | value == 10 | value == 20 | value == 50 | value == 100) 
		{
			return new BankNote(value, currency);
		}
		else
		{
			throw new IllegalArgumentException("This value haven't in Malaysia Coin/Banknote.");
		}
	}
}
