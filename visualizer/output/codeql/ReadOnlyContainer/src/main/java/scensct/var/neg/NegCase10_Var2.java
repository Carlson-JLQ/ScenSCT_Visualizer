// A local container variable assigned non-fresh source, never returned, and never used as qualifier should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;
import java.util.ArrayList;

public class NegCase10_Var2 {
    public void test() {
        // Variant 2: Control‑flow restructuring – variable assigned inside a conditional branch
        Collection<String> other = new ArrayList<>();
        Collection<String> localVar;
        if (System.currentTimeMillis() > 0) {
            localVar = other;
        } else {
            localVar = null; // unreachable, but preserves type
        }
        // No writes, no qualifier use
    }
}