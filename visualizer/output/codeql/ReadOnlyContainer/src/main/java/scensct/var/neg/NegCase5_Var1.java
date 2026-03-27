// A container-typed private field that is a deserializable field should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;
import java.util.LinkedList;
import java.io.Serializable;

public class NegCase5_Var1 implements Serializable {
    // Changed container type and initialization style
    private Collection<String> serializableField = new LinkedList<>();

    public void use() {
        // Query via size() instead of isEmpty()
        int count = serializableField.size();
        System.out.println("Size: " + count);
    }
}