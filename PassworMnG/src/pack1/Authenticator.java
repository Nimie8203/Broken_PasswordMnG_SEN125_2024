package pack1;

import java.util.Scanner;

public class Authenticator {
	/*private String password = null;
	private String hashed = null;
	
	public Authenticator() {
		// Check the storage for the password
		// store it in hashed property
	}
	
	public boolean authenticate() {
		String input = Interfaces.scanner.nextLine();
		
		if (Encryptor.compare(hashed, input)) {
			password = input;
			return true;
		}
		
		 return false;
	}*/

//////////////////////////////////////////////////////////////////////////////////////////////////
	String userId = "0"; // Example ID
    String userPassword = "0";
	
	// This method simulates the authentication process.
    //public static boolean authenticate(String id, String password) {
        // Example: Replace this with a call to the database or storage layer
         // Example password

        //return id.equals(id) && password.equals(userPassword);
    //}

    // Simulate accessing the main program after successful authentication
    public static void accessMainProgram() {
        System.out.println(""
        				 + "You can now manage your passwords!  ");
        // Add the main functionality of the program here
    }
    
    public static void deliverAuthentication() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Password Manager!");
        
        // Prompt for ID
        System.out.print("Enter your ID number: ");
        String id = scanner.nextLine();

        // Prompt for password
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Authenticate the user
       /* if (authenticate(id, password)) {
            System.out.println("Authentication successful!");
            accessMainProgram(); // Grant access to the main program
        } else {
            System.out.println("Incorrect ID or password. Access denied.");
        }*/

        scanner.close();
    }

}