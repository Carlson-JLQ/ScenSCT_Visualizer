// Comparing collection size to 0 with greater-than-or-equal should be flagged as always true.
package scensct.core.pos;

import java.util.*;

public class PosCase2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        // Scenario 2: greater-than-or-equal expression comparing container size to 0
        if (list.size() >= 0) { // Always true, collection size cannot be negative // [REPORTED LINE]
            System.out.println("Always true");
        }
    }
}