// A class with correctly named getter/setter pair where setter is synchronized and getter uses synchronized block should not be flagged as unsynchronized getter with synchronized setter.
package scensct.var.neg;

public class NegCase4_Var1 {
    private int value;

    // Synchronized setter
    public synchronized void setValue(int v) {
        value = v;
    }

    // Getter with synchronized block on 'this', but using a temporary variable
    public int getValue() {
        int result;
        synchronized (this) {
            result = value;
        }
        return result;
    }
}