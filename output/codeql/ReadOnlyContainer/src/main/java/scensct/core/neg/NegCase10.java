// A local container variable assigned non-fresh source, never returned, and never used as qualifier should not be flagged as an uninitialized container.
package scensct.core.neg;

import java.util.Collection;
import java.util.ArrayList;

public class NegCase10 {
    public void test() {
        // Scenario 10: local variable, assignment source is not a fresh container
        Collection<String> other = new ArrayList<>();
        Collection<String> localVar = other; // source is another variable, not fresh
        
        // Never returned from method
        // Never used as qualifier for any method call
        // Not deserializable/annotated/XML-bound
        // Variable is simply assigned and not used further
    }
}