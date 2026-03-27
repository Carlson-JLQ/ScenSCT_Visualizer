// A class with synchronized setter and getter with incorrect lock object, volatile field exists but getter accesses non-volatile field should be flagged as unsynchronized getter.
package scensct.core.pos;

public class PosCase3 {
    private int value;
    private volatile int flag; // Volatile field not accessed by getter
    private final Object wrongLock = new Object();

    public synchronized void setValue(int v) {
        value = v;
    }

    public int getValue() { // [REPORTED LINE]
        synchronized (wrongLock) { // Incorrect lock object
            return value; // Accesses non-volatile field
        }
    }
}