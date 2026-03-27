// A class with correctly named getter/setter pair where both methods are synchronized should not be flagged as unsynchronized getter with synchronized setter.
package scensct.var.neg;

public class NegCase5_Var2 {
    private int value;

    // Synchronized setter with explicit lock on 'this'
    public synchronized void setValue(int v) {
        this.value = v;
    }

    // Synchronized getter wrapped in try-finally (no-op)
    public synchronized int getValue() {
        try {
            return value;
        } finally {
            // empty, just to change structure
        }
    }
}