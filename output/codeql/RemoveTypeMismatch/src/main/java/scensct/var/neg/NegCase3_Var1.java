// Calling remove with compatible argument type should not be flagged as incompatible.
package scensct.var.neg;

import java.util.ArrayList;
import java.util.Collection;

public class NegCase3_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring with temporary variable and renamed identifiers.
        Collection<String> strings = new ArrayList<>();
        String itemToRemove = "test";
        strings.remove(itemToRemove);
    }
}