

public class BankingDemo {
	
	static int Currentbalance = 1000;
	public static void greetCustomer()
	{
		System.out.println("Hello, Welcome to the banking app");
	}
	public void deposit(int amount) {
		Currentbalance =  Currentbalance + amount;
		System.out.println("Amount is deposited succsessfully");
		
	}
	public static void withdrawl(int amount) {
		Currentbalance =  Currentbalance - amount;
		System.out.println("Amount is withdrawl succsessfully");
				
	}
	public int getCurrentbalace() {
		return Currentbalance;
					
	}
	public static void main(String[] args) {
		BankingDemo bank = new BankingDemo(); 
		
	greetCustomer();
	
	System.out.println("Current balance is :" + bank.getCurrentbalace()); 
	
	bank.deposit(500);
	System.out.println("Current balance is :" + bank.getCurrentbalace());
	
	withdrawl(300);
	System.out.println("Current balance is :" + bank.getCurrentbalace());
	
	}
	
}
