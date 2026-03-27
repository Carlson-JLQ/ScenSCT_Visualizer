// RSA algorithm without OAEP flowing to non-cryptographic sink should not be flagged
package scensct.var.neg;

public class NegCase4_Var3 {
    // Variant 3: string concatenation + temporary variable aliasing
    public static void main(String[] args) {
        final String base = "RSA";
        final String mode = "/ECB";
        final String padding = "/PKCS1Padding";
        String fullAlg = base + mode + padding; // still "RSA/ECB/PKCS1Padding"
        String alias = fullAlg;
        String output = alias;
        // sink is not a crypto algorithm parameter
        System.err.println(output);
    }
}