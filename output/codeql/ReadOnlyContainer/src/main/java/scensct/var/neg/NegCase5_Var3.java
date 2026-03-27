// A container-typed private field that is a deserializable field should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;
import java.util.HashSet;
import java.io.Serializable;

public class NegCase5_Var3 implements Serializable {
    // Renamed field, changed to HashSet
    private Collection<String> dataContainer = new HashSet<>();

    // Extracted query to a private method
    public void use() {
        checkIfEmpty();
    }

    private void checkIfEmpty() {
        boolean hasItems = !dataContainer.isEmpty();
        System.out.println("Has items: " + hasItems);
    }
}