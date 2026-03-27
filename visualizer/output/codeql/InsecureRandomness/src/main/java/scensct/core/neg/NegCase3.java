// Insecure randomness not used in sensitive sink should not be flagged as insecure randomness usage.
package scensct.core.neg;

import java.util.Random;

public class NegCase3 {
    public static void main(String[] args) {
        // Insecure random source exists but not used in sensitive sink.
        Random rand = new Random();
        int insecureNum = rand.nextInt();
        // Used only in non-sensitive operation (printing).
        System.out.println("Random number: " + insecureNum);
    }
}