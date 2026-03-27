// A container-typed private field annotated with a reflective access annotation should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;
import java.util.Vector;
import javax.inject.Inject;

public class NegCase4_Var5 {
    // Variant 5: Use synchronized container, multiple query calls
    @Inject
    private Collection<String> syncField = new Vector<>();
    
    public void use() {
        // Multiple read-only operations
        boolean empty = syncField.isEmpty();
        int count = syncField.size();
        boolean containsTest = syncField.contains("test");
        System.out.println(empty + " " + count + " " + containsTest);
    }
}