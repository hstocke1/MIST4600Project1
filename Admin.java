import java.util.*;

public class Admin extends User {
	private AccountManager accountManager;
	private TransactionHistory transactionHistory;
	
	public Admin(String username, String rawPass, String firstName, String lastName, AccountManager accountManager) {
		super(username, rawPass, firstName, lastName, accountManager);
		this.accountManager = accountManager;
	}
	
	public ArrayList<User> getUsers() {
		return new ArrayList<>(accountManager.users.values());
    }

	public boolean changePassword(User user, String newPass) {
		if (user != null) {
			user.changePassword(newPass);
			return true;
		}
		return false;
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
	        System.out.println("Username: " + aUser.getUsername() + ", Name: " + aUser.getName());
	    }
	}
}
