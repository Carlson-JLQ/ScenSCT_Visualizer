// Insecure randomness flows to sensitive sink but path lacks allowed propagation steps should not be flagged as insecure randomness usage.
package scensct.var.neg;

import java.util.Random;

public class NegCase6_Var2 {
    // Variant 2: Extract insecure generation to a helper method, but never pass to sink.
    private static int generateInsecure() {
        return new Random().nextInt();
    }

    public static void main(String[] args) {
        int val = generateInsecure();
        // Store in array, still no sink.
        int[] arr = new int[1];
        arr[0] = val;
        // Loop over array but do nothing sensitive.
        for (int v : arr) {
            String s = Integer.toString(v);
            // s is not used in a sensitive sink.
        }
    }
}