import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.*;
class DES
{
public static void main(String[] args) {
try{
KeyGenerator kg=KeyGenerator.getInstance("DES");
SecretKey key=kg.generateKey();
Cipher cipher=Cipher.getInstance("DES/ECB/PKCS5Padding");
cipher.init(Cipher.ENCRYPT_MODE,key);
String s;
System.out.println("Enter the Plain Text : ");
Scanner sc=new Scanner(System.in);
s=sc.nextLine();
byte[] text=s.getBytes();
System.out.println("Text in bytes : "+text);
System.out.println("Text as String : "+(new String(text)));
byte[] textEnc=cipher.doFinal(text);
System.out.println("Text after encryption in bytes : "+textEnc);
System.out.println("Text encrypted as Strings : "+(new String(textEnc)));
cipher.init(Cipher.DECRYPT_MODE,key);
byte[] textDec=cipher.doFinal(textEnc);
System.out.println("Text after decryption in bytes : "+textDec);
System.out.println("Text decrypted as Strings : "+(new String(textDec)));
}
catch(Exception e)
{
System.out.println("Error is caught");
}
}
}
