// Comparing integer literal 0 to map size with less-than-or-equal should be flagged as always true.
package scensct.var.pos;

import java.util.*;

public class PosCase4_Var2 {
    // Variant 2: Inter-procedural refactoring - extract map creation
    private static Map<Integer, String> createMap() {
        return new HashMap<>();
    }
    
    public static void main(String[] args) {
        Map<Integer, String> map = createMap();
        // Control-flow restructuring: use while loop that never executes
        while (0 <= map.size()) { // [REPORTED LINE]
            System.out.println("Always true");
            break;
        }
    }
}