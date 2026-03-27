// Insecure randomness not used in sensitive sink should not be flagged as insecure randomness usage.
package scensct.var.neg;

import java.util.Random;

public class NegCase3_Var3 {
    private static int generateInsecure() {
        Random r = new Random();
        return r.nextInt();
    }
    
    private static void logNumber(int num) {
        System.out.println("Logged random: " + num);
    }
    
    public static void main(String[] args) {
        int val = generateInsecure();
        logNumber(val);
    }
}