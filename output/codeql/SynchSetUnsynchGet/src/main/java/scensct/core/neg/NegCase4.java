// A class with correctly named getter/setter pair where setter is synchronized and getter uses synchronized block should not be flagged as unsynchronized getter with synchronized setter.
package scensct.core.neg;

public class NegCase4 {
    private int value;

    // Synchronized setter
    public synchronized void setValue(int v) {
        value = v;
    }

    // Getter with synchronized block on 'this'
    public int getValue() {
        synchronized (this) {
            return value;
        }
    }
}