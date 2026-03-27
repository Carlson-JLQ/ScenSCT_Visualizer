// A class with synchronized setter and unsynchronized getter, volatile field exists but getter accesses non-volatile field should be flagged as unsynchronized getter.
package scensct.core.pos;

public class PosCase2 {
    private int value;
    private volatile int flag; // Volatile field not accessed by getter

    public synchronized void setValue(int v) {
        value = v;
    }

    public int getValue() { // Unsynchronized getter, accesses non-volatile field // [REPORTED LINE]
        return value;
    }
}