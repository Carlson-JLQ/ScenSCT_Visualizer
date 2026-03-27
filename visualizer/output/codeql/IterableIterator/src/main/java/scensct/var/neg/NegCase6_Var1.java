// A concrete class that implements Iterable, returns "this" in iterator(), and has hasNext() returning false should not be flagged.
package scensct.var.neg;

import java.util.Iterator;

public class NegCase6_Var1 implements Iterable<Double>, Iterator<Double> {
    // Same scenario: hasNext() ultimately returns false.
    
    public Iterator<Double> iterator() {
        Iterator<Double> self = this;
        return self;
    }
    
    public boolean hasNext() {
        if (System.currentTimeMillis() > 0) {
            return false;
        } else {
            // Dead branch, never taken
            return true;
        }
    }
    
    public Double next() {
        return 0.0;
    }
}