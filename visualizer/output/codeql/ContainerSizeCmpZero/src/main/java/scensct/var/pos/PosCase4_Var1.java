// Comparing integer literal 0 to map size with less-than-or-equal should be flagged as always true.
package scensct.var.pos;

import java.util.*;

public class PosCase4_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring - rename map and use explicit type
        HashMap<Integer, String> dataMap = new HashMap<>();
        int zero = 0;
        boolean condition = zero <= dataMap.size();
        if (condition) {
            System.out.println("Always true");
        }
    }
}