// A local collection variable used only for query methods should be flagged as uninitialized container.
package scensct.ref.pos;

import java.util.ArrayList;
import java.util.Collection;

public class PosCase1_FN1 {
    public void method() {
        Collection<String> col = new ArrayList<>(); // Fresh container instance
        boolean empty = col.isEmpty();              // Only query method call
        int size = col.size();                      // Another query method call
        // No add/remove operations
    }
}