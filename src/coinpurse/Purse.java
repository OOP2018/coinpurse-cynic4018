package coinpurse;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


// You will use Collections.sort() to sort the coins

/**
 *  A coin purse contains coins.
 *  You can insert coins, withdraw money, check the balance,
 *  and check if the purse is full.
 *  
 *  @author Katapon Sinpunyawong
 */
public class Purse {
    /** Collection of objects in the purse. */
	private List<Coin> money;
    
    /** Capacity is maximum number of items the purse can hold.
     *  Capacity is set when the purse is created and cannot be changed.
     */
    private final int capacity;
    
    /** 
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of coins you can put in purse.
     */
    public Purse( int capacity ) {
    	this.capacity = capacity;
    	money = new ArrayList<Coin>();
    }

    /**
     * Count and return the number of coins in the purse.
     * This is the number of coins, not their value.
     * @return the number of coins in the purse
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
    	
		for(Coin coins : money)
		{
			balance += coins.getValue();
		}
    	return balance; 
	}

    
    /**
     * Return the capacity of the coin purse.
     * @return the capacity
     */
    public int getCapacity() { 
		return capacity; 
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
     * Insert a coin into the purse.
     * The coin is only inserted if the purse has space for it
     * and the coin has positive value.  No worthless coins!
     * @param coin is a Coin object to insert into purse
     * @return true if coin inserted, false if can't insert
     */
    public boolean insert( Coin coin ) {
    	if(isFull() || coin.getValue() <= 0) 
    	{
    		return false;
    	}
    	else 
    	{
    		money.add(coin);
    		return true;
    	}
    }
    
    /**  
     *  Withdraw the requested amount of money.
     *  Return an array of Coins withdrawn from purse,
     *  or return null if cannot withdraw the amount requested.
     *  @param amount is the amount to withdraw
     *  @return array of Coin objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
     */
    public Coin[] withdraw( double amount ) {
         
         List<Coin> list = new ArrayList<Coin>();
        
         Collections.sort(money);
         
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
		// Remove the coins you want to withdraw from purse,
		// and return them as an array.
		// Use list.toArray( array[] ) to copy a list into an array.
		// toArray returns a reference to the array itself.
		
		return list.toArray(new Coin[list.size()]);
        
	}
  
    /** 
     * toString returns a string description of the purse contents.
     * It can return whatever is a useful description.
     */
    public String toString() {
    	return String.format("[ Your have %d coins | value %.2f ]" , count() , getBalance());
    }

}

