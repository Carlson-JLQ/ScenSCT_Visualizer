// A container-typed variable that is a method parameter should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Collections;

public class NegCase2_Var5 {
    // Variant 5: Use unmodifiable wrapper and a static helper, with parameter renamed.
    public void process(Collection<String> inputCollection) {
        Collection<String> safeView = Collections.unmodifiableCollection(inputCollection);
        boolean empty = safeView.isEmpty();
        printResult(empty);
    }
    
    private void printResult(boolean flag) {
        System.out.println("Result: " + flag);
    }
    
    public void another() {
        // Catch clause with a generic exception parameter, still non-container.
        try {
            throw new IllegalStateException();
        } catch (Exception general) {
            System.out.println(general);
        }
    }
}