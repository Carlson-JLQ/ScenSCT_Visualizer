// A concrete class that implements Iterable, returns "this" in iterator(), and has hasNext() returning false should not be flagged.
package scensct.var.neg;

import java.util.Iterator;

public class NegCase6_Var2 implements Iterable<Double>, Iterator<Double> { // [REPORTED LINE]
    
    public Iterator<Double> iterator() {
        return this;
    }
    
    private boolean neverHasNext() {
        return false;
    }
    
    public boolean hasNext() {
        return neverHasNext();
    }
    
    public Double next() {
        return 0.0;
    }
}