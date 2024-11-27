package pack1;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Base64.Decoder;
import java.util.Scanner;

public class Encryptor {
	private static Encoder encoder = Base64.getEncoder();
	private static Decoder decoder = Base64.getDecoder();
	
	 // Method to encrypt data
    public static String encrypt(String data, String password) throws Exception {
        // Create a key from the password
        SecretKeySpec key = new SecretKeySpec(getKeyFromPassword(password), "AES");

        // Initialize cipher in ENCRYPT mode
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        // Encrypt the data
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        
        // Return encrypted data as Base64 string
        return encoder.encodeToString(encryptedData);
    }
    
    // Method to decrypt data
    public static String decrypt(String encryptedData, String password) throws Exception {
        // Create a key from the password
        SecretKeySpec key = new SecretKeySpec(getKeyFromPassword(password), "AES");

        // Initialize cipher in DECRYPT mode
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);

        // Decrypt the data
        byte[] decodedData = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedData = cipher.doFinal(decodedData);

        // Return decrypted data as string
        return new String(decryptedData);
    }

    // Method to generate a key from a password (using SHA-256)
    private static byte[] getKeyFromPassword(String password) throws NoSuchAlgorithmException {
        // Use SHA-256 to hash the password
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        return sha.digest(password.getBytes());
    }
    
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
}
