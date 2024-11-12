import java.util.*;

public class TransactionHistory {
	private ArrayList<Transaction> transactions;
	
    public TransactionHistory() {
        this.transactions = new ArrayList<>();
    }
	
	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}
	
	public ArrayList<Transaction> getAllTransactions() {
		return transactions;
	}
	
	public ArrayList<Transaction> getTransactionsForUser(User user) {
		ArrayList<Transaction> userTransactions = new ArrayList<>();
		for (Transaction transaction : transactions) {
            if (transaction.getUser().equals(user) || 
                (transaction.getRecipient() != null && transaction.getRecipient().equals(user))) {
                userTransactions.add(transaction);
            }
        }
		
		return userTransactions;
	}
	
}
