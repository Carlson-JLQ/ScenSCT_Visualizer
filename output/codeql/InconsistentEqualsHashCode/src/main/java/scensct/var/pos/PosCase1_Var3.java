// A class that overrides hashCode but does not override equals should be flagged as a violation.
package scensct.var.pos;

import java.util.concurrent.atomic.AtomicInteger;

public class PosCase1_Var3 { // [REPORTED LINE]
    private AtomicInteger counter; // Changed field type
    
    public PosCase1_Var3(int initial) {
        this.counter = new AtomicInteger(initial);
    }
    
    @Override
    public int hashCode() {
        // Delegate to AtomicInteger's hashCode
        return counter.hashCode();
    }
    
    // Added a helper method that does not affect the contract
    public int increment() {
        return counter.incrementAndGet();
    }
    
    // Still missing equals
}