// A non-private field of a container type should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;
import java.util.ArrayList;

public class NegCase3_Var5 {
    // Variant 5: Fields declared without initialization, assigned in a private init method called from constructor
    protected Collection<String> protectedField;
    Collection<String> packageField;
    public Collection<String> publicField;
    
    public NegCase3_Var5() {
        initFields();
    }
    
    private void initFields() {
        protectedField = new ArrayList<>();
        packageField = new ArrayList<>();
        publicField = new ArrayList<>();
    }
    
    public void use() {
        // Read operations via a local variable that aliases each field
        Collection<String> c1 = protectedField;
        Collection<String> c2 = packageField;
        Collection<String> c3 = publicField;
        System.out.println(c1.isEmpty() + " " + c2.isEmpty() + " " + c3.isEmpty());
    }
}