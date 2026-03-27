// A concrete class that implements Iterable and has an iterator() method with empty body should not be flagged.
package scensct.var.neg;

import java.util.Iterator;

public class NegCase4_Var5 implements Iterable<Object> {
    // Variant 5: Idiomatic variation with a static final field.
    private static final Iterator<Object> NO_ITERATOR = null;
    
    public Iterator<Object> iterator() {
        return NO_ITERATOR;
    }
}