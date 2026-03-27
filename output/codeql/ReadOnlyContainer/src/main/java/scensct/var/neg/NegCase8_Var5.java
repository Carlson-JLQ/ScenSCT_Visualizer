// A private container field assigned non-fresh source and used with mutating methods should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;
import java.util.ArrayList;

public class NegCase8_Var5 {
    private Collection<String> field;
    
    public void test() {
        // Lexical: compound assignment with null and then reassign via method chain
        field = null;
        field = createAndPopulate();
        
        // Mutating method is remove (still mutating)
        field.remove("dummy");
    }
    
    private Collection<String> createAndPopulate() {
        Collection<String> c = new ArrayList<>();
        c.add("dummy");
        return c;
    }
}