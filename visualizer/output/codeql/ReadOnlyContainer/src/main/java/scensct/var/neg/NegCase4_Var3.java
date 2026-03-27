// A container-typed private field annotated with a reflective access annotation should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;
import java.util.ArrayList;
import javax.inject.Inject;

public class NegCase4_Var3 {
    // Variant 3: Split annotation and field declaration, add a trivial static final
    @Inject
    private Collection<String> data;
    
    {
        data = new ArrayList<>();
    }
    
    public void use() {
        // Extract query to a local method
        reportEmptyStatus();
    }
    
    private void reportEmptyStatus() {
        boolean empty = data.isEmpty();
        System.out.println(empty);
    }
}