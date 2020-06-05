import java.util.ArrayList;

public class Account {
	
	private ArrayList<String> AccountHistory = new ArrayList<String>();
	private User AccountHolder ;
	private int  Balance ;
	private int  MinimumBalanceLimit;
	private int  AccountNumber;
	private long IbanNumber;
	private ArrayList<CreditCard> CreditCardList = new  ArrayList<CreditCard>();
	
	// Constructor..............................................................................................................................................
	
	
	public Account(User user , int balance , int minbalance , int accountnumber, long  ibannumber)
	{
		this.setAccountHolder(user);
		this.setAccountNumber(accountnumber);
		this.setBalance(balance);
		this.setMinimumBalanceLimit(minbalance);
		this.setIbanNumber(ibannumber);
		this.AccountHolder.getUaccounts().add(this);
		if(user.getUaccounts().size()<5)
			MainPanel.AllAccounts.add(this);
		else 
			System.out.println("your breaked your  account  limit");
		
	}
	
	
	// accessor and mutator methods.....................................................................................................................................................
	public int getBalance() {
		return Balance;
	}
	public void setBalance(int balance) {
		Balance = balance;
	}
	public int getMinimumBalanceLimit() {
		return MinimumBalanceLimit;
	}
	public void setMinimumBalanceLimit(int minimumBalanceLimit) {
		MinimumBalanceLimit = minimumBalanceLimit;
	}
	public int getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		AccountNumber = accountNumber;
	}
	public long getIbanNumber() {
		return IbanNumber;
	}
	public void setIbanNumber(long ibanNumber) {
		IbanNumber = ibanNumber;
	}
	public User getAccountHolder() {
		return AccountHolder;
	}
	public void setAccountHolder(User accountHolder) {
		AccountHolder = accountHolder;
	}
	public ArrayList<String> getAccountHistory() {
		return AccountHistory;
	}


	public void setAccountHistory(ArrayList<String> accountHistory) {
		AccountHistory = accountHistory;
	}
	public ArrayList<CreditCard> getCreditCardList() {
		return CreditCardList;
	}


	public void setCreditCardList(ArrayList<CreditCard> creditCardList) {
		CreditCardList = creditCardList;
	}
	
	// Methods...............................................................................................................................................................
	
	
	
	public void Eft(long  iban ,int amount ){
		if(IbanFind(iban)==	true )
		{
			this.DecreaseBalance(amount);
			this.AddToHistory("Eft " + amount +" dolars to "+iban);
			
			FindAccount(iban).IncreseBalance(amount);
			FindAccount(iban).AddToHistory(this.getIbanNumber()+"send you"+amount+"dolars" );	
		}
		else
			System.out.println("invalid iba1n");	
	}
	
	
	
	public void IncreseBalance(int money){
		this.setBalance(this.Balance + money );
	}
	public void  DecreaseBalance(int money){
		this.setBalance(this.Balance - money );
	}
	
	 
	public void History(Account account){  
		String str = "";
		
		for(int i = 0; i<=account.getAccountHistory().size()-1;i++)
		{
			str = str + account.getAccountHistory().get(i) + "\n";
		}
	
		System.out.println(str);
		
		 }  
	
	
	
	public void BalanceCheck()	
	{
		System.out.println("your  balance is "+this.Balance+" dollars");
	}

	public  void   AddToHistory(String text)
	{
		this.AccountHistory.add(text);
	}
	
	public Account FindAccount(long iban){
		int checker = 100 ;
		for(int i= 0 ;i<=MainPanel.AllAccounts.size()-1;i++)
		{
			if(MainPanel.AllAccounts.get(i).IbanNumber == iban)
				checker = i;
			
			
		}
		
		return MainPanel.AllAccounts.get(checker);	
	}


	
	
	public boolean IbanFind (long iban)
	{
		int  falsestat = 0;
		for(int i = 0 ; i<MainPanel.AllAccounts.size();i++)
		{
			if(iban ==MainPanel.AllAccounts.get(i).getIbanNumber())
			falsestat=+1;	
			
		}
		if(falsestat ==1)
			return true;
		else
			return false;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
