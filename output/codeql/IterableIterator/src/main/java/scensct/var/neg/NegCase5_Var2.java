// A concrete class that implements Iterable and has an iterator() method returning null should not be flagged.
package scensct.var.neg;

import java.util.Iterator;

public class NegCase5_Var2 implements Iterable<String> {
    // Variant 2: Extract null return into a helper method.
    public Iterator<String> iterator() {
        return getNullIterator();
    }

    private Iterator<String> getNullIterator() {
        return null;
    }
}