// Comparing array length to 0 with less-than should be flagged as always false.
package scensct.var.pos;

import java.util.*;

public class PosCase1_Var1 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        // Use a temporary variable for length
        int len = arr.length;
        if (len < 0) { // Always false
            System.out.println("Unreachable");
        }
    }
}