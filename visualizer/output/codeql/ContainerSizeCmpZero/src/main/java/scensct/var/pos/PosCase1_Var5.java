// Comparing array length to 0 with less-than should be flagged as always false.
package scensct.var.pos;

import java.util.*;

public class PosCase1_Var5 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        // Use ternary operator with always-false condition
        String result = arr.length < 0 ? "Unreachable" : "Reachable"; // [REPORTED LINE]
        System.out.println(result);
    }
}