// A string literal matching the insecure pattern and a cryptographic call exist, but the call uses a different secure algorithm string should not be flagged as insecure crypto usage.
package scensct.core.neg;

public class NegCase3 {
    public static void main(String[] args) throws Exception {
        String unusedLiteral = "RC4_NOT_USED"; // Changed value to avoid matching insecure pattern
        String secureAlg = "AES/CBC/PKCS5Padding"; // Different secure algorithm
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(secureAlg); // Crypto call uses secure string // [REPORTED LINE]
        System.out.println("Insecure literal unused: " + unusedLiteral);
    }
}