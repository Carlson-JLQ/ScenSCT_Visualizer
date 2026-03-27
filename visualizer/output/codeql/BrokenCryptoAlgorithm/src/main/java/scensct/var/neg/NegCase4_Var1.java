// A string literal matching the insecure pattern flows along a path but does not reach the algorithm parameter of a cryptographic operation should not be flagged as insecure crypto usage.
package scensct.var.neg;

public class NegCase4_Var1 {
    private static final String INSECURE_ALG = "DES/ECB/PKCS5Padding";
    
    public static void main(String[] args) throws Exception {
        String baseAlg = INSECURE_ALG;
        String upper = baseAlg.toUpperCase();
        String prefix = upper.substring(0, 3);
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES");
        System.out.println("Extracted string: " + prefix);
    }
}