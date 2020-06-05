
public class CreditCard {
	
	private Account account;
	private int  Limit;
	private long  CardNumber;
	private int  TotalDebt;
	private int  MinimumDebt;
	
	
	// Constructor....................................................................................................................................
	
	public CreditCard(Account account,int limit,long cardnumber,int totaldebt,int  minimumdebt)
		{
				this.setAccount(account);
				this.setLimit(limit);
				this.setCardNumber(cardnumber);
				this.setTotalDebt(totaldebt);
				this.setMinimumDebt(minimumdebt);
				
				if(account.getAccountHolder().getUcreditCards().size()<2)
				{
					account.getAccountHolder().getUcreditCards().add(this);
					account.getCreditCardList().add(this);
				}
					
				else
					System.out.println("you breaked limit of your creditcards");
		}
	
	// accessor and mutator methods............................................................................................................................................


	public int getLimit() {
		return Limit;
	}
	public void setLimit(int limit) {
		Limit = limit;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public int getMinimumDebt() {
		return MinimumDebt;
	}
	public void setMinimumDebt(int minimumDebt) {
		MinimumDebt = minimumDebt;
	}
	public int getTotalDebt() {
		return TotalDebt;
	}
	public void setTotalDebt(int totalDebt) {
		TotalDebt = totalDebt;
	}
	public long getCardNumber() {
		return CardNumber;
	}
	public void setCardNumber(long cardNumber) {
		CardNumber = cardNumber;
	}
	
	
	// Methods................................................................................................................................................
	
	public void Paid(int amount) {
		
	if(amount<0)
	{
		System.out.println("Invalid  amount ");
	}
	else
	{
	if(amount>this.Limit)
	{
		System.out.println("Your  limit  is  not  enough  for  this action");
		this.account.AddToHistory("you tryed to spend "+ amount + " dolars with your CreditCard  named"+ this+"  but your CreditCard   limit was not  enough");
	}
	else 
	{
		this.account.DecreaseBalance(amount);	
		System.out.println("Action Completed");
		this.account.AddToHistory("you spend "+ amount +" dolars with  your CreditCard named"+ this );
	}
	}
	
	
	}
	
	public  void PaingDebt(int  amount)
	{
		if(amount<this.MinimumDebt){
			System.out.println("this  amount  is  lover  than  your  minimum debt ");
			this.account.AddToHistory("amount of "+this+"was  lover than  your  minimum debt thus your action  has been  canceled");	
		}	
		else{
			this.setTotalDebt(this.TotalDebt-amount);
			this.account.DecreaseBalance(amount);
			this.account.AddToHistory("you paid " + amount+" dolars of your  dept" );
			
		}
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
