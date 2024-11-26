package pack1;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Interfaces interfaces = new Interfaces();
		Authenticator authenticator = new Authenticator();
		Encryptor encryptor = new Encryptor();
		Storage storage = new Storage();
		Generator generator = new Generator();

		Scanner scanner = new Scanner(System.in);

		String userInputS;
		int userInput = 9;

		while (userInput != 0) {

			Interfaces.drawInterface();

			userInput = scanner.nextInt();

			switch (userInput) {
			case 1:
				Interfaces.drawManager();
				break;
			case 2:
				Interfaces.drawGenerator();
				break;
			default:
				System.out.println("\nInvalid Input!");
			}

		}
		Interfaces.exitPrompt();

	}

}