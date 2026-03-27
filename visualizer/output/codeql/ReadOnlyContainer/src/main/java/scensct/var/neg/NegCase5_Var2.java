// A container-typed private field that is a deserializable field should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;
import java.util.ArrayList;
import java.io.Serializable;

public class NegCase5_Var2 implements Serializable {
    private Collection<String> serializableField;

    // Moved initialization to constructor, still fresh instance
    public NegCase5_Var2() {
        this.serializableField = new ArrayList<>();
    }

    public void use() {
        // Read-only query wrapped in if-else
        if (serializableField.isEmpty()) {
            System.out.println("It's empty");
        } else {
            System.out.println("Not empty");
        }
    }
}