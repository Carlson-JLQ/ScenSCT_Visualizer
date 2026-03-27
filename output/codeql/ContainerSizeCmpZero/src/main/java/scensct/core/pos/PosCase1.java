// Comparing array length to 0 with less-than should be flagged as always false.
package scensct.core.pos;

import java.util.*;

public class PosCase1 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        // Scenario 1: less-than expression comparing container size to 0
        if (arr.length < 0) { // Always false, array length cannot be negative // [REPORTED LINE]
            System.out.println("Unreachable");
        }
    }
}