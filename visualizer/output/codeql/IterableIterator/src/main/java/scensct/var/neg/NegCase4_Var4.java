// A concrete class that implements Iterable and has an iterator() method with empty body should not be flagged.
package scensct.var.neg;

import java.util.Iterator;

public class NegCase4_Var4 implements Iterable<Object> {
    // Variant 4: Using a try-finally block that returns null.
    public Iterator<Object> iterator() {
        try {
            // No-op in try block.
        } finally {
            // Still returns null.
        }
        return null;
    }
}