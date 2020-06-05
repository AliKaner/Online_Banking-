import java.util.ArrayList;
import java.util.Scanner;


public class MainPanel {
	static ArrayList<Account> AllAccounts = new ArrayList<>();
	static ArrayList<User> ListOfUsers = new ArrayList<User>();
	
	public static void main(String[] args) {
		System.out.println(Ali1.IbanFind(642354390));
			// iban  numbers  :  642354390,543466444
			//  þifre : 1452 
			Login(Ali);
			
			
			
		
		}
	//hardcoded parts ................................................................................
	
	static User Ali = new User("ali","kaner","ali.kaner@hotmail.com",1452,12345543,05346422342);
	static User Beyza = new User("beyze","karababa","beyze.karababa@hotmail.com",3452,13556754,0534636324);
	
	static int errors = 0;
	static Account Ali1 = new Account(Ali,5000,200,1243,1500040240);
	static Account Ali2 = new Account(Ali,200,100,1233,1500430544);
	static Account Beyza1 = new Account(Beyza,600,100,1423,642354390);
	static Account Beyza2 = new Account(Beyza,10000,300,1542,543466444);
	
	// testing  creditcard limit of  user
	static CreditCard CardAli1 = new CreditCard(Ali1,500,323434223,100,4);
	static CreditCard CardAli12 = new CreditCard(Ali1,500,323434253,10,1);
	static CreditCard CardAli13 = new CreditCard(Ali1,500,323434263,100,10);
	static CreditCard CardAli14 = new CreditCard(Ali1,500,323434273,1000,1);
	static CreditCard CardBeyza1 = new  CreditCard(Beyza2,600,346765444,0,0);
	
     // methods.............................................................................................
		public static void Login(User x)
		{
			
			if (errors == 3){
				System.out.println("3  wrong  password trys your account blocked");		
		}
			else
			{
			System.out.println("Password please");
			int  password =  new Scanner(System.in).nextInt();
			if(x.getUpassword() == password)
			{
				System.out.println("Welcome  to  the  system choose  your account  \n\n\n ");
			 UserPanel(x);
			}
			else {
				errors++;
				 System.out.println("wrong password ");
				 Login(x);}}	}
	
		
		
		
		
		public static  void UserPanel(User user){
      for(int i =0 ;i<user.getUaccounts().size();i++)
      {
    	 System.out.println((i+1) + "----" + user.getUaccounts().get(i).getAccountNumber());
      }
    	 int  selection =  new Scanner(System.in).nextInt();
    	 if(selection>4 || selection<0)
    	 {
    		 System.out.println("invalid  seleciton");
    		
    		 UserPanel(user);
    	 }
    	 else 		
    	 AccountPanel(user.getUaccounts().get(selection-1));
	}
		
      
   		
			public static void AccountPanel(Account account){
				System.out.println("welcome  to  your  account  choose  which  service  do you need ");
				System.out.println("1--- Deposit money ");
				System.out.println("2--- Withdraw money");
				System.out.println("3--- EFT");
				System.out.println("4--- Use CreditCard");
				System.out.println("5--- Look at your account  history");
				System.out.println("6--- Check your balance");
				System.out.println("7--- Exit");
				int  selectionService =  new Scanner(System.in).nextInt();
				if(selectionService<8 || selectionService>0)
				{
					if(selectionService== 1) {
						DepositMoney(account);
					}
					else if (selectionService== 2){
						WithdrawMoney(account);
					}
					else if (selectionService== 3){
						DoingEftChecked(account);
					}
					else if(selectionService== 4){
						UsingCreditCard(account);
					}
					else if(selectionService == 5) {
						UsingAccountHistory(account);
					}
					else if(selectionService == 6) {
						account.BalanceCheck();
					}
					else if(selectionService == 7) {
						System.out.println("Thank you for  choosing us ");
					}
				}
				else
					System.out.println("invalid selection");
				AccountPanel(account);
				
	}
			
			
			
			
			
			
			public static  void UsingAccountHistory(Account account)
			{
				account.History(account);
				Return(account);
				
			}
			
			public  static  void UsingCreditCard(Account account)
			{
				 System.out.println("choose  your credit  card");
				    for(int i = 0 ;i < account.getCreditCardList().size();i++)	
				  	System.out.println((i+1) + "----" + account.getCreditCardList().get(i).getCardNumber());
				    int  scanCase5 =  new Scanner(System.in).nextInt();
				    if(scanCase5 ==  1 || scanCase5 ==2){
				    	CreditCardPanel(account.getCreditCardList().get(scanCase5-1));
				    	}
				    	else {
				    		System.out.println("invalid number");
				    		Return(account);
				    		 }}
				   
				  public static void CreditCardPanel(CreditCard creditcard) { 
					System.out.println("select your action\n1--- Pay debt\n2--- Buy something\n3---Cancel");
					int  scanCase6 =  new Scanner(System.in).nextInt();
					if(scanCase6 ==  1 || scanCase6 ==2|| scanCase6 ==3)
						if(scanCase6 ==1){
							System.out.println("Type the amount");
							int  scanCase7 =  new Scanner(System.in).nextInt();
							creditcard.PaingDebt(scanCase7);
							Return(creditcard.getAccount());
						}
						else if(scanCase6 ==2){
							System.out.println("Type the amount");
							int  scanCase8 =  new Scanner(System.in).nextInt();
							creditcard.Paid(scanCase8);
							Return(creditcard.getAccount());}
						else if(scanCase6 ==3) {
							UsingCreditCard(creditcard.getAccount());
							}
						}
			
			
			public  static  void WithdrawMoney(Account account)	  
			{
				System.out.println("Type  the  amount");
				int  scanCase2 =  new Scanner(System.in).nextInt();
				account.DecreaseBalance(scanCase2);
				account.AddToHistory(scanCase2+" dolar withdrawed");
				Return(account);
			}
				  
			public  static  void DoingEft(Account account,long iban)
			{
				
				
					System.out.println("Type the  amount");
					int  scanCase4 =  new Scanner(System.in).nextInt();
					account.Eft(iban, scanCase4);
					Return(account);
				
				
				
				
			}
			public  static  void DoingEftChecked(Account account)
			{
				System.out.println("Type recivers  iban ");
				long  scanCase3 =  new Scanner(System.in).nextInt();
				if(account.IbanFind(scanCase3) == true )
				{
					DoingEft(account,scanCase3);
				
				}
				else
				{
					System.out.println("invalid  iban ");
					AccountPanel(account);
					} } 
		
				  
				  
				  
				  
			public static void DepositMoney(Account account)
			{
				System.out.println("Type  the  amount");
				int  scanCase1 =  new Scanner(System.in).nextInt();
				account.IncreseBalance(scanCase1);
				account.AddToHistory(scanCase1+" dolar added  your  account");
				Return(account);
			}
			
			
			
			
	public static  void  Return(Account account)
	{
		System.out.println("do you want to Continue\n 1-Yes\n2-No");
		int  selection =  new Scanner(System.in).nextInt();
		if(selection == 1 || selection  ==2 )
			if(selection ==1)
				AccountPanel(account);
			else
			{
				System.out.println("Thank you  for  choosing us");
			}
			
			else
			{
				System.out.println(" valid number you can  choose 1 or 2 ");
			}
				

	
	
	
	}}
	
	
	
	
	
	
	
	

