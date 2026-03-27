// A non-private field of a container type should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

public class NegCase3_Var1 {
    // Variant 1: Use List interface, rename fields, split declaration and assignment
    protected List<String> items;
    Collection<String> data;
    public Collection<String> shared;
    
    {
        items = new ArrayList<>();
        data = new ArrayList<>();
        shared = new ArrayList<>();
    }
    
    public void use() {
        // Control flow variation: condition that always executes
        if (true) {
            boolean a = items.isEmpty();
            boolean b = data.isEmpty();
            boolean c = shared.isEmpty();
            System.out.println(a && b && c);
        }
    }
}