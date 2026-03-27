// A local container variable never assigned, never returned, and used only with non-query methods should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;
import java.util.ArrayList;

public class NegCase9_Var1 {
    public void test() {
        // Variant 1: Lexical refactoring with temporary variable and expression split
        Collection<String> source = new ArrayList<>();
        Collection<String> container = source; // alias assignment
        container.add("data"); // mutating call
    }
}