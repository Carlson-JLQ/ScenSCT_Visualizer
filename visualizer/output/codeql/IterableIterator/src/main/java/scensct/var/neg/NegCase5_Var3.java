// A concrete class that implements Iterable and has an iterator() method returning null should not be flagged.
package scensct.var.neg;

import java.util.Iterator;

public class NegCase5_Var3 implements Iterable<String> {
    // Variant 3: Use a try-catch block that returns null in both normal and exceptional flow.
    public Iterator<String> iterator() {
        try {
            return (Iterator<String>) null;
        } catch (ClassCastException e) {
            // Never happens, but returns null anyway
            return null;
        } finally {
            // No-op, doesn't affect return
        }
    }
}