// Insecure randomness flows to non-sensitive sink should not be flagged as insecure randomness usage.
package scensct.var.neg;

import java.util.Random;

public class NegCase5_Var4 {
    // Variant 4: Add trivial control flow that does not affect the flow.
    public static void main(String[] args) {
        Random rand = new Random();
        int x = rand.nextInt();
        if (System.currentTimeMillis() > 0) { // always true
            // Still a non-sensitive sink.
            System.out.println(x);
        } else {
            System.out.println("unreachable");
        }
    }
}