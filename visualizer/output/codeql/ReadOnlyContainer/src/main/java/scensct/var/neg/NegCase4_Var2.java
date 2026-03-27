// A container-typed private field annotated with a reflective access annotation should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.List;
import java.util.LinkedList;
import javax.inject.Inject;

public class NegCase4_Var2 {
    // Variant 2: Use more specific interface, defer initialization in constructor
    @Inject
    private List<String> items;
    
    public NegCase4_Var2() {
        items = new LinkedList<>();
    }
    
    public void use() {
        // Query inside a conditional branch
        if (items != null) {
            System.out.println(items.isEmpty() ? "Empty" : "Not empty");
        }
    }
}