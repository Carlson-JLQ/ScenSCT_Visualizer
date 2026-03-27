// A private container field assigned non-fresh source and used with mutating methods should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

public class NegCase8_Var2 {
    private Collection<String> field;
    
    public void test() {
        // Intra-procedural: use if-else to assign non-fresh source, but always take same branch
        boolean flag = false;
        if (flag) {
            field = null;
        } else {
            Collection<String> local = new ArrayList<>();
            field = local;
        }
        
        // Mutating via a helper method that takes the field as parameter
        mutateField(field);
    }
    
    private void mutateField(Collection<String> col) {
        col.add("data");
    }
}