// A class with correctly named getter/setter pair where setter is synchronized and getter uses synchronized block should not be flagged as unsynchronized getter with synchronized setter.
package scensct.var.neg;

public class NegCase4_Var5 {
    private int value;

    // Synchronized setter
    public synchronized void setValue(int v) {
        value = v;
    }

    // Getter uses synchronized block with explicit monitor extraction
    public int getValue() { // [REPORTED LINE]
        Object monitor = this;
        synchronized (monitor) {
            return value;
        }
    }
}