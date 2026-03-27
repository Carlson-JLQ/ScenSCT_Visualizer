// Comparing collection size to 0 with greater-than-or-equal should be flagged as always true.
package scensct.var.pos;

import java.util.*;

public class PosCase2_Var3 {
    // Variant 3: Extract size check into a helper method
    private static boolean checkSize(Set<?> set) {
        return set.size() >= 0; // Always true // [REPORTED LINE]
    }
    
    public static void main(String[] args) {
        Set<Object> mySet = new LinkedHashSet<>();
        if (checkSize(mySet)) {
            System.out.println("Always true");
        }
    }
}