// A string literal matching the insecure pattern flows along a path but does not reach the algorithm parameter of a cryptographic operation should not be flagged as insecure crypto usage.
package scensct.core.neg;

public class NegCase4 {
    public static void main(String[] args) throws Exception {
        String alg = "DES/ECB/PKCS5Padding"; // Insecure literal assigned
        alg = alg.toUpperCase(); // Modified, but still insecure pattern
        String finalAlg = alg.substring(0, 3); // Extracts "DES", but not used in crypto call
        // Cryptographic call uses a different, secure algorithm
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES");
        System.out.println("Extracted string: " + finalAlg); // Insecure literal does not flow to crypto parameter
    }
}