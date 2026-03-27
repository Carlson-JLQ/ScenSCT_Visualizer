// RSA algorithm without OAEP flowing to non-cryptographic sink should not be flagged
package scensct.core.neg;

public class NegCase4 {
    public static void main(String[] args) {
        // Source: compile-time constant RSA string without OAEP
        final String ALG = "RSA/ECB/PKCS1Padding";
        // Sink: not a cryptographic algorithm parameter (assignment and print)
        String myAlg = ALG;
        System.out.println(myAlg);
    }
}