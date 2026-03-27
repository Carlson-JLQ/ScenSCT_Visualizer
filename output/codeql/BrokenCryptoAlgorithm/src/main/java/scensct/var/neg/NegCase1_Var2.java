// A program with no string literal matching the insecure cryptographic algorithm pattern should not be flagged as insecure crypto usage.
package scensct.var.neg;

public class NegCase1_Var2 {
    // Variant 2: Inter-procedural refactoring - secure algorithm from a helper method
    private static String getSecureAlgorithm() {
        return "AES/GCM/NoPadding";
    }
    
    public static void main(String[] args) throws Exception {
        String secureAlg = getSecureAlgorithm();
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(secureAlg);
        System.out.println("Cipher created with: " + secureAlg);
    }
}