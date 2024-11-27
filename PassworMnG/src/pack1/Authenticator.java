package pack1;

public class Authenticator {
	private String password = null;
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
	}
}