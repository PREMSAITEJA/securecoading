import java.io.*;
import java.math.BigInteger;
import java.net.*;
import java.util.Scanner;
public class DiffieHellmanServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server is waiting for client...");
        Socket socket = serverSocket.accept();
        System.out.println("Client connected.");
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        Scanner scanner = new Scanner(System.in);
        BigInteger p = new BigInteger(input.readUTF());
        BigInteger g = new BigInteger(input.readUTF());
        System.out.println("Received p: " + p + " and g: " + g);
        System.out.print("Enter Server's private key: ");
        BigInteger privateKey = scanner.nextBigInteger();
        BigInteger publicKey = g.modPow(privateKey, p);
        output.writeUTF(publicKey.toString());
        BigInteger clientPublicKey = new BigInteger(input.readUTF());
        BigInteger sharedSecret = clientPublicKey.modPow(privateKey, p);
        System.out.println("Shared Secret: " + sharedSecret);
        scanner.close();
        socket.close();
        serverSocket.close();
    }
}

