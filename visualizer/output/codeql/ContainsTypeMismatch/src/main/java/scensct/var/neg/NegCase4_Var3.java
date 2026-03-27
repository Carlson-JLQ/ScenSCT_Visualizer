// Calling a non-target method (e.g., add) on a collection type should not be flagged.
package scensct.var.neg;

import java.util.ArrayList;

public class NegCase4_Var3 {
    // Variant 3: Inter-procedural refactoring – extract the add call into a helper method.
    // The helper still performs the same non‑target operation.
    private static void addHello(ArrayList<String> target) {
        target.add("hello");
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        addHello(list);
        System.out.println(list.size());
    }
}