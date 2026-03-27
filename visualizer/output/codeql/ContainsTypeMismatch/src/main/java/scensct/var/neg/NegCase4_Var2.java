// Calling a non-target method (e.g., add) on a collection type should not be flagged.
package scensct.var.neg;

import java.util.ArrayList;

public class NegCase4_Var2 {
    // Variant 2: Intra-procedural refactoring – wrap the add in a try-catch-finally
    // to add control-flow noise without changing the observable call.
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        try {
            list.add("hello");
        } catch (RuntimeException e) {
            // never thrown, just noise
        } finally {
            System.out.println(list.size());
        }
    }
}