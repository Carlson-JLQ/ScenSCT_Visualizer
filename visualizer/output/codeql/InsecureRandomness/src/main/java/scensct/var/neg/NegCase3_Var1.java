// Insecure randomness not used in sensitive sink should not be flagged as insecure randomness usage.
package scensct.var.neg;

import java.util.Random;

public class NegCase3_Var1 {
    public static void main(String[] args) {
        // Insecure random source exists but not used in sensitive sink.
        Random insecureRand = new Random();
        Random aliasRand = insecureRand;
        double insecureVal = aliasRand.nextDouble();
        // Used only in non-sensitive operation (printing).
        System.out.println("Random double: " + insecureVal);
    }
}