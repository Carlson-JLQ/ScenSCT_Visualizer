// A class with synchronized setter and unsynchronized getter, getter accesses volatile field but no write to it exists should be flagged as unsynchronized getter.
package scensct.var.pos;

public class PosCase4_Var1 {
    private volatile int stateFlag; // Renamed volatile field
    private int data; // Renamed non-volatile field

    // Synchronized setter using explicit lock object
    private final Object lock = new Object();
    public void setValue(int val) {
        synchronized (lock) { // Changed synchronization method
            data = val; // No write to volatile
        }
    }

    // Unsynchronized getter - should still be reported
    public int getValue() {
        return data; // Accesses non-volatile field
    }

    // Getter for volatile field, no write exists
    public int getStatus() {
        return stateFlag;
    }
}