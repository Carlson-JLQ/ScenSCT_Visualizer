// A container-typed private field annotated with a reflective access annotation should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Set;
import java.util.TreeSet;
import javax.inject.Inject;

public class NegCase4_Var4 {
    // Variant 4: Use Set, wrap query in try-catch for robustness
    @Inject
    private Set<String> injectedSet = new TreeSet<>();
    
    public void use() {
        try {
            int size = injectedSet.size();
            System.out.println("Size: " + size);
        } catch (Exception e) {
            System.out.println("Error checking set");
        }
    }
}