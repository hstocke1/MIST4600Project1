import java.util.Scanner;
import java.util.InputMismatchException;

public class UserInterface {
    private AccountManager accManager;
    private Scanner input;
    private User activeUser;

    public UserInterface(AccountManager accManager) {
        this.accManager = accManager;
        this.input = new Scanner(System.in);
        
    }
    
	public void start() {
		System.out.println("Welcome to Java Project Bank Account");
		System.out.println("What would you like to do today?");
        boolean done = false;
		while(!done) {
		System.out.println("1: Create an account");
		System.out.println("2: Login into your account");
		System.out.println("3: Exit the program");
		System.out.println("Please enter your choice (1-3)");
		
		int option = getValidInput(1,3);
		input.nextLine();
		
		switch(option) {
		
		case 1:
			System.out.print("Please enter a username: ");
			String un = input.nextLine();
			
			if(accManager.getUser(un) != null)  {
				System.out.println("This user already exists.");
			} else {
				System.out.print("Please enter a password: ");
				String pw = input.nextLine();
				System.out.print("Please your first name: ");
				String fName = input.nextLine();
				System.out.print("Please enter your last name: ");
				String lName = input.nextLine();
				accManager.createAccount(un, pw, fName, lName, false);
				System.out.println("Thanks, " + fName + " " + lName + ". Your account has been created with the username " + un);
			}
			System.out.println("\n----------------------");
			break;
		case 2:
			System.out.print("Please enter a username: ");
			String loginUn = input.nextLine();
			System.out.print("Please enter a password: ");
			String loginPw = input.nextLine();
			if (accManager.logIn(loginUn, loginPw) != null) {
				activeUser = accManager.logIn(loginUn, loginPw);
				System.out.println("Welcome " + activeUser.getName());
				boolean keepGoing = true;
				while(keepGoing) {
					System.out.println("1: Check balance");
					System.out.println("2: Deposit funds");
					System.out.println("3: Withdrawl funds");
					System.out.println("4: Transfer funds");
					System.out.println("5: Show my transaction history");
					if(activeUser.isAdmin) {
						System.out.println("6: List users and respective balances");
						System.out.println("7: Change user password");
						System.out.println("8: Show all transaction history");
					}
					System.out.println("9: Log out");
					int loginChoice = getValidInput(1,9);
					switch(loginChoice) {
						case 1:
							System.out.printf("Current balance: $%.2f%n", activeUser.getBalance());
							break;
						case 2:
							System.out.println("How much would you like to deposit?");
							double depositAmt = input.nextDouble();
							activeUser.depositFunds(depositAmt);
							break;
						case 3:
							System.out.println("How much would you like to withdrawl?");
							double withdrawlAmt = input.nextDouble();
							activeUser.withdrawlFunds(withdrawlAmt);
							break;
						case 4:
							System.out.println("Enter the username of the individual whom you would like to transfer funds to");
							input.nextLine();
							String recipient = input.nextLine();
							System.out.println("How much would you like to send them?");
							double transferAmt = input.nextDouble();
							
							activeUser.transferFunds(transferAmt, accManager.getUser(recipient));
							//System.out.printf("%.2f transferred to user %s. Current balance is $%.2f%n", transferAmt, recipient, activeUser.getBalance());
							//we use formatted text (printf) to do all this rounding
							break;
						case 5:
							activeUser.printMyTransactions();
							break;
						case 6:
							activeUser.printUsers();
							break;
						case 7:
							System.out.println("Enter the username of the user whos password you would like to change");
							input.nextLine();
							String username = input.nextLine();
							System.out.println(username);
							
							System.out.println("Enter the new password");
							String pass = input.nextLine();
							activeUser.changePassword(accManager.getUser(username), pass);
							break;
						case 8:
							activeUser.printAllTransactions();
							break;
						case 9:
							activeUser = null;
							keepGoing = false;
							break;
				}
			}
		}
			break;
			
		case 3:
			done = true;
			System.out.println("Thank you for using the system.");
			break;
		default:
			System.out.println("Invalid input. please enter a number (1-3)");
			break;
		}
	}
		input.close();
	}
	
	private int getValidInput(int min, int max) {
		int option = -1;
			while (true) {
	            try {
	                option = input.nextInt();
	                if (option >= min && option <= max) {
	                    break;
	                } else {
	                    System.out.println("Please enter a number between " + min + " and " + max);
	                }
	            } catch (InputMismatchException e) {
	                System.out.println("Invalid input. Please enter a number.");
	                input.next(); // Clear the invalid input
	            }
	        }
	        return option;
	}
}
