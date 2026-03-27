// No insecure randomness source should not be flagged as insecure randomness usage.
package scensct.var.neg;

import java.util.concurrent.ThreadLocalRandom;

public class NegCase1_Var3 {
    public static void main(String[] args) {
        // Using ThreadLocalRandom, which is a secure random source in many contexts.
        // It should not be flagged as insecure randomness.
        int x = ThreadLocalRandom.current().nextInt(1, 101);
        System.out.println("Random number: " + x);
    }
}