// A local container variable never assigned, never returned, and used only with non-query methods should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;
import java.util.ArrayList;

public class NegCase9_Var5 {
    public void test() {
        // Variant 5: Loop restructuring with aliasing inside loop
        Collection<String> src = new ArrayList<>();
        Collection<String> alias = null;
        for (int i = 0; i < 1; i++) {
            alias = src; // alias assignment in loop
        }
        alias.add("test"); // mutating after loop
    }
}