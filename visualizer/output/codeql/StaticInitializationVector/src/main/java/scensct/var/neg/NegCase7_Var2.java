// A program where a static byte array creation is not the data flow source node should not be flagged as using a static byte array as IV.
package scensct.var.neg;

public class NegCase7_Var2 {
    private static byte[] getArray() {
        return new byte[] {0, 1}; // static creation inside helper
    }

    public static void main(String[] args) {
        // Variant 2: Inter-procedural extraction.
        // The source node in main is the return value, not the creation expression.
        byte[] src = getArray();
        System.out.println(src.length);
    }
}