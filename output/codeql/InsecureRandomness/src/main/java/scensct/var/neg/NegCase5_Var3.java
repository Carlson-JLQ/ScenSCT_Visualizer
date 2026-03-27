// Insecure randomness flows to non-sensitive sink should not be flagged as insecure randomness usage.
package scensct.var.neg;

import java.util.Random;

public class NegCase5_Var3 {
    // Variant 3: Use Math.random() as an alternative insecure source.
    public static void main(String[] args) {
        double insecure = Math.random();
        // Convert to int and log via StringBuilder (non-sensitive).
        int scaled = (int) (insecure * 1000);
        StringBuilder sb = new StringBuilder();
        sb.append("Generated: ").append(scaled);
        System.out.println(sb.toString());
    }
}