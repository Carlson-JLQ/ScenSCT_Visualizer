// A private container field never assigned and never used as qualifier for method calls should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;
import java.util.ArrayList;

public class NegCase7_Var2 {
    // Changed to a more specific type but still unassigned
    private ArrayList<String> unusedField;

    public void someMethod() {
        // Read into a local with a cast/type change
        Collection<String> col = unusedField;
        // Still no method invocation on unusedField
    }

    // Additional method that passes the field as argument (still not a qualifier)
    private void process(Collection<String> coll) {
        // dummy
    }

    public void anotherMethod() {
        process(unusedField); // argument pass is a read, not a qualifier use
    }
}