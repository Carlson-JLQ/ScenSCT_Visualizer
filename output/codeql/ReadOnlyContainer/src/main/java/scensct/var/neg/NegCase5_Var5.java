// A container-typed private field that is a deserializable field should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.io.Serializable;

public class NegCase5_Var5 implements Serializable {
    // Using a concurrent collection, still a fresh instance
    private Collection<String> serializableField = new ConcurrentLinkedQueue<>();

    // Query usage split into multiple steps with a temp variable
    public void use() {
        Collection<String> c = serializableField;
        boolean empty = c.isEmpty();
        if (empty) {
            System.out.println("Empty collection");
        }
    }
}