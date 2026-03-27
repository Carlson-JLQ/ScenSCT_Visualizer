// Creating a non-Writer/OutputStream instance should not be flagged as resource leak.
package scensct.var.neg;

import java.util.ArrayList;

public class NegCase1_Var5 {
    public static void main(String[] args) {
        // Variant 5: Aliasing through a temporary variable and try-finally for non-resource logic.
        ArrayList<String> original = new ArrayList<>();
        ArrayList<String> alias = original; // Simple alias
        alias.add("item");
        try {
            // Some dummy operation that doesn't affect the resource scenario
            int x = 1;
            if (x > 0) {
                System.out.println(alias.size());
            }
        } finally {
            // Finally block without closing (not a Writer/OutputStream)
            System.out.println("Done");
        }
    }
}