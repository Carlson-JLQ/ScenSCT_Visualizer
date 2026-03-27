// RSA algorithm without OAEP flowing to non-cryptographic sink should not be flagged
package scensct.var.neg;

public class NegCase4_Var4 {
    // Variant 4: using StringBuilder and loop (unrolled)
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("RSA");
        sb.append("/ECB");
        sb.append("/PKCS1Padding");
        String result = sb.toString();
        // non-crypto usage
        System.out.println(result.toLowerCase());
    }
}