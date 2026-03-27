// A class with synchronized setter and getter with lock not this/class literal, no volatile fields should be flagged as unsynchronized getter.
package scensct.core.pos;

public class PosCase7 {
    private int value;
    private final Object wrongLock = new Object();

    public synchronized void setValue(int v) {
        value = v;
    }

    public int getValue() { // [REPORTED LINE]
        synchronized (wrongLock) { // Lock not 'this'
            return value;
        }
    }
}