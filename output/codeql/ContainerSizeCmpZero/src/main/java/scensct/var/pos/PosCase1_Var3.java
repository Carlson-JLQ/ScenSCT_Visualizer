// Comparing array length to 0 with less-than should be flagged as always false.
package scensct.var.pos;

import java.util.*;

public class PosCase1_Var3 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        // Extract comparison to a helper method
        if (isLengthNegative(arr)) {
            System.out.println("Unreachable");
        }
    }
    
    private static boolean isLengthNegative(int[] array) {
        return array.length < 0; // Always false // [REPORTED LINE]
    }
}