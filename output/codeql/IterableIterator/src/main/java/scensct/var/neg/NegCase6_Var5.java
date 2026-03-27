// A concrete class that implements Iterable, returns "this" in iterator(), and has hasNext() returning false should not be flagged.
package scensct.var.neg;

import java.util.Iterator;

public class NegCase6_Var5 implements Iterable<Double>, Iterator<Double> {
    
    public Iterator<Double> iterator() {
        // Anonymous class that returns the same iterator behavior
        return new Iterator<Double>() {
            private final Iterator<Double> delegate = NegCase6_Var5.this;
            
            public boolean hasNext() {
                return delegate.hasNext();
            }
            
            public Double next() {
                return delegate.next();
            }
        };
    }
    
    public boolean hasNext() {
        return false;
    }
    
    public Double next() {
        return 0.0;
    }
}