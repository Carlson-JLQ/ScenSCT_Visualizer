// A program with no data flow source nodes should not be flagged as using a static byte array as IV.
package scensct.core.neg;

public class NegCase1 {
    public static void main(String[] args) {
        // No byte array creation or other source nodes present.
        System.out.println("No source nodes.");
    }
}