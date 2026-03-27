// A private container field never assigned and never used as qualifier for method calls should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

public class NegCase7_Var4 {
    // Two private unassigned fields, same scenario
    private Collection<String> unusedField;
    private Map<String, Integer> unusedMap;

    public void someMethod() {
        // Read both into locals
        Collection<String> c = unusedField;
        Map<String, Integer> m = unusedMap;
        // No method calls on either field
    }

    // Overloaded method that reads one field
    public void someMethod(boolean flag) {
        Object o = flag ? unusedField : unusedMap;
    }
}