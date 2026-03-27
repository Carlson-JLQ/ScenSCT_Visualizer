// A program with no string literal matching the insecure cryptographic algorithm pattern should not be flagged as insecure crypto usage.
package scensct.var.neg;

public class NegCase1_Var5 {
    // Variant 5: Lexical and idiomatic - different secure algorithm from same family
    public static void main(String[] args) throws Exception {
        // Using another secure algorithm: AES/CBC/PKCS5Padding (still secure if used with proper IV)
        // This tests that the checker only flags insecure ones, not all algorithms.
        String secureAlg = "AES/CBC/PKCS5Padding";
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(secureAlg); // [REPORTED LINE]
        System.out.println("Cipher created with: " + secureAlg);
    }
}