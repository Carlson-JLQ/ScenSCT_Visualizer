// Comparing integer literal 0 to string length with greater-than should be flagged as always false.
package scensct.var.pos;

import java.util.*;

public class PosCase3_Var5 {
    public static void main(String[] args) {
        String str = "test";
        // Using a while loop that never executes due to the false condition
        while (0 > str.length()) { // [REPORTED LINE]
            System.out.println("Unreachable");
            break; // unreachable anyway
        }
    }
}