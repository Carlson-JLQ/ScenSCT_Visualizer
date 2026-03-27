// A local container variable never assigned, never returned, and used only with non-query methods should not be flagged as an uninitialized container.
package scensct.core.neg;

import java.util.Collection;
import java.util.ArrayList;

public class NegCase9 {
    public void test() {
        // Scenario 9: local variable, never assigned (null default if declared without init)
        // To avoid compilation error while preserving scenario intent:
        // Use a non-fresh source (existing container) and call only mutating methods.
        Collection<String> other = new ArrayList<>();
        Collection<String> localVar = other; // assignment with non-fresh source
        localVar.add("test"); // mutating method, not a query
        // Not returned, and assignment source is not fresh.
    }
}