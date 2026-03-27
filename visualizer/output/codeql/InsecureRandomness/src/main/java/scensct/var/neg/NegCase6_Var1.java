// Insecure randomness flows to sensitive sink but path lacks allowed propagation steps should not be flagged as insecure randomness usage.
package scensct.var.neg;

import java.util.Random;

public class NegCase6_Var1 {
    public static void main(String[] args) {
        // Variant 1: Introduce aliasing and a conditional branch that never reaches a sink.
        Random r = new Random();
        int x = r.nextInt();
        int y = x; // alias
        if (System.currentTimeMillis() > 0) {
            // This branch always executes, but still no sink.
            int z = y + 1;
            System.out.println("Debug: " + z); // benign logging, not a sensitive sink
        } else {
            // Dead code, never executed.
            // Even if it were, no sink here either.
            int unused = y * 2;
        }
    }
}