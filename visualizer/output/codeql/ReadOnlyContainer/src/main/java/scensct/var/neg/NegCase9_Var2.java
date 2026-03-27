// A local container variable never assigned, never returned, and used only with non-query methods should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;
import java.util.ArrayList;

public class NegCase9_Var2 {
    public void test() {
        // Variant 2: Control-flow restructuring with conditional aliasing
        Collection<String> base = new ArrayList<>();
        Collection<String> target;
        if (System.currentTimeMillis() > 0) {
            target = base; // alias in branch
        } else {
            target = base; // same alias, different path
        }
        target.add("item"); // mutating after branch
    }
}