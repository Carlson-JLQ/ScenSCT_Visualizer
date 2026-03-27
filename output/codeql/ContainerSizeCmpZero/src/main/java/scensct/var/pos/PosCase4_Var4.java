// Comparing integer literal 0 to map size with less-than-or-equal should be flagged as always true.
package scensct.var.pos;

import java.util.*;

public class PosCase4_Var4 {
    // Variant 4: Control-flow with try-catch block
    public static void main(String[] args) {
        Map<Integer, String> map = Collections.emptyMap();
        try {
            // Comparison inside try block
            boolean result = 0 <= map.size(); // [REPORTED LINE]
            if (result) {
                System.out.println("Always true");
            }
        } catch (Exception e) {
            // Never reached
        }
    }
}