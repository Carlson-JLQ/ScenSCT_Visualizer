// A class with correctly named getter/setter pair where both methods are synchronized should not be flagged as unsynchronized getter with synchronized setter.
package scensct.var.neg;

public class NegCase5_Var1 {
    private int data;

    // Synchronized setter
    public synchronized void setValue(int v) {
        data = v;
    }

    // Synchronized getter with temporary variable
    public synchronized int getValue() {
        int tmp = data;
        return tmp;
    }
}