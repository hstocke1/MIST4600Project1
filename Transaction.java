import java.util.Date;

public class Transaction {
    private String type;
    private double amount;
    private Date date;
    private User user;
    private User recipient;

    public Transaction(String type, double amount, User user) {
        this.type = type;
        this.amount = amount;
        this.date = new Date(); // Sets the current date and time
        this.user = user;
    }
    
    public Transaction(String type, double amount, User user, User recipient) {
        this.type = type;
        this.amount = amount;
        this.date = new Date(); // Sets the current date and time
        this.user = user;
        this.recipient = recipient;
    }

    public String toString() {
    switch (type) {
        case "deposit":
        	return user.getUsername() + " deposited $" + amount + " on " + date;
        case "withdrawal":
        	return user.getUsername() + " withdrew $" + amount + " on " + date;
        case "transfer":
            if (recipient != null) {
                return user.getUsername() + " transferred $" + amount + " to " + recipient.getUsername() + " on " + date;
            } else {
            	return user.getUsername() + " transferred $" + amount + " to unknown on " + date;
            }
        default:
        	return "unknown transaction type";
    }
    }

    
    public String getType() {
    	return type;
    }
    
    public double getAmount() {
    	return amount;
    }
    
    public Date getDate() {
    	return date;
    }
    
    public User getUser() {
    	return user;
    }
    
    public User getRecipient() {
    	return recipient;
    }
}
