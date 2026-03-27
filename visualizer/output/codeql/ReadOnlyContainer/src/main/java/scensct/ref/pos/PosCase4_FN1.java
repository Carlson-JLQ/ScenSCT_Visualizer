// A private collection field used only for query methods with XML-referenced type should be flagged as uninitialized container.
package scensct.ref.pos;

import java.util.HashSet;
import java.util.Set;

public class PosCase4_FN1 {
    private Set<Integer> numbers = new HashSet<>(); // Field assigned fresh instance

    public PosCase4_FN1() {
        // Assignment could also be in constructor
    }

    public void validate() {
        boolean contains = numbers.contains(5); // Query method call
        Set<Integer> keys = numbers;            // Access but no mutation
        // No add/remove operations
    }
}