// A private container field assigned non-fresh source and used with mutating methods should not be flagged as an uninitialized container.
package scensct.core.neg;

import java.util.Collection;
import java.util.ArrayList;

public class NegCase8 {
    // Scenario 8: private field, not deserializable/annotated/XML-bound
    private Collection<String> field;
    
    public void test() {
        // Assignment source is not a fresh container (null)
        field = null;
        
        // Re-assign with another container variable (non-fresh source)
        Collection<String> other = new ArrayList<>();
        field = other; // source is another variable, not fresh
        
        // Method call with field as qualifier is not a query method (mutating)
        field.add("item"); // add is a mutating method, not a query
    }
}