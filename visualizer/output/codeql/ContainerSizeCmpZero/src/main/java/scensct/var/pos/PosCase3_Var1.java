// Comparing integer literal 0 to string length with greater-than should be flagged as always false.
package scensct.var.pos;

import java.util.*;

public class PosCase3_Var1 {
    public static void main(String[] args) {
        String text = "test";
        int length = text.length();
        // Using a temporary variable for the comparison
        if (0 > length) {
            System.out.println("Unreachable");
        }
    }
}