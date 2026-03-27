// A private container field never assigned and never used as qualifier for method calls should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;

public class NegCase7_Var5 {
    private Collection<String> unusedField;

    // Constructor that reads but does not assign the field
    public NegCase7_Var5() {
        Collection<String> dummy = unusedField;
    }

    // Instance initializer that also reads without method call
    {
        Object o = unusedField;
    }

    public void someMethod() {
        // Loop with read access
        for (int i = 0; i < 1; i++) {
            var local = unusedField;
        }
    }

    // Try‑catch block that reads the field
    public void riskyMethod() {
        try {
            Collection<String> insideTry = unusedField;
        } catch (Exception e) {
            // ignore
        }
    }
}