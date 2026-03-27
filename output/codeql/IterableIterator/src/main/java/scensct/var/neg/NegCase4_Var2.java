// A concrete class that implements Iterable and has an iterator() method with empty body should not be flagged.
package scensct.var.neg;

import java.util.Iterator;

public class NegCase4_Var2 implements Iterable<Object> {
    // Variant 2: Control-flow restructuring with an if-else that always returns null.
    public Iterator<Object> iterator() {
        if (System.currentTimeMillis() > 0) {
            // Always true, but returns null.
            return null;
        } else {
            // Dead code, also returns null.
            return null;
        }
    }
}