// A class with correctly named getter/setter pair where both methods are synchronized should not be flagged as unsynchronized getter with synchronized setter.
package scensct.var.neg;

public class NegCase5_Var4 {
    private int value;

    // Synchronized setter with loop (single iteration)
    public synchronized void setValue(int v) {
        for (int i = 0; i < 1; i++) {
            value = v;
        }
    }

    // Synchronized getter with conditional (always true)
    public synchronized int getValue() {
        if (true) {
            return value;
        }
        return -1; // unreachable
    }
}