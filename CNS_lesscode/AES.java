import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;
public class AES{
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);        
        System.out.print("Enter the plain text to encrypt: ");
        String textToEncrypt = scanner.nextLine();  
        System.out.print("Enter the key (16 characters for AES): ");
        String keyInput = scanner.nextLine();
        if (keyInput.length() != 16) {
            System.out.println("Key must be 16 characters long.");
            return;
        }       
        SecretKey secretKey = new SecretKeySpec(keyInput.getBytes(), "AES");        
        String encryptedText = encrypt(textToEncrypt, secretKey);
        System.out.println("Encrypted Text: " + encryptedText);       
        String decryptedText = decrypt(encryptedText, secretKey);
        System.out.println("Decrypted Text: " + decryptedText);
    }
    public static String encrypt(String plainText, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
    public static String decrypt(String encryptedText, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decryptedBytes);
    }
}
