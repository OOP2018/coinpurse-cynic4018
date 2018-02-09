package coinpurse;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * MoneyUtil class for demonstrate compareTo method is working correct
 * and it can sort the coins by value.
 * @author Katapon Sinpunyawong
 */
public class MoneyUtil {
	
	/**
	 * print coins list.
	 * @param print coins and banknotes in coins list.
	 */
	public static void printValuable(List<Valuable> cbvalue) {
		
		System.out.print("list = {");
		
		if(cbvalue.size()==0) 
		{
			System.out.println(" }");
		}
		else 
		{
			for(int count=0 ; count < cbvalue.size() ; count++) 
			{
				if(count==cbvalue.size()-1) 
				{
					System.out.printf(" %s",cbvalue.get(count));
					break;
				}
				else 
				{
					System.out.printf(" %s,",cbvalue.get(count));
				}
			}
			System.out.println(" }");
		}
		
		
		System.out.println();
	}
	
	/**
	 * 
	 * this use .sort in java.util.Collections for sort coin and banknote in list. 
	 * sort from lowest -> highest value. 
	 * @param sort money in coins list by comparator<Valuable>.
	 */
	public static void sortCoinAndBanknote(List<Valuable> cbvalue) {
		Comparator<Valuable> comp = new ValueComparator();
		java.util.Collections.sort(cbvalue, comp);
	}
	
	/**
	 * 
	 * this method use for sort the currency you want  to see from coins list.
	 * @param sorted by currency from coins and money in List<valuable> sortCurrency list.
	 * @return coins and banknotes in list that sorted(sort by currency that you want) 
	 */
	public static List<Valuable> filterByCurrency(List<Valuable> cbmoney, String currency) {
		
		List<Valuable> sortCurrency = new ArrayList<>();
		
		for(Valuable count : cbmoney) 
		{
			if(count.getCurrency().equals(currency)) 
			{ 
				sortCurrency.add(count);
			}
		}
		return sortCurrency;
	}
	
	/**
	 * In main method that test compare 
	 * such as different currency but same value, compareTo method check 
	 * and different between not sort - sort. 
	 * @param add coin to coins list and test.
	 */
	public static void main(String[]args) {
		
		List<Valuable> cbvalue = new ArrayList<Valuable>();
		//test same value but different currency.
		cbvalue.add(new Coin(10.0, "Baht"));
		cbvalue.add(new Coin(10.0, "Yen"));
		
		cbvalue.add(new Coin(0.5, "Baht"));
		cbvalue.add(new Coin(2.0, "Baht"));
		cbvalue.add(new Coin(1.0, "Baht"));
		cbvalue.add(new BankNote(20.0, "USD"));
		cbvalue.add(new BankNote(100.0, "USD"));
		
		//test negative value
		cbvalue.add(new Coin(-10.0, "USD"));//choose 0.00 USD
		
		//not sort
		System.out.println("+-+-+-+-+ Not sort +-+-+-+-");
		printValuable(cbvalue);
		
		System.out.println();
	
		//sort
		System.out.println("+-+-+-+-+ Sort +-+-+-+-");
		sortCoinAndBanknote(cbvalue);
		printValuable(cbvalue);
	
		System.out.println();
		
		System.out.println("+-+-+-+-+ Filter +-+-+-+-");
		sortCoinAndBanknote(cbvalue);
		List<Valuable> filter = filterByCurrency(cbvalue, "USD");
		printValuable(filter);
		
	}

}
