// A concrete class that implements Iterable, returns "this" in iterator(), and has hasNext() returning false should not be flagged.
package scensct.var.neg;

import java.util.Iterator;

public class NegCase6_Var3 implements Iterable<Double>, Iterator<Double> {
    
    private Iterator<Double> getSelf() {
        return this;
    }
    
    public Iterator<Double> iterator() {
        return getSelf();
    }
    
    public boolean hasNext() {
        try {
            return false;
        } catch (Exception e) {
            // Never reached
            throw new RuntimeException(e);
        }
    }
    
    public Double next() {
        return 0.0;
    }
}