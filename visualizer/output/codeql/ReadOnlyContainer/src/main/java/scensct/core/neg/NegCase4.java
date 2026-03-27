// A container-typed private field annotated with a reflective access annotation should not be flagged as an uninitialized container.
package scensct.core.neg;

import java.util.Collection;
import java.util.ArrayList;
import javax.inject.Inject;

public class NegCase4 {
    // Scenario 4: private field with @Inject annotation
    @Inject
    private Collection<String> injectedField = new ArrayList<>();
    
    public void use() {
        // Query operation on annotated field
        boolean empty = injectedField.isEmpty();
        System.out.println(empty);
    }
}