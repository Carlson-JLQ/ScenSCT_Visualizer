// Comparing collection size to 0 with greater-than-or-equal should be flagged as always true.
package scensct.var.pos;

import java.util.*;

public class PosCase2_Var4 {
    public static void main(String[] args) {
        // Variant 4: Use array length (also non-negative) and negated equivalent expression
        String[] arr = new String[5];
        if (!(arr.length < 0)) { // Always true (size >= 0 expressed as not less than 0) // [REPORTED LINE]
            System.out.println("Always true");
        }
    }
}