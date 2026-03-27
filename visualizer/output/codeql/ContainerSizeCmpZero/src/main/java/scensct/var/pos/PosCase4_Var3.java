// Comparing integer literal 0 to map size with less-than-or-equal should be flagged as always true.
package scensct.var.pos;

import java.util.*;

public class PosCase4_Var3 {
    // Variant 3: Idiomatic variation - use TreeMap instead of HashMap
    public static void main(String[] args) {
        SortedMap<Integer, String> sortedMap = new TreeMap<>();
        // Expression rewrite: move zero to right side (still <=)
        if (sortedMap.size() >= 0) { // [REPORTED LINE]
            System.out.println("Always true");
        }
    }
}