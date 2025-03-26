import java.math.BigInteger;
import java.util.*;
public class RSA{
private BigInteger p,q,n,phi,e,d;
private int bigLength=1024;
private Random rand;
public RSA(){
rand=new Random();
}
public void generateKeys(){
Scanner sc=new Scanner(System.in);
System.out.print("Enter the prime number(p): ");
p=sc.nextBigInteger();
System.out.println("Enter the second prime number(Q): ");
q=sc.nextBigInteger();
n=p.multiply(q);
phi=(p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
do{
e=new BigInteger(phi.bitLength(),rand);
}
while(e.compareTo(BigInteger.ONE)<0 || e.compareTo(phi)>=0 ||!e.gcd(phi).equals(BigInteger.ONE));
d=e.modInverse(phi);
System.out.println("\nGenerate Public Key(e,n): ("+e+","+n+")");
System.out.println("Generated Private Key:(d,n): ("+d+","+n+")");
}
public BigInteger encrypt(BigInteger message){
return message.modPow(e,n);
}
public BigInteger decrypt(BigInteger e){
return e.modPow(d,n);
}
public static void main(String[] args){
RSA rsa=new RSA();
rsa.generateKeys();
Scanner sc=new Scanner(System.in);
System.out.print("\nEnter a numeric message to encrypt: ");
BigInteger message=sc.nextBigInteger();
BigInteger e=rsa.encrypt(message);
System.out.println("Encrypted Message: "+e);
BigInteger d=rsa.decrypt(e);
System.out.println("Decrypted Message: "+d);
sc.close();
}
}


