public class User {
	private String username;
	private String encPass;
	private String firstName;
	private String lastName;
	private double balance;
	
	public User(String username, String rawPass, String firstName, String lastName) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		encPass = Hash.sha256(rawPass);
		balance = 0;
	}
	
	public User(String username, String rawPass, String firstName, String lastName, double balance) {
		
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		encPass = Hash.sha256(rawPass);
		this.balance = balance;
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
	
	public void changePassword(String newPass) {
		encPass = Hash.sha256(newPass);
	}
	
}
