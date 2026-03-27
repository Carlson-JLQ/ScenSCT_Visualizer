// RSA algorithm without OAEP flowing to non-cryptographic sink should not be flagged
package scensct.var.neg;

public class NegCase4_Var1 {
    // Variant 1: lexical refactoring + control flow with branching
    public static void main(String[] args) {
        final String cipherSpec = "RSA/ECB/PKCS1Padding";
        String chosenAlg = null;
        if (args.length == 0) {
            chosenAlg = cipherSpec;
        } else {
            chosenAlg = "AES/GCM/NoPadding"; // alternative path, but never taken
        }
        // still a non-crypto sink
        System.out.println("Algorithm: " + chosenAlg);
    }
}