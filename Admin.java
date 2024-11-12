import java.util.*;

public class Admin extends User {
	private AccountManager accountManager;
	
	public Admin(String username, String rawPass, String firstName, String lastName, AccountManager accountManager) {
		super(username, rawPass, firstName, lastName);
		this.accountManager = accountManager;
	}
	
	public ArrayList<User> getUsers() {
		return new ArrayList<>(accountManager.users.values());
    }

	public void printUsers() {
	    ArrayList<User> users = getUsers();
	    for (User user : users) {
	        System.out.println("Username: " + user.getUsername() + ", Name: " + user.getName());
	    }
	}
	
	public boolean changePassword(User user, String newPass) {
		if (user != null) {
			user.changePassword(newPass);
			return true;
		}
		return false;
	}
}
