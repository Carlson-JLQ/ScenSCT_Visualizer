// A program with no string literal matching the insecure cryptographic algorithm pattern should not be flagged as insecure crypto usage.
package scensct.core.neg;

public class NegCase1 {
    public static void main(String[] args) throws Exception {
        // Secure algorithm string, not matching DES, RC4, or ECB (excluding exclusions)
        String secureAlg = "AES/GCM/NoPadding";
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(secureAlg); // Secure crypto call
        System.out.println("Cipher created with: " + secureAlg);
    }
}