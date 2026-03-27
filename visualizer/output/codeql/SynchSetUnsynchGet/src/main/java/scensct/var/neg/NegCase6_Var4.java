// A class with correctly named getter/setter pair accessing a volatile field should not be flagged as unsynchronized getter with synchronized setter.
package scensct.var.neg;

public class NegCase6_Var4 {
    private volatile int value;

    // synchronized setter with try-finally (no-op)
    public synchronized void setValue(int v) {
        try {
            value = v;
        } finally {
            // nothing
        }
    }

    // getter wrapped in a private helper
    public int getValue() { // [REPORTED LINE]
        return readValue();
    }

    private int readValue() {
        return value;
    }
}