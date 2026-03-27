// A string literal matching the insecure pattern flows along a path but does not reach the algorithm parameter of a cryptographic operation should not be flagged as insecure crypto usage.
package scensct.var.neg;

public class NegCase4_Var5 {
    public static void main(String[] args) throws Exception {
        String alg = "DES/ECB/PKCS5Padding";
        String extracted = null;
        try {
            extracted = alg.toUpperCase().substring(0, 3);
        } catch (RuntimeException e) {
            // ignore, won't happen
        }
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding"); // [REPORTED LINE]
        System.out.println("Extracted: " + extracted);
    }
}