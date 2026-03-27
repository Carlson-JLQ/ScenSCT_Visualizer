// A local container variable never assigned, never returned, and used only with non-query methods should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;
import java.util.ArrayList;

public class NegCase9_Var3 {
    // Variant 3: Inter-procedural refactoring - helper method for mutation
    private void mutateContainer(Collection<String> col) {
        col.add("value"); // mutating via parameter
    }

    public void test() {
        Collection<String> existing = new ArrayList<>();
        Collection<String> alias = existing; // alias
        mutateContainer(alias); // mutating through method call
    }
}