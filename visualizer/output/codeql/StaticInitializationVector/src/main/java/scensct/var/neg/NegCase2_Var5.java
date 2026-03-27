// A program with source nodes that are not array creation expressions should not be flagged as using a static byte array as IV.
package scensct.var.neg;

public class NegCase2_Var5 {
    // Variant 5: Use a static initializer block to assign a field, then use it in main.
    private static final String STATIC_SOURCE;

    static {
        STATIC_SOURCE = "not an array";
    }

    public static void main(String[] args) {
        String source = STATIC_SOURCE;
        System.out.println(source);
    }
}