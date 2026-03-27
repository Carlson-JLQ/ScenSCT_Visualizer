// Comparing collection size to 0 with greater-than-or-equal should be flagged as always true.
package scensct.var.pos;

import java.util.*;

public class PosCase2_Var2 {
    public static void main(String[] args) {
        // Variant 2: Restructure control flow with a while loop
        Map<String, Integer> map = new HashMap<>();
        boolean condition = map.size() >= 0; // Always true // [REPORTED LINE]
        while (condition) {
            System.out.println("Always true");
            break;
        }
    }
}