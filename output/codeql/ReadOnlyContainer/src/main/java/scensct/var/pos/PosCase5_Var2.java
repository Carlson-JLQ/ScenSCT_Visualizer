// A local collection variable used in return statements and query methods with XML-referenced type should be flagged as uninitialized container.
package scensct.var.pos;

import java.util.ArrayList;
import java.util.List;

public class PosCase5_Var2 {
    public List<String> getList() {
        final List<String> container = new ArrayList<>(); // [REPORTED LINE]
        // loop that does not modify container
        for (int i = 0; i < 3; i++) {
            int dummy = container.size(); // query inside loop
        }
        // still no add
        return container;
    }
}