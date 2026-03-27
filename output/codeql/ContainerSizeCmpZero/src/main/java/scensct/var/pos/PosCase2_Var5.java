// Comparing collection size to 0 with greater-than-or-equal should be flagged as always true.
package scensct.var.pos;

import java.util.*;

public class PosCase2_Var5 {
    public static void main(String[] args) {
        // Variant 5: Introduce aliasing and ternary operator
        List<Double> original = new LinkedList<>();
        List<Double> alias = original;
        int size = alias.size();
        String result = size >= 0 ? "Always true" : "Never printed";
        System.out.println(result);
    }
}