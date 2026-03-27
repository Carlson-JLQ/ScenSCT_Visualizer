// A concrete class that implements Iterable and has an iterator() method returning null should not be flagged.
package scensct.var.neg;

import java.util.Iterator;

public class NegCase5_Var1 implements Iterable<String> {
    // Variant 1: Use a local variable and a conditional that always returns null.
    public Iterator<String> iterator() {
        Iterator<String> it = null;
        if (System.currentTimeMillis() > 0) { // Always true
            it = null;
        } else {
            it = null; // Dead branch, but same result
        }
        return it;
    }
}