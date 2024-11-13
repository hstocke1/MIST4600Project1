import java.util.*;

public class LoginManager {

    public static void main(String[] args) {
        AccountManager accManager = new AccountManager();
        boolean done = false;
        Scanner input = new Scanner(System.in);
        User activeUser;

        accManager.createAccount("admin", "password", "Admin", null, true);
        accManager.createAccount("odonnelly", "myPass", "Owen", "Donnelly", false);
        accManager.createAccount("hstocke", "hisPass", "Hank", "Stocke", false);
        accManager.createAccount("lhelm", "pass", "Levon", "Helm", false);
        accManager.createAccount("rmanuel", "pass", "Richard", "Manuel", false);
        accManager.createAccount("gbrooks", "pass", "Garth", "Brooks", false);

        //activeUser = accManager.logIn("odonnelly", "myPass"); //log into odonnelly
        //activeUser.transferFunds(50, accManager.getUser("hstocke")); //transfer 50 from the active user to hstocke

		System.out.println("Welcome to Java Project Bank Account");
		System.out.println("What would you like to do today?");
        
		while(!done) {


		System.out.println("1: Create an account");
		System.out.println("2: Login into your account");
		System.out.println("3: Exit the program");
		
		System.out.println("Please enter your choice (1-3)");
		int option = input.nextInt();
		
		input.nextLine();
		
		switch(option) {
		
		case 1:
			System.out.print("Please enter a username: ");
			String un = input.nextLine();
			
			if(accManager.getUser(un) != null)  {
				System.out.println("This user already exists.");
			} else {
				System.out.println("Please enter a password:");
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
			System.out.println("Please enter a password:");
			String loginPw = input.nextLine();
			activeUser = accManager.logIn(loginUn, loginPw);
			if (accManager.logIn(loginUn, loginPw) != null) {
				System.out.println("Welcome " + activeUser.getName());
				boolean keepGoing = true;
				while(keepGoing) {
					System.out.println("1: Check balance");
					System.out.println("2: Deposit funds");
					System.out.println("3: Withdrawl funds");
					System.out.println("4: Transfer funds");
					System.out.println("5: Log out");
					int loginChoice = input.nextInt();
					switch(loginChoice) {
						case 1:
							System.out.printf("Current balance: $%.2f%n", activeUser.getBalance());
							break;
						case 2:
							System.out.println("How much would you like to deposit?");
							double depositAmt = input.nextDouble();
							activeUser.addFunds(depositAmt);
							System.out.printf("%.2f deposited. Current balance is $%.2f%n", depositAmt, activeUser.getBalance());
							break;
						case 3:
							System.out.println("How much would you like to withdrawl?");
							double withdrawlAmt = input.nextDouble();
							activeUser.subFunds(withdrawlAmt);
							System.out.printf("%.2f withdrawn. Current balance is $%.2f%n", withdrawlAmt, activeUser.getBalance());
							break;
						case 4:
							System.out.println("Enter the username of the individual whom you would like to transfer funds to");
							input.nextLine();
							String recipient = input.nextLine();
							System.out.println("How much would you like to send them?");
							double transferAmt = input.nextDouble();
							activeUser.transferFunds(transferAmt, accManager.getUser(recipient));
							System.out.printf("%.2f transferred to user %s. Current balance is $%.2f%n", transferAmt, recipient, activeUser.getBalance());
							//we use formatted text (printf) to do all this rounding
							break;
						case 5:
							activeUser = null;
							keepGoing = false;
							break;
					}
				}
			} else {
				System.out.println();
			}
			
			break;
			
		case 3:
			done = true;
			System.out.println("Thank you for using the system.");
			
			break;
			
			default:
			
			break;
		

		
		}
        
        
        
        
        
		}
		input.close();
    }
}
