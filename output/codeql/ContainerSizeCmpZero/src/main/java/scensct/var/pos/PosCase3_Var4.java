// Comparing integer literal 0 to string length with greater-than should be flagged as always false.
package scensct.var.pos;

import java.util.*;

public class PosCase3_Var4 {
    public static void main(String[] args) {
        String str = "test";
        // Extracting the comparison into a helper method
        if (isAlwaysFalse(str)) {
            System.out.println("Unreachable");
        }
    }

    private static boolean isAlwaysFalse(String s) {
        return 0 > s.length(); // [REPORTED LINE]
    }
}