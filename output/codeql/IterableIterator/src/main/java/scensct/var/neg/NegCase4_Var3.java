// A concrete class that implements Iterable and has an iterator() method with empty body should not be flagged.
package scensct.var.neg;

import java.util.Iterator;

public class NegCase4_Var3 implements Iterable<Object> {
    // Variant 3: Inter-procedural refactoring: delegate to a helper method.
    private Iterator<Object> getNullIterator() {
        return null;
    }
    
    public Iterator<Object> iterator() {
        return getNullIterator();
    }
}