// A class with correctly named getter/setter pair where both methods are synchronized should not be flagged as unsynchronized getter with synchronized setter.
package scensct.var.neg;

public class NegCase5_Var3 {
    private int value;

    // Synchronized setter via helper
    public synchronized void setValue(int v) {
        assignValue(v);
    }

    private void assignValue(int v) {
        value = v;
    }

    // Synchronized getter via helper
    public synchronized int getValue() {
        return retrieveValue();
    }

    private int retrieveValue() {
        return value;
    }
}