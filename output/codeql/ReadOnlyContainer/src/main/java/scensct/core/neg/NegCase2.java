// A container-typed variable that is a method parameter should not be flagged as an uninitialized container.
package scensct.core.neg;

import java.util.Collection;
import java.util.ArrayList;

public class NegCase2 {
    // Scenario 2: method parameter (container type) is not subject to checker
    public void process(Collection<String> param) {
        // Query operation on parameter
        boolean isEmpty = param.isEmpty();
        System.out.println(isEmpty);
    }
    
    public void another() {
        // Catch clause parameter (container type) is not subject to checker
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) { // e is not a container, but catch param is not local/field
            // Example with container in catch? Not typical, but scenario says "catch clause parameter"
            // We'll demonstrate with a non-container catch param as per typical Java.
        }
    }
}