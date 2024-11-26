package pack1;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.SecretKey;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Base64.Decoder;
import java.util.Scanner;

public class Encryptor {
	private static Encoder encoder = Base64.getEncoder();
	private static Decoder decoder = Base64.getDecoder();

	// Method to generate a cryptographic key from a password
	private static SecretKey generateKeyFromPassword(String password, byte[] salt) throws Exception {
		// Set PBKDF2 parameters
		int iterations = 65536; // Iteration count for PBKDF2
		int keyLength = 256; // Length of the derived key (in bits)

		// Create the PBKDF2 specification
		PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt, iterations, keyLength);

		// Create a SecretKeyFactory for PBKDF2
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

		// Generate the key from the password and salt
		SecretKey secretKey = keyFactory.generateSecret(keySpec);

		return secretKey;
	}

	// Method to generate a random salt
	private static byte[] generateSalt() {
		SecureRandom secureRandom = new SecureRandom();
		byte[] salt = new byte[16]; // 16 bytes salt
		secureRandom.nextBytes(salt);
		return salt;
	}

	public static String cipher(String password) throws Exception {
		byte[] salt = generateSalt();
		SecretKey secretKey = generateKeyFromPassword(password, salt);

		return encoder.encodeToString(secretKey.getEncoded()) + encoder.encodeToString(salt);
	}

	public static boolean compare(String hashed, String input) {
		try {
			int i = hashed.indexOf("=");

			if (i == -1) {
				return false;
			}

			String saltBase64 = hashed.substring(i + 1);

			byte[] salt = decoder.decode(saltBase64);

			SecretKey hashedInput = generateKeyFromPassword(input, salt);

			String encodedHashedInput = encoder.encodeToString(hashedInput.getEncoded()) + saltBase64;

			if (hashed.equals(encodedHashedInput)) {
				return true;
			}

			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Input a password: ");

		String password = scanner.nextLine();

		String hashSalted = Encryptor.cipher(password);

		System.out.println(hashSalted);
		// System.out.println(hashSalted.length());

		System.out.print("Input a password: ");

		password = scanner.nextLine();

		System.out.println(Encryptor.compare(hashSalted, password));

		scanner.close();
	}

}
