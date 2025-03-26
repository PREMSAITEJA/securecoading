import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

class md5 {
    public static String md5(String input) {
        try {
            MessageDigest hash = MessageDigest.getInstance("MD5");
            byte[] messageDigest = hash.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String args[]) throws NoSuchAlgorithmException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter plain text: ");
        String s = sc.nextLine();
        System.out.println("Plain text: " + s);
        System.out.println("Encrypted (hashed) text: " + md5(s));
        // Removed the line attempting to display "decrypted" text as it's not possible with hashing
    }
}











