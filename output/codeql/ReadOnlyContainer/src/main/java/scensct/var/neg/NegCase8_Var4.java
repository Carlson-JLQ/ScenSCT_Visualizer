// A private container field assigned non-fresh source and used with mutating methods should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;
import java.util.ArrayList;

public class NegCase8_Var4 {
    private Collection<String> field;
    
    public void test() {
        // Inter-procedural: extract the non-fresh assignment to a helper
        assignNonFresh();
        
        // Mutating in a try-catch block (intra-procedural control flow)
        try {
            field.add("item");
        } catch (Exception e) {
            // ignore
        }
    }
    
    private void assignNonFresh() {
        Collection<String> src = new ArrayList<>();
        field = src;
    }
}