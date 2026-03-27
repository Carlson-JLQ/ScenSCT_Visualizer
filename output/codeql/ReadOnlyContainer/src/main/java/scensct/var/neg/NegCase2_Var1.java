// A container-typed variable that is a method parameter should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;
import java.util.ArrayList;
import java.util.function.Predicate;

public class NegCase2_Var1 {
    // Variant 1: Introduce a helper method that delegates the query, and use a try-finally for logging.
    public void process(Collection<String> param) {
        // Delegate emptiness check to a private method
        boolean empty = checkEmpty(param);
        System.out.println(empty);
    }
    
    private boolean checkEmpty(Collection<String> col) {
        return col.isEmpty();
    }
    
    public void another() {
        try {
            someRiskyOperation();
        } catch (RuntimeException ex) {
            // Catch parameter remains non-container
            System.err.println("Caught: " + ex.getMessage());
        }
    }
    
    private void someRiskyOperation() {
        throw new RuntimeException("Simulated error");
    }
}