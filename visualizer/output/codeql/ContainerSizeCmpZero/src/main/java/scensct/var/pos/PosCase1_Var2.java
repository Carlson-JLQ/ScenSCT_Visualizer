// Comparing array length to 0 with less-than should be flagged as always false.
package scensct.var.pos;

import java.util.*;

public class PosCase1_Var2 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        // Restructure control flow with a while loop that never executes
        while (arr.length < 0) { // Always false // [REPORTED LINE]
            System.out.println("Unreachable");
            break;
        }
    }
}