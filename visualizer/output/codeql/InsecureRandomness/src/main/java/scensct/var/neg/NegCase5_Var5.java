// Insecure randomness flows to non-sensitive sink should not be flagged as insecure randomness usage.
package scensct.var.neg;

import java.util.Random;

public class NegCase5_Var5 {
    // Variant 5: Inline the random call into the sink argument, with a wrapper method.
    private static void logValue(int value) {
        System.out.println("Logged number: " + value);
    }
    
    public static void main(String[] args) {
        logValue(new Random().nextInt());
    }
}