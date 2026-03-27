// A program with no string literal matching the insecure cryptographic algorithm pattern should not be flagged as insecure crypto usage.
package scensct.var.neg;

public class NegCase1_Var3 {
    // Variant 3: Idiomatic variation - use StringBuilder and a constant
    private static final String ALG_PREFIX = "AES";
    
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(ALG_PREFIX).append("/GCM").append("/NoPadding");
        String secureAlg = sb.toString();
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(secureAlg);
        System.out.println("Cipher created with: " + secureAlg);
    }
}