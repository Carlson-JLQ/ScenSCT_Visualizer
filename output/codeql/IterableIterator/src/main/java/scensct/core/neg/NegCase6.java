// A concrete class that implements Iterable, returns "this" in iterator(), and has hasNext() returning false should not be flagged.
package scensct.core.neg;

import java.util.Iterator;

public class NegCase6 implements Iterable<Double>, Iterator<Double> {
    // Concrete class implements both Iterable and Iterator.
    // iterator() returns "this" (single statement).
    // hasNext() returns false (single statement).
    // This matches the pattern but hasNext() returns false, so the checker should not report.
    
    public Iterator<Double> iterator() {
        return this; // Single statement returning "this"
    }
    
    public boolean hasNext() {
        return false; // Single statement returning false
    }
    
    public Double next() {
        return 0.0; // Required by Iterator interface
    }
}