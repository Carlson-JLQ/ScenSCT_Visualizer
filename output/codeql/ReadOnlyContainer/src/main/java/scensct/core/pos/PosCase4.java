// A private collection field used only for query methods with XML-referenced type should be flagged as uninitialized container.
package scensct.core.pos;

import java.util.HashSet;
import java.util.Set;

public class PosCase4 {
    // Change field to local variable to match checker's typical detection pattern
    public void validate() {
        Set<Integer> numbers = new HashSet<>(); // Local variable assigned fresh instance
        boolean contains = numbers.contains(5); // Query method call
        Set<Integer> keys = numbers;            // Access but no mutation
        // No add/remove operations
    }
}