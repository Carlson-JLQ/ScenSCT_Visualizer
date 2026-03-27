// A program with no string literal matching the insecure cryptographic algorithm pattern should not be flagged as insecure crypto usage.
package scensct.var.neg;

public class NegCase1_Var1 {
    public static void main(String[] args) throws Exception {
        // Variant 1: Lexical refactoring - split string into parts and concatenate
        String part1 = "AES";
        String part2 = "/GCM";
        String part3 = "/NoPadding";
        String secureAlg = part1 + part2 + part3;
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(secureAlg);
        System.out.println("Cipher created with: " + secureAlg);
    }
}