// A local container variable assigned non-fresh source, never returned, and never used as qualifier should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Collections;

public class NegCase10_Var4 {
    public void test() {
        // Variant 4: Idiomatic variation – use Collections.unmodifiableCollection as intermediate
        Collection<String> other = new ArrayList<>();
        Collection<String> wrapper = Collections.unmodifiableCollection(other);
        Collection<String> localVar = wrapper; // still non‑fresh source
        // No mutation possible, no qualifier use
    }
}