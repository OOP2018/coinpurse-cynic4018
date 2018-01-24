package coinpurse;
import java.util.ArrayList;
import java.util.List;

/**
 * MoneyUtil class for demonstrate compareTo method is working correct
 * and it can sort the coins by value.
 * @author Katapon Sinpunyawong
 */
public class MoneyUtil {
	
	/**
	 * print coins list.
	 * @param print coins in coins list.
	 */
	public static void printCoins(List<Coin> coins) {
		
		System.out.print("list = {");
		
		if(coins.size()==0) 
		{
			System.out.println(" }");
		}
		else 
		{
			for(int count=0 ; count < coins.size() ; count++) 
			{
				if(count==coins.size()-1) 
				{
					System.out.printf(" %s",coins.get(count));
					break;
				}
				else 
				{
					System.out.printf(" %s,",coins.get(count));
				}
			}
			System.out.println(" }");
		}
		
		
		System.out.println();
	}
	
	/**
	 * In main method that test compare 
	 * such as different currency but same value, compareTo method check 
	 * and different between not sort - sort. 
	 * @param add coin to coins list and test.
	 */
	public static void main(String[]args) {
		
		List<Coin> coins = new ArrayList<Coin>();
		//test same value but different currency.
		coins.add(new Coin(10.0, "Baht"));
		coins.add(new Coin(10.0, "Yen"));
		
		coins.add(new Coin(0.5, "Baht"));
		coins.add(new Coin(2.0, "Baht"));
		coins.add(new Coin(1.0, "Baht"));
		coins.add(new Coin(20.0, "USD"));
		
		//test negative value
		coins.add(new Coin(-10.0, "USD"));//choose 0.00 USD
		
		//test compareTo method
		// 0.5 Baht compare to 2.0 baht : 0.5 order before 2.0 that mean result < 0
		System.out.println(coins.get(2).compareTo(coins.get(3)));
		// 2.0 Baht compare to 1.0 baht : 2.0 order after 1.0 that mean result > 0
		System.out.println(coins.get(3).compareTo(coins.get(4)));
		// 10 Baht compare to 10 Yen : have to same order that mean result = 0
		System.out.println(coins.get(0).compareTo(coins.get(1)));
		
		System.out.println();
		System.out.println("--------------------------------------");
		
		//not sort
		System.out.println("+-+-+-+-+ Not sort +-+-+-+-");
		printCoins(coins);
		
		System.out.println();
	
		//sort
		System.out.println("+-+-+-+-+ Sort +-+-+-+-");
		java.util.Collections.sort(coins);
		printCoins(coins);
	}

}
