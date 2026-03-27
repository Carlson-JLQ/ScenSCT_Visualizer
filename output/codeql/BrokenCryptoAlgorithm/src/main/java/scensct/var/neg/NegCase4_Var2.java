// A string literal matching the insecure pattern flows along a path but does not reach the algorithm parameter of a cryptographic operation should not be flagged as insecure crypto usage.
package scensct.var.neg;

public class NegCase4_Var2 {
    public static void main(String[] args) throws Exception {
        String alg;
        if (System.currentTimeMillis() > 0) { // always true
            alg = "DES/ECB/PKCS5Padding";
        } else {
            alg = "AES/GCM/NoPadding";
        }
        alg = alg.toUpperCase();
        String extracted = alg.substring(0, 3);
        // Crypto call uses a different literal
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/GCM/NoPadding");
        System.out.println("Prefix was: " + extracted);
    }
}