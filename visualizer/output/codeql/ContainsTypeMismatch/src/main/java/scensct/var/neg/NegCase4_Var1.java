// Calling a non-target method (e.g., add) on a collection type should not be flagged.
package scensct.var.neg;

import java.util.ArrayList;

public class NegCase4_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring – use a temporary variable for the list,
        // and split the add call across lines.
        ArrayList<String> strings = new ArrayList<>();
        strings.add(
            "hello"
        );
        System.out.println(strings.size());
    }
}