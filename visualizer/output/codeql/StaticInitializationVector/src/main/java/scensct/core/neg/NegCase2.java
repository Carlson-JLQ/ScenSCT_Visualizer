// A program with source nodes that are not array creation expressions should not be flagged as using a static byte array as IV.
package scensct.core.neg;

public class NegCase2 {
    public static void main(String[] args) {
        // Source node is a string literal, not an array creation.
        String source = "not an array";
        System.out.println(source);
    }
}