// A private container field never assigned and never used as qualifier for method calls should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;
import java.util.Set;

public class NegCase7_Var3 {
    // Split declaration and later possible (but not actually) assignment
    private Collection<String> unusedField /* = null */;

    public void someMethod() {
        // Control‑flow variation: read only in one branch
        Collection<String> local = null;
        if (Math.random() > 0.5) {
            local = unusedField; // read here
        }
        // Still no method call on unusedField
    }

    // Added a static initializer that does NOT touch the field
    static {
        System.out.println("Class loaded");
    }
}