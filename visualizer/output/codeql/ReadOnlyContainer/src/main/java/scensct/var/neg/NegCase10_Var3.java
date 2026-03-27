// A local container variable assigned non-fresh source, never returned, and never used as qualifier should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;
import java.util.ArrayList;

public class NegCase10_Var3 {
    // Variant 3: Inter‑procedural – move assignment to a helper method
    private Collection<String> provide(Collection<String> c) {
        return c;
    }
    
    public void test() {
        Collection<String> other = new ArrayList<>();
        Collection<String> localVar = provide(other);
        // Never used further
    }
}