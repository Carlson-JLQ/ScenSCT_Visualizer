// A container-typed private field that is a deserializable field should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;
import java.util.ArrayList;
import java.io.Serializable;

public class NegCase5_Var4 implements Serializable {
    // Initialization via instance initializer block
    private Collection<String> serializableField;

    {
        serializableField = new ArrayList<>();
    }

    public void use() {
        // Query inside try-catch (no exception expected)
        try {
            System.out.println(serializableField.contains("test"));
        } catch (Exception e) {
            // ignore
        }
    }
}