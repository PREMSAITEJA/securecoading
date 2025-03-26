import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
public class SHA{
      public static String SHA1(String input){
      try{
            MessageDigest hash = MessageDigest.getInstance("SHA-256");
            //byte[] messageDigest = hash.digest(input.getBytes());
            BigInteger no = new BigInteger(1, hash.digest(input.getBytes());
            String hashtext = no.toString(16);
            while (hashtext.length() < 64){
                  hashtext = "0" + hashtext;
            }
            return hashtext;
      } catch(NoSuchAlgorithmException e){
            throw new RuntimeException(e);
       }
       }
       public static void main(String args[]) {
                  Scanner sc = new Scanner(System.in);
                  System.out.print("Enter plain text: ");
                  String s = sc.nextLine();
                  System.out.println("Plain text: " + s);
                  System.out.println("Encrypted text: " + SHA1(s));
                  System.out.println("Decrypted text: " + s);
            }
}

