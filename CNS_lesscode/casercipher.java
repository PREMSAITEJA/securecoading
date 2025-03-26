import java.util.*;
public class casercipher{
public static String encrypt(String t,int s){
StringBuilder et=new StringBuilder();
t=t.toLowerCase();
for(int i=0;i<t.length();i++)
{
char c=t.charAt(i);
c=(char)((c+s-97)%26+97);
et.append(c);
}
return et.toString();
}
public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
System.out.print("Enter the Plain text: ");
String t=sc.next();
System.out.print("Enter the shift Value: ");
int s=sc.nextInt();
String et=encrypt(t,s);
System.out.println("Encrypted Text: "+et);
}
}

