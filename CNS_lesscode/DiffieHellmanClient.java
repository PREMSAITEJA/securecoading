import java.io.*;
import java.math.BigInteger;
import java.net.*;
import java.util.Scanner;
public class DiffieHellmanClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);
        System.out.println("Connected to the server.");
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a prime number (p): ");
        BigInteger p = scanner.nextBigInteger();
        System.out.print("Enter a primitive root (g): ");
        BigInteger g = scanner.nextBigInteger();
        output.writeUTF(p.toString());
        output.writeUTF(g.toString());
        System.out.print("Enter Client's private key: ");
        BigInteger privateKey = scanner.nextBigInteger();

        BigInteger publicKey = g.modPow(privateKey, p);
        output.writeUTF(publicKey.toString());

        BigInteger serverPublicKey = new BigInteger(input.readUTF());

        BigInteger sharedSecret = serverPublicKey.modPow(privateKey, p);
        System.out.println("Shared Secret: " + sharedSecret);
        scanner.close();
        socket.close();
    }
}

