// A non-private field of a container type should not be flagged as an uninitialized container.
package scensct.core.neg;

import java.util.Collection;
import java.util.ArrayList;

public class NegCase3 {
    // Scenario 3: non-private field (protected)
    protected Collection<String> protectedField = new ArrayList<>();
    
    // Scenario 3: non-private field (package-private)
    Collection<String> packageField = new ArrayList<>();
    
    // Scenario 3: non-private field (public)
    public Collection<String> publicField = new ArrayList<>();
    
    public void use() {
        // Query operations on non-private fields
        boolean p1 = protectedField.isEmpty();
        boolean p2 = packageField.isEmpty();
        boolean p3 = publicField.isEmpty();
        System.out.println(p1 + " " + p2 + " " + p3);
    }
}