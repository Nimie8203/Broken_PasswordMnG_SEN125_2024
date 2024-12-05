package pack1;

import java.util.Scanner;

public class Interfaces {

	static Scanner scanner = new Scanner(System.in);
	Authenticator authenticator = new Authenticator();

	public static void drawInterface() {

		System.out.print("____________________\n"
					   + "/// Password M&G \\\\\\\n\n"
					   + "1- Manager\n"
					   + "2- Generator\n\n"
					   + "0- Exit"
					   + "\n\nInput: ");

	}

	public static void exitPrompt() {
		System.out.println("######\nExited");
	}
	
	public static void drawAuthenticator() {
		String enteredID;
		
		System.out.println("____________________\n"
						 + "/// Authenticator \\\\\\\n"
						 + "");
		
		/*if(authenticator.userId == "0") {
			System.out.print("Enter your TC ID:");
			String inputID = scanner.next();
		}*/

	}

	public static void drawManager() {
		System.out.println("____________________"
						 + "\n/// Manager \\\\\\");
		String input = scanner.next();
	}

	public static void drawGenerator() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
		int input = -1;
		while (input != 0) {
			System.out.println();

			System.out.print("1- Generate\n"
						   + "0- Menu"
						   + "\n\nInput: ");

			input = scanner.nextInt();

			switch (input) {
			case 1:
				System.out.println();
				Generator.deliverPassword();
				break;
			case 0:
				break;
			default:
				System.out.println("\nInvalid Input!");
			}
		}
	}

	/*
	 * public static void spacer() { for (int i = 0; i < 50; i++) {
	 * System.out.println(); } }
	 */

}