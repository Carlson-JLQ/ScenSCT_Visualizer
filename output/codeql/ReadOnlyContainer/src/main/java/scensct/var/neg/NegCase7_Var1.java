// A private container field never assigned and never used as qualifier for method calls should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;
import java.util.List;

public class NegCase7_Var1 {
    // Renamed field, still private and unassigned
    private Collection<String> internalData;

    public void someMethod() {
        // Read via a temporary variable with a different name
        Collection<String> tempRef = internalData;
        // No method calls on internalData
    }

    // Added a helper method that reads the field but still no qualifier use
    private void helper() {
        if (internalData == null) {
            // Just a null check, not a method call on the field
        }
    }
}