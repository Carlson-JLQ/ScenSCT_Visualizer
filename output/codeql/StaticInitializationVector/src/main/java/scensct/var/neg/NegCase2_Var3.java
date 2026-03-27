// A program with source nodes that are not array creation expressions should not be flagged as using a static byte array as IV.
package scensct.var.neg;

public class NegCase2_Var3 {
    // Variant 3: Inter-procedural refactoring - move string literal to a static helper method.
    private static String getString() {
        return "not an array";
    }

    public static void main(String[] args) {
        String source = getString();
        System.out.println(source);
    }
}