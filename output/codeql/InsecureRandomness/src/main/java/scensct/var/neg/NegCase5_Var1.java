// Insecure randomness flows to non-sensitive sink should not be flagged as insecure randomness usage.
package scensct.var.neg;

import java.util.Random;

public class NegCase5_Var1 {
    public static void main(String[] args) {
        // Variant 1: Introduce a temporary variable and split the flow.
        Random rng = new Random();
        int val = rng.nextInt();
        String logMessage = "Random value logged: " + val;
        System.out.println(logMessage);
    }
}