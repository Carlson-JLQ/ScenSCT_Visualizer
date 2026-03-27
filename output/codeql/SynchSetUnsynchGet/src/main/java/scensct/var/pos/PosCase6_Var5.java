// A class with synchronized setter and getter with incorrect lock object, getter accesses volatile field but writes to it are outside synchronized setter should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase6_Var5 {
    private volatile int counter;
    private int value;
    private final Object wrongLock = new Object();
    private final Object anotherLock = new Object();

    public synchronized void setValue(int v) {
        value = v;
    }

    public void incrementCounter() {
        counter++;
    }

    private boolean alwaysTrue() {
        return true;
    }

    public int getValue() {
        // Nested synchronization with outer correct lock but inner incorrect lock
        synchronized (this) {
            if (alwaysTrue()) {
                synchronized (wrongLock) { // Inner lock mismatch
                    return value;
                }
            }
        }
        return -1; // Never reached
    }

    public int getCounter() {
        return counter;
    }
}