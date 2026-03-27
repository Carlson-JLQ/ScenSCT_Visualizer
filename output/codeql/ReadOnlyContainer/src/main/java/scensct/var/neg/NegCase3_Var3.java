// A non-private field of a container type should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;
import java.util.ArrayList;

public class NegCase3_Var3 {
    // Variant 3: Inline initialization in constructor, add a static initializer for a static field (non‑private static also shouldn't report)
    protected Collection<String> protectedField;
    Collection<String> packageField;
    public Collection<String> publicField;
    
    public NegCase3_Var3() {
        protectedField = new ArrayList<>();
        packageField = new ArrayList<>();
        publicField = new ArrayList<>();
    }
    
    public void use() {
        // Helper method extraction for the read‑only queries
        queryFields();
    }
    
    private void queryFields() {
        boolean p1 = protectedField.isEmpty();
        boolean p2 = packageField.isEmpty();
        boolean p3 = publicField.isEmpty();
        System.out.println(String.format("%b %b %b", p1, p2, p3));
    }
}