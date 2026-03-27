// A class with correctly named getter/setter pair where both methods are synchronized should not be flagged as unsynchronized getter with synchronized setter.
package scensct.var.neg;

public class NegCase5_Var5 {
    private int value;

    // Synchronized setter with explicit block
    public void setValue(int v) {
        synchronized (this) {
            value = v;
        }
    }

    // Synchronized getter with explicit block
    public int getValue() {
        synchronized (this) {
            return value;
        }
    }
}