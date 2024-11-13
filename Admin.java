import java.util.*;

public class Admin extends User {
	private AccountManager accountManager;
	private TransactionHistory transactionHistory;
	
	public Admin(String username, String rawPass, String firstName, String lastName, AccountManager accountManager, boolean isAdmin) {
		super(username, rawPass, firstName, lastName, accountManager, isAdmin);
		balance = 200;
		this.accountManager = accountManager;
	}
	
	public ArrayList<User> getUsers() {
		return new ArrayList<>(accountManager.users.values());
    }

    public void changePassword(User user, String newPassword) {
        if (user != null) {
        	user.changePassword(newPassword);
            System.out.println("Password changed successfully for user: " + user.getUsername());
        } else {
            System.out.println("User not found.");
        }
    }
	
	public void printMyTransactions() {
        for (Transaction transaction : transactionHistory.getAllTransactions()) {
            System.out.println(transaction);
        }
	}
	
	@Override
	public void printAllTransactions() {
        ArrayList<Transaction> transactions = accountManager.getAllTransactions();
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
	}
	
	@Override
	public void printUsers() {
	    ArrayList<User> users = getUsers();
	    for (User aUser : users) {
	        System.out.println("Username: " + aUser.getUsername() + ", Name: " + aUser.getName() + " Balance: " + aUser.getBalance());
	    }
	}
}
