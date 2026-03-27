// A class with correctly named getter/setter pair where both methods are synchronized should not be flagged as unsynchronized getter with synchronized setter.
package scensct.core.neg;

public class NegCase5 {
    private int value;

    // Synchronized setter
    public synchronized void setValue(int v) {
        value = v;
    }

    // Synchronized getter
    public synchronized int getValue() {
        return value;
    }
}