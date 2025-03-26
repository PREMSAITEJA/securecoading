import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.*;
public class DigitalSignatureDynamic{
public static void main(String[] args)throws Exception{
Scanner sc=new Scanner(System.in);
System.out.println("Enter the text: ");
String msg=sc.nextLine();
sc.close();
KeyPairGenerator KeyPairGen=KeyPairGenerator.getInstance("DSA");
KeyPairGen.initialize(2048);
KeyPair pair=KeyPairGen.generateKeyPair();
PrivateKey privkey=pair.getPrivate();
PublicKey pubkey=pair.getPublic();
Signature sign=Signature.getInstance("SHA256withDSA");
sign.initSign(privkey);
byte[] bytes=msg.getBytes();
sign.update(bytes);
byte[] signature=sign.sign();
System.out.println("Generated Digital Signature: ");
for(byte b:signature){
System.out.print(b+" ");
}
System.out.println();
sign.initVerify(pubkey);
sign.update(bytes);
boolean isverified=sign.verify(signature);
System.out.println(isverified ? "Signature verified successfully" : "Signature verification failed");
}
}
