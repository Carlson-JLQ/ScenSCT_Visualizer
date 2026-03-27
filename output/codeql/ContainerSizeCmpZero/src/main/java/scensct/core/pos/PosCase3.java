// Comparing integer literal 0 to string length with greater-than should be flagged as always false.
package scensct.core.pos;

import java.util.*;

public class PosCase3 {
    public static void main(String[] args) {
        String str = "test";
        // Scenario 3: greater-than expression comparing 0 to container size
        if (0 > str.length()) { // Always false, string length cannot be negative // [REPORTED LINE]
            System.out.println("Unreachable");
        }
    }
}