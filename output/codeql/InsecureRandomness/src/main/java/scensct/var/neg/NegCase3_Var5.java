// Insecure randomness not used in sensitive sink should not be flagged as insecure randomness usage.
package scensct.var.neg;

import java.util.Random;

public class NegCase3_Var5 {
    public static void main(String[] args) {
        Random rand = null;
        try {
            rand = new Random();
        } catch (Exception e) {
            rand = new Random(123); // fallback, still insecure
        }
        int insecureNum = rand.nextInt();
        int printedNum = insecureNum;
        // Used only in non-sensitive operation (printing).
        System.out.println("Random number: " + printedNum);
    }
}