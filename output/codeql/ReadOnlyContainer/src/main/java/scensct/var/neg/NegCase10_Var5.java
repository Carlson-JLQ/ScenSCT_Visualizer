// A local container variable assigned non-fresh source, never returned, and never used as qualifier should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;
import java.util.ArrayList;

public class NegCase10_Var5 {
    public void test() {
        // Variant 5: Try‑finally block with no write inside
        Collection<String> other = new ArrayList<>();
        Collection<String> localVar;
        try {
            localVar = other;
        } finally {
            // No operation on localVar
        }
        // No further use
    }
}