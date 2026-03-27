// Comparing integer literal 0 to map size with less-than-or-equal should be flagged as always true.
package scensct.core.pos;

import java.util.*;

public class PosCase4 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        // Scenario 4: less-than-or-equal expression comparing 0 to container size
        if (0 <= map.size()) { // Always true, map size cannot be negative // [REPORTED LINE]
            System.out.println("Always true");
        }
    }
}