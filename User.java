//import java.util.ArrayList;

public class User {
	private String username;
	private String encPass;
	private String firstName;
	private String lastName;
	private double balance;
	public boolean isAdmin;
	private TransactionHistory transactionHistory; //track each users transaction history
	private AccountManager accountManager;
	
	public User(String username, String rawPass, String firstName, String lastName, AccountManager accountManager, boolean isAdmin) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		encPass = Hash.sha256(rawPass);
		balance = 100;
		transactionHistory = new TransactionHistory();
		this.accountManager = accountManager;
		this.isAdmin = isAdmin;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getName() {
		return lastName + ", " + firstName;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public String getEncPass() {
		return encPass;
	}
	
	public boolean getAdminStatus() {
		return isAdmin;
	}
	
	public void changePassword(String newPass) {
		encPass = Hash.sha256(newPass);
	}
	
    public void printUsers() {//standard users cannot print all users
        System.out.println("Access denied. Only admins can view users.");
    }
    
	public void printAllTransactions() {//standard users cannot view others transactions
		System.out.println("Access denied. Only admins can view full transaction history.");
	}
	
	public void printMyTransactions() {
        for (Transaction transaction : transactionHistory.getAllTransactions()) {
            System.out.println(transaction);
        }
	}
    
    public void addFunds(double change) {
    	balance += change;
    }
    
    public void subFunds(double change) {
    	balance -= change;
    	
    }
    
    public void depositFunds(double depositAmt) {
    	addFunds(depositAmt);
    	Transaction thisTransaction = new Transaction("deposit", depositAmt, this);
    	transactionHistory.addTransaction(thisTransaction);
    }
    
    public void withdrawlFunds(double withdrawlAmt) {
    	if(withdrawlAmt > this.balance) {
    		System.out.println("You do not have enough funds to perform this withdrawl.");
    		return;
    	} 
    	subFunds(withdrawlAmt);
    	Transaction thisTransaction = new Transaction("withdrawl", withdrawlAmt, this);
    	transactionHistory.addTransaction(thisTransaction);
		System.out.printf("%.2f withdrawn. Current balance is $%.2f%n", withdrawlAmt, this.balance);

    }
    
    
    public void transferFunds(double amount, User recipient) {
    	Transaction thisTransaction = new Transaction("transfer", amount, this, recipient); //create a transaction object for the transfer
    	if(amount > 0 && this.balance >= amount && recipient != null) { //check the sender can afford it, and that the recipient exists
    		this.subFunds(amount);
    		recipient.addFunds(amount);
    		transactionHistory.addTransaction(thisTransaction); //add transaction to senders history
    		recipient.transactionHistory.addTransaction(thisTransaction); //add transaction to recipients history
    		accountManager.addTransaction(thisTransaction); //add transaction to master history
    		System.out.printf("$%.2f transferred to user %s. Current balance is $%.2f%n", amount, recipient.getUsername(), this.balance);
    	} else {
    		System.out.println("Transfer failed. Insufficient funds, invalid amount, or invalid user");
    	}
    }
    
}
