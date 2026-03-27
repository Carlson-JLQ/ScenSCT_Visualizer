// Comparing array length to 0 with less-than should be flagged as always false.
package scensct.var.pos;

import java.util.*;

public class PosCase1_Var4 {
    public static void main(String[] args) {
        // Use a String instead of array, but same non-negative length property
        String str = "hello";
        if (str.length() < 0) { // Always false // [REPORTED LINE]
            System.out.println("Unreachable");
        }
    }
}