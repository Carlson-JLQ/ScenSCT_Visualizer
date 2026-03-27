// RSA algorithm without OAEP flowing to non-cryptographic sink should not be flagged
package scensct.var.neg;

public class NegCase4_Var2 {
    // Variant 2: helper method extraction
    private static String getRSAAlg() {
        return "RSA/ECB/PKCS1Padding";
    }

    private static void log(String msg) {
        System.out.println(msg); // non-crypto sink
    }

    public static void main(String[] args) {
        String alg = getRSAAlg();
        log(alg);
    }
}