// A container-typed private field that is a deserializable field should not be flagged as an uninitialized container.
package scensct.core.neg;

import java.util.Collection;
import java.util.ArrayList;
import java.io.Serializable;

public class NegCase5 implements Serializable {
    // Scenario 5: non-transient private field in Serializable class
    private Collection<String> serializableField = new ArrayList<>();
    // transient field would not be deserializable, but scenario says non-transient
    
    public void use() {
        // Query operation on deserializable field
        boolean empty = serializableField.isEmpty();
        System.out.println(empty);
    }
}