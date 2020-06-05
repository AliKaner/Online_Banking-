import java.util.ArrayList;

public class User {
	private String Uname;
	private String Usurname;
	private int  Unumber;
	private String Uemail;
	private int Upassword;
	private int UphoneNumber;
	private ArrayList<Account> Uaccounts = new ArrayList<Account>(5);
	private ArrayList<CreditCard> UcreditCards = new ArrayList<CreditCard>(2);
	
	
	
	// Constructor................................................................................................................................................................
	
	
	public User(String name, String surname,String email,int password,int number, int phonenumber)
	{
		this.setUname(name);
		this.setUsurname(surname);
		this.setUnumber(number);
		this.setUemail(email);
		this.setUphoneNumber(phonenumber);
		this.setUpassword(password);
		MainPanel.ListOfUsers.add(this);
	}


    // accessor and mutator methods	............................................................................................................................................................


	public int getUnumber() {
		return Unumber;
	}
	public void setUnumber(int unumber) {
		Unumber = unumber;
	}
	public String getUsurname() {
		return Usurname;
	}
	public void setUsurname(String usurname) {
		Usurname = usurname;
	}
	public String getUname() {
		return Uname;
	}
	public void setUname(String uname) {
		Uname = uname;
	}
	public String getUemail() {
		return Uemail;
	}
	public void setUemail(String uemail) {
		Uemail = uemail;
	}
	public int getUpassword() {
		return Upassword;
	}
	public void setUpassword(int upassword) {
		Upassword = upassword;
	}
	public int getUphoneNumber() {
		return UphoneNumber;
	}
	public void setUphoneNumber(int uphoneNumber) {
		UphoneNumber = uphoneNumber;
	}
	public ArrayList<Account> getUaccounts() {
		return Uaccounts;
	}
	public void setUaccounts(ArrayList<Account> uaccounts) {
		Uaccounts = uaccounts;
	}
	public ArrayList<CreditCard> getUcreditCards() {
		return UcreditCards;
	}
	public void setUcreditCards(ArrayList<CreditCard> ucreditCards) {
		UcreditCards = ucreditCards;
	}
	
		
	//methods.....................................................................................................................................................................................
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
