package coinpurse;
import java.util.Comparator;
/**
* That called from Comparator<Valuable> for compare two object in compare method.
* @author Katapon Sinpunyawong.
*/
public class ValueComparator implements Comparator<Valuable> {
	/**
	 * Compare two objects that implement Valuable.
	 * First compare them by currency, so that "Baht" < "Dollar".
	 * If both objects have the same currency, order them by value.
	 */

	@Override
	public int compare(Valuable a, Valuable b) {
		
		if(a.getCurrency().equals(b.getCurrency())) {
			
			if(a.getValue()<b.getValue()) 
			{
				return -1;
			}
			else if(a.getValue()>b.getValue())
			{
				return 1;
			}
			else 
			{
				return 0;
			}
			
		}
		return (Integer.valueOf(a.getCurrency().length())).compareTo(Integer.valueOf(b.getCurrency().length()));
	}

}
