// A program with source nodes that are not array creation expressions should not be flagged as using a static byte array as IV.
package scensct.var.neg;

public class NegCase2_Var4 {
    public static void main(String[] args) {
        // Variant 4: Introduce a try-catch block that does not affect the string assignment.
        String source;
        try {
            source = "not an array";
        } catch (Exception e) {
            source = "fallback"; // Never reached
        }
        System.out.println(source);
    }
}