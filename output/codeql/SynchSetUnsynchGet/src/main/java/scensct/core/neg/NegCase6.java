// A class with correctly named getter/setter pair accessing a volatile field should not be flagged as unsynchronized getter with synchronized setter.
package scensct.core.neg;

public class NegCase6 {
    private volatile int value; // Volatile field

    // Synchronized setter
    public synchronized void setValue(int v) {
        value = v;
    }

    // Unsynchronized getter
    public int getValue() {
        return value;
    }
}