// Comparing integer literal 0 to string length with greater-than should be flagged as always false.
package scensct.var.pos;

import java.util.*;

public class PosCase3_Var3 {
    public static void main(String[] args) {
        String str = "test";
        // Using a ternary operator that never executes the true branch
        String result = 0 > str.length() ? "Unreachable" : "Reachable"; // [REPORTED LINE]
        System.out.println(result);
    }
}