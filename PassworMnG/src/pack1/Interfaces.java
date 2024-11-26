package pack1;

import java.util.Scanner;

public class Interfaces {

	static Scanner scanner = new Scanner(System.in);

	public static void drawInterface() {

		System.out.print("____________________\n" + "/// Password M&G \\\\\\\n\n" + "1- Manager\n" + "2- Generator\n\n"
				+ "0- Exit" + "\n\nInput: ");

	}

	public static void exitPrompt() {
		System.out.println("######\nExited");
	}

	public static void drawManager() {
		
	}

	public static void drawGenerator() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
		int input = -1;
		while (input != 0) {
			System.out.println();

			System.out.print("1- Generate\n" + "0- Menu" + "\n\nInput: ");

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