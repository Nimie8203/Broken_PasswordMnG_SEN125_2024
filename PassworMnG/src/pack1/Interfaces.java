package pack1;

import java.util.Scanner;

public class Interfaces {

	static Scanner scanner = new Scanner(System.in);
	Authenticator authenticator = new Authenticator();

	public static void drawInterface() {

		System.out.println("=====================================");
        System.out.println(">>       PASSWORD M&G MENU         <<");
        System.out.println("=====================================");
        System.out.println("->  1. Manager");
        System.out.println("->  2. Generator");
        System.out.println("->  0. Exit");
        System.out.println("=====================================");
        System.out.print("Select an option: ");
	}

	public static void exitPrompt() {
		System.out.println("Exiting the program.");
        scanner.close(); 
        System.exit(0);
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