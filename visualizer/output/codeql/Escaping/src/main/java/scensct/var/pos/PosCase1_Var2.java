// A class annotated with @ThreadSafe contains a non-final, non-private, non-volatile instance field should be flagged as a concurrency issue.
package scensct.var.pos;

@interface ThreadSafe {}

@ThreadSafe
public class PosCase1_Var2 {
    // Field with explicit default (no modifier) and initialization, plus a synchronized method that doesn't protect it.
    int counter = 0; // [REPORTED LINE]
    
    public synchronized void incrementSomethingElse() {
        // This method is synchronized but doesn't touch 'counter'
    }
    
    public void incrementCounter() {
        counter++; // Unsynchronized access
    }
}