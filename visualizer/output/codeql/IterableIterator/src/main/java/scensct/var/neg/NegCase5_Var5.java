// A concrete class that implements Iterable and has an iterator() method returning null should not be flagged.
package scensct.var.neg;

import java.util.Iterator;

public class NegCase5_Var5 implements Iterable<String> {
    // Variant 5: Return a ternary expression that always evaluates to null.
    public Iterator<String> iterator() {
        return (1 == 1) ? null : this.iterator(); // Dead branch, never called
    }
}