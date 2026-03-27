// Calling a non-target method (e.g., add) on a collection type should not be flagged.
package scensct.var.neg;

import java.util.ArrayList;

public class NegCase4_Var5 {
    // Variant 5: Idiomatic variation – use diamond operator and a different
    // initial capacity, then add via a variable with a different name.
    public static void main(String[] args) {
        ArrayList<String> items = new ArrayList<>(5);
        String greeting = "hello";
        items.add(greeting);
        System.out.println(items.size());
    }
}