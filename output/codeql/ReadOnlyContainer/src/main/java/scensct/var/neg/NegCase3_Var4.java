// A non-private field of a container type should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Collections;

public class NegCase3_Var4 {
    // Variant 4: Use Collections.emptyList() initially, then reassign to new ArrayList (still no writes after)
    protected Collection<String> protectedField = Collections.emptyList();
    Collection<String> packageField = Collections.emptyList();
    public Collection<String> publicField = Collections.emptyList();
    
    {
        // Instance initializer reassigns to mutable containers
        protectedField = new ArrayList<>();
        packageField = new ArrayList<>();
        publicField = new ArrayList<>();
    }
    
    public void use() {
        // Read operations inside a try‑catch (no effect)
        try {
            boolean empty = protectedField.isEmpty() && packageField.isEmpty() && publicField.isEmpty();
            System.out.println(empty);
        } catch (Exception e) {
            // ignore
        }
    }
}