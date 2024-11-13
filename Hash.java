import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
    public static String sha256(String text) {
        try {
            // Create a MessageDigest instance for SHA-256. MessageDigest is a package that contains hashing functions. This instance is called sha256, and uses the SHA-256 algorithm
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            
            //create an array using the getBytes function.
            byte[] undoneBytes = text.getBytes();
            //print the length of the array. Each byte is 8 bits (1/0)
            //System.out.println(undoneBytes.length);
            for (int i = 0; i<undoneBytes.length; i++) {
            	//System.out.println("Prehashed Hexadecimal Value " + i + ": " + undoneBytes[i]);
            }
            
            // Convert the input string into a byte array and compute the hash
            byte[] hash = sha256.digest(text.getBytes());
            

            // Prepare a StringBuilder to convert the byte array into a hex string
            StringBuilder hexString = new StringBuilder();
            
            // Iterate over each byte in the hash
            for (int i = 0; i < hash.length; i++) {
            	// Convert the byte to a two-digit hex value
            	String hex = Integer.toHexString(0xff & hash[i]);
            	//System.out.println("Byte value: " + hash[i] + " converted to string value: " + hex);
            	
            	
                // Ensure each hex value is two digits by adding a leading zero if necessary
                if (hex.length() == 1) {
                	hexString.append('0');
                	//System.out.println("Added leading 0 to hexString object");
                	}
                
                // Append the hex value to the StringBuilder
                hexString.append(hex);
                //System.out.println(hexString.toString());
            }
            
            // Return the complete hex string
            return hexString.toString();

        } 
        
        
        
        
        
        
        catch (NoSuchAlgorithmException xx) {
        	// If SHA-256 algorithm is not available, throw a runtime exception
        	throw new RuntimeException(xx);
        }
    }
}
