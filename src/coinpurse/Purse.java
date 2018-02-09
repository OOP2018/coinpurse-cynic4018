package coinpurse;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;


// You will use Collections.sort() to sort the coins

/**
 *  A purse contains value.
 *  You can insert money, withdraw money, check the balance,
 *  and check if the purse is full.
 *  
 *  @author Katapon Sinpunyawong
 */
public class Purse {
    /** Collection of objects in the purse. */
	private List<Valuable> money;
    
    /** Capacity is maximum number of items the purse can hold.
     *  Capacity is set when the purse is created and cannot be changed.
     */
    private final int capacity;
    
    private Comparator<Valuable> comp = new ValueComparator();
    
    /** 
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of value of money you can put in purse.
     */
    public Purse( int capacity ) {
    	this.capacity = capacity;
    	money = new ArrayList<Valuable>();
    }

    /**
     * Count and return the number of coins in the purse.
     * This is the number of money, not their value.
     * @return the number of money in the purse
     */
    public int count() { 
    	
    	int counter = money.size();
    	return counter; 
    	
    }
    
    /** 
     *  Get the total value of all items in the purse.
     *  @return the total value of items in the purse.
     */
    public double getBalance() {
    	
    	double balance = 0;
    	
		for(Valuable cbvalue : money)
		{
			balance += cbvalue.getValue();
		}
    	return balance; 
	}

    
    /**
     * Return the capacity of the money purse.
     * @return the capacity
     */
    public int getCapacity() { 
		return this.capacity; 
	}
    
    /** 
     *  Test whether the purse is full.
     *  The purse is full if number of items in purse equals
     *  or greater than the purse capacity.
     *  @return true if purse is full.
     */
    public boolean isFull() {
    	
        if(count() >= this.getCapacity()) 
        {
        	return true;
        }
        return false;
    }

    /** 
     * Insert a money into the purse.
     * The money is only inserted if the purse has space for it
     * and the value of money has positive value.  No worthless coins!
     * @param cbvalue is a Valuable object to insert into purse
     * @return true if cbvalue inserted, false if can't insert
     */
    public boolean insert( Valuable cbvalue ) {
    	if(isFull() || cbvalue.getValue() <= 0) 
    	{
    		return false;
    	}
    	else 
    	{
    		money.add(cbvalue);
    		return true;
    	}
    }
    
    /**  
     *  Withdraw the requested amount of money.
     *  Return an array of Valuable withdrawn from purse,
     *  or return null if cannot withdraw the amount requested.
     *  @param amount is the amount to withdraw
     *  @return array of Valuable objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
     */
    public Valuable[] withdraw( double amount ) {
         
         List<Valuable> list = new ArrayList<Valuable>();
        
         Collections.sort(money, comp);
         
         double amountNeededToWithdraw = amount;
         
         if(amount > getBalance() || amount < 0) 
         {
        	return null; 
         }
         
         for(int count = money.size()-1 ; count >= 0 ; count-- ) 
         {
        	 if(amountNeededToWithdraw-money.get(count).getValue() >= 0) 
        	 {
        		 amountNeededToWithdraw -= money.get(count).getValue();
        		list.add(money.get(count));
        		money.remove(count);
        	 }
        	 if(amountNeededToWithdraw == 0) 
        	 {
        		break; 
        	 }
         }
           
		if ( amountNeededToWithdraw != 0 )
		{	
			// failed. Don't change the contents of the purse.
			return null;
		}

		// Success.
		// Remove the money you want to withdraw from purse,
		// and return them as an array.
		// Use list.toArray( array[] ) to copy a list into an array.
		// toArray returns a reference to the array itself.
		
		return list.toArray(new Valuable[list.size()]);
        
	}
  
    /** 
     * toString returns a string description of the purse contents.
     * It can return whatever is a useful description.
     */
    public String toString() {
    	return String.format("[ Your have %d | value %.2f ]" , count() , getBalance());
    }

}

