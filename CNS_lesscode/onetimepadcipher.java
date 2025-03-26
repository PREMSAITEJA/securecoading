import java.util.*;
public class onetimepadcipher {
public static String encrypt(String t,String k){
StringBuilder et=new StringBuilder();
for(int i=0;i<t.length();i++){
int x=((int)t.charAt(i)+(int)k.charAt(i))%26;
et.append((char)(x+97));
}
return et.toString();
}
public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
System.out.println("Enter the plain text: ");
String t=sc.nextLine();
System.out.println("Enter the key of same length: ");
String k=sc.nextLine();
String et=encrypt(t.toUpperCase(),k.toUpperCase());
System.out.println("Encrypted text: "+et);
}
}


