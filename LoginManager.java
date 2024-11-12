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
    //public user 
    }
}
