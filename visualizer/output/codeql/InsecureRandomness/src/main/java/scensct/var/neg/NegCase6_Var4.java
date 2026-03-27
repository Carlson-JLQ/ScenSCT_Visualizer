// Insecure randomness flows to sensitive sink but path lacks allowed propagation steps should not be flagged as insecure randomness usage.
package scensct.var.neg;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class NegCase6_Var4 {
    // Variant 4: Mix multiple insecure sources, but still avoid any sensitive sink.
    public static void main(String[] args) {
        Random rand1 = new Random();
        int a = rand1.nextInt();
        
        // Another insecure source
        int b = ThreadLocalRandom.current().nextInt();
        
        // Combine them
        int combined = a ^ b;
        
        // Use in a loop that does not call a sink.
        for (int i = 0; i < 1; i++) {
            String temp = "Prefix" + combined;
            // temp is not used in a sensitive sink.
        }
        
        // Possibly store in a field? (non‑static inner class simulation)
        Holder h = new Holder();
        h.value = combined;
        // No further use of h.
    }
    
    static class Holder {
        int value;
    }
}