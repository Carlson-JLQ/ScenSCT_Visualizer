// A container-typed variable that is a method parameter should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

public class NegCase2_Var2 {
    // Variant 2: Change parameter type to a more specific interface (List), add control flow with early return.
    public void process(List<String> param) {
        if (param == null) {
            System.out.println("null param");
            return;
        }
        boolean isEmpty = param.isEmpty();
        System.out.println("Collection empty? " + isEmpty);
    }
    
    public void another() {
        // Remove catch clause, replace with a simple method that uses a container parameter.
        helper(new ArrayList<>());
    }
    
    private void helper(Collection<Object> coll) {
        // This is a different method with its own parameter; not relevant to the seed scenario.
        System.out.println(coll.size());
    }
}