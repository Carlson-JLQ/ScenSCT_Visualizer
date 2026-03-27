// Insecure randomness not used in sensitive sink should not be flagged as insecure randomness usage.
package scensct.var.neg;

import java.util.Random;

public class NegCase3_Var2 {
    public static void main(String[] args) {
        Random rand = new Random();
        int insecureNum = 0;
        for (int i = 0; i < 1; i++) {
            insecureNum = rand.nextInt();
        }
        if (insecureNum % 2 == 0) {
            System.out.println("Even random: " + insecureNum);
        } else {
            System.out.println("Odd random: " + insecureNum);
        }
    }
}