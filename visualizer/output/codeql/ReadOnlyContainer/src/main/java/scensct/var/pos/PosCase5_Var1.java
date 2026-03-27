// A local collection variable used in return statements and query methods with XML-referenced type should be flagged as uninitialized container.
package scensct.var.pos;

import java.util.ArrayList;
import java.util.List;

public class PosCase5_Var1 {
    public List<String> getList() {
        List<String> items; // declaration separate
        items = new ArrayList<>(); // fresh instance
        // query via isEmpty instead of size
        if (items.isEmpty()) {
            // no mutation
        }
        return items; // returned unchanged
    }
}