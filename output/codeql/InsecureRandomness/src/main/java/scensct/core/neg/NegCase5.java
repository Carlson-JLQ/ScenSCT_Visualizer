// Insecure randomness flows to non-sensitive sink should not be flagged as insecure randomness usage.
package scensct.core.neg;

import java.util.Random;

public class NegCase5 {
    public static void main(String[] args) {
        // Insecure random source.
        Random rand = new Random();
        int insecureNum = rand.nextInt();
        // Flow to a generic logging API (non-sensitive sink).
        System.out.println("Log: " + insecureNum); // Not a SetCookieValue or SensitiveExpr.
    }
}