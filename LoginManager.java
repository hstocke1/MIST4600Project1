public class LoginManager {

    public static void main(String[] args) {
        AccountManager accManager = new AccountManager();
        UserInterface userInterface = new UserInterface(accManager);
        
        accManager.createAccount("admin", "password", "Admin", null, true);
        accManager.createAccount("odonnelly", "myPass", "Owen", "Donnelly", false);
        accManager.createAccount("hstocke", "hisPass", "Hank", "Stocke", false);
        accManager.createAccount("lhelm", "pass", "Levon", "Helm", false);
        accManager.createAccount("rmanuel", "pass", "Richard", "Manuel", false);
        accManager.createAccount("gbrooks", "pass", "Garth", "Brooks", false);
    
        userInterface.start();
    
    }
}
