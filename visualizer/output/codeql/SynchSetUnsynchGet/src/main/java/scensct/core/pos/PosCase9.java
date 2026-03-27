// A class with synchronized setter and getter with lock not this/class literal, getter accesses volatile field but no write to it exists should be flagged as unsynchronized getter.
package scensct.core.pos;

public class PosCase9 {
    private volatile int status;
    private int value;
    private final Object wrongLock = new Object();

    public synchronized void setValue(int v) {
        value = v; // Does not write to volatile field
    }

    public int getValue() { // [REPORTED LINE]
        synchronized (wrongLock) { // Lock not 'this'
            return value; // Accesses non-volatile field
        }
    }

    public int getStatus() { // Accesses volatile field but no write exists
        return status;
    }
}