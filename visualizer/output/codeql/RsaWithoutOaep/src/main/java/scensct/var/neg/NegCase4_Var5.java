// RSA algorithm without OAEP flowing to non-cryptographic sink should not be flagged
package scensct.var.neg;

public class NegCase4_Var5 {
    // Variant 5: wrapping in a container object, then unwrapping
    static class Wrapper {
        final String value;
        Wrapper(String v) { this.value = v; }
        String get() { return value; }
    }

    public static void main(String[] args) {
        Wrapper w = new Wrapper("RSA/ECB/PKCS1Padding");
        String unwrapped = w.get();
        // still a non-cryptographic sink
        System.out.println(unwrapped);
    }
}