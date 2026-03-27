// A program with no string literal matching the insecure cryptographic algorithm pattern should not be flagged as insecure crypto usage.
package scensct.var.neg;

public class NegCase1_Var4 {
    // Variant 4: Intra-procedural refactoring - control flow to select algorithm
    public static void main(String[] args) throws Exception {
        String secureAlg;
        boolean useSecure = true; // could be a complex condition
        if (useSecure) {
            secureAlg = "AES/GCM/NoPadding";
        } else {
            secureAlg = "DES"; // dead code, never executed
        }
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(secureAlg);
        System.out.println("Cipher created with: " + secureAlg);
    }
}