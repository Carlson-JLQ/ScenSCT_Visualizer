// A private container field never assigned and never used as qualifier for method calls should not be flagged as an uninitialized container.
package scensct.core.neg;

import java.util.Collection;

public class NegCase7 {
    // Scenario 7: private field, no assignment, no method qualifier use
    private Collection<String> unusedField;
    // No assignment (null default), not deserializable/annotated/XML-bound
    
    public void someMethod() {
        // Field may be accessed (read) but not used as qualifier
        Collection<String> local = unusedField; // read access, not a method qualifier
        // No query/mutation methods called on unusedField
    }
}