package coinpurse;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 * MoneyFactoryTest for test money factories that work correct or not. 
 * By use JUnit for test.
 * @author Katapon Sinpunyawong.
 *
 */
public class MoneyFactoryTest {
	
	/**Thai money currency*/
	private static final String thCURRENCY = "Baht";
	/**Malay money currency*/
	private static final String mlCURRENCY = "Ringgit";
	
	/**
     * Sets up the test fixture.
     * Called before every test method.
     */
    @Before
    public void setUp() {
    	// nothing to initialize
    }
    
	/**
	 * For test ThaiMoneyFactory.
	 */
	@Test
	public void testThaiMoneyFactory() {
		
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		MoneyFactory th = MoneyFactory.getInstance();
		
		//use createMoney(double value)
		//test create coin.
		assertEquals(new Coin(1, thCURRENCY), th.createMoney(1));
		assertEquals(new Coin(2, thCURRENCY), th.createMoney(2));
		assertEquals(new Coin(5, thCURRENCY), th.createMoney(5));
		assertEquals(new Coin(10, thCURRENCY), th.createMoney(10));
		//test create banknote.
		assertEquals(new BankNote(20, thCURRENCY, 1000000), th.createMoney(20));
		assertEquals(new BankNote(50, thCURRENCY, 1000001), th.createMoney(50));
		assertEquals(new BankNote(100, thCURRENCY, 1000002), th.createMoney(100));
		assertEquals(new BankNote(500, thCURRENCY, 1000003), th.createMoney(500));
		assertEquals(new BankNote(1000, thCURRENCY, 1000004), th.createMoney(1000));
		
		//use createMoney(String value)
		//test create coin.
		assertEquals(new Coin(1, thCURRENCY), th.createMoney("1"));
		assertEquals(new Coin(2, thCURRENCY), th.createMoney("2"));
		assertEquals(new Coin(5, thCURRENCY), th.createMoney("5"));
		assertEquals(new Coin(10, thCURRENCY), th.createMoney("10"));
		//test create banknote.
		assertEquals(new BankNote(20, thCURRENCY, 1000005), th.createMoney("20"));
		assertEquals(new BankNote(50, thCURRENCY, 1000006), th.createMoney("50"));
		assertEquals(new BankNote(100, thCURRENCY, 1000007), th.createMoney("100"));
		assertEquals(new BankNote(500, thCURRENCY, 1000008), th.createMoney("500"));
		assertEquals(new BankNote(1000, thCURRENCY, 1000009), th.createMoney("1000"));	
	}
	
	/**
	 * For test MalayMoneyFactory.
	 */
	@Test
	public void testMalayMoneyFactory() {
		
		MoneyFactory.setFactory(new MalayMoneyFactory());
		MoneyFactory ml = MoneyFactory.getInstance();
		
		//use createMoney(double value)
		//test create coin.
		assertEquals(new Coin(5, "Sen"), ml.createMoney(0.05));
		assertEquals(new Coin(10, "Sen"), ml.createMoney(0.10));
		assertEquals(new Coin(20, "Sen"), ml.createMoney(0.20));
		assertEquals(new Coin(50, "Sen"), ml.createMoney(0.50));
		//test create banknote.
		assertEquals(new BankNote(1, mlCURRENCY, 1000000), ml.createMoney(1));
		assertEquals(new BankNote(2, mlCURRENCY, 1000001), ml.createMoney(2));
		assertEquals(new BankNote(5, mlCURRENCY, 1000002), ml.createMoney(5));
		assertEquals(new BankNote(10, mlCURRENCY, 1000003), ml.createMoney(10));
		assertEquals(new BankNote(20, mlCURRENCY, 1000004), ml.createMoney(20));
		assertEquals(new BankNote(50, mlCURRENCY, 1000005), ml.createMoney(50));
		assertEquals(new BankNote(100, mlCURRENCY, 1000006), ml.createMoney(100));
		
		//use createMoney(String value)
		//test create coin.
		assertEquals(new Coin(5, "Sen"), ml.createMoney("0.05"));
		assertEquals(new Coin(10, "Sen"), ml.createMoney("0.10"));
		assertEquals(new Coin(20, "Sen"), ml.createMoney("0.20"));
		assertEquals(new Coin(50, "Sen"), ml.createMoney("0.50"));
		//test create banknote.
		assertEquals(new BankNote(1, mlCURRENCY, 1000007), ml.createMoney("1"));
		assertEquals(new BankNote(2, mlCURRENCY, 1000008), ml.createMoney("2"));
		assertEquals(new BankNote(5, mlCURRENCY, 1000009), ml.createMoney("5"));
		assertEquals(new BankNote(10, mlCURRENCY, 1000010), ml.createMoney("10"));
		assertEquals(new BankNote(20, mlCURRENCY, 1000011), ml.createMoney("20"));
		assertEquals(new BankNote(50, mlCURRENCY, 1000012), ml.createMoney("50"));
		assertEquals(new BankNote(100, mlCURRENCY, 1000013), ml.createMoney("100"));
		
	}
		
	
}

