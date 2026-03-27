// A non-private field of a container type should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;
import java.util.ArrayList;
import java.util.HashSet;

public class NegCase3_Var2 {
    // Variant 2: Mixed container types, different access modifiers, initializer block
    protected Collection<String> protectedField = new ArrayList<>();
    Collection<String> packageField = new HashSet<>(); // HashSet instead of ArrayList
    public Collection<String> publicField;
    
    public NegCase3_Var2() {
        publicField = new ArrayList<>();
    }
    
    public void use() {
        // Extract query to a temporary variable per field
        var check1 = protectedField.isEmpty();
        var check2 = packageField.isEmpty();
        var check3 = publicField.isEmpty();
        // Use results in a loop
        for (int i = 0; i < 1; i++) {
            System.out.println(check1 + " " + check2 + " " + check3);
        }
    }
}