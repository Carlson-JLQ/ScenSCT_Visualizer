// Comparing collection size to 0 with greater-than-or-equal should be flagged as always true.
package scensct.var.pos;

import java.util.*;

public class PosCase2_Var1 {
    public static void main(String[] args) {
        // Variant 1: Use a temporary variable and rename collection
        Collection<Integer> items = new HashSet<>();
        int count = items.size();
        if (count >= 0) { // Always true
            System.out.println("Always true");
        }
    }
}