// A class with correctly named getter/setter pair where setter is synchronized and getter uses synchronized block should not be flagged as unsynchronized getter with synchronized setter.
package scensct.var.neg;

public class NegCase4_Var2 {
    private int value;

    // Synchronized setter
    public synchronized void setValue(int v) {
        value = v;
    }

    // Getter with synchronized block, but the block is inside a try-finally
    public int getValue() {
        synchronized (this) {
            try {
                return value;
            } finally {
                // empty, just to add complexity
            }
        }
    }
}