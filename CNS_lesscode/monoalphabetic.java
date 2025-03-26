import java.util.*;
public class monoalphabetic {
public static String encrypt(String t,String st){
StringBuilder et=new StringBuilder();
t=t.toUpperCase();
String a="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
for(int i=0;i<t.length();i++){
char c=t.charAt(i);
if(Character.isAlphabetic(c)){
int in=a.indexOf(c);
et.append(st.charAt(in));
}
else{
et.append(c);
}
}
return et.toString();
}

public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
System.out.print("Enter the Plain text: ");
String t=sc.nextLine();
System.out.println("Enter subtutionkey(26 letters): ");
String st=sc.next();
String et=encrypt(t,st);
System.out.println("Encrypted text: "+et);
}
}

