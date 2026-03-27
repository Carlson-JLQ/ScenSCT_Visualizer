// A program where a static byte array creation is not the data flow source node should not be flagged as using a static byte array as IV.
package scensct.var.neg;

public class NegCase7_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring with different array literal syntax and extra temporary.
        final byte[] data = {0, 1};
        byte[] temp = data;
        byte[] origin = temp;
        System.out.println(origin.length);
    }
}