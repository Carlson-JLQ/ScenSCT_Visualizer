// Insecure randomness flows to sensitive sink but path lacks allowed propagation steps should not be flagged as insecure randomness usage.
package scensct.var.neg;

import java.util.Random;

public class NegCase6_Var3 {
    // Variant 3: Use Math.random() as an alternative insecure source, still no sink.
    public static void main(String[] args) {
        double insecure = Math.random();
        int scaled = (int) (insecure * 1000);
        // Temporarily hold in a wrapper object.
        Integer boxed = Integer.valueOf(scaled);
        int unboxed = boxed.intValue();
        // Simulate a try-catch that does not propagate to sink.
        try {
            if (unboxed % 2 == 0) {
                System.err.println("Even random: " + unboxed);
            }
        } catch (Exception e) {
            // Ignore, no sink.
        }
    }
}