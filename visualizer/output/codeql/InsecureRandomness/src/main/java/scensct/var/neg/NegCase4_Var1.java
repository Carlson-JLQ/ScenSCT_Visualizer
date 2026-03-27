// Insecure randomness and sensitive sink independent should not be flagged as insecure randomness usage.
package scensct.var.neg;

import java.util.Random;

public class NegCase4_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical & Control-Flow Restructuring
        // Rename variables and wrap sink in a conditional that doesn't affect independence.
        Random rng = new Random();
        int randomValue = rng.nextInt();
        String sessionToken = "session123";
        if (System.currentTimeMillis() > 0) {
            // Hypothetical sink call with independent data.
            // setCookie(sessionToken);
        }
        // randomValue is never used near the sink.
    }
}