import java.math.BigInteger;
import java.security.SecureRandom;

public class p9_RSADemo {
    private final static BigInteger ONE = BigInteger.ONE;
    private final static SecureRandom RANDOM = new SecureRandom();
    private BigInteger privateKey;
    private BigInteger publicKey;
    private BigInteger modulus;

    public p9_RSADemo(int bitLength) {
        if (bitLength < 512) {
            throw new IllegalArgumentException("bitLength must be at least 512");
        }

        BigInteger prime1 = generateDistinctPrime(bitLength / 2, null);
        BigInteger prime2 = generateDistinctPrime(bitLength / 2, prime1);

        BigInteger phi = (prime1.subtract(ONE)).multiply(prime2.subtract(ONE));

        modulus = prime1.multiply(prime2);
        publicKey = new BigInteger("65537"); // Commonly used public exponent
        privateKey = publicKey.modInverse(phi);
    }

    private BigInteger generateDistinctPrime(int bitLength, BigInteger otherPrime) {
        BigInteger prime;
        do {
            prime = BigInteger.probablePrime(bitLength, RANDOM);
        } while (prime.equals(otherPrime));
        return prime;
    }

    public BigInteger getPrivateKey() {
        return privateKey;
    }

    public BigInteger getPublicKey() {
        return publicKey;
    }

    public BigInteger getModulus() {
        return modulus;
    }

    public static void main(String[] args) {
        int bitLength = 1024; // Example bit length
        p9_RSADemo rsa = new p9_RSADemo(bitLength);
        System.out.println("Public Key: " + rsa.getPublicKey());
        System.out.println("Private Key: " + rsa.getPrivateKey());
        System.out.println("Modulus: " + rsa.getModulus());
    }
}