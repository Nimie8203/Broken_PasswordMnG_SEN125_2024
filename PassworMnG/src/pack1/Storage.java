package pack1;

import java.io.*;
import java.util.*;

public class Storage {

	private static final String StorageFile = "data.txt";

	public static void save(String location, String username, String password) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(StorageFile, true))) {
			writer.write(location + "," + username + "," + password);
			writer.newLine();
			System.out.println("Entry saved successfully.");
		} catch (IOException e) {
			System.out.println("An error occurred while writing to the file: " + e.getMessage());
		}
	}

	public static void read() {
		try (BufferedReader reader = new BufferedReader(new FileReader(StorageFile))) {
			String line;
			System.out.println("Stored Entries:");
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 3) {
					System.out.println("Location: " + parts[0] + ", Username: " + parts[1] + ", Password: " + parts[2]);
				} else {
					System.out.println("Invalid entry found in file.");
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("No password file found. Please add entries first.");
		} catch (IOException e) {
			System.out.println("An error occurred while reading from the file: " + e.getMessage());
		}
	}
}