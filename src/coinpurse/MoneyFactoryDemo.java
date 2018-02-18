package coinpurse;
/**
 * MoneyFactoryDemo use to test each method in MoneyFactory when use thai and malay factory that work correct or not.
 * @author Katapon Sinpunyawong.
 *
 */
public class MoneyFactoryDemo {
	
	public static void main(String[]args) {
		
		System.out.println("<<<<< [Test] >>>>");
		System.out.println();
		System.out.println("<========< ThaiMoney >========>");
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		MoneyFactory THmoney = MoneyFactory.getInstance();
		//test create coin.
		Valuable thcoin = THmoney.createMoney("5");
		System.out.println(thcoin.toString());
		//test create banknote.
		Valuable thbanknote = THmoney.createMoney("1000");
		System.out.println(thbanknote.toString());
		
//		//test create value haven't in thailand coin/banknote.
//		Valuable thnone = THmoney.createMoney("7");  // This value haven't in thailand Coin/Banknote.
//		System.out.println(thnone.toString());
//		
//		//test String that can't parse to double.
//		Valuable thnotdouble = THmoney.createMoney("sun"); //String value is not a number
//		System.out.println(thnotdouble.toString()); 
		
		System.out.println();
		System.out.println("<========< MalayMoney >========>");
		MoneyFactory.setFactory(new MalayMoneyFactory());
		MoneyFactory MLmoney = MoneyFactory.getInstance();
		//test create coin.
		Valuable mlcoin = MLmoney.createMoney("0.50");
		System.out.println(mlcoin.toString());
		System.out.println(mlcoin.getCurrency());
		//test create banknote.
		Valuable mlbanknote = MLmoney.createMoney("1");
		System.out.println(mlbanknote.toString());
		
//		//test create value haven't in malaysia coin/banknote.
//		Valuable mlnone = MLmoney.createMoney("9");  // This value haven't in Malaysia Coin/Banknote.
//		System.out.println(mlnone.toString());
//		
//		//test String that can't parse to double.
//		Valuable mlnotdouble = MLmoney.createMoney("moon"); //String value is not a number
//		System.out.println(mlnotdouble.toString()); 
		
		
	
	}
}
