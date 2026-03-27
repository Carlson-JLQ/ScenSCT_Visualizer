// Comparing integer literal 0 to string length with greater-than should be flagged as always false.
package scensct.var.pos;

import java.util.*;

public class PosCase3_Var2 {
    public static void main(String[] args) {
        String str = "test";
        // Inverted condition with early return to preserve semantics
        if (!(0 <= str.length())) { // [REPORTED LINE]
            System.out.println("Unreachable");
        }
    }
}