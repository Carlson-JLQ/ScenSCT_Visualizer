// A class with synchronized setter and getter with lock not this/class literal, volatile field exists but getter accesses non-volatile field should be flagged as unsynchronized getter.
package scensct.core.pos;

public class PosCase8 {
    private int value;
    private volatile int flag;
    private final Object wrongLock = new Object();

    public synchronized void setValue(int v) {
        value = v;
    }

    public int getValue() { // [REPORTED LINE]
        synchronized (wrongLock) { // Lock not 'this'
            return value; // Accesses non-volatile field
        }
    }
}