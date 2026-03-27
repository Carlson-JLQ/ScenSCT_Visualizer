// Comparing integer literal 0 to map size with less-than-or-equal should be flagged as always true.
package scensct.var.pos;

import java.util.*;

public class PosCase4_Var5 {
    // Variant 5: Complex expression with method call
    private static int getZero() {
        return 0;
    }
    
    public static void main(String[] args) {
        Map<Integer, String> map = new LinkedHashMap<>();
        // Use method call for zero and nested comparison
        if (getZero() <= map.size() && true) {
            System.out.println("Always true");
        }
    }
}