// A concrete class that implements Iterable, returns "this" in iterator(), and has hasNext() returning false should not be flagged.
package scensct.var.neg;

import java.util.Iterator;

public class NegCase6_Var4 implements Iterable<Double>, Iterator<Double> { // [REPORTED LINE]
    private final boolean NO_MORE = false;
    
    public Iterator<Double> iterator() {
        return this;
    }
    
    public boolean hasNext() {
        for (int i = 0; i < 1; i++) {
            // loop does nothing
        }
        return NO_MORE;
    }
    
    public Double next() {
        return 0.0;
    }
}