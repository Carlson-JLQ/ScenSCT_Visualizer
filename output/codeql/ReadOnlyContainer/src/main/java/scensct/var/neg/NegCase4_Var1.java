// A container-typed private field annotated with a reflective access annotation should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;
import java.util.HashSet;
import javax.inject.Inject;

public class NegCase4_Var1 {
    // Variant 1: Change container type and initializer, rename field
    @Inject
    private Collection<String> injectedCollection = new HashSet<>();
    
    public void use() {
        // Query via a temporary variable
        Collection<String> col = injectedCollection;
        boolean hasElements = col.size() > 0;
        System.out.println("Is empty? " + !hasElements);
    }
}