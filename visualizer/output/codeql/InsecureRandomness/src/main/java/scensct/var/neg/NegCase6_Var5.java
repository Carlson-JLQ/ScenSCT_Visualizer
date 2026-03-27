// Insecure randomness flows to sensitive sink but path lacks allowed propagation steps should not be flagged as insecure randomness usage.
package scensct.var.neg;

import java.util.Random;

public class NegCase6_Var5 {
    // Variant 5: Control‑flow restructuring with early return that prevents any sink.
    public static void main(String[] args) {
        Random rand = new Random();
        int insecure = rand.nextInt();
        
        // Early return based on a condition that is always true.
        if (insecure != 0) {
            return; // exits before any possible sink
        }
        
        // This code is unreachable, but even if it were reached,
        // it does not contain a sensitive sink.
        String dummy = String.valueOf(insecure);
        System.out.println(dummy); // benign output
    }
}